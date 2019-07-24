package com.dani.daoimpl;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.dani.dao.PartidosDao;
import com.dani.entidad.Jornadas;
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

	@Override
	public Partidos nextPartido(Jornadas jornada) {
		Partidos partido = null;
		
		String sql = "select p"
				+ " 	from Partidos p "
			 	+ "	   where p.idJornada = :idJornada"
			 	+ "      and p.idPartido = (select min(p1.idPartido)"
			 	+ " 						  from Partidos p1"
			 	+ "							 where p1.idJornada = :idJornada)";
		Query<Partidos> query = session.createQuery(sql, Partidos.class);
		query.setParameter("idJornada", jornada);
		
		partido = query.uniqueResult();
					
		return partido;
	}

	@Override
	public void updateResult(Partidos partido) {
		session = HibernateUtils.getTransaction();
		session.update(partido);
		HibernateUtils.doCommit(session);
		
	}
	


}
