<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	      <a class="navbar-brand" href="catalogo.htm?idmarca=-1&idcategoria=-1&idcategoria=-1&pos=1&total=0">Fleetmove</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      	  <c:if test="${pageContext.request.userPrincipal.name!=null}">
      		<ul class="nav navbar-nav">
	      		<li><a href="#">Información</a></li>
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
          <div class="jumbotron">
            <h1>Fleetmove</h1>
            <p>Vendemos todo tipo de respuestos nuevos, seminuevos y usados para tu vehiculo. Sino encuentras lo que necesitas en el catalogo no dudes en ponerte en contacto con nosotros. </p>
          </div>
          
          <div class="row">
	        <c:forEach items="${productos}" var="producto">
	        <div class="col-sm-4 col-lg-4 col-md-4">
                <div class="thumbnail">
                	<c:forEach var="f" items="${producto.fotos}" end="0">
					      <img data-src="holder.js/300x200" class="img-responsive" alt="300x200" src="<c:url value="${f.url}" />" style="width: 300px; height: 200px;">
					</c:forEach>
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
          <div class="text-center">
	          <ul class="pagination">
		          <c:choose>
		          	<c:when test="${pos eq 1}">
		          		<li class="disabled"><a href="catalogo.htm?idmarca=${idmarca}&idcategoria=${idcategoria}&pos=${pos - 1}&total=${total}">«</a></li>
		          	</c:when>
		          	<c:otherwise>
		          		<li><a href="catalogo.htm?idmarca=${idmarca}&idcategoria=${idcategoria}&pos=${pos - 1}&total=${total}">«</a></li>
		          	</c:otherwise>
		          </c:choose>
		          
		          <c:forEach var="i" begin="1" end="${total}">
		          	<c:choose>
		          		<c:when test="${pos eq i}">
		          			<li class="active"><a href="catalogo.htm?idmarca=${idmarca}&idcategoria=${idcategoria}&pos=${i}&total=${total}">${i}<span class="sr-only">(current)</span></a></li>
		          		</c:when>
		          		<c:otherwise>
		          			<li><a href="catalogo.htm?idmarca=${idmarca}&idcategoria=${idcategoria}&pos=${i}&total=${total}">${i}<span class="sr-only">(current)</span></a></li>
		          		</c:otherwise>
		          	</c:choose>
				  </c:forEach>
				  
	          	  <c:choose>
		          	<c:when test="${pos eq total}">
		          		<li class="disabled"><a href="catalogo.htm?idmarca=${idmarca}&idcategoria=${idcategoria}&pos=${pos + 1}&total=${total}">»</a></li>
		          	</c:when>
		          	<c:otherwise>
		          		<li><a href="catalogo.htm?idmarca=${idmarca}&idcategoria=${idcategoria}&pos=${pos + 1}&total=${total}">»</a></li>
		          	</c:otherwise>
		          </c:choose>
	   		  </ul>
	   	  </div>
          
        </div><!--/span-->

        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
          <h3>Vehiculos</h3>
          <div class="list-group">
          <c:forEach items="${marcas}" var="marca">
          	<a href="catalogo.htm?idmarca=${marca.idmarca}&idcategoria=-1&pos=${1}&total=${total}" class="list-group-item">${marca.nombre}</a>
          </c:forEach>
          </div>
        </div><!--/span-->
        
        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
          <h3>Categorias</h3>
          <div class="list-group">
          <c:forEach items="${categorias}" var="categoria">
          	<a href="catalogo.htm?idmarca=-1&idcategoria=${categoria.idcategoria}&pos=${1}&total=${total}" class="list-group-item">${categoria.nombre}</a>
          </c:forEach>
          </div>
        </div><!--/span-->
        
      </div><!--/row-->
      
      <hr>

      <footer>
        <p>© Fleetmove 2014</p>
        total = ${total}<p>
        pos = ${pos}
      </footer>

    </div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>