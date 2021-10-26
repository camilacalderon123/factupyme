/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soltec.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Camila
 */

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	private Integer NIT;
	private String departamento;
	private String pais;
	private String nombre;
	private String correo;
	private String direccion;
	private String numero_documento;
	private String razon_social;
	private String nombre_comercial;
	private String municipio;
	private int tipo_documento;
	public Integer getNIT() {
		return NIT;
	}
	public void setNIT(Integer nIT) {
		NIT = nIT;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNumero_documento() {
		return numero_documento;
	}
	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}
	public String getRazon_social() {
		return razon_social;
	}
	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}
	public String getNombre_comercial() {
		return nombre_comercial;
	}
	public void setNombre_comercial(String nombre_comercial) {
		this.nombre_comercial = nombre_comercial;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public int getTipo_documento() {
		return tipo_documento;
	}
	public void setTipo_documento(int tipo_documento) {
		this.tipo_documento = tipo_documento;
	}
	

	
}
