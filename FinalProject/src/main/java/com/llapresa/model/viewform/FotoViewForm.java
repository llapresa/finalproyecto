package com.llapresa.model.viewform;

import org.springframework.web.multipart.MultipartFile;

import com.llapresa.model.Producto;

public class FotoViewForm {

	private int idfoto;
	private Producto producto;
	private MultipartFile url;

	public int getIdfoto() {
		return idfoto;
	}

	public void setIdfoto(int idfoto) {
		this.idfoto = idfoto;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public MultipartFile getUrl() {
		return url;
	}

	public void setUrl(MultipartFile url) {
		this.url = url;
	}

}
