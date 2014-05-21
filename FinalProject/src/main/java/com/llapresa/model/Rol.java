package com.llapresa.model;

public class Rol implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idrol;
	private String rol;

	public Rol() {
		super();
	}

	public Rol(Integer idrol, String rol) {
		super();
		this.idrol = idrol;
		this.rol = rol;
	}

	public Integer getIdrol() {
		return idrol;
	}

	public void setIdrol(Integer idrol) {
		this.idrol = idrol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}