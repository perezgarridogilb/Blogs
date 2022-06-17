package com.bolsadeideas.springboot.di1.app;



import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.bolsadeideas.springboot.di1.app.models.domain.ItemFactura;
import com.bolsadeideas.springboot.di1.app.models.domain.Producto;
import com.bolsadeideas.springboot.di1.app.models.service.IServicio;
import com.bolsadeideas.springboot.di1.app.models.service.MiServicio;

public class AppConfig {
	
	@Bean("miServicioSimple")
	@Primary
	public IServicio registrarMiServicio() {
	return new MiServicio();
	}
	
	@Bean("miServicioComplejo")
	public IServicio registrarMiServicioComplejo() {
	return new MiServicio();
	}
	
	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems() {
		Producto producto1 = new Producto("Monitor LG LCD 24", 250);
		Producto producto2 = new Producto("Notebook Asus", 500);
		Producto producto3 = new Producto("Impresora HP Multifuncional", 80);
		Producto producto4 = new Producto("Escritorio Oficina", 300);
		
		ItemFactura linea1 = new ItemFactura(producto1, 2);
		ItemFactura linea2 = new ItemFactura(producto2, 1);
		ItemFactura linea3 = new ItemFactura(producto3, 1);
		ItemFactura linea4 = new ItemFactura(producto4, 1);
		
		return Arrays.asList(linea1, linea2, linea3, linea4);
	}
}
