package com.llapresa.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	protected MarcaViewForm formBackingObject(HttpServletRequest req)
			throws Exception {
		MarcaViewForm marca = new MarcaViewForm();

		req.setAttribute("marca", marca);

		return marca;
	}

	@RequestMapping(method = RequestMethod.POST)
	protected String onSubmit(MarcaViewForm marca, BindingResult result) {

		if (result.hasErrors())
			return "altamarca";
		// OJO MARCA TIENE UN SET DE PRODUCTOS COMPROBAR SI SE UTILIZA
		Marca mar = new Marca();
		mar.setNombre(marca.getNombre());
		managerMarca.addMarca(mar);

		return "redirect:/marcas.htm";
	}
}
