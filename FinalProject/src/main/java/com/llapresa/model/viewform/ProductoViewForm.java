package com.llapresa.model.viewform;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class ProductoViewForm {

	private Integer idproducto;

	@NotNull(message = "Es obligatorio introducir un titulo.")
	@Size(min = 10, max = 200)
	private String titulo;

	@NotNull(message = "Es obligatorio introducir una descripcion.")
	@Size(min = 100, max = 2000)
	private String descripcion;

	private String estado;

	@NotNull(message = "El precio es obligatorio.")
	@Range(min = 1, max = 60000)
	private double precio;
	private Date fechaalta;

	@NotNull(message = "Debes seleccionar una categoria.")
	@Range(min = 1, max = Integer.MAX_VALUE)
	private Integer categoria;

	@NotEmpty(message = "Debe seleccionar al menos una marca.")
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

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
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
