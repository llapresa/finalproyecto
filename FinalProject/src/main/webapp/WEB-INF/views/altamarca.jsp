<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="tags.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Marca</title>
</head>
<body>

	<form:form method="post" commandName="marca">
		
		<div>
			<form:label path="nombre">Nombre:</form:label>
			<form:input path="nombre"/>
			<form:errors path="nombre"/>
		</div>
		<br>
		<input type="submit" value="Crear">
		
	</form:form>
	
</body>
</html>