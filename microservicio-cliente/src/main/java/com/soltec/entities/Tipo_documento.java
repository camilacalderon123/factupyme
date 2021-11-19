/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soltec.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tipo_documento")
public class Tipo_documento {
    @Id
    private int id_tipo_documento;
    
    private String descripcion;
    
	public int getId_tipo_documento() {
		return id_tipo_documento;
	}
	public void setId_tipo_documento(int id_tipo_documento) {
		this.id_tipo_documento = id_tipo_documento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
}
