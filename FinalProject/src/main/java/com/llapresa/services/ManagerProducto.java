package com.llapresa.services;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

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

	public String[] getProductoMasCaro() {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		Criteria criteria = ses.createCriteria(Producto.class)
				.addOrder(Order.desc("precio")).setMaxResults(1);

		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("titulo"));
		projectionList.add(Projections.property("precio"));

		criteria.setProjection(projectionList);

		List result = criteria.list();
		Object[] obj = (Object[]) result.get(0);
		String[] masB = new String[2];

		masB[0] = obj[0].toString();
		masB[1] = obj[1].toString();

		return masB;
	}

	public String[] getProductoMasBarato() {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		Criteria criteria = ses.createCriteria(Producto.class)
				.addOrder(Order.asc("precio")).setMaxResults(1);

		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("titulo"));
		projectionList.add(Projections.property("precio"));

		criteria.setProjection(projectionList);

		List result = criteria.list();
		Object[] obj = (Object[]) result.get(0);
		String[] masB = new String[2];

		masB[0] = obj[0].toString();
		masB[1] = obj[1].toString();

		return masB;
	}

	public String getProductoPrecioMedia() {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		Criteria criteria = ses.createCriteria(Producto.class);

		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.avg("precio"));

		criteria.setProjection(projectionList);

		List result = criteria.list();
		return String.valueOf(new DecimalFormat("#.##").format(result.get(0)));
	}

	public String[][] getCategoriasStatistics() {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		Criteria criteriaProducto = ses.createCriteria(Producto.class);

		ProjectionList projectionList = Projections.projectionList();

		projectionList.add(Projections.groupProperty("categoria"));
		projectionList.add(Projections.rowCount());

		criteriaProducto.setProjection(projectionList);

		@SuppressWarnings("rawtypes")
		List result = criteriaProducto.list();

		String[][] categoriaSta = new String[result.size()][2];

		for (int i = 0; i < result.size(); i++) {
			Object[] obj = (Object[]) result.get(i);
			categoriaSta[i][0] = (String) obj[0];
			categoriaSta[i][1] = (String) String.valueOf(obj[1]);
		}

		return categoriaSta;
	}
}
