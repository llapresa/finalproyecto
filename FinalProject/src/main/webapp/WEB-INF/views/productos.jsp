<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Productos</title>
</head>
<body>

	<h3>Listado de Productos</h3>
	
	<table>
		<thead>
			<tr>
				<th>Titulo</th>
				<th>Descripcion</th>
				<th>Estado</th>
				<th>Precio</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${productos}" var="producto">
			<tr>
				<td>${producto.titulo}</td>
				<td>${producto.descripcion}</td>
				<td>${producto.estado}</td>
				<td>${producto.precio}</td>
			</tr>
		</c:forEach>	
		</tbody>
	</table>

</body>
</html>