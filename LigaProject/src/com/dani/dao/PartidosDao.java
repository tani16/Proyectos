package com.dani.dao;

import com.dani.entidad.Jornadas;
import com.dani.entidad.Partidos;

public interface PartidosDao {

	public void create(Partidos partido);

	public Partidos nextPartido(Jornadas jornada);

	public void updateResult(Partidos partido);
	
	
}
