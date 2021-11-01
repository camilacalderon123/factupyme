package com.soltec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soltec.entities.Usuario;
import com.soltec.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioServiceImpl;
	
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Usuario> findAll() {
		return usuarioServiceImpl.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Usuario> findAll(Pageable pagebale) {
		return usuarioServiceImpl.findAll(pagebale);
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario findByUser(String correo) {
		return usuarioServiceImpl.buscarUsuario(correo);
	}

	@Override
	@Transactional
	public Usuario save(Usuario user) {
		return usuarioServiceImpl.save(user);
	}

	@Override
	@Transactional
	public Boolean desactivarUsuario(Boolean estadoUsuario) {
		return usuarioServiceImpl.desactivarUsuario(estadoUsuario);
	}

	@Override
	@Transactional
	public Boolean activarUsuario(Boolean estadoUsuario) {
		return usuarioServiceImpl.activarUsuario(estadoUsuario);
	}

}
