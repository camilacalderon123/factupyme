/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/Repository.java to edit this template
 */
package com.soltec.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.soltec.entities.Cliente;

/**
 *
 * @author Camila
 */
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    
}
