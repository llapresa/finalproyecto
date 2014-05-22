package com.llapresa.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.llapresa.model.Marca;
import com.llapresa.model.Producto;

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

		Query query = ses.createQuery("from Marca");

		List<Marca> marcas = query.list();

		return marcas;
	}

	@SuppressWarnings("unchecked")
	public int getTotalViews(int idmarca) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		Query query = ses.createQuery("from Marca where idmarca=:idmarca");
		query.setInteger("idmarca", idmarca);
		List<Marca> marcas = query.list();
		Marca marca = marcas.get(0);

		Hibernate.initialize(marca.getProductos());

		Set<Producto> productos = marca.getProductos();

		return ((int) productos.size() / 6) + 1;
	}

	@SuppressWarnings("unchecked")
	public Collection<Producto> getAllProductosByMarca(int idmarca,
			boolean lazy, int pos) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		Query query = ses.createQuery("from Marca where idmarca=:idmarca");
		query.setInteger("idmarca", idmarca);
		List<Marca> marcas = query.list();
		Marca marca = marcas.get(0);

		if (!lazy)
			Hibernate.initialize(marca.getProductos());

		List<Producto> productos = new ArrayList<Producto>();

		Set<Producto> setP = marca.getProductos();
		Iterator<Producto> iterator = setP.iterator();

		while (iterator.hasNext()) {
			productos.add(iterator.next());
		}

		List<Producto> productosF = new ArrayList<Producto>();

		for (int i = pos * 6 - 6; i < 6 && i < productos.size(); i++) {
			Hibernate.initialize(productos.get(i).getFotos());
			productosF.add(productos.get(i));

		}

		return productosF;
	}
}
