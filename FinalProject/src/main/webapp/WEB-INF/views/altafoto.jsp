<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="tags.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Foto</title>
</head>
<body>

	<form:form method="post" commandName="foto" enctype="multipart/form-data">
		<div>
			<form:label path="producto">Producto:</form:label>
          	<form:select path="producto">
          		<form:options items="${productos}" />
          	</form:select>
          	<form:errors path="producto"/>
		</div>
		
			<form:label class="control-label" path="url">Seleccionar Foto:</form:label>
        	<form:input path="url" type="file" />
			<form:errors path="url"/>
		
		
		<input type="submit" value="Introducir">
		
	</form:form>

</body>
</html>