<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fleetmove</title>
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
          <div class="thumbnail">
               <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
				  <!-- Indicators -->
				  <ol class="carousel-indicators">
				  	<c:forEach items="${producto.fotos}" var="foto" varStatus="loopCount">
				  		<c:choose>
				  			<c:when test="${loopCount.count eq 1}">
				  				<li data-target="#carousel-example-generic" data-slide-to="${loopCount.count-1}" class="active"></li>
				  			</c:when>
				  			<c:otherwise>
				  				<li data-target="#carousel-example-generic" data-slide-to="${loopCount.count-1}"></li>
				  			</c:otherwise>
				  		</c:choose>
				  	</c:forEach>
				  </ol>
				
				  <!-- Wrapper for slides -->
				  <div class="carousel-inner">
				  
				  	<c:forEach items="${producto.fotos}" var="foto" varStatus="loopCount">
				  		<c:choose>
				  			<c:when test="${loopCount.count eq 1}">
				  				<div class="item active">
					      			<img src="<c:url value="${foto.url}" />" alt="...">
					    		</div>	
				  			</c:when>
				  			<c:otherwise>
				  				<div class="item">
					      			<img src="<c:url value="${foto.url}" />" alt="...">
					    		</div>
				  			</c:otherwise>
				  		</c:choose>
				  	</c:forEach>
				  	
				  	<!-- 
				    <div class="item active">
				      <img src="<c:url value="/resources/bar.jpg" />" alt="...">
				    </div>
				    <div class="item">
				    	<img src="<c:url value="/resources/bar.jpg" />" alt="...">
				    </div>
				    <div class="item">
				    	<img src="<c:url value="/resources/bar.jpg" />" alt="...">
				    </div>-->
				  </div>
				
				  <!-- Controls -->
				  <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
				    <span class="glyphicon glyphicon-chevron-left"></span>
				  </a>
				  <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
				    <span class="glyphicon glyphicon-chevron-right"></span>
				  </a>
				</div>
               
               <div class="caption-full">
                   <h4 class="pull-right"><fmt:formatNumber type="currency" value="${producto.precio}"/></h4>
                   <h4><a href="producto.htm?idproducto=${producto.idproducto}">${producto.titulo}</a></h4>
                   <p>${producto.descripcion }
               </div>
           </div>
          
          
        </div><!--/span-->

        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
          <h3>Vehiculos</h3>
          <div class="list-group">
          <c:forEach items="${marcas}" var="marca">
          	<a href="catalogo.htm?idmarca=${marca.idmarca}&idcategoria=-1&pos=1&total=1" class="list-group-item">${marca.nombre}</a>
          </c:forEach>
          </div>
        </div><!--/span-->
        
        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
          <h3>Categorias</h3>
          <div class="list-group">
          <c:forEach items="${categorias}" var="categoria">
          	<a href="catalogo.htm?idmarca=-1&idcategoria=${categoria.idcategoria}&pos=1&total=1" class="list-group-item">${categoria.nombre}</a>
          </c:forEach>
          </div>
        </div><!--/span-->
        
        <hr>
	
	    <footer>
	        <p class="col-xs-3 col-sm-2">© Fleetmove 2014</p>
	        <div class="col-xs-3 col-sm-2">
	        	<a href="https://twitter.com/intent/tweet?screen_name=llapresa&text=Visita%20Prueba.com" class="twitter-mention-button" data-lang="es">Tweet to @llapresa</a>
				<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>
	        </div>
	        <div class="col-xs-3 col-sm-2">
	        	<!-- Inserta esta etiqueta donde quieras que aparezca Botón Compartir. -->
				<div class="g-plus" data-action="share" data-annotation="none" data-height="15"></div>
				
				<!-- Inserta esta etiqueta después de la última etiqueta de compartir. -->
				<script type="text/javascript">
				  window.___gcfg = {lang: 'es'};
				
				  (function() {
				    var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
				    po.src = 'https://apis.google.com/js/platform.js';
				    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
				  })();
				</script>
	        </div>
	        <div class="fb-like col-xs-3 col-sm-2" data-href="https://developers.facebook.com/docs/plugins/" data-layout="button" data-action="like" data-show-faces="true" data-share="true">
	        </div>
	      </footer>
        
      </div><!--/row-->

    </div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<div id="fb-root"></div>
	<script>(function(d, s, id) {
	  var js, fjs = d.getElementsByTagName(s)[0];
	  if (d.getElementById(id)) return;
	  js = d.createElement(s); js.id = id;
	  js.src = "//connect.facebook.net/es_LA/sdk.js#xfbml=1&appId=468934253190546&version=v2.0";
	  fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));</script>
</body>
</html>