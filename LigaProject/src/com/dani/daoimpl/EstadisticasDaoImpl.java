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


	@Override
	public void updateRacha(Equipos equipo, String key) {
		Estadisticas stats = getStatics(equipo);
		if(key.equals("Victoria")) {
			if(stats.getRacha() >= 0) {
				stats.setRacha(stats.getRacha() + 0.1);
			}else {
				stats.setRacha(0.0);
			}
		}else if(key.equals("Empate")) {
			stats.setRacha(0.0);
		}else {
			if(stats.getRacha() <= 0) {
				stats.setRacha(stats.getRacha() - 0.1);
			}else {
				stats.setRacha(0.0);
			}
		}
		save(stats);
	}

	@Override
	public void save(Estadisticas stats) {

		session = HibernateUtils.getTransaction();
		session.save(stats);
		HibernateUtils.doCommit(session);
		
	}

}
