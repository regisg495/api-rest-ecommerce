package com.ecommercerest.service;

import com.ecommercerest.model.Cliente;
import com.ecommercerest.model.Sexo;
import com.ecommercerest.model.TipoEndereco;
import com.ecommercerest.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Page<Cliente> findDistinctByEnderecoPrincipal_TipoEnderecoOrEnderecoPrincipalCepLocalidadeOrEnderecoPrincipalCepBairro(Optional<TipoEndereco> tipoEndereco, Optional<String> localidade, Optional<String> bairro, Pageable pageable) {
        return this.clienteRepository.findDistinctByEnderecoPrincipal_TipoEnderecoOrEnderecoPrincipalCepLocalidadeOrEnderecoPrincipalCepBairro(tipoEndereco, localidade, bairro, pageable);
    }

    public Page<Cliente> findDistinctByEnderecoPrincipal_CepUfAndSexo(Sexo sexo, String localidade, Pageable pageable) {
        return this.clienteRepository.findDistinctBySexoAndEnderecoPrincipalCepLocalidade(sexo, localidade, pageable);

    }

    public List<Cliente> findAll() {
        return this.clienteRepository.findAll();
    }

    public Page<Cliente> findAll(Pageable pageable) {
        return this.clienteRepository.findAll(pageable);
    }

    public Cliente findById(Long id) {
        Optional<Cliente> cliente = this.clienteRepository.findById(id);
        if (!cliente.isPresent()) throw new EntityNotFoundException("Cliente não encontrado");
        return cliente.get();
    }

    @Transactional
    public void deleteById(Long id) {
        Cliente cliente = this.findById(id);
        this.clienteRepository.deleteById(cliente.getId());
    }

}
