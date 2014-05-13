package com.llapresa.model.viewform;

public class CategoriaViewForm {

	private Integer idcategoria;
	private String nombre;
	private Integer[] productos;

	public Integer getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(Integer idcategoria) {
		this.idcategoria = idcategoria;
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
