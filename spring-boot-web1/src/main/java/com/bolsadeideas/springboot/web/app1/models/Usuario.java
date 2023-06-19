package com.bolsadeideas.springboot.web.app1.models;

public class Usuario {
	private String nombre;
	private String apellido;
	private String email;

	public Usuario(String nombre, String apellido, String email) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	public Usuario() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
