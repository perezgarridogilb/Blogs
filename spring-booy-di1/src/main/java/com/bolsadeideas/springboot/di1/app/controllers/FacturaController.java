package com.bolsadeideas.springboot.di1.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.di1.app.models.domain.Factura;

@Controller
@RequestMapping("/factura")
public class FacturaController {
	
	/**
	 * Inyectar en el controlador la factura
	 * @param model
	 * @return
	 */
	private Factura factura;
	
	@GetMapping("/ver")
	public String ver(Model model) {
		model.addAttribute("Attribute", factura);
		model.addAttribute("TITULO", "Ejemplo factura con inyección de dependencia");
		return "factura/ver";
	}
}
