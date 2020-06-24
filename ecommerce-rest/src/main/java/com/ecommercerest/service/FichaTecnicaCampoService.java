package com.ecommercerest.service;

import com.ecommercerest.controller.form.FichaTecnicaCampoForm;
import com.ecommercerest.error.FieldValueAlreadyExistsException;
import com.ecommercerest.error.ParentRowDeleteException;
import com.ecommercerest.model.FichaTecnicaCampo;
import com.ecommercerest.repository.FichaTecnicaCampoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class FichaTecnicaCampoService {

    @Autowired
    private FichaTecnicaCampoRepository fichaTecnicaCampoRepository;

    @Autowired
    private SubGrupoService subGrupoService;

    @Autowired
    private FichaTecnicaProdutoService fichaTecnicaProdutoService;

    public FichaTecnicaCampo findById(Short id) {
        Optional<FichaTecnicaCampo> fichaTecnicaCampoOptional = this.fichaTecnicaCampoRepository.findById(id);
        if(!fichaTecnicaCampoOptional.isPresent()) throw new EntityNotFoundException("Ficha técnica não encontrada");
        return fichaTecnicaCampoOptional.get();
    }

    public Page<FichaTecnicaCampo> findAll(Pageable pageable) {
        return this.fichaTecnicaCampoRepository.findAll(pageable);
    }

    @Transactional
    public void deleteById(Short id) {
        FichaTecnicaCampo fichaTecnicaCampo = this.findById(id);
        if(this.fichaTecnicaProdutoService.existsByProdutoSubgrupo(fichaTecnicaCampo.getSubgrupo())) throw new
                ParentRowDeleteException("Existe uma ficha técnica de um produto usando esses campos");
        this.fichaTecnicaCampoRepository.deleteById(fichaTecnicaCampo.getId());
    }

    @Transactional
    public FichaTecnicaCampo save(FichaTecnicaCampoForm fichaTecnicaCampoForm) {
        if(this.fichaTecnicaCampoRepository.existsById(fichaTecnicaCampoForm.getId_subgrupo())) throw new FieldValueAlreadyExistsException("Já existe uma ficha técnica desse subgrupo salva");
        FichaTecnicaCampo fichaTecnicaCampo = fichaTecnicaCampoForm.convert(this.subGrupoService);
        return this.fichaTecnicaCampoRepository.save(fichaTecnicaCampo);
    }

    @Transactional
    public FichaTecnicaCampo edit(FichaTecnicaCampoForm fichaTecnicaCampoForm) {
        FichaTecnicaCampo fichaTecnicaCampo = this.findById(fichaTecnicaCampoForm.getId_subgrupo());

        fichaTecnicaCampo.setNomeCampo1(fichaTecnicaCampoForm.getNomeCampo1());
        fichaTecnicaCampo.setNomeCampo2(fichaTecnicaCampoForm.getNomeCampo2());
        fichaTecnicaCampo.setNomeCampo3(fichaTecnicaCampoForm.getNomeCampo3());
        fichaTecnicaCampo.setNomeCampo4(fichaTecnicaCampo.getNomeCampo4());
        fichaTecnicaCampo.setNomeCampo5(fichaTecnicaCampo.getNomeCampo5());
        fichaTecnicaCampo.setNomeCampo6(fichaTecnicaCampo.getNomeCampo6());
        fichaTecnicaCampo.setNomeCampo7(fichaTecnicaCampo.getNomeCampo7());
        fichaTecnicaCampo.setNomeCampo8(fichaTecnicaCampo.getNomeCampo8());
        fichaTecnicaCampo.setNomeCampo9(fichaTecnicaCampo.getNomeCampo9());
        fichaTecnicaCampo.setNomeCampo10(fichaTecnicaCampo.getNomeCampo10());

        return fichaTecnicaCampo;
    }

}
