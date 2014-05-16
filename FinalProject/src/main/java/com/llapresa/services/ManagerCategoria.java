package com.llapresa.services;

import java.util.Collection;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.llapresa.model.Categoria;

@Transactional
public class ManagerCategoria extends HibernateDaoSupport {

	public Categoria getCategoria(Integer id, boolean lazy) {

		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		Categoria categoria = (Categoria) ses.get(Categoria.class, id);

		if (!lazy) {
			Hibernate.initialize(categoria.getProductos());
		}

		return categoria;
	}

	public void addCategoria(Categoria categoria) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		ses.save(categoria);
	}

	public void deleteCategoria(Categoria categoria) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		ses.delete(categoria);
	}

	public void updateCategoria(Categoria categoria) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		ses.update(categoria);
	}

	@SuppressWarnings("unchecked")
	public Collection<Categoria> getAllCategorias() {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		Query query = ses.createQuery("from Categoria");

		List<Categoria> categorias = query.list();

		return categorias;
	}

}
