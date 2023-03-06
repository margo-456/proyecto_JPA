package com.web.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.web.idao.ILibrosDAO;
import com.web.model.Cliente;
import com.web.model.JPAUtil;
import com.web.model.Libros;

public class LibrosDAOImpl implements ILibrosDAO{
	EntityManager entity= JPAUtil.getEntityManagerFactory().createEntityManager();
	@Override
	public void guardar(Libros libros) {
		// TODO Auto-generated method stub
		entity.getTransaction().begin();
		entity.persist(libros);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}

	@Override
	public void editar(Libros libros) {
		// TODO Auto-generated method stub
		entity.getTransaction().begin();
		entity.merge(libros);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
		
	}

	@Override
	public Libros buscar(int id) {
		// TODO Auto-generated method stub
		Libros oLibros = new Libros();
		oLibros = entity.find(Libros.class, id);
		//JPAUtil.shutdown();
		return oLibros;
	}

	@Override
	public List<Libros> obtenerLibros() {
        // TODO Auto-generated method stub
        List<Libros> listaLibros=new ArrayList<Libros>();
        //sentencia SQL
        Query query = entity.createQuery("SELECT c From Libros c");
        listaLibros=query.getResultList();
        return listaLibros;
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		Libros oLibros=new Libros();
		oLibros = entity.find(Libros.class, id);
		entity.getTransaction().begin();
		entity.remove(oLibros);
		entity.getTransaction().commit();
		
	}
}

