
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
@RequestMapping("/cliente")//Se accede a través de esta URL
public class ClienteController {

	@Autowired // estamos inyectando la Interface de ClienteService en el controlador
	private ClienteService clientService;
	
	//Creando un nuevo cliente
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Cliente cliente) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(cliente));
		
	}
	
	//Leer 1 usuario por ID
	@GetMapping("/{NIT}")
	public ResponseEntity<?> leer(@PathVariable(value="NIT") Integer NITcliente){
		Optional<Cliente> cliente = clientService.findById(NITcliente);
		if (!cliente.isPresent()) {
			return ResponseEntity.notFound().build(); 
		}
		return ResponseEntity.ok(cliente);
	}
	
	//Editar un usuario
	@PutMapping("/{NIT}")
	public ResponseEntity<?> editar(@RequestBody Cliente clienteEditar, @PathVariable(value="NIT") Integer NITcliente){
		Optional<Cliente> cliente = clientService.findById(NITcliente);
		if (!cliente.isPresent()) {
			return ResponseEntity.notFound().build(); 
		}	
		cliente.get().setNIT(clienteEditar.getNIT());
		cliente.get().setDepartamento(clienteEditar.getDepartamento());
		cliente.get().setPais(clienteEditar.getPais());
		cliente.get().setNombre(clienteEditar.getNombre());
		cliente.get().setCorreo(clienteEditar.getCorreo());
		cliente.get().setDireccion(clienteEditar.getDireccion());
		cliente.get().setNumero_documento(clienteEditar.getNumero_documento());
		cliente.get().setRazon_social(clienteEditar.getRazon_social());
		cliente.get().setNombre_comercial(clienteEditar.getNombre_comercial());
		cliente.get().setMunicipio(clienteEditar.getMunicipio());
		cliente.get().setTipo_documento(clienteEditar.getTipo_documento());
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(cliente.get()));
	}
	
	//Eliminar un cliente
	@DeleteMapping("/{NIT}")
	public ResponseEntity<?> eliminar(@PathVariable(value="NIT") Integer NITcliente){
		if (!clientService.findById(NITcliente).isPresent()) {
			return ResponseEntity.notFound().build(); 
		}
		clientService.deleteById(NITcliente);
		return ResponseEntity.ok().build();
	}
	
	//Listar todos los usuarios
	@GetMapping
	public List<Cliente> leerTodos(){
		List<Cliente> cliente = StreamSupport.stream(clientService.findAll().spliterator(),false).collect(Collectors.toList());
		return cliente;
	}
	
	
	
}