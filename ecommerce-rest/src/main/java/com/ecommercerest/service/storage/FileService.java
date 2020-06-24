package com.ecommercerest.service.storage;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public interface FileService <T> {

    public final String UPLOAD_ROOT = "upload";

    public Path load(String filename);

    public Stream<Path> loadAll();

    public void createDirectory();

    public void deleteDirectory();

    public boolean delete(Path path);

    public void deleteAll(List<Path> paths);

    public Optional<T> store(MultipartFile file);

    public List<T> storeAll(List<MultipartFile> files);

}
