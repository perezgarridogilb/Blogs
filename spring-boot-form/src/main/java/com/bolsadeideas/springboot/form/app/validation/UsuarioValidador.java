package com.bolsadeideas.springboot.form.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bolsadeideas.springboot.form.app.models.domain.Usuario;

@Component
public class UsuarioValidador implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// Casteos
		Usuario usuario = (Usuario)target;
		
		ValidationUtils.rejectIfEmpty(errors, "nombre", "NotEmpty.usuario.nombre");
		
		/**
		 * Otra alternativa
		
		if(usuario.getNombre().isEmpty()) {
			errors.rejectValue("nombre", "NotEmpty.usuario.nombre");
		}
		 */
		
		if(usuario.getIdentificador().matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}") == false) {
			errors.rejectValue("identificador", "pattern.usuario.identificador");
		}

	}

}
