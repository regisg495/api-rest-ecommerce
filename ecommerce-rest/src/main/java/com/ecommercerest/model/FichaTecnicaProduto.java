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
@Table(name = "ficha_tecnica_produto")
public class FichaTecnicaProduto {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produto")
    @MapsId
    private Produto produto;

    @Column(name = "valor_campo_1")
    private String valorCampo1;

    @Column(name = "valor_campo_2")
    private String valorCampo2;

    @Column(name = "valor_campo_3")
    private String valorCampo3;

    @Column(name = "valor_campo_4")
    private String valorCampo4;

    @Column(name = "valor_campo_5")
    private String valorCampo5;

    @Column(name = "valor_campo_6")
    private String valorCampo6;

    @Column(name = "valor_campo_7")
    private String valorCampo7;

    @Column(name = "valor_campo_8")
    private String valorCampo8;

    @Column(name = "valor_campo_9")
    private String valorCampo9;

    @Column(name = "valor_campo_10")
    private String valorCampo10;

    public FichaTecnicaProduto() {

    }

    public FichaTecnicaProduto(Produto produto, String valorCampo1, String valorCampo2, String valorCampo3, String valorCampo4, String valorCampo5, String valorCampo6, String valorCampo7, String valorCampo8, String valorCampo9, String valorCampo10) {
        this.produto = produto;
        this.valorCampo1 = valorCampo1;
        this.valorCampo2 = valorCampo2;
        this.valorCampo3 = valorCampo3;
        this.valorCampo4 = valorCampo4;
        this.valorCampo5 = valorCampo5;
        this.valorCampo6 = valorCampo6;
        this.valorCampo7 = valorCampo7;
        this.valorCampo8 = valorCampo8;
        this.valorCampo9 = valorCampo9;
        this.valorCampo10 = valorCampo10;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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
}
