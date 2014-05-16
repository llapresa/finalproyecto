package com.llapresa.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.llapresa.model.Categoria;
import com.llapresa.services.ManagerCategoria;

@Controller
public class CategoriasController implements BeanFactoryAware {

	private ManagerCategoria dao;

	@RequestMapping(value = "/categorias.htm")
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse rep) throws Exception {

		Collection<Categoria> categorias = dao.getAllCategorias();

		Map<String, Object> datos;
		datos = new HashMap<String, Object>();

		datos.put("categorias", categorias);

		return new ModelAndView("categorias", datos);
	}

	@Override
	public void setBeanFactory(BeanFactory bf) throws BeansException {
		dao = bf.getBean(ManagerCategoria.class);
	}

}
