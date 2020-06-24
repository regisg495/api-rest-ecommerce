package com.ecommercerest.error.validation;

import com.ecommercerest.controller.form.UsuarioForm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        UsuarioForm usuarioForm = (UsuarioForm) object;
        return usuarioForm.getSenha().equals(usuarioForm.getConfirmacaoSenha());
    }
}
