/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soltec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soltec.entities.Cliente;
import com.soltec.repository.ClienteRepository;


@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Override
	@Transactional(readOnly = true) //Transaccion de solo lectura, quiere decir que no se va a cambiar ni a guardar nada de la base de datos
	public Iterable<Cliente> findAll() {
		return clienteRepo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cliente> findById(Long ID) {
		return clienteRepo.findById(ID);
	}

	@Override
	@Transactional //solo transaccional ya quiere decir que va a hacer un cambio en la BD
	public Cliente save(Cliente cliente) {
		return clienteRepo.save(cliente);
	}

	@Override
	@Transactional
	public void deleteById(Long ID) {
		clienteRepo.deleteById(ID);
		
	}
	
	

}
