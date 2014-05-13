package com.llapresa.model;

import java.util.HashSet;
import java.util.Set;

public class Categoria implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idcategoria;
	private String nombre;
	private Set<Producto> productos = new HashSet<Producto>(0);

	public Categoria() {
	}

	public Categoria(String nombre) {
		this.nombre = nombre;
	}

	public Categoria(String nombre, Set<Producto> productos) {
		this.nombre = nombre;
		this.productos = productos;
	}

	public Integer getIdcategoria() {
		return this.idcategoria;
	}

	public void setIdcategoria(Integer idcategoria) {
		this.idcategoria = idcategoria;
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
