package com.ecommercerest.service.storage;

import com.ecommercerest.error.StorageEmptyFileException;
import com.ecommercerest.error.StorageException;
import com.ecommercerest.model.Produto;
import com.ecommercerest.model.ProdutoImagem;
import com.ecommercerest.model.TipoImagem;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProdutoImagemFileService implements FileService<ProdutoImagem> {

    private final Path path;
    private final Produto produto;
    private int row;

    public ProdutoImagemFileService(String path, Produto produto) {
        this.produto = produto;
        this.path = Paths.get(UPLOAD_ROOT + path + produto.getId());
    }

    @Override
    public Path load(String filename) {
        return this.path.resolve(filename);
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.path)
                    .filter(path -> !path.equals(this.path))
                    .map(this.path::relativize);
        } catch (IOException e) {
            throw new StorageException("Falha ao carregar as imagens");
        }

    }

    @Override
    public void createDirectory() {
        try {
            Files.createDirectory(this.path);
        } catch (IOException e) {
            throw new StorageException("Impossível salvar as fotos");
        }
    }

    @Override
    public void deleteDirectory() {
        try {
            Files.walk(this.path).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
        } catch (IOException e) {
            throw new StorageException("Impossível deletar");
        }
    }

    @Override
    public boolean delete(Path path) {
        return path.toFile().delete();
    }

    @Override
    public void deleteAll(List<Path> paths) {
        paths.forEach(this::delete);
    }

    @Override
    public Optional<ProdutoImagem> store(MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        Optional<ProdutoImagem> produtoImagem = Optional.empty();
        try {
            if (file.isEmpty()) {
                throw new StorageEmptyFileException("Arquivo vazio " + filename);
            }
            if (filename.contains("..")) {
                throw new StorageException(
                        "O nome do arquivo "
                                + filename + " é invalido");
            }
            try (InputStream inputStream = file.getInputStream()) {
                String extension = filename.substring(filename.lastIndexOf(".") + 1);
                String url = this.produto.getId() + "-" + this.row;
                long copied = Files.copy(inputStream, this.path.resolve(url + "." + extension),
                        StandardCopyOption.REPLACE_EXISTING);
                if (copied == file.getBytes().length) {
                    this.row++;
                    produtoImagem = Optional.of(new ProdutoImagem(this.path.toString().replace("\\", "/") + "/" + url, TipoImagem.valueOf(extension)));
                }
            }
        } catch (IOException e) {
            throw new StorageException("Falha ao guardar o arquivo " + filename, e);
        }
        return produtoImagem;
    }

    @Override
    public List<ProdutoImagem> storeAll(List<MultipartFile> files) {
        this.row = 0;
        return files.stream().map(file -> store(file).get()).filter(Objects::nonNull).collect(Collectors.toList());
    }

}

