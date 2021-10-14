/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soltec.service;

import com.soltec.entities.Cliente;
import java.util.Optional;

/**
 *
 * @author Camila
 */
public class ClienteServiceImpl implements ClienteService {

	@Override
	public Iterable<Cliente> findAll() {
		// TODO Auto-generated method stub
		return findAll();
	}

	@Override
	public Optional<Cliente> findById(Long ID) {
		// TODO Auto-generated method stub
		return findById(ID);
	}

	@Override
	public Cliente save(Cliente cliente) {
		// TODO Auto-generated method stub
		return save(cliente);
	}

	@Override
	public void deleteById(Long ID) {
		// TODO Auto-generated method stub
		return ;
	}

}
