package com.ecommercerest.repository;

import com.ecommercerest.model.Venda;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.TemporalType;
import java.util.Date;

public interface VendaRepository extends CrudRepository<Venda, Long> {


    public Page<Venda> findAll(Pageable pageable);

    public Page<Venda> findDistinctByDataVendaGreaterThanAndTotalVendaGreaterThan(
            @Temporal(TemporalType.DATE) Date dataVenda, Double total, Pageable pageable);

    public Page<Venda> findDistinctByDataVendaGreaterThan(@Temporal(TemporalType.DATE) Date data,
                                                          Pageable pageable);

}
