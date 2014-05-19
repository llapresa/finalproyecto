package com.llapresa.controllers;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.llapresa.model.Categoria;
import com.llapresa.model.Marca;
import com.llapresa.model.Producto;
import com.llapresa.model.viewform.ProductoViewForm;
import com.llapresa.services.ManagerCategoria;
import com.llapresa.services.ManagerMarca;
import com.llapresa.services.ManagerProducto;

@Controller
@RequestMapping(value = "/altaproducto.htm")
public class ProductoAltaController {

	@Autowired
	private ManagerProducto managerProducto;

	@Autowired
	private ManagerCategoria managerCategoria;

	@Autowired
	private ManagerMarca managerMarca;

	public ManagerProducto getManagerProducto() {
		return managerProducto;
	}

	public void setManagerProducto(ManagerProducto managerProducto) {
		this.managerProducto = managerProducto;
	}

	public ManagerCategoria getManagerCategoria() {
		return managerCategoria;
	}

	public void setManagerCategoria(ManagerCategoria managerCategoria) {
		this.managerCategoria = managerCategoria;
	}

	public ManagerMarca getManagerMarca() {
		return managerMarca;
	}

	public void setManagerMarca(ManagerMarca managerMarca) {
		this.managerMarca = managerMarca;
	}

	@RequestMapping(method = RequestMethod.GET)
	protected ProductoViewForm formBackingObject(HttpServletRequest req)
			throws Exception {

		ProductoViewForm producto = new ProductoViewForm();
		req.setAttribute("producto", producto);

		Collection<Producto> productos = managerProducto.getAllProductos();
		req.setAttribute("productos", productos);

		Collection<Marca> marcas = managerMarca.getAllMarcas();
		req.setAttribute("marcas", marcas);

		Collection<Categoria> categorias = managerCategoria.getAllCategorias();
		req.setAttribute("categorias", categorias);

		return producto;
	}

	@RequestMapping(method = RequestMethod.POST)
	protected String onSubmit(ProductoViewForm producto, BindingResult result,
			HttpServletRequest req) {

		if (result.hasErrors())
			return "altaproducto";

		Categoria categoria = new Categoria();
		categoria.setIdcategoria(producto.getCategoria());

		Producto pro = new Producto();
		pro.setTitulo(producto.getTitulo());
		pro.setDescripcion(producto.getDescripcion());
		pro.setEstado(producto.getEstado());
		pro.setPrecio(producto.getPrecio());
		pro.setCategoria(categoria);

		Set<Marca> marcas = new HashSet<Marca>();
		Marca marca;

		for (Integer idmarca : producto.getMarcas()) {
			marca = new Marca();
			marca.setIdmarca(idmarca);
			marcas.add(marca);
		}

		pro.setMarcas(marcas);

		managerProducto.addProducto(pro);

		return "redirect:/productos.htm";
	}
}
