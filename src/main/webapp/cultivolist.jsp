<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cultivos</title>
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
				<li><a href="<%=request.getContextPath()%>/cultivo/list"
					class="nav-link">Cultivos</a></li>
			</ul>

		</nav>
	</header>

	<main>
		<div class="row">
			<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

			<div class="container">
				<h3 class="text-center">Listado de Cultivos</h3>
				<hr>
				<div class="container text-left">

					<a href="<%=request.getContextPath()%>/cultivo/new" class="btn btn-success">Agregar
						Nuevo Cultivo</a>
				</div>
				<br>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>Finca</th>
							<th>Número Cultivo</th>
						</tr>
					</thead>
					<tbody>
						<!--   for (Todo todo: todos) {  -->
						<c:forEach var="cultivo" items="${cultivos}">

							<tr>
								<td><c:out value="${cultivo.id}" /></td>
								<td><c:out value="${cultivo.finca.nombre}" /></td>
								<td><c:out value="${cultivo.numero}" /></td>
								
								<td><a href="<%=request.getContextPath()%>/cultivo/edit?id=<c:out value='${cultivo.id}' />">Editar</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="<%=request.getContextPath()%>/cultivo/delete?id=<c:out value='${cultivo.id}' />">Eliminar</a></td>
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