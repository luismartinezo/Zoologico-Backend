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
@Table(name = "itinerario")
public class Itinerario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "codigo", nullable = false)
	private long codigo;
	@Column(name = "duracion_recorrido")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private java.util.Date duracionRecorrido;
	@Column(name = "longitud")
	private long longitud;
	@Column(name = "numero_visitante")
	private int numeroVisitante;
	@Column(name = "numero_especie_visitada")
	private int numeroEspecieVisitada;
	@Column(name = "zona_id", nullable = false)
	private int zona_id;
	@Column(name = "guia_id", nullable = false)
	private int guia_id;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "zona_id") Zona zona;
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "guia_id") Guia guia;
	 */

	public Itinerario() {
	}

	public Itinerario(long id, long codigo, Date duracionRecorrido, long longitud, int numeroVisitante,
			int numeroEspecieVisitada, int zona_id, int guia_id) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.duracionRecorrido = duracionRecorrido;
		this.longitud = longitud;
		this.numeroVisitante = numeroVisitante;
		this.numeroEspecieVisitada = numeroEspecieVisitada;
		this.zona_id = zona_id;
		this.guia_id = guia_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Date getDuracionRecorrido() {
		return duracionRecorrido;
	}

	public void setDuracionRecorrido(Date duracionRecorrido) {
		this.duracionRecorrido = duracionRecorrido;
	}

	public long getLongitud() {
		return longitud;
	}

	public void setLongitud(long longitud) {
		this.longitud = longitud;
	}

	public int getNumeroVisitante() {
		return numeroVisitante;
	}

	public void setNumeroVisitante(int numeroVisitante) {
		this.numeroVisitante = numeroVisitante;
	}

	public int getNumeroEspecieVisitada() {
		return numeroEspecieVisitada;
	}

	public void setNumeroEspecieVisitada(int numeroEspecieVisitada) {
		this.numeroEspecieVisitada = numeroEspecieVisitada;
	}

	public int getZona_id() {
		return zona_id;
	}

	public void setZona_id(int zona_id) {
		this.zona_id = zona_id;
	}

	public int getGuia_id() {
		return guia_id;
	}

	public void setGuia_id(int guia_id) {
		this.guia_id = guia_id;
	}

	@Override
	public String toString() {
		return "Itinerario [id=" + id + ", codigo=" + codigo + ", duracionRecorrido=" + duracionRecorrido
				+ ", longitud=" + longitud + ", numeroVisitante=" + numeroVisitante + ", numeroEspecieVisitada="
				+ numeroEspecieVisitada + ", zona_id=" + zona_id + ", guia_id=" + guia_id + "]";
	}

}
