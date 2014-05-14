package com.llapresa.services;

import java.util.Collection;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.llapresa.model.Marca;

@Transactional
public class ManagerMarca extends HibernateDaoSupport {

	public Marca getMarca(Integer id, boolean lazy) {

		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		Marca marca = (Marca) ses.get(Marca.class, id);

		if (!lazy)
			Hibernate.initialize(marca.getProductos());

		return marca;
	}

	public void addMarca(Marca marca) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		ses.save(marca);
	}

	public void deleteMarca(Marca marca) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		ses.delete(marca);
	}

	public void updateMarca(Marca marca) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		ses.update(marca);
	}

	@SuppressWarnings("unchecked")
	public Collection<Marca> getAllMarcas() {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		Query query = ses.createQuery("from marca");

		List<Marca> marcas = query.list();

		return marcas;
	}
}
