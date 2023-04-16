<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Propietarios</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
	<header>
		<%@ include file = "partials/menu.jsp" %>
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
							<th>Telefono</th>
							<th>Número Cedula</th>
							<th>Lugar de Expedicion</th>
							<th></th>
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
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>