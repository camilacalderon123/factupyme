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

import com.soltec.entities.Cliente;
import com.soltec.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clientRepository;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Cliente> findAll() {
		return clientRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Cliente> findAll(Pageable pagebale) {
		return clientRepository.findAll(pagebale);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Cliente> findById(Integer numero_documento) {
		return clientRepository.findById(numero_documento);
	}

	@Override
	@Transactional
	public Cliente save(Cliente client) {
		return clientRepository.save(client);
	}

	@Override
	@Transactional
	public void deleteById(Integer numero_documento) {
		clientRepository.deleteById(numero_documento);
	}
}
