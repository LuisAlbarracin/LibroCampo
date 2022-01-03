<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cosechas</title>
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
				height="24" class="d-inline-block align-text-top"> Libro del
				Campo
			</a>
		</div>
	</nav>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Cosecha</a></li>
			</ul>
		</nav>
	</header>

	<main>

		<div class="container col-md-5">
			<div class="card">
				<div class="card-body">

					<c:if test="${cosecha != null}">
						<form action="<%=request.getContextPath()%>/cosecha/update"
							method="post">
					</c:if>
					<c:if test="${cosecha == null}">
						<form action="<%=request.getContextPath()%>/cosecha/insert"
							method="post">
					</c:if>

					<caption>
						<h2>
							<c:if test="${cosecha != null}">
                                    Editar Cosecha
                                </c:if>
							<c:if test="${cosecha == null}">
                                    Agregar Nuevo Cosecha
                                </c:if>
						</h2>
					</caption>

					<c:if test="${cosecha != null}">
						<input type="hidden" name="id"
							value="<c:out value='${cosecha.id}' />" />
					</c:if>

					<select class="form-select" name="cultivo"
						aria-label="Default select example">
						<c:forEach var="cultivo" items="${cultivos}">
							<option value="<c:out value='${cultivo.id}' />"
								<c:if test="${cultivo.id == cosecha.cultivo.id}">
									selected
								</c:if>><c:out
									value='${cultivo.id}' /></option>
						</c:forEach>
					</select>

					<fieldset class="form-group">
						<label>Fecha</label> <input type="text"
							value="<c:out value='${cosecha.fecha}' />" class="form-control"
							name="fecha">
					</fieldset>

					<fieldset class="form-group">
						<label>Número de Racimos</label> <input type="number"
							value="<c:out value='${cosecha.numeroRacimos}' />"
							class="form-control" name="numeroRacimos">
					</fieldset>

					<fieldset class="form-group">
						<label>Peso Total</label> <input type="number"
							value="<c:out value='${cosecha.pesoTotal}' />"
							class="form-control" name="pesoTotal">
					</fieldset>

					<fieldset class="form-group">
						<label>Precio Venta</label> <input type="number"
							value="<c:out value='${cosecha.precioVenta}' />"
							class="form-control" name="precioVenta">
					</fieldset>

					<div class="d-flex justify-content-end">
						<button type="submit" class="btn btn-success m-3">Guardar</button>
					</div>
					
					</form>
				</div>
			</div>
		</div>
	</main>
</body>
</html>