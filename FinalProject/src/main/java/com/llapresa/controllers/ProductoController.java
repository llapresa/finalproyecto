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
public class ProductoController implements BeanFactoryAware {

	private ManagerProducto managerProducto;
	private ManagerMarca managerMarca;
	private ManagerCategoria managerCategoria;

	@RequestMapping(value = "/producto.htm")
	public ModelAndView handleRequest(
			@RequestParam("idproducto") Integer idproducto,
			HttpServletRequest req, HttpServletResponse rep) throws Exception {

		Map<String, Object> datos;
		datos = new HashMap<String, Object>();

		Producto producto = managerProducto.getProducto(idproducto, false);

		datos.put("producto", producto);

		// Collection<Producto> productos = new ArrayList<Producto>();

		// productos.add(producto);

		// datos.put("productos", productos);

		Collection<Marca> marcas = managerMarca.getAllMarcas();

		datos.put("marcas", marcas);

		Collection<Categoria> categorias = managerCategoria.getAllCategorias();

		datos.put("categorias", categorias);

		return new ModelAndView("producto", datos);
	}

	@Override
	public void setBeanFactory(BeanFactory bf) throws BeansException {
		managerProducto = bf.getBean(ManagerProducto.class);
		managerMarca = bf.getBean(ManagerMarca.class);
		managerCategoria = bf.getBean(ManagerCategoria.class);
	}

}
