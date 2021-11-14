<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cosecha</title>
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
				<a href="#" class="navbar-brand"> Gestión de Cosechas </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Cosechas</a></li>
			</ul>

		</nav>
	</header>

	<main>
		<div class="row">
			<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

			<div class="container">
				<h3 class="text-center">Listado de Cosecha</h3>
				<hr>
				<div class="container text-left">

					<a href="<%=request.getContextPath()%>/cosecha/new"
						class="btn btn-success">Agregar Nuevo Cosecha</a>
				</div>
				<br>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>Cultivo</th>
							<th>Fecha</th>
							<th>Número Racimos</th>
							<th>Peso Total</th>
							<th>Precio Venta</th>
						</tr>
					</thead>
					<tbody>
						<!--   for (Todo todo: todos) {  -->
						<c:forEach var="cosecha" items="${cosechas}">

							<tr>
								<td><c:out value="${cosecha.id}" /></td>
								<td><c:out value="${cosecha.cultivo.numero}" /></td>
								<td><c:out value="${cosecha.fecha}" /></td>
								<td><c:out value="${cosecha.numeroRacimos}" /></td>
								<td><c:out value="${cosecha.pesoTotal} " /></td>
								<td><c:out value="${cosecha.precioVenta} " /></td>

								<td><a
									href="<%=request.getContextPath()%>/cosecha/edit?id=<c:out value='${cosecha.id}' />">Editar</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="<%=request.getContextPath()%>/cosecha/delete?id=<c:out value='${cosecha.id}' />">Eliminar</a></td>
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