package com.ecommercerest.repository;

import com.ecommercerest.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    @Override
    public List<Usuario> findAll();

    public Page<Usuario> findAll(Pageable pageable);

    public Optional<Usuario> findByEmail(String email);

    public List<Usuario> findByEmailOrCpfOrTelefoneCelularOrTelefoneResidencial(String email, String cpf, String telefoneCelular, String telefoneResidencial);

}
