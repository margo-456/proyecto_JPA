package com.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.web.dao.OrdenDAOImpl;
import com.web.model.Ordenes;

@ManagedBean(name="ordenBean")
@RequestScoped
public class OrdenBean {
	OrdenDAOImpl ordenDAO=new OrdenDAOImpl();
	List<Ordenes> listaOrdenes = new ArrayList<>();
	
	public List<Ordenes> getListaOrdenes(){
		return ordenDAO.obtenerOrdenes();
	}
	
	public void setListaOrdenes(List<Ordenes> listaOrdenes) {
		this.listaOrdenes=listaOrdenes;
	}
	
	public String editar(int id) {
		Ordenes oOrden=new Ordenes();
		oOrden=ordenDAO.buscar(id);
		System.out.println(oOrden);
		
		
		//crear una coleccion de tipo mapa
		Map<String, Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		//pasar los datos del cliente
		sessionMap.put("ordenes", oOrden);
		
		return "/faces/editar.xhtml";
	}
	
	public String actualizar(Ordenes orden) {
		ordenDAO.editar(orden);
		return "/faces/index.xhtml";
	}
	
	public String actualizar2(Ordenes orden) {
		ordenDAO.editar(orden);
		return "/faces/indexAdmin.xhtml";
	}
	
	public String eliminar(int id) {
		ordenDAO.eliminar(id);
		return "/faces/index.xhtml";
	}
	
	public String nuevo() {
		Ordenes oOrden = new Ordenes();
		//crear una coleccion de tipo mapa
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				
		//pasar los datos del cliente
		sessionMap.put("ordenes", oOrden);
		return "/faces/crear.xhtml";
	}
	
	public String guardar(Ordenes orden) {
		Ordenes oOrden=new Ordenes();
		ordenDAO.guardar(orden);
		//crear una coleccion de tipo mapa
		Map<String, Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				
				//pasar los datos del cliente
		sessionMap.put("ordenes", oOrden);
				
		return "/faces/index.xhtml";
	}

}
