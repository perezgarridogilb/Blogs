package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.models.service.IServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicio;

@Controller
public class IndexController {
	
	/**
	 * Meter un objeto que esta registrado en el contenedor de Spring Boot
	 * 
	 * Depende de algo genérico (no concreto)
	 */
	// @Autowired
	//private MiServicio servicio;
	
	/**
	 * @Autowired: Sin este lo inyecta de forma implícita por los parámetros (MiServicio servicio)
	 * @param servicio
	 */
	
	// @Autowired
	// public IndexController(MiServicio servicio) {
	// 	// super();
	// 	this.servicio = servicio;
	// }
	
	@Autowired
	/**
	 * Permite también, seleccionar a través del nombre para inyectar el componente especifíco que implementa la interfaz
	 */
	// @Qualifier("miServicioPrincipal")
	@Qualifier("miServicioComplejo")
	private IServicio servicio;

	/**
	 * Para pasar datos en ella
	 */
	@GetMapping({"/", "", "/index"})
	public String index(Model model) {
		model.addAttribute("objeto", servicio.operacion());
		return "index";
	}

	// @Autowired
	// public void setServicio(MiServicio servicio) {
	// 	this.servicio = servicio;
	// }
	
	

}
