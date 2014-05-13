package com.llapresa.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Producto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idproducto;
	private Categoria categoria;
	private String titulo;
	private String descripcion;
	private String estado;
	private double precio;
	private Date fechaalta;
	private Set<Marca> marcas = new HashSet<Marca>(0);
	private Set<Foto> fotos = new HashSet<Foto>(0);

	public Producto() {
	}

	public Producto(String titulo, String descripcion, String estado,
			double precio) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.precio = precio;
	}

	public Producto(Categoria categoria, String titulo, String descripcion,
			String estado, double precio, Date fechaalta, Set<Marca> marcas,
			Set<Foto> fotos) {
		this.categoria = categoria;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.precio = precio;
		this.fechaalta = fechaalta;
		this.marcas = marcas;
		this.fotos = fotos;
	}

	public Integer getIdproducto() {
		return this.idproducto;
	}

	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFechaalta() {
		return this.fechaalta;
	}

	public void setFechaalta(Date fechaalta) {
		this.fechaalta = fechaalta;
	}

	public Set<Marca> getMarcas() {
		return this.marcas;
	}

	public void setMarcas(Set<Marca> marcas) {
		this.marcas = marcas;
	}

	public Set<Foto> getFotos() {
		return this.fotos;
	}

	public void setFotos(Set<Foto> fotos) {
		this.fotos = fotos;
	}

}
