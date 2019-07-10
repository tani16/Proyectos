package com.dani.daoimpl;

import org.hibernate.Session;

import com.dani.dao.PartidosDao;
import com.dani.entidad.Partidos;
import com.dani.util.HibernateUtils;

public class PartidosDaoImpl implements PartidosDao {

	private Session session = null;
	
	public PartidosDaoImpl() {
		session = HibernateUtils.getSessionFactory().getCurrentSession();
	}

	@Override
	public void create(Partidos partido) {
		session = HibernateUtils.getTransaction();
		session.save(partido);
		HibernateUtils.doCommit(session);
	}
	


}
