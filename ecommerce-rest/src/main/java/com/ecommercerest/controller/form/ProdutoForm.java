package com.ecommercerest.controller.form;

import com.ecommercerest.model.Produto;
import com.ecommercerest.model.SubGrupo;
import com.ecommercerest.service.SubGrupoService;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class ProdutoForm {

    @Size(max = 200, message = "O campo nome ultrapassa o limite de caracteres")
    @NotNull(message = "O campo nome é necessário")
    @NotEmpty(message = "O Campo nome é necessário")
    private String nome;

    @Size(max = 65535, message = "O campo detalhes ultrapassa o limite de caracteres")
    private String detalhes;

    @Min(value =  1, message = "O valor minimo é R$ 1.00")
    @NotNull(message = "O campo preço é necessário")
    private Double preco;

    @NotNull(message = "O campo subgrupo é necessário")
    private Short id_subgrupo;

    @Size(min = 1, max = 8, message = "Você deve ter entre 1 e 8 fotos")
    private List<MultipartFile> imagens = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Short getId_subgrupo() {
        return id_subgrupo;
    }

    public void setId_subgrupo(Short id_subgrupo) {
        this.id_subgrupo = id_subgrupo;
    }

    public List<MultipartFile> getImagens() {
        return imagens;
    }

    public void setImagens(List<MultipartFile> imagens) {
        this.imagens = imagens;
    }

    public Produto convert(SubGrupoService subGrupoService) {
        SubGrupo subGrupo = subGrupoService.findById(this.id_subgrupo);
        return new Produto(this.nome, this.detalhes, subGrupo, this.preco, this.imagens);
    }

}
