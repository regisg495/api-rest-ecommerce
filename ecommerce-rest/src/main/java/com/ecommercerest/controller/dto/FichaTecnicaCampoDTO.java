package com.ecommercerest.controller.dto;

import com.ecommercerest.model.FichaTecnicaCampo;
import com.google.common.collect.Lists;
import org.springframework.data.domain.Page;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FichaTecnicaCampoDTO {

    private String nomeSubgrupo;
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

    public FichaTecnicaCampoDTO(FichaTecnicaCampo fichaTecnicaCampo) {
        this.nomeSubgrupo = fichaTecnicaCampo.getSubgrupo().getNome();
        this.nomeCampo1 = fichaTecnicaCampo.getNomeCampo1();
        this.nomeCampo2 = fichaTecnicaCampo.getNomeCampo2();
        this.nomeCampo3 = fichaTecnicaCampo.getNomeCampo3();
        this.nomeCampo4 = fichaTecnicaCampo.getNomeCampo4();
        this.nomeCampo5 = fichaTecnicaCampo.getNomeCampo5();
        this.nomeCampo6 = fichaTecnicaCampo.getNomeCampo6();
        this.nomeCampo7 = fichaTecnicaCampo.getNomeCampo7();
        this.nomeCampo8 = fichaTecnicaCampo.getNomeCampo8();
        this.nomeCampo9 = fichaTecnicaCampo.getNomeCampo9();
        this.nomeCampo10 = fichaTecnicaCampo.getNomeCampo10();
    }

    public String getNomeSubgrupo() {
        return nomeSubgrupo;
    }

    public String getNomeCampo1() {
        return nomeCampo1;
    }

    public String getNomeCampo2() {
        return nomeCampo2;
    }

    public String getNomeCampo3() {
        return nomeCampo3;
    }

    public String getNomeCampo4() {
        return nomeCampo4;
    }

    public String getNomeCampo5() {
        return nomeCampo5;
    }

    public String getNomeCampo6() {
        return nomeCampo6;
    }

    public String getNomeCampo7() {
        return nomeCampo7;
    }

    public String getNomeCampo8() {
        return nomeCampo8;
    }

    public String getNomeCampo9() {
        return nomeCampo9;
    }

    public String getNomeCampo10() {
        return nomeCampo10;
    }

    public static FichaTecnicaCampoDTO convert(FichaTecnicaCampo fichaTecnicaCampo) {
        return new FichaTecnicaCampoDTO(fichaTecnicaCampo);
    }

    public static Page<FichaTecnicaCampoDTO> convert(Page<FichaTecnicaCampo> fichaTecnicaCampos) {
        return fichaTecnicaCampos.map(FichaTecnicaCampoDTO::new);
    }

    public List<String> convertToStringList() {
        List<Field> fields = Lists.newArrayList(this.getClass().getDeclaredFields());
        List<String> campos = new ArrayList<>();
        fields.forEach(field -> {
            field.setAccessible(true);
            try {
                Object val = field.get(this);
                campos.add(val.toString());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (NullPointerException e) {
                campos.add("Campo vazio");
            }
        });

        return campos;
    }
}
