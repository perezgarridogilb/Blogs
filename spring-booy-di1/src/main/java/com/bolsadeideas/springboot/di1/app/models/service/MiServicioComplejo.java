package com.bolsadeideas.springboot.di1.app.models.service;

import org.springframework.stereotype.Component;


@Component("miServicioComplejo")
public class MiServicioComplejo implements IServicio {

	/**
	 * @Override: De un padre que estamos heredando
	 */
	@Override
	public String operacion() {
		return "ejecutando algún proceso importante complicado...";
	}
	
}

