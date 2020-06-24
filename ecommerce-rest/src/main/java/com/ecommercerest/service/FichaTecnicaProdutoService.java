package com.ecommercerest.service;

import com.ecommercerest.controller.form.FichaTecnicaProdutoForm;
import com.ecommercerest.error.FieldValueAlreadyExistsException;
import com.ecommercerest.model.FichaTecnicaProduto;
import com.ecommercerest.model.SubGrupo;
import com.ecommercerest.repository.FichaTecnicaProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class FichaTecnicaProdutoService {

    @Autowired
    private FichaTecnicaProdutoRepository fichaTecnicaProdutoRepository;

    @Autowired
    private ProdutoService produtoService;

    public FichaTecnicaProduto findById(Long id) {
        Optional<FichaTecnicaProduto> fichaTecnicaProdutoOptional = this.fichaTecnicaProdutoRepository.findById(id);
        if(!fichaTecnicaProdutoOptional.isPresent()) throw new EntityNotFoundException("Ficha técnica não encontrada");
        return fichaTecnicaProdutoOptional.get();
    }

    public Page<FichaTecnicaProduto> findAll(Pageable pageable) {
        return this.fichaTecnicaProdutoRepository.findAll(pageable);
    }

    @Transactional
    public FichaTecnicaProduto save(FichaTecnicaProdutoForm fichaTecnicaProdutoForm) {
        if(this.fichaTecnicaProdutoRepository.existsById(fichaTecnicaProdutoForm.getId_produto()))
            throw new FieldValueAlreadyExistsException("Já existe uma ficha técnica cadastrada nesse produto");
        FichaTecnicaProduto fichaTecnicaProduto = fichaTecnicaProdutoForm.convert(this.produtoService);
        return this.fichaTecnicaProdutoRepository.save(fichaTecnicaProduto);
    }

    @Transactional
    public void deleteById(Long id) {
        FichaTecnicaProduto fichaTecnicaProduto = this.findById(id);
        this.fichaTecnicaProdutoRepository.deleteById(id);
    }

    @Transactional
    public FichaTecnicaProduto edit(FichaTecnicaProdutoForm fichaTecnicaProdutoForm) {
        FichaTecnicaProduto fichaTecnicaProduto = this.findById(fichaTecnicaProdutoForm.getId_produto());

        fichaTecnicaProduto.setValorCampo1(fichaTecnicaProdutoForm.getValorCampo1());
        fichaTecnicaProduto.setValorCampo2(fichaTecnicaProdutoForm.getValorCampo2());
        fichaTecnicaProduto.setValorCampo3(fichaTecnicaProdutoForm.getValorCampo3());
        fichaTecnicaProduto.setValorCampo4(fichaTecnicaProdutoForm.getValorCampo4());
        fichaTecnicaProduto.setValorCampo5(fichaTecnicaProdutoForm.getValorCampo5());
        fichaTecnicaProduto.setValorCampo6(fichaTecnicaProdutoForm.getValorCampo6());
        fichaTecnicaProduto.setValorCampo7(fichaTecnicaProdutoForm.getValorCampo7());
        fichaTecnicaProduto.setValorCampo8(fichaTecnicaProdutoForm.getValorCampo8());
        fichaTecnicaProduto.setValorCampo9(fichaTecnicaProdutoForm.getValorCampo9());
        fichaTecnicaProduto.setValorCampo10(fichaTecnicaProdutoForm.getValorCampo10());

        return fichaTecnicaProduto;
    }

    public Boolean existsByProdutoSubgrupo(SubGrupo subGrupo) {
        return this.fichaTecnicaProdutoRepository.existsByProdutoSubgrupo(subGrupo);
    }
}
