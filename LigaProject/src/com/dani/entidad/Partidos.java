package com.dani.entidad;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "partidos")
public class Partidos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3034569161932116857L;
	
	@Id
	@Column(name = "idPartido")
	private int idPartido;
	
	@Id
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idJornada")
	private Jornadas idJornada;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idEquipoC")
	private Equipos equipoC;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idEquipoF")
	private Equipos equipoF;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idResultado")
	private Resultados idResultado;
	
	public Partidos() {}
	
	public Partidos(int idPartido, Jornadas idJornada, Equipos equipoC, Equipos equipoF, Resultados idResultado) {
		super();
		this.idPartido = idPartido;
		this.idJornada = idJornada;
		this.equipoC = equipoC;
		this.equipoF = equipoF;
		this.idResultado = idResultado;
	}

	public int getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}

	public Jornadas getIdJornada() {
		return idJornada;
	}

	public void setIdJornada(Jornadas idJornada) {
		this.idJornada = idJornada;
	}

	public Equipos getEquipoC() {
		return equipoC;
	}

	public void setEquipoC(Equipos equipoC) {
		this.equipoC = equipoC;
	}

	public Equipos getEquipoF() {
		return equipoF;
	}

	public void setEquipoF(Equipos equipoF) {
		this.equipoF = equipoF;
	}

	public Resultados getIdResultado() {
		return idResultado;
	}

	public void setIdResultado(Resultados idResultado) {
		this.idResultado = idResultado;
	}
}
