<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Propietario</title>
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
				<a href="#" class="navbar-brand"> Gestión de Propietarios </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Propietarios</a></li>
			</ul>
		</nav>
	</header>

	<main>

		<div class="container col-md-5">
			<div class="card">
				<div class="card-body">

					<c:if test="${propietario != null}">
						<form action="propietario/update" method="post">
					</c:if>
					<c:if test="${propietario == null}">
						<form action="propietario/insert" method="post">
					</c:if>

					<caption>
						<h2>
							<c:if test="${propíetario != null}">
                                    Editar Propietario
                                </c:if>
							<c:if test="${propietario == null}">
                                    Agregar Nuevo Propietario
                                </c:if>
						</h2>
					</caption>

					<c:if test="${propietario != null}">
						<input type="hidden" name="id"
							value="<c:out value='${propietario.id}' />" />
					</c:if>

					<fieldset class="form-group">
						<label>Nombre de Propietario</label> <input type="text"
							value="<c:out value='${propietario.nombre}' />"
							class="form-control" name="nombre" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Apellido del Propietario</label> <input type="text"
							value="<c:out value='${propietario.apellido}' />"
							class="form-control" name="apellido">
					</fieldset>

					<fieldset class="form-group">
						<label>Número de Cedula del Propietario</label> <input type="text"
							value="<c:out value='${propietario.noCedula}' />"
							class="form-control" name="noCedula">
					</fieldset>

					<fieldset class="form-group">
						<label>Telefono del Propietario</label> <input type="tel"
							value="<c:out value='${propietario.telefono}' />"
							class="form-control" name="telefono">
					</fieldset>

					<fieldset class="form-group">
						<label>Expedicion de Cedula del Propietario</label> <input
							type="text"
							value="<c:out value='${propietario.expedicionCedula}' />"
							class="form-control" name="expedicionCedula">
					</fieldset>
					


					<button type="submit" class="btn btn-success m-3">Guardar</button>
					</form>
				</div>
			</div>
		</div>
	</main>
</body>
</html>