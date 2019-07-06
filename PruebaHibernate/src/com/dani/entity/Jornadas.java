package com.dani.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Jornadas")
public class Jornadas implements Serializable{

	
	@Id
	@Column(name = "jornada")
	private int jornada;
	
	@Id
	@Column(name = "partido")
	private int partido;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idequipo")
	private Equipos equipo;

	public Jornadas() {}
	
	public Jornadas(int jornada, int partido, Equipos equipo) {
		this.jornada = jornada;
		this.partido = partido;
		this.equipo = equipo;
	}

	public int getJornada() {
		return jornada;
	}

	public void setJornada(int jornada) {
		this.jornada = jornada;
	}

	public int getPartido() {
		return partido;
	}

	public void setPartido(int partido) {
		this.partido = partido;
	}

	public Equipos getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipos equipo) {
		this.equipo = equipo;
	}
	
	
}
