package com.llapresa.controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	protected String formBackingObject(
			@RequestParam("idcategoria") Integer idcategoria, ModelMap model,
			HttpServletRequest req) throws Exception {

		CategoriaViewForm categoria = new CategoriaViewForm();

		if (idcategoria != -1) {
			Categoria c = managerCategoria.getCategoria(idcategoria, false);
			categoria.setIdcategoria(c.getIdcategoria());
			categoria.setNombre(c.getNombre());
		}

		model.addAttribute("idcategoria", idcategoria);

		model.addAttribute("categoria", categoria);

		Collection<Categoria> categorias = managerCategoria.getAllCategorias();
		model.addAttribute("categorias", categorias);

		return "altacategoria";
	}

	@RequestMapping(method = RequestMethod.POST)
	protected String onSubmit(
			@Valid @ModelAttribute("categoria") CategoriaViewForm categoria,
			BindingResult result, HttpServletRequest req) {

		if (result.hasErrors()) {

			Collection<Categoria> categorias = managerCategoria
					.getAllCategorias();
			req.setAttribute("categorias", categorias);

			req.setAttribute("idcategoria", categoria.getIdcategoria());

			return "altacategoria";
		}
		// OJO CATEGORIA TIENE UN SET DE PRODUCTOS COMPROBAR SI SE UTILIZA
		Categoria cat = new Categoria();
		cat.setNombre(categoria.getNombre());

		if (categoria.getIdcategoria() == -1)
			managerCategoria.addCategoria(cat);
		else {
			cat.setIdcategoria(categoria.getIdcategoria());
			managerCategoria.updateCategoria(cat);
		}

		return "redirect:/altacategoria.htm?idcategoria=-1";
	}
}
