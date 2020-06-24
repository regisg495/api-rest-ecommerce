package com.ecommercerest.service;

import com.ecommercerest.model.Venda;
import com.ecommercerest.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public Page<Venda> findAll(Pageable pageable) {
        return this.vendaRepository.findAll(pageable);
    }

    public Venda findById(Long id) {
        Optional<Venda> venda = this.vendaRepository.findById(id);
        if(!venda.isPresent()) throw new EntityExistsException("Venda não encontrada");
        return venda.get();
    }

    public Page<Venda> findDistinctByDataVendaGreaterThanAndTotalVendaGreaterThan(
            @Temporal(TemporalType.DATE) Date dataVenda, Double total, Pageable pageable) {
        return this.vendaRepository.findDistinctByDataVendaGreaterThanAndTotalVendaGreaterThan(dataVenda, total, pageable);
    }


    public Page<Venda> findDistinctByDataVendaGreaterThan(@Temporal(TemporalType.DATE) Date data,
                                                          Pageable pageable) {
        return this.vendaRepository.findDistinctByDataVendaGreaterThan(data, pageable);
    }



}
