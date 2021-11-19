
package com.soltec.controllers;
import java.util.List;
import java.util.Optional;
//import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soltec.entities.Cliente;
import com.soltec.service.ClienteService;

@RestController // Controlador de tipo Rest
@CrossOrigin(origins="http://localhost:4200", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/cliente")//Se accede a través de esta URL
public class ClienteController {

	@Autowired // estamos inyectando la Interface de ClienteService en el controlador
	private ClienteService clientService;
	
	//Creando un nuevo cliente
	@PostMapping("/")
	public ResponseEntity<?> crear(@RequestBody Cliente cliente) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(cliente));
		
	}
	
	//Listar todos los usuarios
	@GetMapping("/")
	public List<Cliente> leerTodos(){
		List<Cliente> cliente = StreamSupport.stream(clientService.findAll().spliterator(),false).collect(Collectors.toList());
		return cliente;
	}
	
	//Leer 1 usuario por ID
	@GetMapping("/listar-id/{numero_documento}")
	public ResponseEntity<?> leer(@PathVariable(value="numero_documento") Integer id_cliente){
		Optional<Cliente> cliente = clientService.findById(id_cliente);
		if (!cliente.isPresent()) {
			return ResponseEntity.notFound().build(); 
		}
		return ResponseEntity.ok(cliente);
	}
	
	//Editar un usuario
	@PutMapping("/")
	public ResponseEntity<?> editar(@RequestBody Cliente clienteEditar){
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(clienteEditar));
	}
	
	//Eliminar un cliente
	@DeleteMapping("/eliminar/{numero_documento}")
	public ResponseEntity<?> eliminar(@PathVariable(value="numero_documento") Integer id_cliente){
		if (!clientService.findById(id_cliente).isPresent()) {
			return ResponseEntity.notFound().build(); 
		}
		
		clientService.deleteById(id_cliente);
		return ResponseEntity.ok().build();
	}
	

	
}