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

import com.llapresa.model.Marca;
import com.llapresa.services.ManagerMarca;

@Controller
public class MarcasController implements BeanFactoryAware {

	private ManagerMarca dao;

	@RequestMapping(value = "/marcas.htm")
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse rep) throws Exception {

		Collection<Marca> marcas = dao.getAllMarcas();

		Map<String, Object> datos;
		datos = new HashMap<String, Object>();

		datos.put("marcas", marcas);

		return new ModelAndView("marcas", datos);
	}

	@Override
	public void setBeanFactory(BeanFactory bf) throws BeansException {
		dao = bf.getBean(ManagerMarca.class);
	}

}
