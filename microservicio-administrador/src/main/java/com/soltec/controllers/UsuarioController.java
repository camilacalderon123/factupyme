package com.soltec.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.soltec.entities.Usuario;
import com.soltec.service.UsuarioService;

public class UsuarioController {
	
	@Autowired // estamos inyectando la Interface de ClienteService en el controlador
	private UsuarioService usuarioService;
	
	//listar usuario
	@GetMapping("/usuarios")
	public String index(Model model) {
		model.addAttribute("list", usuarioService.findAll());
		return "Dashboard/ver-usuarios";
	}
	//agregar usuario
	@PostMapping("/crear-usuario")
	public String crear(@RequestBody Usuario usuario, Model model) {
		usuarioService.save(usuario);	
		return "Dashboard/agregar-usuario";	
	}
	
	//Editar contraseña
	@PutMapping("/{usuario}")
	public ResponseEntity<?> editar(@RequestBody Usuario usuarioEditar, @PathVariable(value="correo") String correo){
		 Usuario usuarioBuscado = usuarioService.findByUser(correo);
		 if(!usuarioBuscado.getCorreo().equals(correo)) {
			return ResponseEntity.notFound().build(); 
		 }
		usuarioBuscado.setContrasena(usuarioEditar.getContrasena());
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuarioBuscado));
	}
	
	//listar Empresa por NIT
	@GetMapping("/{usuario}")
	public ResponseEntity<?> buscarUsuario(@RequestBody Usuario usuarioConsultar, @PathVariable(value="correo") String correo){
	 Usuario usuarioBuscado = usuarioService.findByUser(correo);
	 if(!usuarioBuscado.getCorreo().equals(correo)) {
		return ResponseEntity.notFound().build(); 
	 }
	 return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.findByUser(usuarioConsultar.getCorreo()));
	}
	//Listar todas las usuarios
	@GetMapping
	public List<Usuario> leerTodos(){
		List<Usuario> usuario= StreamSupport.stream(usuarioService.findAll().spliterator(),false).collect(Collectors.toList());
		return usuario;
	}
	
	
	
	
	
	
	
	

}
