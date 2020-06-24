package com.ecommercerest.error;

import java.util.Calendar;
import java.util.List;

public class CustomErrorResponse {

    private String mensagem;
    private List<String> detalhes;
    private String status;
    private Calendar data;

    public CustomErrorResponse(String mensagem, List<String> detalhes, String status, Calendar data) {
        this.mensagem = mensagem;
        this.detalhes = detalhes;
        this.status = status;
        this.data = data;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public List<String> getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(List<String> detalhes) {
        this.detalhes = detalhes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }
}
