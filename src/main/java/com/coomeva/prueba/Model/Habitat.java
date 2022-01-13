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
@Table(name = "habitat")
public class Habitat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "nombre", nullable = false)
	private String nombre;
	@Column(name = "clima")
	private String clima;
	@Column(name = "tipoVegetacion")
	private String tipoVegetacion;
	@Column(name = "continente_id", nullable = false)
	private int continente_id;
	@Column(name = "especie_id", nullable = false)
	private int especie_id;
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="continente_id") Continente continente;
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="especie_id") Especie especie;
	 */

	public Habitat() {
	}

	public Habitat(long id, String nombre, String clima, String tipoVegetacion, int continente_id,
			int especie_id) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.clima = clima;
		this.tipoVegetacion = tipoVegetacion;
		this.continente_id = continente_id;
		this.especie_id = especie_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTipoVegetacion() {
		return tipoVegetacion;
	}

	public void setTipoVegetacion(String tipoVegetacion) {
		this.tipoVegetacion = tipoVegetacion;
	}

	public int getContinente_id() {
		return continente_id;
	}

	public void setContinente_id(int continente_id) {
		this.continente_id = continente_id;
	}

	public int getEspecie_id() {
		return especie_id;
	}

	public void setEspecie_id(int especie_id) {
		this.especie_id = especie_id;
	}

}
