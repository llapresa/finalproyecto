package com.llapresa.model;

public class Usuario implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idusuario;
	private String login;
	private String password;
	private Rol rol;

	public Usuario() {
	}

	public Usuario(String login) {
		this.login = login;
	}

	public Usuario(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}
