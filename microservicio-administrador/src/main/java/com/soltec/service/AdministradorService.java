
package com.soltec.service;

import com.soltec.entities.Usuario;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdministradorService {
	public Iterable<Usuario> findAll(); //Devuelve un Iterable del objeto usuario 
	
	public Page<Usuario> findAll(Pageable pagebale);
	
	public Optional<Usuario> findById(Integer NIT); 
	
	public Usuario save(Usuario user);
	
	public void deleteById(Integer NIT);
}
