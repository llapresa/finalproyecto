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

import com.llapresa.model.Producto;
import com.llapresa.services.ManagerProducto;

@Controller
public class ProductosController implements BeanFactoryAware {

	private ManagerProducto dao;

	@RequestMapping(value = "/productos.htm")
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse rep) throws Exception {

		Collection<Producto> productos = dao.getAllProductos();

		Map<String, Object> datos;
		datos = new HashMap<String, Object>();

		datos.put("productos", productos);

		return new ModelAndView("productos", datos);
	}

	@Override
	public void setBeanFactory(BeanFactory bf) throws BeansException {
		dao = bf.getBean(ManagerProducto.class);
	}

}
