/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/Repository.java to edit this template
 */
package com.soltec.repository;

import com.soltec.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Camila
 */
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    
}
