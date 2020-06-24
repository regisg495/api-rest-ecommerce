package com.ecommercerest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nome_usuario")
    private String nome;

    @Column(name = "email_usuario")
    private String email;

    @Column(name = "senha_usuario")
    private String senha;

    @Column(name = "esta_ativo_usuario")
    private Boolean ativo;

    @Column(name = "cpf_usuario")
    private String cpf;

    @Column(name = "data_nascimento_usuario")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;

    @Column(name = "telefone_residencial_usuario")
    private String telefoneResidencial;

    @Column(name = "telefone_celular_usuario")
    private String telefoneCelular;

    @Column(name = "data_atualizacao_usuario")
    private Calendar dataAtualizacao;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_permissao",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "nome_permissao"))
    private List<Permissao> permissoes = new ArrayList<>();

    @PrePersist
    public void setEncodeSenha() {
        this.senha = new BCryptPasswordEncoder().encode(this.senha);
    }

    public Usuario() {

    }

    public Usuario(String nome, String email, String senha, String cpf, Date dataNascimento, String telefoneResidencial, String telefoneCelular) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefoneResidencial = telefoneResidencial;
        this.telefoneCelular = telefoneCelular;
    }

    public Usuario(String nome, String email, String senha, String cpf) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.permissoes;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.ativo;
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
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

    public List<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }
}
