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

import com.llapresa.model.Marca;
import com.llapresa.model.viewform.MarcaViewForm;
import com.llapresa.services.ManagerMarca;

@Controller
@RequestMapping(value = "/altamarca.htm")
public class MarcaAltaController {

	@Autowired
	private ManagerMarca managerMarca;

	public ManagerMarca getManagerMarca() {
		return managerMarca;
	}

	public void setManagerMarca(ManagerMarca managerMarca) {
		this.managerMarca = managerMarca;
	}

	@RequestMapping(method = RequestMethod.GET)
	protected String formBackingObject(
			@RequestParam("idmarca") Integer idmarca, ModelMap model,
			HttpServletRequest req) throws Exception {

		MarcaViewForm marca = new MarcaViewForm();

		if (idmarca != -1) {
			Marca m = managerMarca.getMarca(idmarca, false);
			marca.setIdmarca(m.getIdmarca());
			marca.setNombre(m.getNombre());
		}

		model.addAttribute("idmarca", idmarca);

		model.addAttribute("marca", marca);

		Collection<Marca> marcas = managerMarca.getAllMarcas();
		model.addAttribute("marcas", marcas);

		return "altamarca";
	}

	@RequestMapping(method = RequestMethod.POST)
	protected String onSubmit(
			@Valid @ModelAttribute("marca") MarcaViewForm marca,
			BindingResult result, HttpServletRequest req) {

		if (result.hasErrors()) {

			Collection<Marca> marcas = managerMarca.getAllMarcas();
			req.setAttribute("marcas", marcas);

			req.setAttribute("idmarca", marca.getIdmarca());

			return "altamarca";
		}

		// OJO CATEGORIA TIENE UN SET DE PRODUCTOS COMPROBAR SI SE UTILIZA
		Marca m = new Marca();
		m.setNombre(marca.getNombre());

		if (marca.getIdmarca() == -1)
			managerMarca.addMarca(m);
		else {
			m.setIdmarca(marca.getIdmarca());
			managerMarca.updateMarca(m);
		}

		return "redirect:/altamarca.htm?idmarca=-1";
	}
}
