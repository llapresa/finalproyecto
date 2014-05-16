package com.llapresa.model.viewform;

import org.springframework.web.multipart.MultipartFile;

public class FotoViewForm {

	private Integer idfoto;
	private Integer producto;
	private MultipartFile url;

	public FotoViewForm() {
		super();
	}

	public Integer getIdfoto() {
		return idfoto;
	}

	public void setIdfoto(Integer idfoto) {
		this.idfoto = idfoto;
	}

	public Integer getProducto() {
		return producto;
	}

	public void setProducto(Integer producto) {
		this.producto = producto;
	}

	public MultipartFile getUrl() {
		return url;
	}

	public void setUrl(MultipartFile url) {
		this.url = url;
	}

}
