
package com.soltec.service;

import com.soltec.entities.Cliente;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;




public interface ClienteService {
	
	public Iterable<Cliente> findAll(); //Devuelve un Iterable del objeto usuario 
	
	public Page<Cliente> findAll(Pageable pagebale);
	
	public Optional<Cliente> findById(Integer numero_documento); 
	
	public Cliente save(Cliente user);
	
	public void deleteById(Integer numero_documento);
}
