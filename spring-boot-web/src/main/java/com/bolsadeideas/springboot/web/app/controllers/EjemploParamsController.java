package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
/**
 * Dar una ruta base
 */
@RequestMapping("/params")
public class EjemploParamsController {
	/**
	 * Controlador del tipo string
	 */
	@GetMapping({"/", ""})
	public String a(@RequestParam(name="texto", required=false, defaultValue="algún valor...") String texto, Model model) {
		model.addAttribute("resultado", "El texto enviado es: " + texto);
		return "params/index";
	}
	
	
	@GetMapping("/string")
	public String praram(@RequestParam(name="texto", required=false, defaultValue="algún valor...") String texto, Model model) {
		model.addAttribute("resultado", "El texto enviado es: " + texto);
		return "params/ver";
	}
	
	@GetMapping("/mix-params")
	public String a(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		model.addAttribute("resultado", "El texto enviado es: " + saludo + " y el número es '" + numero + "'");
		return "params/ver";
	}
	
	
	@GetMapping("/mix-params/request")
	public String a(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		try {
		numero = Integer.parseInt(request.getParameter("numero"));
		} catch (NumberFormatException e) {
			numero = 0;
		}
		model.addAttribute("resultado", "El texto enviado es: " + saludo + " y el número es '" + numero + "'");
		return "params/ver";
	}


}
