package com.dani.daoimpl;

import org.hibernate.Session;

import com.dani.dao.JornadasDao;
import com.dani.entidad.Jornadas;
import com.dani.util.HibernateUtils;

public class JornadasDaoImpl implements JornadasDao {

	private Session session;
	
	public JornadasDaoImpl() {
		session = HibernateUtils.getSessionFactory().getCurrentSession();
	}

	@Override
	public void createJornada(Jornadas jornada) {
		session.save(jornada);
	}
}
