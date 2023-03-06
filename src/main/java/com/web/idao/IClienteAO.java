package com.web.idao;

import java.util.List;

import com.web.model.Cliente;

public interface IClienteAO {

	public void guardar(Cliente cliente);
	public void editar(Cliente cliente);
	public Cliente buscar(int id);
	public List<Cliente> obtenerClientes();
	public void eliminar(int id);
}
