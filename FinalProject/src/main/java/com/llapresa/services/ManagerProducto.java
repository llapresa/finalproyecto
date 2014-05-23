package com.llapresa.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.llapresa.model.Categoria;
import com.llapresa.model.Producto;

@Transactional
public class ManagerProducto extends HibernateDaoSupport {

	public Producto getProducto(Integer id, boolean lazy) {

		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		Producto producto = (Producto) ses.get(Producto.class, id);

		if (!lazy) {
			Hibernate.initialize(producto.getFotos());
			Hibernate.initialize(producto.getMarcas());
		}

		return producto;
	}

	public void addProducto(Producto producto) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		ses.save(producto);
	}

	public void deleteProducto(Producto producto) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		ses.delete(producto);
	}

	public void updateProducto(Producto producto) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		ses.update(producto);
	}

	@SuppressWarnings("unchecked")
	public int getTotalViews(int idcategoria) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		Query query;

		if (idcategoria != -1) {
			query = ses
					.createQuery("from Producto where idcategoria=:idcategoria");
			query.setInteger("idcategoria", idcategoria);
		} else
			query = ses.createQuery("from Producto");

		List<Producto> productos = query.list();

		return ((int) productos.size() / 6) + 1;
	}

	@SuppressWarnings("unchecked")
	public Collection<Producto> getAllProductos(boolean lazy) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		Query query = ses.createQuery("from Producto");

		List<Producto> productos = query.list();

		if (!lazy) {
			for (Producto p : productos) {
				Hibernate.initialize(p.getFotos());
				Hibernate.initialize(p.getMarcas());
			}
		}

		return productos;
	}

	@SuppressWarnings("unchecked")
	public Collection<Producto> getAllProductosPos(boolean lazy, int pos) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		Query query = ses.createQuery("from Producto");

		query.setFirstResult(pos * 6 - 6);
		query.setMaxResults(6);

		List<Producto> productos = query.list();

		if (!lazy) {
			for (Producto p : productos) {
				Hibernate.initialize(p.getFotos());
				Hibernate.initialize(p.getMarcas());
			}
		}

		return productos;
	}

	@SuppressWarnings("unchecked")
	public Collection<Producto> getProductosByCategoria(Integer idcategoria,
			boolean lazy, int pos) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		Query query = ses
				.createQuery("from Producto where idcategoria=:idcategoria");

		query.setInteger("idcategoria", idcategoria);

		query.setFirstResult(pos * 6 - 6);
		query.setMaxResults(6);

		List<Producto> productos = query.list();

		if (!lazy) {
			for (Producto p : productos) {
				Hibernate.initialize(p.getFotos());
				Hibernate.initialize(p.getMarcas());
			}
		}

		return productos;
	}

	public Producto getProductoMasCaro() {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		Criteria criteria = ses.createCriteria(Producto.class);

		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.max("precio"));

		criteria.setProjection(projectionList);

		List result = criteria.list();

		return (Producto) result.get(0);
	}

	public Producto getProductoMasBarato() {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		Criteria criteria = ses.createCriteria(Producto.class);

		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("titulo"));
		projectionList.add(Projections.min("precio"));

		criteria.setProjection(projectionList);

		List result = criteria.list();

		return (Producto) result.get(0);
	}

	public Map<String, Integer> getCategoriasStatistics() {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		Criteria criteria = ses.createCriteria(Producto.class);

		ProjectionList projectionList = Projections.projectionList();

		projectionList.add(Projections.groupProperty("categoria"));
		projectionList.add(Projections.rowCount());

		criteria.setProjection(projectionList);

		@SuppressWarnings("rawtypes")
		List result = criteria.list();

		Map<String, Integer> categoriaSta = new HashMap<String, Integer>();

		for (int i = 0; i < result.size(); i++) {
			Object[] obj = (Object[]) result.get(i);
			Long l = (Long) obj[1];
			categoriaSta.put(((Categoria) obj[0]).getNombre(), l.intValue());
		}

		return categoriaSta;
	}
}
