package com.llapresa.model;

import java.util.HashSet;
import java.util.Set;

public class Marca implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idmarca;
	private String nombre;
	private Set<Producto> productos = new HashSet<Producto>(0);

	public Marca() {
	}

	public Marca(String nombre) {
		this.nombre = nombre;
	}

	public Marca(String nombre, Set<Producto> productos) {
		this.nombre = nombre;
		this.productos = productos;
	}

	public Integer getIdmarca() {
		return this.idmarca;
	}

	public void setIdmarca(Integer idmarca) {
		this.idmarca = idmarca;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

}
