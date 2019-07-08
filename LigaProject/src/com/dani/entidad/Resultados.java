package com.dani.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "resultados")
public class Resultados implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8808226062002238832L;
	
	@Id
	@Column(name = "idResultado")
	private int idResultado;
	
	@Column(name = "golesC")
	private int golesC;
	
	@Column(name = "golesF")
	private int golesF;

	public Resultados() {}
	
	public Resultados(int idResultado, int golesC, int golesF) {
		super();
		this.idResultado = idResultado;
		this.golesC = golesC;
		this.golesF = golesF;
	}

	public int getIdResultado() {
		return idResultado;
	}

	public void setIdResultado(int idResultado) {
		this.idResultado = idResultado;
	}

	public int getGolesC() {
		return golesC;
	}

	public void setGolesC(int golesC) {
		this.golesC = golesC;
	}

	public int getGolesF() {
		return golesF;
	}

	public void setGolesF(int golesF) {
		this.golesF = golesF;
	}
	
	
	

}
