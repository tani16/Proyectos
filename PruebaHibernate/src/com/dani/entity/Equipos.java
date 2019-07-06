package com.dani.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Equipos")
public class Equipos implements Serializable{

	@Id
	@Column(name = "idequipo")
	private int idEquipo;
	
	@Column(name = "nombre")
	private String nombre;

	public Equipos() {	}
	
	public Equipos(int idEquipos, String nombre) {
		this.idEquipo = idEquipos;
		this.nombre = nombre;
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipos) {
		this.idEquipo = idEquipos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
}
