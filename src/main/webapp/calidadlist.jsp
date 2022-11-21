<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calidad</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>


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
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>