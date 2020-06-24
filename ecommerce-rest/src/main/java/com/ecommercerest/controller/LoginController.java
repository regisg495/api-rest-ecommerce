package com.ecommercerest.controller;

//import com.ecommercerest.config.security.TokenService;


import com.ecommercerest.config.security.AuthenticationTokenProvider;
import com.ecommercerest.controller.dto.TokenDTO;
import com.ecommercerest.controller.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthenticationTokenProvider authenticationTokenProvider;

    @PostMapping("/logar")
    public ResponseEntity<TokenDTO> login(@RequestBody @Valid LoginForm loginForm) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = loginForm.convert();
        Authentication authentication = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        String token = authenticationTokenProvider.createToken(authentication);
        return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
    }

}