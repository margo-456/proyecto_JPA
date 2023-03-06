package com.web.idao;

import java.util.List;

import com.web.model.Usuario_Mos;

public interface IUsuario_MosDAO {
	public void guardar(Usuario_Mos usuario_mos);
	public void editar(Usuario_Mos usuario_mos);
	public Usuario_Mos buscar(int id);
	public List<Usuario_Mos> obtenerUsuario_Mos();
	public void eliminar(int id);
}
