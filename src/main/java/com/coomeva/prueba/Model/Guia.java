/**
 * 
 */
package com.coomeva.prueba.Model;

import java.util.*;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author LUIS MARTINEZ
 * @since 01/2022
 */

@Entity
@Table(name = "guias")
public class Guia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "nombre", nullable = false)
	private String nombre;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "telefono")
	private int telefono;
	@Column(name = "fecha_ingreso_Zoo")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private java.util.Date fechaIngresoZoo;
	@Column(name = "itinerario_id", nullable = false)
	private int itinerario_id;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="itinerario_id") Itinerario itinerario;
	 */
	
	public Guia() {
	}

	public Guia(long id, String nombre, String direccion, int telefono, Date fechaIngresoZoo, int itinerario_id) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fechaIngresoZoo = fechaIngresoZoo;
		this.itinerario_id = itinerario_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Date getFechaIngresoZoo() {
		return fechaIngresoZoo;
	}

	public void setFechaIngresoZoo(Date fechaIngresZoo) {
		this.fechaIngresoZoo = fechaIngresZoo;
	}

	public int getItinerario_id() {
		return itinerario_id;
	}

	public void setItinerario_id(int itinerario_id) {
		this.itinerario_id = itinerario_id;
	}

	@Override
	public String toString() {
		return "Guia [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", fechaIngresoZoo=" + fechaIngresoZoo + ", itinerario_id=" + itinerario_id + "]";
	}

}
