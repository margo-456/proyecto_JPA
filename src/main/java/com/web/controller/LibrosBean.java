package com.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.web.dao.LibrosDAOImpl;
import com.web.model.Libros;

@ManagedBean(name="librosBean")
@RequestScoped
public class LibrosBean {
	LibrosDAOImpl librosDAO=new LibrosDAOImpl();
	List<Libros> listaLibros = new ArrayList<>();
	
	public List<Libros> getListaLibros(){
		return librosDAO.obtenerLibros();
	}
	
	public void setListaLibros(List<Libros> listaLibros) {
		this.listaLibros=listaLibros;
	}
	
	public String editar(int id) {
		Libros oLibros=new Libros();
		oLibros=librosDAO.buscar(id);
		System.out.println(oLibros);
		
		
		//crear una coleccion de tipo mapa
		Map<String, Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		//pasar los datos del cliente
		sessionMap.put("libros", oLibros);
		
		return "/faces/editarLibros.xhtml";
	}
	
	public String actualizar(Libros libros) {
		librosDAO.editar(libros);
		return "/faces/indexAdminLibros.xhtml";
	}
	
	public String eliminar(int id) {
		librosDAO.eliminar(id);
		return "/faces/indexAdminLibros.xhtml";
	}
	
	public String nuevo() {
		Libros oLibros = new Libros();
		//crear una coleccion de tipo mapa
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				
		//pasar los datos del cliente
		sessionMap.put("libros", oLibros);
		return "/faces/crearLibros.xhtml";
	}
	
	public String guardar(Libros libros) {
		Libros oLibros=new Libros();
		librosDAO.guardar(libros);
		//crear una coleccion de tipo mapa
		Map<String, Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				
				//pasar los datos del cliente
		sessionMap.put("libros", oLibros);
				
		return "/faces/indexAdminLibros.xhtml";
	}


}
