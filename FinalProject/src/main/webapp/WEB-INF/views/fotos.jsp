<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fotos</title>
</head>
<body>
	
	<h3>Listado de Fotos</h3>
	
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>URL</th>
				<th>Foto</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${fotos}" var="foto">
			<tr>
				<td>${foto.idfoto}</td>
				<td>${foto.url}</td>
				<td><img src="<c:url value="/resources/bar.jpg" />" /></td>
				<!--td><img src="<c:url value="${foto.url}"/>" /></td-->
			</tr>
		</c:forEach>	
		</tbody>
	</table>

</body>
</html>