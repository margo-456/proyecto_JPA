package com.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idusuario;
	@Column
	private String nombreusuario;
	@Column
	private String apellidousuario;
	@Column
	private String cedulausuario;
	@Column
	private String telefonousuario;
	@Column
	private String direccionusuario;
	@Column
	private String correousuario;
	
	public Integer getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}
	public String getNombreusuario() {
		return nombreusuario;
	}
	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}
	public String getApellidousuario() {
		return apellidousuario;
	}
	public void setApellidousuario(String apellidousuario) {
		this.apellidousuario = apellidousuario;
	}
	public String getCedulausuario() {
		return cedulausuario;
	}
	public void setCedulausuario(String cedulausuario) {
		this.cedulausuario = cedulausuario;
	}
	public String getTelefonousuario() {
		return telefonousuario;
	}
	public void setTelefonousuario(String telefonousuario) {
		this.telefonousuario = telefonousuario;
	}
	public String getDireccionusuario() {
		return direccionusuario;
	}
	public void setDireccionusuario(String direccionusuario) {
		this.direccionusuario = direccionusuario;
	}
	public String getCorreousuario() {
		return correousuario;
	}
	public void setCorreousuario(String correousuario) {
		this.correousuario = correousuario;
	}
	
	@Override
	public String toString() {
		return "Cliente [idusuario=" + idusuario + ", nombreusuario=" + nombreusuario + ", apellidousuario="
				+ apellidousuario + ", cedulausuario=" + cedulausuario + ", telefonousuario=" + telefonousuario
				+ ", direccionusuario=" + direccionusuario + ", correousuario=" + correousuario + "]";
	}
}
