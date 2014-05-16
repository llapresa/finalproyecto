package com.llapresa.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.llapresa.model.Categoria;
import com.llapresa.model.viewform.CategoriaViewForm;
import com.llapresa.services.ManagerCategoria;

@Controller
@RequestMapping(value = "/altacategoria.htm")
public class CategoriaAltaController {

	@Autowired
	private ManagerCategoria managerCategoria;

	public ManagerCategoria getManagerCategoria() {
		return managerCategoria;
	}

	public void setManagerCategoria(ManagerCategoria managerCategoria) {
		this.managerCategoria = managerCategoria;
	}

	@RequestMapping(method = RequestMethod.GET)
	protected CategoriaViewForm formBackingObject(HttpServletRequest req)
			throws Exception {
		CategoriaViewForm categoria = new CategoriaViewForm();

		req.setAttribute("categoria", categoria);

		return categoria;
	}

	@RequestMapping(method = RequestMethod.POST)
	protected String onSubmit(CategoriaViewForm categoria, BindingResult result) {

		if (result.hasErrors())
			return "altacategoria";
		// OJO CATEGORIA TIENE UN SET DE PRODUCTOS COMPROBAR SI SE UTILIZA
		Categoria cat = new Categoria();
		cat.setNombre(categoria.getNombre());
		managerCategoria.addCategoria(cat);

		return "redirect:/categorias.htm";
	}
}
