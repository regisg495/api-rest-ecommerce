package com.ecommercerest.service;

import com.ecommercerest.model.Avaliacao;
import com.ecommercerest.model.Cliente;
import com.ecommercerest.model.Produto;
import com.ecommercerest.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.stereotype.Service;

import javax.persistence.TemporalType;
import java.util.Date;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public Page<Avaliacao> findAllByProduto(Produto produto, Pageable pageable) {
        return this.avaliacaoRepository.findAllByProduto(produto, pageable);
    }

    public Page<Avaliacao> findAllByCliente(Cliente cliente, Pageable pageable) {
        return this.avaliacaoRepository.findAllByCliente(cliente, pageable);
    }

    public Page<Avaliacao> findAllByClienteAndDataAvaliacaoBetweenOrderByDataAvaliacaoDesc(Cliente cliente,
                                                                                           @Temporal(TemporalType.DATE) Date dataAvaliacaoIni,
                                                                                           @Temporal(TemporalType.DATE) Date dataAvaliacaoFim,
                                                                                           Pageable pageable) {
        return this.avaliacaoRepository.findAllByClienteAndDataAvaliacaoBetweenOrderByDataAvaliacaoDesc(cliente,
                dataAvaliacaoIni, dataAvaliacaoFim, pageable);
    }

    public Page<Avaliacao> findAllByProdutoAndClienteAndDataAvaliacaoBetweenOrderByDataAvaliacaoDesc(Produto produto,
                                                                              Cliente cliente,
                                                                              @Temporal(TemporalType.DATE) Date dataAvaliacaoIni,
                                                                              @Temporal(TemporalType.DATE) Date dataAvaliacaoFim,
                                                                              Pageable pageable) {
        return this.avaliacaoRepository.findAllByProdutoAndClienteAndDataAvaliacaoBetweenOrderByDataAvaliacaoDesc(
                produto, cliente, dataAvaliacaoIni, dataAvaliacaoFim, pageable);

    }

}
