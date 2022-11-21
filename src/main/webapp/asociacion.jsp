<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Asociación</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>


	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/asociacion/list"
					class="nav-link">Asociación</a></li>
			</ul>
		</nav>
	</header>

	<main>

		<div class="container col-md-5">
			<div class="card">
				<div class="card-body">

					<c:if test="${asociacion != null}">
						<form action="<%=request.getContextPath()%>/asociacion/update"
							method="post">
					</c:if>
					<c:if test="${asociacion == null}">
						<form action="<%=request.getContextPath()%>/asociacion/insert"
							method="post">
					</c:if>

					<caption>
						<h2>
							<c:if test="${asociacion != null}">
                                    Editar Asociacion
                                </c:if>
							<c:if test="${asociacion == null}">
                                    Agregar Nuevo Asociacion
                                </c:if>
						</h2>
					</caption>

					<c:if test="${asociacion != null}">
						<input type="hidden" name="id"
							value="<c:out value='${asociacion.id}' />" />
					</c:if>

					<fieldset class="form-group">
						<label>Nombre de la Asociación</label> <input type="text"
							value="<c:out value='${asociacion.nombre}' />"
							class="form-control" name="nombre" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Descripción de la Asociación</label> <input type="text"
							value="<c:out value='${asociacion.descripcion}' />"
							class="form-control" name="descripcion">
					</fieldset>

					<div class="d-flex justify-content-end">
						<button type="submit" class="btn btn-success m-3">Guardar</button>
					</div>
					
					</form>
				</div>
			</div>
		</div>
	</main>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>