package com.soltec.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soltec.entities.Producto;
import com.soltec.service.ProductoService;



@RestController // Controlador de tipo Rest

public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	//Listar productos
	@GetMapping("/productos")
	public String index(Model model) {
		model.addAttribute("list", productoService.findAll());
		return "Dashboard/ver-productos";
	}
	
	//agregar producto
	@PostMapping("/crear-producto")
	public String crear(@RequestBody Producto producto, Model model) {
		productoService.save(producto);	
		return "Dashboard/agregar-productos";	
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
	public String eliminar(@PathVariable(value="codigo") Integer codigo){
		productoService.deleteById(codigo);
		return "redirect:/";
	}
	
	//Listar todos los productos
	@GetMapping
	public List<Producto> leerTodos(){
		List<Producto> producto = StreamSupport.stream(productoService.findAll().spliterator(),false).collect(Collectors.toList());
		return producto;
	}
}