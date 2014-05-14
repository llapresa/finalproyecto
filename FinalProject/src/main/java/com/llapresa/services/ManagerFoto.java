package com.llapresa.services;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.llapresa.model.Foto;

@Transactional
public class ManagerFoto extends HibernateDaoSupport {

	public Foto getFoto(Integer id) {

		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		Foto foto = (Foto) ses.get(Foto.class, id);

		return foto;
	}

	public void addFoto(Foto foto) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		ses.save(foto);
	}

	public void deleteFoto(Foto foto) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		ses.delete(foto);
	}

	public void updateFoto(Foto foto) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		ses.update(foto);
	}

	@SuppressWarnings("unchecked")
	public Collection<Foto> getAllFotos() {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		Query query = ses.createQuery("from foto");

		List<Foto> fotos = query.list();

		return fotos;
	}
}
