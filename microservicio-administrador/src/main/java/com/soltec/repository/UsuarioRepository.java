package com.soltec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soltec.entities.Usuario;
import com.soltec.service.UsuarioService;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	public default Boolean activarUsuario(Boolean estadoUsuario) {

		Boolean estado = false;
		if (estadoUsuario.booleanValue() == false) {
			estado = true;
		}
		return estado;
	}

	public default Boolean desactivarUsuario(Boolean estadoUsuario) {

		Boolean estado = false;
		if (estadoUsuario.booleanValue() == true) {
			estado = false;
		}
		return estado;
	}

	public default Usuario buscarUsuario(String correo) {
		UsuarioService usuarioService = null;
		@SuppressWarnings("null")
		Usuario usuarioBuscar = usuarioService.findByUser(correo);
		if ((usuarioBuscar.getCorreo().isEmpty()) || !(usuarioBuscar.equals(correo))){
			return null;
		}
		return usuarioBuscar;
	}
}
