package com.soltec.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.soltec.entities.Empresa;

public interface EmpresaService {

	
	public Iterable<Empresa> findAll(); //Devuelve un Iterable del objeto usuario 
	
	public Page<Empresa> findAll(Pageable pagebale);
	
	public Optional<Empresa> findById(Integer NIT); 
	
	public Empresa save(Empresa empresa);
	
	public void deleteById(Integer NIT);
}
