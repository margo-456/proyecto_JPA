package com.web.idao;

import java.util.List;

import com.web.model.Ordenes;

public interface IOrdenDAO {
	
	public void guardar (Ordenes orden);
	public void editar(Ordenes orden);
	public Ordenes buscar (int id);
	public List<Ordenes> obtenerOrdenes();
	public void eliminar (int id);

}
