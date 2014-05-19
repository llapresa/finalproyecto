<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="tags.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Producto</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
</head>
<body>

	<nav class="navbar navbar-inverse" role="navigation">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#">Fleetmove</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
	          <ul class="dropdown-menu">
	            <li><a href="#">Action</a></li>
	            <li><a href="#">Another action</a></li>
	            <li><a href="#">Something else here</a></li>
	            <li class="divider"></li>
	            <li><a href="#">Separated link</a></li>
	            <li class="divider"></li>
	            <li><a href="#">One more separated link</a></li>
	          </ul>
	        </li>
	      </ul>
	      <form:form class="navbar-form navbar-left" role="search">
	        <div class="form-group">
	          <input type="text" class="form-control" placeholder="Introduce tu busqueda">
	        </div>
	        <button type="submit" class="btn btn-default">Buscar</button>
	      </form:form>
	      <ul class="nav navbar-nav navbar-right">
	        <li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">Mantenimiento<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li>
						<a href="altacategoria.htm">Categorias</a>
					</li>
					<li>
						<a href="altamarca.htm">Marcas</a>
					</li>
					<li class="divider"></li>
					<li>
						<a href="altaproducto.htm">Productos</a>
					</li>
					<li>
						<a href="altafoto.htm">Fotos</a>
					</li>
				</ul>
			</li>
			<li>
				<a href="#">Log In</a>
			</li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
	
	<div class="container">
		<div class="row row-offcanvas row-offcanvas-right">
			<div class="col-xs-12 col-sm-9">
				<div class="table-responsive">
					<table class="table table-bordered">
		                <thead>
		                    <tr class="success">
		                    	<th>Id</th>
		                        <th>Titulo</th>
		                        <th>Descripcion</th>
		                        <th>Estado</th>
		                        <th>Precio</th>
		                        <th>Fecha</th>
		                    </tr>
		                </thead>
		                <tbody>
		                <c:forEach items="${productos}" var="p">
		                    <tr>
		                    	<td>${p.idproducto}</td>
		                    	<td>${p.titulo}</td>
		                    	<td>${p.descripcion}</td>
		                    	<td>${p.estado}</td>
		                    	<td>${p.precio}</td>
		                    	<td>${p.fechaalta}</td>
		                    </tr>
		                </c:forEach>
		                </tbody>
		            </table>
				</div>
			</div>
			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
	          <h3>Vehiculos</h3>
	          <div class="list-group">
	          <c:forEach items="${marcas}" var="marca">
	          	<a href="catalogo.htm?idmarca=${marca.idmarca}&idcategoria=-1" class="list-group-item">${marca.nombre}</a>
	          </c:forEach>
	          </div>
	        </div><!--/span-->
	        
	        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
	          <h3>Categorias</h3>
	          <div class="list-group">
	          <c:forEach items="${categorias}" var="categoria">
	          	<a href="catalogo.htm?idmarca=-1&idcategoria=${categoria.idcategoria}" class="list-group-item">${categoria.nombre}</a>
	          </c:forEach>
	          </div>
	        </div><!--/span-->
		</div>
	</div>
	
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
	
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>