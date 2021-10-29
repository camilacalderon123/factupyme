/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soltec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soltec.entities.Usuario;
import com.soltec.repository.AdministradorRepository;

@Service
public class AdministradorServiceImpl implements AdministradorService {
	
	@Autowired
	private AdministradorRepository clientRepository;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Usuario> findAll() {
		return clientRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Usuario> findAll(Pageable pagebale) {
		return clientRepository.findAll(pagebale);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Usuario> findById(Integer NIT) {
		return clientRepository.findById(NIT);
	}

	@Override
	@Transactional
	public Usuario save(Usuario user) {
		return clientRepository.save(user);
	}

	@Override
	@Transactional
	public void deleteById(Integer NIT) {
		clientRepository.deleteById(NIT);
	}
}
