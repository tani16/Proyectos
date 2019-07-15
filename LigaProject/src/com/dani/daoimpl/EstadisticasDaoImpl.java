package com.dani.daoimpl;

import org.hibernate.Session;

import com.dani.dao.EstadisticasDao;
import com.dani.entidad.Equipos;
import com.dani.entidad.Estadisticas;
import com.dani.util.HibernateUtils;

public class EstadisticasDaoImpl implements EstadisticasDao{
	
	private Session session = null;
	
	public EstadisticasDaoImpl() {
		session = HibernateUtils.getSessionFactory().getCurrentSession();
	}
	

	@Override
	public Estadisticas getStatics(Equipos equipo) {
		
		return session.get(Estadisticas.class, equipo.getIdEquipo());
	}

}
