package com.ecommercerest.controller.form;

import com.ecommercerest.model.FichaTecnicaCampo;
import com.ecommercerest.model.SubGrupo;
import com.ecommercerest.service.SubGrupoService;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class FichaTecnicaCampoForm {

    @Min(value = 1, message = "O valor deve ser maior que zero")
    @NotNull(message = "O campo subgrupo é obrigatório")
    private Short id_subgrupo;

    private String nomeCampo1;

    private String nomeCampo2;

    private String nomeCampo3;

    private String nomeCampo4;

    private String nomeCampo5;

    private String nomeCampo6;

    private String nomeCampo7;

    private String nomeCampo8;

    private String nomeCampo9;

    private String nomeCampo10;

    public Short getId_subgrupo() {
        return id_subgrupo;
    }

    public void setId_subgrupo(Short id_subgrupo) {
        this.id_subgrupo = id_subgrupo;
    }

    public String getNomeCampo1() {
        return nomeCampo1;
    }

    public void setNomeCampo1(String nomeCampo1) {
        this.nomeCampo1 = nomeCampo1;
    }

    public String getNomeCampo2() {
        return nomeCampo2;
    }

    public void setNomeCampo2(String nomeCampo2) {
        this.nomeCampo2 = nomeCampo2;
    }

    public String getNomeCampo3() {
        return nomeCampo3;
    }

    public void setNomeCampo3(String nomeCampo3) {
        this.nomeCampo3 = nomeCampo3;
    }

    public String getNomeCampo4() {
        return nomeCampo4;
    }

    public void setNomeCampo4(String nomeCampo4) {
        this.nomeCampo4 = nomeCampo4;
    }

    public String getNomeCampo5() {
        return nomeCampo5;
    }

    public void setNomeCampo5(String nomeCampo5) {
        this.nomeCampo5 = nomeCampo5;
    }

    public String getNomeCampo6() {
        return nomeCampo6;
    }

    public void setNomeCampo6(String nomeCampo6) {
        this.nomeCampo6 = nomeCampo6;
    }

    public String getNomeCampo7() {
        return nomeCampo7;
    }

    public void setNomeCampo7(String nomeCampo7) {
        this.nomeCampo7 = nomeCampo7;
    }

    public String getNomeCampo8() {
        return nomeCampo8;
    }

    public void setNomeCampo8(String nomeCampo8) {
        this.nomeCampo8 = nomeCampo8;
    }

    public String getNomeCampo9() {
        return nomeCampo9;
    }

    public void setNomeCampo9(String nomeCampo9) {
        this.nomeCampo9 = nomeCampo9;
    }

    public String getNomeCampo10() {
        return nomeCampo10;
    }

    public void setNomeCampo10(String nomeCampo10) {
        this.nomeCampo10 = nomeCampo10;
    }

    public FichaTecnicaCampo convert(SubGrupoService subGrupoService) {
        SubGrupo subGrupo = subGrupoService.findById(this.id_subgrupo);
        return new FichaTecnicaCampo(subGrupo, this.nomeCampo1, this.nomeCampo2, this.nomeCampo3, this.nomeCampo4, this.nomeCampo5,
                this.nomeCampo6, this.nomeCampo7, this.nomeCampo8, this.nomeCampo9, this.nomeCampo10);
    }
}
