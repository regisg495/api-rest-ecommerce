package com.ecommercerest.service;

import com.ecommercerest.model.Endereco;
import com.ecommercerest.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> findAll() {
        return this.enderecoRepository.findAll();
    }

    public Endereco findById(Long id) {
        Optional<Endereco> endereco = this.enderecoRepository.findById(id);
        if (!endereco.isPresent()) throw new EntityNotFoundException("Endereço inexistente");
        return endereco.get();
    }

    @Transactional
    public void deleteById(Long id) {
        Endereco endereco = this.findById(id);
        this.enderecoRepository.deleteById(endereco.getId());
    }

    @Transactional
    public Endereco save(Endereco endereco) {
        return this.enderecoRepository.save(endereco);
    }

}
