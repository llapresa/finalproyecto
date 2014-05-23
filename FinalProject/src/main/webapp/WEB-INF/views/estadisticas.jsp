<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="tags.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Estadisticas</title>
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
	      <a class="navbar-brand" href="catalogo.htm?idmarca=-1&idcategoria=-1&idcategoria=-1&pos=1&total=0">Fleetmove</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      	  <c:if test="${pageContext.request.userPrincipal.name!=null}">
      		<ul class="nav navbar-nav">
	      		<li><a href="estadisticas.htm">Estadisticas</a></li>
	      	</ul>
          </c:if>
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
						<a href='<c:url value="j_spring_security_logout" />'>Usuario ${pageContext.request.userPrincipal.name} Log Out</a>
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
				<div class="alert alert-warning alert-dismissable">
					<fmt:parseNumber var="i" type="number" value="${media}" />
					<p>El precio medio de los procutos es <fmt:formatNumber type="currency" value="${i}"/></p>
				</div>
				<div class="alert alert-warning alert-dismissable">
					<p>El producto mas caro es ${caro[0]} y su precio es de <fmt:formatNumber type="currency" value="${caro[1]}"/></p>
				</div>
				<div class="alert alert-warning alert-dismissable">
					<p>El producto mas barato es ${barato[0]} y su precio es de <fmt:formatNumber type="currency" value="${barato[1]}"/></p>
				</div>
			</div>
			
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