package com.bolsadeideas.springboot.form.app.controllers;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.form.app.editors.NombreMayusculaEditor;
import com.bolsadeideas.springboot.form.app.models.domain.Usuario;
import com.bolsadeideas.springboot.form.app.validation.UsuarioValidador;

@Controller
@SessionAttributes("usuario")
public class FormController {
	
	@Autowired
	private UsuarioValidador validador;
	
	/**
	 * Poblar los datos del formulario
	 * @param model
	 * @return
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		/* binder.setValidator(validador); */
		binder.addValidators(validador);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		/**
		 * Qué sea estricto con el formato
		 */
		dateFormat.setLenient(false);
		
		/**
		 * Le pasamos Date y una instancia (true o false para verse vacío (validación adicional en caso de true))
		 * "fechaNacimiento": ser específico con la validación
		 * 
		 */
		binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(String.class, "nombre", new NombreMayusculaEditor());
		binder.registerCustomEditor(String.class, "apellido", new NombreMayusculaEditor());
	}
	
	@ModelAttribute("paises")
	public List<String> paises(){
		return Arrays.asList("España", "México", "Chile", "Argentina", "Perú", "Colombia", "Venezuela");
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("John");
		usuario.setApellido("Doe");
		usuario.setIdentificador("123.456.789-KLO");
		model.addAttribute("titulo", "Formulario usuarios");
		model.addAttribute("usuario", usuario);

		return"form";
	}
	
	/*
	 * 
	 * BindingResult: Objeto propio de Spring y representa el resultado de la validación
	 * Se inyecta de forma automática cuando está anotado el objeto con @Valid (ANTES del objeto que se valida)
	 * 
	 */
	
	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
		
		/* validador.validate(usuario, result); */
		//  @ModelAttribute("user")
		model.addAttribute("titulo", "Resultado form");
		
		if(result.hasErrors()) {
			/*
			 * Map<String, String> errores = new HashMap<>();
			 * result.getFieldErrors().forEach(err ->{ errores.put(err.getField(),
			 * "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()
			 * )); }); model.addAttribute("error", errores);
			 */
			return "form";
		}
		
		model.addAttribute("usuario", usuario);
		status.setComplete();
		return "resultado";
	}
}
