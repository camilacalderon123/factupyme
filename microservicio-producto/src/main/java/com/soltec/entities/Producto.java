package com.soltec.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //le dice a spring que esta clase es una entidad
@Table(name = "producto") //nuestras clases entidad se van a mapear a tablas en la bd
public class Producto {
	
	@Id //definimos la llave primaria 
	private int codigo;
	
	private String nombre;
	private String descripcion;
	private int valor_unitario;
	private String unidad_medida;
	private double porcentaje_descuento;
	private double iva;
	private boolean estado;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getValor_unitario() {
		return valor_unitario;
	}
	public void setValor_unitario(int valor_unitario) {
		this.valor_unitario = valor_unitario;
	}
	public String getUnidad_medida() {
		return unidad_medida;
	}
	public void setUnidad_medida(String unidad_medida) {
		this.unidad_medida = unidad_medida;
	}
	public double getPorcentaje_descuento() {
		return porcentaje_descuento;
	}
	public void setPorcentaje_descuento(double porcentaje_descuento) {
		this.porcentaje_descuento = porcentaje_descuento;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	

	
}