package com.soltec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soltec.entities.Producto;
import com.soltec.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Producto> findAll() {
		return productoRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Producto> findAll(Pageable pagebale) {
		return productoRepository.findAll(pagebale);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Producto> findById(Integer codigo) {
		return productoRepository.findById(codigo);
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	@Transactional
	public void deleteById(Integer codigo) {
		productoRepository.deleteById(codigo);
	}
}
