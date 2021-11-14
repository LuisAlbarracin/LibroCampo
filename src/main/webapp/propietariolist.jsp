<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Propietarios</title>
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
				<li><a href="<%=request.getContextPath()%>/propietario/list"
					class="nav-link">Propietarios</a></li>
			</ul>

		</nav>
	</header>

	<main>
		<div class="row">
			<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

			<div class="container">
				<h3 class="text-center">Listado de Propietarios</h3>
				<hr>
				<div class="container text-left">

					<a href="<%=request.getContextPath()%>/propietario/new" class="btn btn-success">Agregar
						Nuevo Propietario</a>
				</div>
				<br>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nombre</th>
							<th>Apellido</th>
							<th>Email</th>
							<th>Contraseña</th>
							<th>Telefono</th>
							<th>Número Cedula</th>
							<th>Lugar de Expedicion</th>
						</tr>
					</thead>
					<tbody>
						<!--   for (Todo todo: todos) {  -->
						<c:forEach var="propietario" items="${propietarios}">

							<tr>
								<td><c:out value="${propietario.id}" /></td>
								<td><c:out value="${propietario.nombre}" /></td>
								<td><c:out value="${propietario.apellido}" /></td>
								<td><c:out value="${propietario.email}" /></td>
								<td><c:out value="${propietario.contrasenia}" /></td>
								<td><c:out value="${propietario.telefono}" /></td>
								<td><c:out value="${propietario.noCedula}" /></td>
								<td><c:out value="${propietario.expedicionCedula} " /></td>
								<td><a href="<%=request.getContextPath()%>/propietario/edit?id=<c:out value='${propietario.id}' />">Editar</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="<%=request.getContextPath()%>/propietario/delete?id=<c:out value='${propietario.id}' />">Eliminar</a></td>
							</tr>
						</c:forEach>
						<!-- } -->
					</tbody>

				</table>
			</div>
		</div>

	</main>
</body>
</html>