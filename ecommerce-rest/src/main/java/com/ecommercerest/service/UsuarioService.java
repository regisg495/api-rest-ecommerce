package com.ecommercerest.service;

import com.ecommercerest.config.security.AuthenticationTokenProvider;
import com.ecommercerest.controller.form.PermissaoUsuarioForm;
import com.ecommercerest.controller.form.UsuarioForm;
import com.ecommercerest.error.FieldValueAlreadyExistsException;
import com.ecommercerest.model.Permissao;
import com.ecommercerest.model.Usuario;
import com.ecommercerest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PermissaoService permissaoService;

    @Autowired
    private AuthenticationTokenProvider authenticationTokenProvider;

    public Page<Usuario> findAll(Pageable pageable) {
        return this.usuarioRepository.findAll(pageable);
    }

    public Usuario findByEmail(String email) {
        Optional<Usuario> usuario = this.usuarioRepository.findByEmail(email);
        if (!usuario.isPresent()) throw new UsernameNotFoundException("Email inválido");
        return usuario.get();
    }

    public List<Usuario> findAll() {
        return this.usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        Optional<Usuario> usuario = this.usuarioRepository.findById(id);
        if (!usuario.isPresent()) throw new EntityNotFoundException("Usuário inexistente");
        return usuario.get();
    }

    @Transactional
    public Usuario save(UsuarioForm usuarioForm) {
        List<Usuario> usuarios = this.usuarioRepository.findByEmailOrCpfOrTelefoneCelularOrTelefoneResidencial(usuarioForm.getEmail(), usuarioForm.getCpf(), usuarioForm.getTelefoneCelular(), usuarioForm.getTelefoneResidencial());
        if (!usuarios.isEmpty())
            throw new FieldValueAlreadyExistsException(getMsgUniqueUsuarioErrorAdd(usuarios, usuarioForm));

        Usuario usuario = usuarioForm.convert();
        return this.usuarioRepository.save(usuario);
    }

    public String getMsgUniqueUsuarioErrorAdd(List<Usuario> usuarios, UsuarioForm usuarioForm) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Já existe um usuário cadastrado com esse ");
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equalsIgnoreCase(usuarioForm.getEmail()))
                stringBuilder.append("email: " + usuarioForm.getEmail() + ". ");
            if (usuario.getCpf().equals(usuarioForm.getCpf()))
                stringBuilder.append("cpf: " + usuarioForm.getCpf() + ". ");
            if (usuario.getTelefoneCelular().equals(usuarioForm.getTelefoneCelular()))
                stringBuilder.append("telefone celular: " + usuarioForm.getTelefoneCelular() + ". ");
            if (usuario.getTelefoneResidencial().equals(usuarioForm.getTelefoneResidencial()))
                stringBuilder.append("telefone residencial: " + usuarioForm.getTelefoneResidencial() + ".");
        }

        return stringBuilder.toString();
    }

    public String getMsgUniqueUsuarioErrorEdit(List<Usuario> usuarios, UsuarioForm usuarioForm, Long id) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Já existe um usuário cadastrado com esse ");
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equalsIgnoreCase(usuarioForm.getEmail()) && usuario.getId() != id)
                stringBuilder.append("email: " + usuarioForm.getEmail() + ". ");
            if (usuario.getCpf().equals(usuarioForm.getCpf()) && usuario.getId() != id)
                stringBuilder.append("cpf: " + usuarioForm.getCpf() + ". ");
            if (usuario.getTelefoneCelular().equals(usuarioForm.getTelefoneCelular()) && usuario.getId() != id)
                stringBuilder.append("telefone celular: " + usuarioForm.getTelefoneCelular() + ". ");
            if (usuario.getTelefoneResidencial().equals(usuarioForm.getTelefoneResidencial()) && usuario.getId() != id)
                stringBuilder.append("telefone residencial: " + usuarioForm.getTelefoneResidencial() + ".");
        }

        return stringBuilder.toString();
    }

    @Transactional
    public void deleteById(Long id) {
        Usuario usuario = this.findById(id);
        this.usuarioRepository.deleteById(usuario.getId());
    }

    @Transactional
    public Usuario edit(Long id, UsuarioForm usuarioForm) {
        Usuario usuario = this.findById(id);

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization").split(" ")[1];

        Optional<Usuario> usuario1 = this.usuarioRepository.findByEmail(authenticationTokenProvider.getUsername(token));

        if(!usuario1.isPresent()) throw new AuthenticationCredentialsNotFoundException("Erro de autenticação");

        if(!usuario1.get().getEmail().equals(usuario.getEmail())) throw new IllegalArgumentException("Somente você pode alterar seus dados");

        List<Usuario> usuarios = this.usuarioRepository.findByEmailOrCpfOrTelefoneCelularOrTelefoneResidencial(usuarioForm.getEmail(), usuarioForm.getCpf(), usuarioForm.getTelefoneCelular(), usuarioForm.getTelefoneResidencial());
        if (usuarios.size() > 1)
            throw new FieldValueAlreadyExistsException(getMsgUniqueUsuarioErrorEdit(usuarios, usuarioForm, usuario.getId()));

        usuario.setNome(usuarioForm.getNome());
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuarioForm.getSenha()));
        usuario.setCpf(usuarioForm.getCpf());
        usuario.setDataNascimento(usuarioForm.getDataNascimento());
        usuario.setTelefoneCelular(usuarioForm.getTelefoneCelular());
        usuario.setTelefoneResidencial(usuarioForm.getTelefoneResidencial());
        usuario.setEmail(usuarioForm.getEmail());

        return usuario;
    }

    @Transactional
    public Usuario editPermissoes(Long id, PermissaoUsuarioForm permissaoUsuarioForm) {
        Usuario usuario = this.findById(id);
        List<Permissao> permissoes = permissaoUsuarioForm.convert(this.permissaoService);
        usuario.setPermissoes(permissoes);
        return usuario;
    }
}
