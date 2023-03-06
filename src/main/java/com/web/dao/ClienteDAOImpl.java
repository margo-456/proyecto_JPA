package com.web.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.web.idao.IClienteAO;
import com.web.model.Cliente;
import com.web.model.JPAUtil;

public class ClienteDAOImpl implements IClienteAO {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@Override
	public void guardar(Cliente cliente) {
		entity.getTransaction().begin();
		entity.persist(cliente);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}

	@Override
	public void editar(Cliente cliente) {
		entity.getTransaction().begin();
		entity.merge(cliente);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}

	@Override
	public Cliente buscar(int id) {
		Cliente oCliente = new Cliente();
		oCliente = entity.find(Cliente.class, id);
		//JPAUtil.shutdown();
		return oCliente;
	}

	@Override
	public List<Cliente> obtenerClientes() {
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		//sentencia JPQL 
		Query query = entity.createQuery("SELECT c FROM Cliente c");
		listaClientes = query.getResultList();
		return listaClientes;
	}

	@Override
	public void eliminar(int id) {
		Cliente oCliente = new Cliente();
		oCliente = entity.find(Cliente.class, id);
		entity.getTransaction().begin();
		entity.remove(oCliente);
		entity.getTransaction().commit();
	}

}
