package com.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "libros")
public class Libros {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id_libro;
	@Column
	private String titulo;
	@Column
	private String nombre_autor;
	@Column
	private String apellido_autor;
	@Column
	private String categoria;
	@Column
	private double precio;

	
	
	public Libros() {
		super();
	}
//Generamos metodos get y set
	
	public Integer getId_libro() {
		return id_libro;
	}

	public void setId_libro(Integer id_libro) {
		this.id_libro = id_libro;
	}

	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNombre_autor() {
		return nombre_autor;
	}

	public void setNombre_autor(String nombre_autor) {
		this.nombre_autor = nombre_autor;
	}

	public String getApellido_autor() {
		return apellido_autor;
	}

	public void setApellido_autor(String apellido_autor) {
		this.apellido_autor = apellido_autor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	@Override
	public String toString() {
		return "Libros [id_libro=" + id_libro + ", titulo=" + titulo + ", nombre_autor=" + nombre_autor
				+ ", apellido_autor=" + apellido_autor + ", categoria=" + categoria + ", precio=" + precio + "]";
	}
	

}

