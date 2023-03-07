package com.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.web.dao.ClienteDAOImpl;
import com.web.model.Cliente;

@ManagedBean(name = "clienteBean")
@RequestScoped
public class ClienteBean {
	ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
	List<Cliente> listaClientes = new ArrayList<>();
	
	public List<Cliente> getListaClientes() {
		return clienteDAO.obtenerClientes();
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public String editar(int id) {
		Cliente oCliente = new Cliente();
		oCliente = clienteDAO.buscar(id);
		System.out.println(oCliente);
		
		//crear una coleccion de tipo mapa
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		//pasar los datos del cliente
		sessionMap.put("cliente", oCliente);
		
		return "/faces/editar.xhtml";
	}
	
	public String actualizar(Cliente cliente) {
		clienteDAO.editar(cliente);
		return "/faces/index.xhtml";
	}
	
	public String eliminar(int id) {
		clienteDAO.eliminar(id);
		return "/faces/index.xhtml";
	}
	
	public String nuevo() {
		Cliente oCliente = new Cliente();
		//crear una coleccion de tipo mapa
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				
		//pasar los datos del cliente
		sessionMap.put("cliente", oCliente);
		return "/faces/crear.xhtml";
	}
	
	public String guardar(Cliente cliente) {
		clienteDAO.guardar(cliente);
		return "/faces/index.xhtml";
	}
	
	
}
