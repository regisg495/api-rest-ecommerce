package com.ecommercerest.repository;

import com.ecommercerest.model.Avaliacao;
import com.ecommercerest.model.Cliente;
import com.ecommercerest.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.TemporalType;
import java.util.Date;

public interface AvaliacaoRepository extends CrudRepository<Avaliacao, Long> {

    Page<Avaliacao> findAllByProduto(Produto produto, Pageable pageable);

    Page<Avaliacao> findAllByCliente(Cliente cliente, Pageable pageable);

    Page<Avaliacao> findAllByClienteAndDataAvaliacaoBetweenOrderByDataAvaliacaoDesc(Cliente cliente,
                                                                           @Temporal(TemporalType.DATE) Date dataAvaliacaoIni,
                                                                           @Temporal(TemporalType.DATE) Date dataAvaliacaoFim,
                                                                           Pageable pageable);

    Page<Avaliacao> findAllByProdutoAndClienteAndDataAvaliacaoBetweenOrderByDataAvaliacaoDesc(Produto produto,
                                                                                       Cliente cliente,
                                                                                       @Temporal(TemporalType.DATE) Date dataAvaliacaoIni,
                                                                                       @Temporal(TemporalType.DATE) Date dataAvaliacaoFim,
                                                                                       Pageable pageable);
}
