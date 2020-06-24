package com.ecommercerest.controller.dto;

import com.ecommercerest.model.FichaTecnicaProduto;
import com.google.common.collect.Lists;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class FichaTecnicaProdutoDTO {

    private String nomeProduto;

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

    public FichaTecnicaProdutoDTO() {

    }

    public FichaTecnicaProdutoDTO(FichaTecnicaProduto fichaTecnicaProduto) {
        this.nomeProduto = fichaTecnicaProduto.getProduto().getNome();
        this.valorCampo1 = fichaTecnicaProduto.getValorCampo1();
        this.valorCampo2 = fichaTecnicaProduto.getValorCampo2();
        this.valorCampo3 = fichaTecnicaProduto.getValorCampo3();
        this.valorCampo4 = fichaTecnicaProduto.getValorCampo4();
        this.valorCampo5 = fichaTecnicaProduto.getValorCampo5();
        this.valorCampo6 = fichaTecnicaProduto.getValorCampo6();
        this.valorCampo7 = fichaTecnicaProduto.getValorCampo7();
        this.valorCampo8 = fichaTecnicaProduto.getValorCampo8();
        this.valorCampo9 = fichaTecnicaProduto.getValorCampo9();
        this.valorCampo10 = fichaTecnicaProduto.getValorCampo10();
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getValorCampo1() {
        return valorCampo1;
    }

    public String getValorCampo2() {
        return valorCampo2;
    }

    public String getValorCampo3() {
        return valorCampo3;
    }

    public String getValorCampo4() {
        return valorCampo4;
    }

    public String getValorCampo5() {
        return valorCampo5;
    }

    public String getValorCampo6() {
        return valorCampo6;
    }

    public String getValorCampo7() {
        return valorCampo7;
    }

    public String getValorCampo8() {
        return valorCampo8;
    }

    public String getValorCampo9() {
        return valorCampo9;
    }

    public String getValorCampo10() {
        return valorCampo10;
    }

    public static FichaTecnicaProdutoDTO convert(FichaTecnicaProduto fichaTecnicaProduto) {
        return new FichaTecnicaProdutoDTO(fichaTecnicaProduto);
    }

    public List<String> convertToStringList() {
        List<Field> fields = Lists.newArrayList(this.getClass().getDeclaredFields());
        List<String> valores = new ArrayList<>();
        fields.forEach(field -> {
            field.setAccessible(true);
            try {
                Object val = field.get(this).toString();
                valores.add(val.toString());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (NullPointerException e) {
                valores.add("Campo à preencher");
            }
        });
        return valores;
    }

    public static Map<String, String> convertToMap(List<String> campos, List<String> valores) {
        Map<String, String> fichaTecnicaProdutoMap = new LinkedHashMap<>();

        IntStream.range(0, campos.size()).boxed().
                filter(integer -> !campos.get(integer).equals("Campo vazio")).
                forEach(integer -> fichaTecnicaProdutoMap.put(
                campos.get(integer), valores.get(integer)));

        return fichaTecnicaProdutoMap;
    }

    public static Page<Map<String, String>> convert(Page<FichaTecnicaProduto> fichaTecnicaProdutos) {

        List<Map<String, String>> fichaTecnicaCampoValorMap = new ArrayList<>();

        IntStream.range(0, fichaTecnicaProdutos.getContent().size()).boxed()
                .forEach(integer -> fichaTecnicaCampoValorMap.add(
                        new LinkedHashMap<>(
                                convertToMap(
                                        new FichaTecnicaCampoDTO(fichaTecnicaProdutos.toList().get(integer)
                                                .getProduto().getSubgrupo().getFichaTecnicaCampo()).convertToStringList(),
                                        new FichaTecnicaProdutoDTO(fichaTecnicaProdutos.toList()
                                                .get(integer)).convertToStringList()
                                )
                        )
                ));

        return new PageImpl<>(
                fichaTecnicaCampoValorMap, fichaTecnicaProdutos.getPageable(),
                fichaTecnicaProdutos.getTotalPages());
    }

}
