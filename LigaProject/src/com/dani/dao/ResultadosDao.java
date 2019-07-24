package com.dani.dao;

import com.dani.entidad.Resultados;

public interface ResultadosDao {

	public Resultados getResultadoById(int id);

	public void save(Resultados resultado);
		
	
}
