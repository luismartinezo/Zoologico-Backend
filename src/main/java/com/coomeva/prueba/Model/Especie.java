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
@Table (name = "especie")
public class Especie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	@Column(name="nombre_espanol",nullable = false)
	private String nombreEspanol;
	@Column(name="nombre_cientifico",nullable = false)
	private String nombreCientifico;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="fecha_cuidado")
	private Date fechaCuidado;
	@Column(name="habitat_id", nullable = false)
	private int habitat_id;
	@Column(name="zona_id", nullable = false)
	private int zona_id;
	@Column(name="cuidador_id", nullable = false)
	private int cuidador_id;
	/*
	@ManyToOne
	@JoinColumn(name="habitat_id")
	Habitat habitat;
	@ManyToOne
	@JoinColumn(name="zona_id")
	Zona zona;
	@ManyToOne
	@JoinColumn(name="cuidador_id")
	Cuidador cuidador;
	*/
	public Especie() {
	}
	
	public Especie(long id, String nombreEspanol, String nombreCientifico, String descripcion, Date fechaCuidado,
			int habitat_id, int zona_id, int cuidador_id) {
		super();
		this.id = id;
		this.nombreEspanol = nombreEspanol;
		this.nombreCientifico = nombreCientifico;
		this.descripcion = descripcion;
		this.fechaCuidado = fechaCuidado;
		this.habitat_id = habitat_id;
		this.zona_id = zona_id;
		this.cuidador_id = cuidador_id;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombreEspanol() {
		return nombreEspanol;
	}
	public void setNombreEspanol(String nombreEspanol) {
		this.nombreEspanol = nombreEspanol;
	}
	public String getNombreCientifico() {
		return nombreCientifico;
	}
	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechaCuidado() {
		return fechaCuidado;
	}
	public void setFechaCuidado(Date fechaCuidado) {
		this.fechaCuidado = fechaCuidado;
	}
	
	public int getHabitat_id() {
		return habitat_id;
	}

	public void setHabitat_id(int habitat_id) {
		this.habitat_id = habitat_id;
	}

	public int getZona_id() {
		return zona_id;
	}

	public void setZona_id(int zona_id) {
		this.zona_id = zona_id;
	}

	public int getCuidador_id() {
		return cuidador_id;
	}

	public void setCuidador_id(int cuidador_id) {
		this.cuidador_id = cuidador_id;
	}

	@Override
	public String toString() {
		return "Especie [id=" + id + ", nombreEspanol=" + nombreEspanol + ", nombreCientifico=" + nombreCientifico
				+ ", descripcion=" + descripcion + ", fechaCuidado=" + fechaCuidado + ", habitat_id=" + habitat_id
				+ ", zona_id=" + zona_id + ", cuidador_id=" + cuidador_id + "]";
	}

	
	
	
	
	
}
