package com.ecommercerest.repository;

import com.ecommercerest.model.Cliente;
import com.ecommercerest.model.Sexo;
import com.ecommercerest.model.TipoEndereco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    @Override
    public List<Cliente> findAll();

    public Page<Cliente> findAll(Pageable pageable);

    public Page<Cliente> findDistinctByEnderecoPrincipal_TipoEnderecoOrEnderecoPrincipalCepLocalidadeOrEnderecoPrincipalCepBairro(Optional<TipoEndereco> tipoEndereco, Optional<String> localidade, Optional<String> bairro, Pageable pageable);

    public Page<Cliente> findDistinctBySexoAndEnderecoPrincipalCepLocalidade(Sexo sexo, String localidade, Pageable pageable);

}
