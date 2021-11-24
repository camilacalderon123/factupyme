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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soltec.entities.Producto;
import com.soltec.service.ProductoService;



@RestController // Controlador de tipo Rest
@CrossOrigin(origins="http://localhost:4200") //Con esto le decimos que acepte peticiones
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	//agregar producto
	@PostMapping("/")
	public ResponseEntity<?> crear(@RequestBody Producto producto) {//en el cuerpo de la peticion vamos a recibir un producto
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));	
	}
	
	//Listar todos los productos
	@GetMapping("/")
	public List<Producto> leerTodos(){
		List<Producto> producto = StreamSupport.stream(productoService.findAll().spliterator(),false).collect(Collectors.toList());
		return producto;
	}
	
	//Listar uno solo 
	@GetMapping("/listar-codigo/{codigo}")
	public ResponseEntity<?> obtenerProducto(@PathVariable(value="codigo") Integer codigo) {
		Optional<Producto> producto = productoService.findById(codigo);
		if(!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(producto);
	}
	
	//Editar un producto
	@PutMapping("/{codigo}")
	public ResponseEntity<?> editar(@RequestBody Producto productoEditar, @PathVariable(value="codigo") Integer codigoproducto){
		Optional<Producto> producto= productoService.findById(codigoproducto);
		if (!producto.isPresent()) {
			return ResponseEntity.notFound().build(); 
		}	
		producto.get().setCodigo(productoEditar.getCodigo());
		producto.get().setDescripcion(productoEditar.getDescripcion());
		producto.get().setEstado(productoEditar.isEstado());
		producto.get().setIva(productoEditar.getIva());
		producto.get().setNombre(productoEditar.getNombre());
		producto.get().setPorcentaje_descuento(productoEditar.getPorcentaje_descuento());
		producto.get().setUnidad_medida(productoEditar.getUnidad_medida());
		producto.get().setValor_unitario(productoEditar.getValor_unitario());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto.get()));
	}
	//Eliminar un producto
	@DeleteMapping("/{codigo}")
	public ResponseEntity<?> eliminar(@PathVariable(value="codigo") Integer codigo){
		if(!productoService.findById(codigo).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		productoService.deleteById(codigo);
		return ResponseEntity.ok().build();
	}
	

}