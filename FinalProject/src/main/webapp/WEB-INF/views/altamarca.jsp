<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="tags.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Marca</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/jasny-bootstrap.min.css" />"
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
	      <a class="navbar-brand" href="catalogo.htm?idmarca=-1&idcategoria=-1&idcategoria=-1&pos=1&total=0">Fleetmove</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	      	<li class="active"><a href="#">Información</a></li>
	      </ul>
	      <form class="navbar-form navbar-left" role="search">
	        <div class="form-group">
	          <input type="text" class="form-control" placeholder="Introduce tu busqueda">
	        </div>
	        <button type="submit" class="btn btn-default">Buscar</button>
	      </form>
	      <ul class="nav navbar-nav navbar-right">
	      	<c:choose>
	      		<c:when test="${pageContext.request.userPrincipal.name!=null}">
			        <li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Mantenimiento<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li>
								<a href="altacategoria.htm?idcategoria=-1">Categorias</a>
							</li>
							<li>
								<a href="altamarca.htm?idmarca=-1">Marcas</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="altaproducto.htm?idproducto=-1">Productos</a>
							</li>
							<li>
								<a href="altafoto.htm?idfoto=-1">Fotos</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="redirect:/catalogo.htm?idmarca=-1&idcategoria=-1&idcategoria=-1&pos=1&total=0">Usuario ${pageContext.request.userPrincipal.name} Log Out</a>
					</li>
				</c:when>
				<c:otherwise>
					<li>
						<a href="login.htm">Log In</a>
					</li>
				</c:otherwise>
			</c:choose>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
	
	<div class="container">
		<div class="row row-offcanvas row-offcanvas-right">
			<div class="col-xs-12 col-sm-9">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover">
		                <thead>
		                    <tr class="success">
		                    	<th>Id</th>
		                        <th>Nombre</th>
		                    </tr>
		                </thead>
		                <tbody data-link="row" class="rowlink">
		                <c:forEach items="${marcas}" var="marca">
		                    <tr onclick="document.location = 'altamarca.htm?idmarca=${marca.idmarca}';" data-toggle="modal">
		                    	<td>${marca.idmarca}</td>
		                    	<td>${marca.nombre}</td>
		                    </tr>
		                </c:forEach>
		                </tbody>
		            </table>
				</div>
			</div>
			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
	          	<form:form class="well" method="post" commandName="marca" role="form">
					<div>
						<form:label class="control-label" path="nombre">Nombre:</form:label>
			            <form:input class="form-control" path="nombre"/>
			            <form:errors class="label label-danger" path="nombre"/>
					</div>
					<div>
						<c:choose>
							<c:when test="${idmarca==-1}">
								<input type="submit" value="Crear" class="btn btn-success">
							</c:when>
							<c:otherwise>
				        		<input type="submit" value="Modificar" class="btn btn-success">
				        		<a href="altamarca.htm?idmarca=-1" class="btn btn-success">Nuevo</a>
				        	</c:otherwise>
						</c:choose>
					</div>
				</form:form>
	        </div><!--/span-->
		</div>
		
		<hr>
	
	    <footer>
	      <p>© Fleetmove 2014</p>
	    </footer>
		
	</div>
	
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/jasny-bootstrap.min.js" />"></script>
</body>
</html>