package com.ecommercerest.controller.form;

import com.ecommercerest.error.FieldsTempateNotFoundException;
import com.ecommercerest.model.FichaTecnicaProduto;
import com.ecommercerest.model.Produto;
import com.ecommercerest.service.ProdutoService;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class FichaTecnicaProdutoForm {

    @NotNull(message = "Campo produto é obrigatório")
    @Min(value = 1, message = "O valor deve ser maior que zero")
    private Long id_produto;
    private String valorCampo1;
    private String valorCampo2;
    private String valorCampo3;
    private String valorCampo4;
    private String valorCampo5;
    private String valorCampo6;
    private String valorCampo7;
    private String valorCampo8;
    private String valorCampo9;
    private String valorCampo10;

    public Long getId_produto() {
        return id_produto;
    }

    public void setId_produto(Long id_produto) {
        this.id_produto = id_produto;
    }

    public String getValorCampo1() {
        return valorCampo1;
    }

    public void setValorCampo1(String valorCampo1) {
        this.valorCampo1 = valorCampo1;
    }

    public String getValorCampo2() {
        return valorCampo2;
    }

    public void setValorCampo2(String valorCampo2) {
        this.valorCampo2 = valorCampo2;
    }

    public String getValorCampo3() {
        return valorCampo3;
    }

    public void setValorCampo3(String valorCampo3) {
        this.valorCampo3 = valorCampo3;
    }

    public String getValorCampo4() {
        return valorCampo4;
    }

    public void setValorCampo4(String valorCampo4) {
        this.valorCampo4 = valorCampo4;
    }

    public String getValorCampo5() {
        return valorCampo5;
    }

    public void setValorCampo5(String valorCampo5) {
        this.valorCampo5 = valorCampo5;
    }

    public String getValorCampo6() {
        return valorCampo6;
    }

    public void setValorCampo6(String valorCampo6) {
        this.valorCampo6 = valorCampo6;
    }

    public String getValorCampo7() {
        return valorCampo7;
    }

    public void setValorCampo7(String valorCampo7) {
        this.valorCampo7 = valorCampo7;
    }

    public String getValorCampo8() {
        return valorCampo8;
    }

    public void setValorCampo8(String valorCampo8) {
        this.valorCampo8 = valorCampo8;
    }

    public String getValorCampo9() {
        return valorCampo9;
    }

    public void setValorCampo9(String valorCampo9) {
        this.valorCampo9 = valorCampo9;
    }

    public String getValorCampo10() {
        return valorCampo10;
    }

    public void setValorCampo10(String valorCampo10) {
        this.valorCampo10 = valorCampo10;
    }

    public FichaTecnicaProduto convert(ProdutoService produtoService) {
        Produto produto = produtoService.findById(this.id_produto);
        if(produto.getSubgrupo().getFichaTecnicaCampo() == null)
            throw new FieldsTempateNotFoundException("O subgrupo a que este produto pertence ainda não possui campos cadastrado");

        return new FichaTecnicaProduto(produto, this.valorCampo1, this.valorCampo2, this.valorCampo3,
                this.valorCampo4, this.valorCampo5, this.valorCampo6, this.valorCampo7,
                this.valorCampo8, this.valorCampo9, this.valorCampo10);
    }
}
