/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soltec.controllers;

import com.soltec.entities.Cliente;
import com.soltec.service.ClienteService;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // Controlador de tipo Rest
public class ClienteController {

	@Autowired // estamos inyectando la Interface de ClienteService en el controlador
	private ClienteService service;

	@GetMapping // esta mapeado a la raiz del proyecto, ya que no tiene ninguna ruta
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/{id}")
	// ResponseEntity nos permite construir la respuesta: podemos guardar y pasar
	// objetos
	public ResponseEntity<?> verDetalles(@PathVariable Long ID) {
		Optional<Cliente> op = service.findById(ID);
		if (op.isEmpty()) {
			System.out.println("ID vacio");
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(op.get());
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Cliente cliente) {
		if (cliente.equals(null)) {
			return ResponseEntity.notFound().build();
		}
		Cliente clienteDb = service.save(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteDb);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Cliente cliente, @PathVariable Long ID) {
		if (service.findById(ID).equals(null)) {
			return ResponseEntity.notFound().build();
		}
		Optional<Cliente> o = null;
		Cliente clientedb = o.get();
		clientedb.setNIT(cliente.getNIT());
		clientedb.setDepartamento(cliente.getDepartamento());
		clientedb.setPais(cliente.getPais());
		clientedb.setNombre(cliente.getNombre());
		clientedb.setCorreo(cliente.getCorreo());
		clientedb.setDireccion(cliente.getDireccion());
		clientedb.setNumero_documento(cliente.getNumero_documento());
		clientedb.setRazon_social(cliente.getRazon_social());
		clientedb.setNombre_comercial(cliente.getNombre_comercial());
		clientedb.setMunicipio(cliente.getMunicipio());
		clientedb.setTipo_documento(cliente.getTipo_documento());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clientedb));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long ID) {
		/*
		 * if (service.findById(ID).equals(null) || ID == null) { return
		 * ResponseEntity.notFound().build(); }
		 */
		service.deleteById(ID);
		return ResponseEntity.noContent().build();
	}
}