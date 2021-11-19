/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soltec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	private Integer numero_documento;
	
	private String nombre_comercial;
	private String nombre;
	private String pais;
	private String departamento;
	private String ciudad;
	private String direccion;
	private String correo;
	private String telefono;
	private String contribuyente;
	private String regimen_contable;
	private int tipo_documento;
	
	public Integer getNumero_documento() {
		return numero_documento;
	}
	public void setNumero_documento(Integer numero_documento) {
		this.numero_documento = numero_documento;
	}
	public String getNombre_comercial() {
		return nombre_comercial;
	}
	public void setNombre_comercial(String nombre_comercial) {
		this.nombre_comercial = nombre_comercial;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getContribuyente() {
		return contribuyente;
	}
	public void setContribuyente(String contribuyente) {
		this.contribuyente = contribuyente;
	}
	public String getRegimen_contable() {
		return regimen_contable;
	}
	public void setRegimen_contable(String regimen_contable) {
		this.regimen_contable = regimen_contable;
	}
	public int getTipo_documento() {
		return tipo_documento;
	}
	public void setTipo_documento(int tipo_documento) {
		this.tipo_documento = tipo_documento;
	}


	

	
}
