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
	
	
}
