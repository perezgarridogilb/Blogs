package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
public class HomeController {

	@GetMapping("/")
	public String home() {
		// return "redirect:/app/index";
		/**
		 * forward: ruta del proyecto
		 */
		return "forward:/app/index";
	}
}
