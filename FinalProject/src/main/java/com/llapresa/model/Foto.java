package com.llapresa.model;

public class Foto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idfoto;
	private Producto producto;
	private String url;

	public Foto() {
	}

	public Foto(Integer idfoto, Producto producto, String url) {
		this.idfoto = idfoto;
		this.producto = producto;
		this.url = url;
	}

	public Integer getIdfoto() {
		return this.idfoto;
	}

	public void setIdfoto(Integer idfoto) {
		this.idfoto = idfoto;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
