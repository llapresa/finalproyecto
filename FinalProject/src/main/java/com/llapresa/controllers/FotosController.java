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

import com.llapresa.model.Foto;
import com.llapresa.services.ManagerFoto;

@Controller
public class FotosController implements BeanFactoryAware {

	private ManagerFoto dao;

	@RequestMapping(value = "/fotos.htm")
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse rep) throws Exception {

		Collection<Foto> fotos = dao.getAllFotos();

		Map<String, Object> datos;
		datos = new HashMap<String, Object>();

		datos.put("fotos", fotos);

		return new ModelAndView("fotos", datos);
	}

	@Override
	public void setBeanFactory(BeanFactory bf) throws BeansException {
		dao = bf.getBean(ManagerFoto.class);
	}

}
