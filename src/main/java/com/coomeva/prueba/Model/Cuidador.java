/**
 * 
 */
package com.coomeva.prueba.Model;

import java.util.Date;

import javax.persistence.*;

/**
 * @author LUIS MARTINEZ
 * @since 01/2022
 */

@Entity
@Table(name = "cuidador")
public class Cuidador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	Long id;
	@Column(name="nombre",nullable = false)
	String nombre;
	@Column(name="direccion")
	String direccion;
	@Column(name="telefono")
	String telefono;
	@Column(name="fecha_ingreso_parque")
	Date fechaIngresoParque;
	@Column(name="especie_id", nullable = false)
	int especie_id;
	/*
	@ManyToOne
	@JoinColumn(name="especie_id")
	Especie especie;
	 */
	public Cuidador() {
	}

	

	public Cuidador(Long id, String nombre, String direccion, String telefono, Date fechaIngresoParque,
			int especie_id) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fechaIngresoParque = fechaIngresoParque;
		this.especie_id = especie_id;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaIngresoParque() {
		return fechaIngresoParque;
	}

	public void setFechaIngresoParque(Date fechaIngresoParque) {
		this.fechaIngresoParque = fechaIngresoParque;
	}
	
	public int getEspecie_id() {
		return especie_id;
	}

	public void setEspecie_id(int especie_id) {
		this.especie_id = especie_id;
	}

	@Override
	public String toString() {
		return "Cuidador [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", fechaIngresoParque=" + fechaIngresoParque + ", especie_id=" + especie_id + "]";
	}
	
	
	
	
}
