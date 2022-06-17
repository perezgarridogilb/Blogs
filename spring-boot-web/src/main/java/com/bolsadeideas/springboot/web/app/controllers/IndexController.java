package com.bolsadeideas.springboot.web.app.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	/**
	 * Nombre de la vista que tiene que mostrar o cargar
	 * @return
	 */
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	@GetMapping({"/index", "/", "", "/home"})
	public String index(Model model) {
		/**
		 * Map
		 * ModelMap
		 * 
		 * addAttribute
		 * 
		 * *
		 * 
		 * Map<String, Object>
		 * 
		 * map.put
		 * 
		 * *
		 * 
		 * public ModelAndView
		 * 
		 * mv.addObject
		 */
		model.addAttribute("titulo", textoIndex);
		// model.setViewName("index");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Django");
		usuario.setApellido("RESTfull");
		usuario.setEmail("andre2s@correo.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	@RequestMapping("/lista")
	public String lista(Model model) {
		// List<Usuario> usuarios = new ArrayList<>();
		// usuarios.add(new Usuario("Django", "RESTfull", "andre2s@correo.com"));
		// usuarios.add(new Usuario("Django1", "RESTfull", "andre2s@correo.com"));
		// usuarios.add(new Usuario("Django11", "RESTfull", "andre2s@correo.com"));
		model.addAttribute("titulo", textoListar);
		// model.addAttribute("usuarios", usuarios);
		return "listar";
	}
	
	/**
	 * Pasar datos fuera de la vista
	 * @return
	 */
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){

		List<Usuario> usuarios = Arrays.asList(new Usuario("Andrés", "Guzmán", "andres@correo.com"),
				new Usuario("Django", "RESTfull", "andre2s@correo.com"),
				new Usuario("Django1", "RESTfull", "andre2s@correo.com"),
				new Usuario("Django11", "RESTfull", "andre2s@correo.com")
				);
		
		return usuarios;
	}

}
