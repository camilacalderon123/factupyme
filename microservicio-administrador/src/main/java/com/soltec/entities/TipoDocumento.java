package com.soltec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the tipo_documento database table.
 * 
 */
@Entity
@Table(name="tipo_documento")
public class TipoDocumento{

	private String descripcion;
	@Id
	@Column(name="id_tipo_documento")
	private int idTipoDocumento;

	public TipoDocumento() {
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdTipoDocumento() {
		return this.idTipoDocumento;
	}

	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

}