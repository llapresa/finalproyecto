<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Marcas</title>
</head>
<body>
	
	<h3>Listado de Marcas</h3>
	
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${marcas}" var="marca">
			<tr>
				<td>${marca.idmarca}</td>
				<td>${marca.nombre}</td>
			</tr>
		</c:forEach>	
		</tbody>
	</table>
	
</body>
</html>