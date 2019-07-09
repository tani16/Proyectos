package com.dani.daoimpl;

import org.hibernate.Session;

import com.dani.dao.EquiposDao;
import com.dani.dao.ResultadosDao;
import com.dani.entidad.Equipos;
import com.dani.entidad.Resultados;
import com.dani.util.HibernateUtils;

public class ResultadosDaoImpl implements ResultadosDao {

	private Session session = null;
	
	public ResultadosDaoImpl() {
		session = HibernateUtils.getSessionFactory().getCurrentSession();
	}
	
	
	@Override
	public Resultados getResultadoById(int id) {
		
		return session.get(Resultados.class, id);
	}

}
