package com.llapresa.services;

import java.util.Collection;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
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
	public Collection<Producto> getAllProductos() {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		Query query = ses.createQuery("from Producto");

		List<Producto> productos = query.list();

		return productos;
	}

	@SuppressWarnings("unchecked")
	public Collection<Producto> getProductosByMarca(Integer idmarca) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		Query query = ses
				.createQuery("select idproducto, titulo, descripcion, estado, precio, idcategoria, fechaalta from producto a, producto_marca b where a.idproducto = b.idproducto and b.idmarca=:idmarca");

		query.setInteger("idmarca", idmarca);

		List<Producto> productos = query.list();

		return productos;
	}

	@SuppressWarnings("unchecked")
	public Collection<Producto> getProductosByCategoria(Integer idcategoria) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		Query query = ses
				.createQuery("from Producto where idcategoria=:idcategoria");

		query.setInteger("idcategoria", idcategoria);

		List<Producto> productos = query.list();

		return productos;
	}
}
