/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soltec.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.soltec.entities.Cliente;
import com.soltec.service.ClienteService;

@RestController // Controlador de tipo Rest
@RequestMapping("/probando")//Se accede a través de esta URL
public class ClienteController {

	@Autowired // estamos inyectando la Interface de ClienteService en el controlador
	private ClienteService service;
	
	// ResponseEntity nos permite construir la respuesta: podemos guardar y pasar objetos
	//@RequestBody se recibe un cliente
	@PostMapping("/crear")
	public ResponseEntity<?> crear(@RequestBody Cliente cliente) {
		Cliente clienteDb = service.save(cliente);
		if (cliente.equals(null)) {
			return ResponseEntity.status(HttpStatus.CREATED).body(clienteDb);
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteDb);
	}

	@GetMapping
	public List<Cliente> listar() {
		//pasamos un Iterable a una lista
		List<Cliente> client = StreamSupport.stream(service.findAll().spliterator(), false).collect(Collectors.toList());
		return client;
	}
	
	@GetMapping("/{id}")//entre corchete porque es un valor variable
	public ResponseEntity<?> listarUsuario(@PathVariable Long id ){
		Optional<Cliente> client = service.findById(id);
		if (!client.isPresent()) {
			return ResponseEntity.notFound().build(); //devolviendo error 404
		}
		return ResponseEntity.ok(client);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Cliente cliente, @PathVariable Long id) {
		Optional<Cliente> client = service.findById(id);
		if (!client.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		client.get().setNIT(cliente.getNIT());
		client.get().setDepartamento(cliente.getDepartamento());
		client.get().setPais(cliente.getPais());
		client.get().setNombre(cliente.getNombre());
		client.get().setCorreo(cliente.getCorreo());
		client.get().setDireccion(cliente.getDireccion());
		client.get().setNumero_documento(cliente.getNumero_documento());
		client.get().setRazon_social(cliente.getRazon_social());
		client.get().setNombre_comercial(cliente.getNombre_comercial());
		client.get().setMunicipio(cliente.getMunicipio());
		client.get().setTipo_documento(cliente.getTipo_documento());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(client.get()));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		if (!service.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		service.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	
	
	
	
}