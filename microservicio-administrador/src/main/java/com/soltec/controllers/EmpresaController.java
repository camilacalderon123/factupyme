package com.soltec.controllers;

import java.util.List;
import java.util.Optional;
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

import com.soltec.entities.Empresa;
import com.soltec.service.EmpresaService;



public class EmpresaController {
	
	
	@Autowired // estamos inyectando la Interface de ClienteService en el controlador
	private EmpresaService empresaService;
	
	//listar empresa
	@GetMapping("/empresas")
	public String index(Model model) {
		model.addAttribute("list", empresaService.findAll());
		return "Dashboard/ver-empresas";
	}
	//agregar empresa
	@PostMapping("/crear-empresas")
	public String crear(@RequestBody Empresa empresa, Model model) {
		empresaService.save(empresa);	
		return "Dashboard/agregar-cliente";	
	}
	
	//Editar empresa
	@PutMapping("/{NIT}")
	public ResponseEntity<?> editar(@RequestBody Empresa empresaEditar, @PathVariable(value="NIT") Integer NIT){
		Optional<Empresa> empresa= empresaService.findById(NIT);
		if (!empresa.isPresent()) {
			return ResponseEntity.notFound().build(); 
		}	
		empresa.get().setCorreoEmpresa(empresaEditar.getCorreoEmpresa());
		empresa.get().setDepartamento(empresaEditar.getDepartamento());
		empresa.get().setDireccion(empresaEditar.getDireccion());
		empresa.get().setDocumento(empresaEditar.getDocumento());
		empresa.get().setMunicipio(empresaEditar.getMunicipio());
		empresa.get().setNit(empresaEditar.getNit());
		empresa.get().setNombreRepresentante(empresaEditar.getNombreRepresentante());
		empresa.get().setNumeroDocumento(empresaEditar.getNumeroDocumento());
		empresa.get().setRazonSocial(empresaEditar.getRazonSocial());
		empresa.get().setTelefono(empresaEditar.getTelefono());
		empresa.get().setTipoDocumento(empresaEditar.getTipoDocumento());
		return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.save(empresa.get()));
	}
	
	//listar Empresa por NIT
	@GetMapping("/{NIT}")
	public ResponseEntity<?> buscarNIT(@RequestBody Empresa empresaConsultar, @PathVariable(value="NIT") Integer NIT){
	 Optional<Empresa> empresa = empresaService.findById(NIT);
	 if(!empresa.isPresent()) {
			return ResponseEntity.notFound().build(); 
	 }
	 return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.findById(empresaConsultar.getNit()));
	}
	
	/*@GetMapping("/{NIT}")
	public ResponseEntity<?> editar(@RequestBody Empresa empresa, @PathVariable(value="NIT")){
		List<Empresa> empresa= StreamSupport.stream(empresaService.findById(NIT).spliterator(),false).collect(Collectors.toList());
		return empresa;
	}
	*/
	//Listar todas las empresas
	@GetMapping
	public List<Empresa> leerTodos(){
		List<Empresa> empresa= StreamSupport.stream(empresaService.findAll().spliterator(),false).collect(Collectors.toList());
		return empresa;
	}
	

}
