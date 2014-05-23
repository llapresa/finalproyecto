package com.llapresa.controllers;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Controller;

import com.llapresa.services.ManagerCategoria;
import com.llapresa.services.ManagerMarca;
import com.llapresa.services.ManagerProducto;

@Controller
public class BusquedaProductoController implements BeanFactoryAware {

	private ManagerProducto managerProducto;
	private ManagerMarca managerMarca;
	private ManagerCategoria managerCategoria;

	/*
	 * @RequestMapping(value = "/busqueda.htm") public ModelAndView
	 * handleRequest(
	 * 
	 * @RequestParam("idcategoria") Integer idcategoria, HttpServletRequest req,
	 * HttpServletResponse rep) throws Exception {
	 * 
	 * Map<String, Object> datos; datos = new HashMap<String, Object>();
	 * 
	 * Collection<Producto> productos; Collection<Marca> marcas;
	 * Collection<Categoria> categorias;
	 * 
	 * productos = managerProducto.getProductosBusqueda();
	 * 
	 * datos.put("total", prod)
	 * 
	 * return new ModelAndView(); }
	 */

	@Override
	public void setBeanFactory(BeanFactory bf) throws BeansException {
		managerProducto = bf.getBean(ManagerProducto.class);
		managerMarca = bf.getBean(ManagerMarca.class);
		managerCategoria = bf.getBean(ManagerCategoria.class);
	}

}
