package com.ecommercerest.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Column(name = "nome_cliente")
    private String nome;

    @Column(name = "email_cliente")
    private String email;

    @Column(name = "senha_cliente")
    private String senha;

    @Column(name = "apelido_cliente")
    private String apelido;

    @Column(name = "sexo_cliente")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(name = "cpf_cliente")
    private String cpf;

    @Column(name = "data_nascimento_cliente")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;

    @Column(name = "telefone_residencial_cliente")
    private String telefoneResidencial;

    @Column(name = "telefone_celular_cliente")
    private String telefoneCelular;

    @Column(name = "data_atualizacao_cliente")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataAtualizacao;

    @Column(name = "esta_ativo_cliente")
    private Boolean ativo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_endereco_principal_cliente", referencedColumnName = "id_endereco")
    private Endereco enderecoPrincipal;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "cliente_endereco",
            joinColumns = @JoinColumn(name = "id_cliente"),
            inverseJoinColumns = @JoinColumn(name = "id_endereco"))
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Venda> compras = new ArrayList<>();

    public Cliente() {

    }

    public Cliente(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public Calendar getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Calendar dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Endereco getEnderecoPrincipal() {
        return enderecoPrincipal;
    }

    public void setEnderecoPrincipal(Endereco enderecoPrincipal) {
        this.enderecoPrincipal = enderecoPrincipal;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public List<Venda> getCompras() {
        return compras;
    }

    public void setCompras(List<Venda> compras) {
        this.compras = compras;
    }
}
