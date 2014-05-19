<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fleetmove - Piezas de segunda mano</title>
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
	      <form class="navbar-form navbar-left" role="search">
	        <div class="form-group">
	          <input type="text" class="form-control" placeholder="Introduce tu busqueda">
	        </div>
	        <button type="submit" class="btn btn-default">Buscar</button>
	      </form>
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
						<a href="altaproducto.htm?idproducto=-1">Productos</a>
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
          <div class="jumbotron">
            <h1>Fleetmove</h1>
            <p>Vendemos todo tipo de respuestos nuevos, seminuevos y usados para tu vehiculo. Sino encuentras lo que necesitas en el catalogo no dudes en ponerte en contacto con nosotros. </p>
          </div>
          
          <div class="row">
	        <c:forEach items="${productos}" var="producto">
	        
	        <div class="col-sm-4 col-lg-4 col-md-4">
                <div class="thumbnail">
                    <img data-src="holder.js/300x200" class="img-responsive" alt="300x200" src="<c:url value="/resources/bar.jpg" />" style="width: 300px; height: 200px;">
                    <div class="caption">
                        <h4 class="pull-right"><fmt:formatNumber type="currency" value="${producto.precio}"/></h4>
                        <h4>
                        	<c:set var="titulo" value="${producto.titulo}"/>
                        	<c:choose>
                        		<c:when test="${fn:length(titulo) gt 40}">
                        			<a href="producto.htm?idproducto=${producto.idproducto}">${fn:substring(titulo, 0, 37)}...</a>
                        		</c:when>
                        		<c:otherwise>
        							<a href="producto.htm?idproducto=${producto.idproducto}">${producto.titulo}</a>
        						</c:otherwise>
                        	</c:choose>
                        	
                        </h4>
                    </div>
                </div>
            </div>
	        </c:forEach>
          </div>
          
          
        </div><!--/span-->

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
        
      </div><!--/row-->

      <hr>

      <footer>
        <p>© Fleetmove 2014</p>
      </footer>

    </div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>