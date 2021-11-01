package com.soltec.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@Table(name = "empresa")
public class Empresa{

	@Column(name="correo_empresa")
	private String correoEmpresa;

	private String departamento;

	private String direccion;

	private String documento;

	private String municipio;

	@Id
	private int nit;

	@Column(name="nombre_representante")
	private String nombreRepresentante;

	@Column(name="numero_documento")
	private String numeroDocumento;

	@Column(name="razon_social")
	private String razonSocial;

	private String telefono;

	@Column(name="tipo_documento")
	private int tipoDocumento;

	public Empresa() {
	}

	
	
	
	public String getCorreoEmpresa() {
		return this.correoEmpresa;
	}

	public void setCorreoEmpresa(String correoEmpresa) {
		this.correoEmpresa = correoEmpresa;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public int getNit() {
		return this.nit;
	}

	public void setNit(int nit) {
		this.nit = nit;
	}

	public String getNombreRepresentante() {
		return this.nombreRepresentante;
	}

	public void setNombreRepresentante(String nombreRepresentante) {
		this.nombreRepresentante = nombreRepresentante;
	}

	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(int tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

}