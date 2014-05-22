package com.llapresa.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.llapresa.model.Usuario;
import com.llapresa.services.ManagerAuth;

@Controller
@RequestMapping(value = "/login.htm")
public class LoginController {

	@Autowired
	private ManagerAuth manager;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) {

		Usuario usuario = new Usuario();

		return new ModelAndView("login", "usuario", usuario);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmint(Usuario usuario, BindingResult result,
			HttpServletRequest req) {

		Usuario resultado = manager.validar(usuario.getLogin(),
				usuario.getPassword());

		if (resultado != null) {
			List<GrantedAuthority> perm = new ArrayList<GrantedAuthority>();
			perm.add(new SimpleGrantedAuthority(resultado.getRol().getRol()));

			Authentication auth = new UsernamePasswordAuthenticationToken(
					resultado.getLogin(), resultado.getPassword(), perm);

			SecurityContextHolder.getContext().setAuthentication(auth);

			return "redirect:/catalogo.htm?idmarca=-1&idcategoria=-1&idcategoria=-1&pos=1&total=0";// "redirect:/adminaltaempleado.htm";
		} else
			return "login";

	}
}