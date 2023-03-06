package com.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.web.dao.Usuario_MosDAOImpl;
import com.web.model.Usuario_Mos;

@ManagedBean(name = "usuario_mosBean")
@RequestScoped
public class Usuario_MosBean {

	Usuario_MosDAOImpl usuarioDAO = new Usuario_MosDAOImpl();
	List<Usuario_Mos> listaUsuario_Mos = new ArrayList<>();
	
	public List<Usuario_Mos> getListaUsuario_Mos() {
		return usuarioDAO.obtenerUsuario_Mos();
	}
	
	public void setListaUsuario_Mos(List<Usuario_Mos> listaUsuario_Mos) {
		this.listaUsuario_Mos = listaUsuario_Mos;
	}
	
	public String editar(int id) {
		Usuario_Mos oUsuario_Mos = new Usuario_Mos();
		oUsuario_Mos = usuarioDAO.buscar(id);
		System.out.println(oUsuario_Mos);
		
		//crear una coleccion de tipo mapa
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		//pasar los datos del cliente
		sessionMap.put("usuario", oUsuario_Mos);
		
		return "/faces/editarUsuario.xhtml";
	}
	
	public String actualizar(Usuario_Mos usuario) {
		usuarioDAO.editar(usuario);
		return "/faces/indexAdminUsuarios.xhtml";
	}
	
	public String eliminar(int id) {
		usuarioDAO.eliminar(id);
		return "/faces/indexAdminUsuarios.xhtml";
	}
	
	public String nuevo() {
		Usuario_Mos oUsuario_Mos = new Usuario_Mos();
		//crear una coleccion de tipo mapa
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				
		//pasar los datos del cliente
		sessionMap.put("usuario", oUsuario_Mos);
		return "/faces/crearAdminUsuarios.xhtml";
	}
	
	public String guardar(Usuario_Mos usuario) {
		usuarioDAO.guardar(usuario);
		return "/faces/indexAdminUsuarios.xhtml";
	}
}
