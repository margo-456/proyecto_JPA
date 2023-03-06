package com.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ordenes")
public class Ordenes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id_orden;
	
	@OneToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	private Usuario_Mos id_usuario;
	
	@OneToOne
	@JoinColumn(name = "id_libro", referencedColumnName = "id_libro")
	private Libros id_libro;
	
	@Column
	private String fecha_orden;
	@Column
	private String fecha_entrega;
	
	public Ordenes() {
		super();
	}

	public Integer getId_orden() {
		return id_orden;
	}

	public void setId_orden(Integer id_orden) {
		this.id_orden = id_orden;
	}

	public Usuario_Mos getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario_Mos id_usuario) {
		this.id_usuario = id_usuario;
	}

	public 	Libros getId_libro() {
		return id_libro;
	}

	public void setId_Libros(Libros id_libro) {
		this.id_libro = id_libro;
	}

	public String getFecha_orden() {
		return fecha_orden;
	}

	public void setFecha_orden(String fecha_orden) {
		this.fecha_orden = fecha_orden;
	}

	public String getFecha_entrega() {
		return fecha_entrega;
	}

	public void setFecha_entrega(String fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}

	@Override
	public String toString() {
		return "Ordenes [id_orden=" + id_orden + ", id_usuario=" + id_usuario + ", id_libro=" + id_libro
				+ ", fecha_orden=" + fecha_orden + ", fecha_entrega=" + fecha_entrega + "]";
	}
	
	

}
