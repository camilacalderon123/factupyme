
package com.soltec.controllers;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soltec.entities.Cliente;
import com.soltec.service.ClienteService;

@Controller // Controlador de tipo Rest
public class ClienteController {

	@Autowired // estamos inyectando la Interface de ClienteService en el controlador
	private ClienteService clientService;
	
	//listar los clientes
	@GetMapping("/clientes")
	public String index(Model model) {
		model.addAttribute("list", clientService.findAll());
		return "Dashboard/ver-clientes";
	}
	//agregar
	@PostMapping("/crear-cliente")
	public String crear(@RequestBody Cliente cliente, Model model) {
		clientService.save(cliente);	
		return "Dashboard/agregar-cliente";	
	}
	
	//eliminar
	
	
	//editar
	
	

	
	
	//Editar un usuario
	@PutMapping("/{NIT}")
	public ResponseEntity<?> editar(@RequestBody Cliente clienteEditar, @PathVariable(value="NIT") Integer NITcliente){
		Optional<Cliente> cliente = clientService.findById(NITcliente);
		if (!cliente.isPresent()) {
			return ResponseEntity.notFound().build(); 
		}	
		cliente.get().setNumero_documento(clienteEditar.getNumero_documento());
		cliente.get().setNombre_comercial(clienteEditar.getNombre_comercial());
		cliente.get().setNombre(clienteEditar.getNombre());
		cliente.get().setPais(clienteEditar.getPais());
		cliente.get().setDepartamento(clienteEditar.getDepartamento());
		cliente.get().setCiudad(clienteEditar.getCiudad());
		cliente.get().setDireccion(clienteEditar.getDireccion());
		cliente.get().setCorreo(clienteEditar.getCorreo());
		cliente.get().setTelefono(clienteEditar.getTelefono());
		cliente.get().setContribuyente(clienteEditar.getContribuyente());
		cliente.get().setRegimen_contable(clienteEditar.getRegimen_contable());
		cliente.get().setTipo_documento(clienteEditar.getTipo_documento());
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(cliente.get()));
	}
	
	//Eliminar un cliente
	@DeleteMapping("/{NIT}")
	public String eliminar(@PathVariable(value="NIT") Integer NITcliente){
		clientService.deleteById(NITcliente);
		return "redirect:/";
	}
	
	//Listar todos los usuarios
	@GetMapping
	public List<Cliente> leerTodos(){
		List<Cliente> cliente = StreamSupport.stream(clientService.findAll().spliterator(),false).collect(Collectors.toList());
		return cliente;
	}
	
	
}