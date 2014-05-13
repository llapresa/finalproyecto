package com.llapresa.model.viewform;

import java.util.Date;

public class ProductoViewForm {

	private Integer idproducto;
	private String titulo;
	private String descripcion;
	private String estado;
	private double precio;
	private Date fechaalta;
	private Integer[] marcas;
	private Integer[] fotos;

	public ProductoViewForm() {
		super();
		fechaalta = new Date();
	}

	public Integer getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFechaalta() {
		return fechaalta;
	}

	public void setFechaalta(Date fechaalta) {
		this.fechaalta = fechaalta;
	}

	public Integer[] getMarcas() {
		return marcas;
	}

	public void setMarcas(Integer[] marcas) {
		this.marcas = marcas;
	}

	public Integer[] getFotos() {
		return fotos;
	}

	public void setFotos(Integer[] fotos) {
		this.fotos = fotos;
	}

}
