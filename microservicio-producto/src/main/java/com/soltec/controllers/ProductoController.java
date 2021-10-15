package com.soltec.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soltec.entities.Producto;
import com.soltec.service.ProductoService;



@RestController // Controlador de tipo Rest

public class ProductoController {

	@Autowired
	private ProductoService service;

	@GetMapping // esta mapeado a la raiz del proyecto, ya que no tiene ninguna ruta
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/{id}")
	// ResponseEntity nos permite construir la respuesta: podemos guardar y pasar
	// objetos
	public ResponseEntity<?> verDetalles(@PathVariable Long ID) {
		Optional<Producto> op = service.findById(ID);
		if (op.isEmpty()) {
			System.out.println("ID vacio");
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(op.get());
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Producto producto) {
		if (producto.equals(null)) {
			return ResponseEntity.notFound().build();
		}
		Producto alumnoDb = service.save(producto);
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDb);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Producto producto, @PathVariable Long ID) {
		if (service.findById(ID).equals(null)) {
			return ResponseEntity.notFound().build();
		}
		Optional<Producto> o = null;
		Producto productodb = o.get();
		productodb.setCodigo(producto.getCodigo());
		productodb.setNombre(producto.getNombre());
		productodb.setDescripcion(producto.getDescripcion());
		productodb.setUnidad_medida(producto.getUnidad_medida());
		productodb.setPorcentaje_descuento(producto.getPorcentaje_descuento());
		productodb.setIva(producto.getIva());
		productodb.setEstado(producto.isEstado());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productodb));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long ID) {
		/*if (service.findById(ID).equals(null) || ID == null) {
			return ResponseEntity.notFound().build();
		}*/
		service.deleteById(ID);
		return ResponseEntity.noContent().build();
	}
}