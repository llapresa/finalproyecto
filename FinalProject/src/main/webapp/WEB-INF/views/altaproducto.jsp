<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="tags.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Producto</title>
</head>
<body>

	<form:form method="post" commandName="producto">
		<div>
			<form:label path="titulo">Titulo:</form:label>
            <form:input path="titulo"/>
            <form:errors path="titulo"/>
		</div>
		<div>
			<form:label path="descripcion">Descripcion:</form:label>
            <form:input path="descripcion"/>
            <form:errors path="descripcion"/>
		</div>
		<div>
			<form:label path="precio">Precio:</form:label>
            <form:input path="precio"/>
            <form:errors path="precio"/>
		</div>
		<div>
			<form:label path="estado">Estado:</form:label>
          	<form:select path="estado">
          		<form:option value="Nuevo">Nuevo</form:option>
          		<form:option value="En Perfecto Estado">En Perfecto Estado</form:option>
          		<form:option value="Usado">Usuado</form:option>
          	</form:select>
          	<form:errors path="estado"/>
		</div>
		<div>
			<form:label path="categoria">Categoria:</form:label>
          	<form:select path="categoria">
          		<form:options items="${categorias}" />
          	</form:select>
          	<form:errors path="categoria"/>
		</div>
		<div>
			<form:label path="marcas">Marca:</form:label>
          	<form:select path="marcas"  multiple="true">
          		<form:options items="${marcas}" />
          	</form:select>
          	<form:errors path="marcas"/>
		</div>
		<div>
			<input type="submit" value="Crear" >
		</div>
	</form:form>

</body>
</html>