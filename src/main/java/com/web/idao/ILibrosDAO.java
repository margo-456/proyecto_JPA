package com.web.idao;

import java.util.List;

import com.web.model.Libros;

public interface ILibrosDAO {
	
	
	public void guardar (Libros libros);
	public void editar(Libros libros);
	public Libros buscar (int id);
	public List<Libros> obtenerLibros();
	public void eliminar (int id);
}