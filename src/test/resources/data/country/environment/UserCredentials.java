package com.falabella.templateautomationfront.entity;

public class UserCredentials {

	private String username;
	private String password;
	private String producto;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "UserCredentials [username=" + username + ", password=" + password + ",producto=" + producto + "]";
	}
}
