package com.ecommercerest.service;

import com.ecommercerest.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;

    public Boolean existsById(String id) {
        return this.permissaoRepository.existsById(id);
    }

}
