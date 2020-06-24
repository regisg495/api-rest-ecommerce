package com.ecommercerest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ficha_tecnica_campo")
public class FichaTecnicaCampo {

    @Id
    private Short id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subgrupo")
    @MapsId
    private SubGrupo subgrupo;

    @Column(name = "nome_campo_1")
    private String nomeCampo1;

    @Column(name = "nome_campo_2")
    private String nomeCampo2;

    @Column(name = "nome_campo_3")
    private String nomeCampo3;

    @Column(name = "nome_campo_4")
    private String nomeCampo4;

    @Column(name = "nome_campo_5")
    private String nomeCampo5;

    @Column(name = "nome_campo_6")
    private String nomeCampo6;

    @Column(name = "nome_campo_7")
    private String nomeCampo7;

    @Column(name = "nome_campo_8")
    private String nomeCampo8;

    @Column(name = "nome_campo_9")
    private String nomeCampo9;

    @Column(name = "nome_campo_10")
    private String nomeCampo10;

    public FichaTecnicaCampo() {

    }

    public FichaTecnicaCampo(SubGrupo subgrupo, String nomeCampo1, String nomeCampo2, String nomeCampo3, String nomeCampo4, String nomeCampo5, String nomeCampo6, String nomeCampo7, String nomeCampo8, String nomeCampo9, String nomeCampo10) {
        this.subgrupo = subgrupo;
        this.nomeCampo1 = nomeCampo1;
        this.nomeCampo2 = nomeCampo2;
        this.nomeCampo3 = nomeCampo3;
        this.nomeCampo4 = nomeCampo4;
        this.nomeCampo5 = nomeCampo5;
        this.nomeCampo6 = nomeCampo6;
        this.nomeCampo7 = nomeCampo7;
        this.nomeCampo8 = nomeCampo8;
        this.nomeCampo9 = nomeCampo9;
        this.nomeCampo10 = nomeCampo10;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public SubGrupo getSubgrupo() {
        return subgrupo;
    }

    public void setSubgrupo(SubGrupo subgrupo) {
        this.subgrupo = subgrupo;
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
}
