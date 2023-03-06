package com.web.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.web.idao.IUsuario_MosDAO;
import com.web.model.JPAUtil;
import com.web.model.Usuario_Mos;

public class Usuario_MosDAOImpl implements IUsuario_MosDAO{
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	@Override
	public void guardar(Usuario_Mos usuario) {
		entity.getTransaction().begin();
		entity.persist(usuario);
		entity.getTransaction().commit();
		// TODO Auto-generated method stub
	}

	@Override
	public void editar(Usuario_Mos usuario) {
		entity.getTransaction().begin();
		entity.merge(usuario);
		entity.getTransaction().commit();
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario_Mos buscar(int id) {
		Usuario_Mos oUsuario_Mos = new Usuario_Mos();
		oUsuario_Mos = entity.find(Usuario_Mos.class, id);
		//JPAUtil.shutdown();
		return oUsuario_Mos;
	}

	@Override
	public List<Usuario_Mos> obtenerUsuario_Mos() {
		List<Usuario_Mos> listaUsuario_Mos = new ArrayList<Usuario_Mos>();
		//sentencia JPQL 
		Query query = entity.createQuery("SELECT c FROM Usuario_Mos c");
		listaUsuario_Mos = query.getResultList();
		return listaUsuario_Mos;
	}

	@Override
	public void eliminar(int id) {
		Usuario_Mos oUsuario_Mos = new Usuario_Mos();
		oUsuario_Mos = entity.find(Usuario_Mos.class, id);
		entity.getTransaction().begin();
		entity.remove(oUsuario_Mos);
		entity.getTransaction().commit();
		// TODO Auto-generated method stub
		
	}

}
