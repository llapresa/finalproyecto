package com.llapresa.services;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.llapresa.model.Usuario;

@Transactional
public class ManagerAuth extends HibernateDaoSupport {

	public Usuario validar(String login, String pwd) {

		Usuario usuario = null;

		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		Query query = ses
				.createQuery("from Usuario where login=:login and password=:pwd");

		query.setString("login", login);
		try {
			query.setString("pwd", Utils.getHash(pwd));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		List<Usuario> usuarios = query.list();

		if (usuarios.size() > 0) {
			usuario = usuarios.get(0);
			Hibernate.initialize(usuario.getRol());
		}

		return usuario;
	}
}