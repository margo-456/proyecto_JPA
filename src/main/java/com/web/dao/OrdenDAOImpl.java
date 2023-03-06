package com.web.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.web.idao.IOrdenDAO;
import com.web.model.JPAUtil;
import com.web.model.Ordenes;

public class OrdenDAOImpl implements IOrdenDAO{
	EntityManager entity= JPAUtil.getEntityManagerFactory().createEntityManager();

	@Override
	public void guardar(Ordenes orden) {
		// TODO Auto-generated method stub
		entity.getTransaction().begin();
		entity.persist(orden);
		entity.getTransaction().commit();
	}

	@Override
	public void editar(Ordenes orden) {
		// TODO Auto-generated method stub
		entity.getTransaction().begin();
		entity.merge(orden);
		entity.getTransaction().commit();
	}

	@Override
	public Ordenes buscar(int id) {
		// TODO Auto-generated method stub
		Ordenes oOrden = new Ordenes();
		oOrden = entity.find(Ordenes.class, id);
		return oOrden;
	}

	@Override
	public List<Ordenes> obtenerOrdenes() {
		// TODO Auto-generated method stub
		List<Ordenes> listaOrdenes=new ArrayList<Ordenes>();
        //sentencia SQL
        Query query = entity.createQuery("SELECT c From Ordenes c");
        listaOrdenes=query.getResultList();
        return listaOrdenes;
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		Ordenes oOrden=new Ordenes();
		oOrden = entity.find(Ordenes.class, id);
		entity.getTransaction().begin();
		entity.remove(oOrden);
		entity.getTransaction().commit();
	}

}
