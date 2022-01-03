<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calidad</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
</head>
<body>

	<nav class="navbar navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src="/docs/5.1/assets/brand/bootstrap-logo.svg" alt="" width="30"
				height="24" class="d-inline-block align-text-top"> Libro del Campo
			</a>
		</div>
	</nav>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/calidad/list"
					class="nav-link">Calidad</a></li>
			</ul>

		</nav>
	</header>

	<main>
		<div class="row">
			<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

			<div class="container">
				<h3 class="text-center">Listado de Calidad</h3>
				<hr>
				<div class="container text-left">

					<a href="<%=request.getContextPath()%>/calidad/new"
						class="btn btn-success">Agregar Nueva Calidad</a>
				</div>
				<br>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>Cultivo</th>
							<th>Fecha</th>
							<th>% Verdes</th>
							<th>% Sobremaduros</th>
							<th>% Pedunculo Largo</th>
							<th>% Podridos</th>
							<th>Impurezas</th>
							<th>Lugar de Expedicion</th>
						</tr>
					</thead>
					<tbody>
						<!--   for (Todo todo: todos) {  -->
						<c:forEach var="calidad" items="${calidades}">

							<tr>
								<td><c:out value="${calidad.id}" /></td>
								<td><c:out value="${calidad.cultivo}" /></td>
								<td><c:out value="${calidad.fecha}" /></td>
								<td><c:out value="${calidad.porcentajeVerdes}" /></td>
								<td><c:out value="${calidad.porcentajeSobremaduros}" /></td>
								<td><c:out value="${calidad.porcentajePedunculoLargo} " /></td>
								<td><c:out value="${calidad.porcentajePodridos} " /></td>
								<td><c:out value="${calidad.impurezas} " /></td>
								<td><a
									href="<%=request.getContextPath()%>/calidad/edit?id=<c:out value='${calidad.id}' />">Editar</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="<%=request.getContextPath()%>/calidad/delete?id=<c:out value='${calidad.id}' />">Eliminar</a></td>
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