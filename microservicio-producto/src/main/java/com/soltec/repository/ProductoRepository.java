package com.soltec.repository;

import org.springframework.data.repository.CrudRepository;

import com.soltec.entities.Producto;

public interface ProductoRepository  extends CrudRepository<Producto, Long>  {

}
