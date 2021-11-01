package com.soltec.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.soltec.entities.Usuario;

public interface UsuarioService {
	
	public Iterable<Usuario> findAll(); //Devuelve un Iterable del objeto usuario 
	
	public Page<Usuario> findAll(Pageable pagebale); 
	 
	public Usuario findByUser(String correo); //Buscar Usuario por correo
	
	public Usuario save(Usuario user);	//Guardar y Activar usuario
	
	public Boolean desactivarUsuario(Boolean estadoUsuario); //Desactivar Usuario
	
	public Boolean activarUsuario(Boolean estadoUsuario); //activar usuario
	
}
