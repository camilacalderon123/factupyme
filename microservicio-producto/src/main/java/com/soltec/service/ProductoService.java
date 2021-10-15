package com.soltec.service;

import java.util.Optional;

import com.soltec.entities.Producto;


public interface ProductoService {
	public Iterable<Producto> findAll();

	public Optional<Producto> findById(Long ID);

	public Producto save(Producto producto);

	public void deleteById(Long ID);
}
