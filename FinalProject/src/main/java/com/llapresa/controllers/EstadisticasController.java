package com.llapresa.controllers;

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

import com.llapresa.services.ManagerProducto;

@Controller
public class EstadisticasController implements BeanFactoryAware {

	private static String[] barstyles = { "progress-bar-success",
			"progress-bar-info", "progress-bar-warning", "progress-bar-danger" };

	private ManagerProducto managerProducto;

	@RequestMapping(value = "/estadisticas.htm")
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse rep) throws Exception {

		Map<String, Object> datos = new HashMap<String, Object>();

		// managerProducto.getProductoPrecioMedia();
		String[] barato = managerProducto.getProductoMasBarato();
		String[] caro = managerProducto.getProductoMasCaro();
		String media = managerProducto.getProductoPrecioMedia();
		String[][] categoriasEsta = managerProducto.getCategoriasStatistics();

		// String[][] estadisticas = managerProducto.getCategoriasStatistics();

		// String[][] barato = managerProducto.getProductoMasBarato();
		// String[][] caro = managerProducto.getProductoMasCaro();

		// datos.put("estadisticas", estadisticas);

		datos.put("barato", barato);
		datos.put("caro", caro);
		datos.put("media", media);
		datos.put("barstyles", barstyles);
		datos.put("categorias", categoriasEsta);

		return new ModelAndView("estadisticas", datos);
	}

	@Override
	public void setBeanFactory(BeanFactory bf) throws BeansException {
		managerProducto = bf.getBean(ManagerProducto.class);
	}

}
