package com.dani.dao;

import com.dani.entidad.Jornadas;
import com.dani.entidad.Partidos;
import com.dani.entidad.Resultados;

public interface PartidosDao {

	public void create(Partidos partido);

	public Partidos nextPartido(Jornadas jornada, Resultados resultadoNulo);

	public void updateResult(Partidos partido);
	
	
}
