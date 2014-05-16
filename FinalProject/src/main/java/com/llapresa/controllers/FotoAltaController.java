package com.llapresa.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.llapresa.model.Foto;
import com.llapresa.model.Producto;
import com.llapresa.model.viewform.FotoViewForm;
import com.llapresa.services.ManagerFoto;
import com.llapresa.services.ManagerProducto;

@Controller
@RequestMapping(value = "/altafoto.htm")
public class FotoAltaController {

	static String path;

	@Autowired
	private ManagerFoto managerFoto;

	@Autowired
	private ManagerProducto managerProducto;

	public ManagerFoto getManagerFoto() {
		return managerFoto;
	}

	public void setManagerFoto(ManagerFoto managerFoto) {
		this.managerFoto = managerFoto;
	}

	public ManagerProducto getManagerProducto() {
		return managerProducto;
	}

	public void setManagerProducto(ManagerProducto managerProducto) {
		this.managerProducto = managerProducto;
	}

	@RequestMapping(method = RequestMethod.GET)
	protected FotoViewForm formBackingObject(HttpServletRequest req)
			throws Exception {

		path = req.getSession().getServletContext().getRealPath("/");

		FotoViewForm foto = new FotoViewForm();
		req.setAttribute("foto", foto);

		Collection<Producto> productos = managerProducto.getAllProductos();
		Map<Integer, String> datos = new HashMap<Integer, String>();

		for (Producto producto : productos) {
			datos.put(producto.getIdproducto(), producto.getTitulo());
		}
		req.setAttribute("productos", datos);

		return foto;
	}

	@RequestMapping(method = RequestMethod.POST)
	protected String onSubmit(FotoViewForm foto, BindingResult result,
			HttpServletRequest req) {

		Date d = new Date();
		String ruta = d.getTime() + ".png";

		File dir = new File("/uploads");
		if (!dir.exists())
			dir.mkdir();

		System.out.println(dir.getAbsolutePath());

		File f = new File(dir, ruta);

		try {
			FileOutputStream fos = new FileOutputStream(f);
			byte[] datos = new byte[(int) foto.getUrl().getSize()];
			foto.getUrl().getInputStream().read(datos);
			fos.write(datos);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result.hasErrors()) {

			req.setAttribute("foto", foto);

			return "altafoto";

		}

		Producto pro = new Producto();
		pro.setIdproducto(foto.getProducto());

		Foto fot = new Foto();
		fot.setUrl("C:/uploads/" + ruta);
		fot.setProducto(pro);

		managerFoto.addFoto(fot);

		return "redirect:/fotos.htm";
	}
}
