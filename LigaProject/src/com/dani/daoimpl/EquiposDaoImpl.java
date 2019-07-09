package com.dani.daoimpl;

import org.hibernate.Session;

import com.dani.dao.EquiposDao;
import com.dani.entidad.Equipos;
import com.dani.util.HibernateUtils;

public class EquiposDaoImpl implements EquiposDao {

	private Session session = null;
	
	public EquiposDaoImpl() {
		session = HibernateUtils.getSessionFactory().getCurrentSession();
	}
	
	
	@Override
	public Equipos getEquipoById(int id) {
		
		return session.get(Equipos.class, id);
	}

}
