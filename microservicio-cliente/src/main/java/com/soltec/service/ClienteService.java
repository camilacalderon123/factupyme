/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/Repository.java to edit this template
 */
package com.soltec.service;

import com.soltec.entities.Cliente;
import java.util.Optional;




public interface ClienteService {
	public Iterable<Cliente> findAll();

	public Optional<Cliente> findById(Long id);

	public Cliente save(Cliente cliente);

	public void deleteById(Long ID);
}
