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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.llapresa.model.Categoria;
import com.llapresa.model.Marca;
import com.llapresa.model.Producto;
import com.llapresa.services.ManagerCategoria;
import com.llapresa.services.ManagerMarca;
import com.llapresa.services.ManagerProducto;

@Controller
public class CatalogoController implements BeanFactoryAware {

	private ManagerProducto managerProducto;
	private ManagerMarca managerMarca;
	private ManagerCategoria managerCategoria;

	@RequestMapping(value = "/catalogo.htm")
	public ModelAndView handleRequest(@RequestParam("idmarca") Integer idmarca,
			@RequestParam("idcategoria") Integer idcategoria,
			HttpServletRequest req, HttpServletResponse rep) throws Exception {

		Map<String, Object> datos;
		datos = new HashMap<String, Object>();

		Collection<Producto> productos;
		Collection<Marca> marcas;
		Collection<Categoria> categorias;

		if (idmarca != -1) {
			productos = managerProducto.getProductosByMarca(idmarca, false);
			datos.put("productos", productos);
		} else if (idcategoria != -1) {
			productos = managerProducto.getProductosByCategoria(idcategoria,
					false);
			datos.put("productos", productos);
		} else {
			productos = managerProducto.getAllProductosPos(false, 1);
			datos.put("productos", productos);
		}

		marcas = managerMarca.getAllMarcas();
		datos.put("marcas", marcas);

		categorias = managerCategoria.getAllCategorias();
		datos.put("categorias", categorias);

		return new ModelAndView("catalogo", datos);
	}

	@Override
	public void setBeanFactory(BeanFactory bf) throws BeansException {
		managerProducto = bf.getBean(ManagerProducto.class);
		managerMarca = bf.getBean(ManagerMarca.class);
		managerCategoria = bf.getBean(ManagerCategoria.class);
	}

}
