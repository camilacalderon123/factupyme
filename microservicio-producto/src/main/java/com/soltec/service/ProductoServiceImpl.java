package com.soltec.service;

import java.util.Optional;

import com.soltec.entities.Producto;

public class ProductoServiceImpl implements ProductoService {

	@Override
	public Iterable<Producto> findAll() {
		// TODO Auto-generated method stub
		return findAll();
	}

	@Override
	public Optional<Producto> findById(Long ID) {
		// TODO Auto-generated method stub
		return findById(ID);
	}

	@Override
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		return save(producto);
	}

	@Override
	public void deleteById(Long ID) {
		// TODO Auto-generated method stub
		return ;
	}

}
