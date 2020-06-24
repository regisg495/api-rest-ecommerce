package com.ecommercerest.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Long id;

    @Column(name = "tipo_endereco")
    @Enumerated(EnumType.STRING)
    private TipoEndereco tipoEndereco;

    @Column(name = "nome_destinatario_endereco")
    private String nomeDestinatario;

    @Column(name = "numero_endereco")
    private String numero;

    @Column(name = "complemento_endereco")
    private String complemento;

    @Column(name = "informacoes_referencia_endereco")
    private String informacoesReferencia;

    @AttributeOverrides({
            @AttributeOverride(name = "cep", column = @Column(name = "cep_endereco")),
            @AttributeOverride(name = "logradouro", column = @Column(name = "logradouro_endereco")),
            @AttributeOverride(name = "bairro", column = @Column(name = "bairro_endereco")),
            @AttributeOverride(name = "localidade", column = @Column(name = "cidade_endereco")),
            @AttributeOverride(name = "uf", column = @Column(name = "uf_endereco"))

    })
    @Embedded
    private CEP cep;

    @OneToOne(mappedBy = "enderecoPrincipal", fetch = FetchType.LAZY)
    private Cliente cliente;

    @ManyToMany(mappedBy = "enderecos", fetch = FetchType.LAZY)
    private List<Cliente> clientes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getInformacoesReferencia() {
        return informacoesReferencia;
    }

    public void setInformacoesReferencia(String informacoesReferencia) {
        this.informacoesReferencia = informacoesReferencia;
    }

    public CEP getCep() {
        return cep;
    }

    public void setCep(CEP cep) {
        this.cep = cep;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
