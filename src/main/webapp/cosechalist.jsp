<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cosecha</title>
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
				<h3 class="text-center">Listado de Cosechas</h3>
				<hr>
				<div class="container text-left">

					<a href="<%=request.getContextPath()%>/cosecha/new"
						class="btn btn-success">Agregar Nueva Cosecha</a>
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
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>