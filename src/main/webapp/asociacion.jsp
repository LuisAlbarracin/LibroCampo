<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Asociación</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand"> Gestión de Asociacion </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Asociacion</a></li>
			</ul>
		</nav>
	</header>

	<main>

		<div class="container col-md-5">
			<div class="card">
				<div class="card-body">

					<c:if test="${asociacion != null}">
						<form action="asociacion/update" method="post">
					</c:if>
					<c:if test="${asociacion == null}">
						<form action="asociacion/insert" method="post">
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

					<button type="submit" class="btn btn-success m-3">Guardar</button>
					</form>
				</div>
			</div>
		</div>
	</main>
</body>
</html>