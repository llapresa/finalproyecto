package com.llapresa.model.viewform;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MarcaViewForm {

	private Integer idmarca;

	@NotNull(message = "Es obligatorio introducir un nombre.")
	@Size(min = 4, max = 100)
	private String nombre;

	private Integer[] productos;

	public Integer getIdmarca() {
		return idmarca;
	}

	public void setIdmarca(Integer idmarca) {
		this.idmarca = idmarca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer[] getProductos() {
		return productos;
	}

	public void setProductos(Integer[] productos) {
		this.productos = productos;
	}

}
