/**
 * 
 */
package com.coomeva.prueba.Model;

import javax.persistence.*;

/**
 * @author LUIS MARTINEZ
 * @since 01/2022
 */

@Entity
@Table(name = "zona")
public class Zona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Long id;
	@Column(name = "nombre", nullable = false)
	String nombre;
	@Column(name = "extension")
	int extension;
	@Column(name = "itinerario_id", nullable = false)
	int itinerario_id;
	@Column(name = "especie_id", nullable = false)
	int especie_id;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="itinerario_id") Itinerario itinerario;
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="especie_id") Especie especie;
	 */
	public Zona() {
	}

	public Zona(Long id, String nombre, int extension, int itinerario_id, int especie_id) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.extension = extension;
		this.itinerario_id = itinerario_id;
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

	public int getExtension() {
		return extension;
	}

	public void setExtension(int extension) {
		this.extension = extension;
	}

	public int getItinerario_id() {
		return itinerario_id;
	}

	public void setItinerario_id(int itinerario_id) {
		this.itinerario_id = itinerario_id;
	}

	public int getEspecie_id() {
		return especie_id;
	}

	public void setEspecie_id(int especie_id) {
		this.especie_id = especie_id;
	}

	@Override
	public String toString() {
		return "Zona [id=" + id + ", nombre=" + nombre + ", extension=" + extension + ", itinerario_id=" + itinerario_id
				+ ", especie_id=" + especie_id + "]";
	}

}
