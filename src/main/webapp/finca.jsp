<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Finca</title>
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
					class="nav-link">Fincas</a></li>
			</ul>
		</nav>
	</header>

	<main>

		<div class="container col-md-5">
			<div class="card">
				<div class="card-body">

					<c:if test="${finca != null}">
						<form action="<%=request.getContextPath()%>/finca/update"
							method="post">
					</c:if>
					<c:if test="${finca == null}">
						<form action="<%=request.getContextPath()%>/finca/insert"
							method="post">
					</c:if>

					<caption>
						<h2>
							<c:if test="${finca != null}">
                                    Editar Finca
                                </c:if>
							<c:if test="${finca == null}">
                                    Agregar Nuevo Finca
                                </c:if>
						</h2>
					</caption>

					<c:if test="${finca != null}">
						<input type="hidden" name="id"
							value="<c:out value='${finca.id}' />" />
					</c:if>

					<fieldset class="form-group">
						<label>Nombre de Finca</label> <input type="text"
							value="<c:out value='${finca.nombre}' />" class="form-control"
							name="nombre" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Area de la Finca</label> <input type="text"
							value="<c:out value='${finca.area}' />" class="form-control"
							name="area">
					</fieldset>

					<select class="form-select" name="asociacion"
						aria-label="Default select example">
						<c:forEach var="asociacion" items="${asociaciones}">
							<option value="<c:out value='${asociacion.id}' />"
								<c:if test="${asociacion.id == finca.asociacion.id}">
									selected
								</c:if>><c:out
									value='${asociacion.id}' /></option>
						</c:forEach>
					</select>

					<fieldset class="form-group">
						<label>Vereda</label> <input type="text"
							value="<c:out value='${finca.vereda}' />" class="form-control"
							name="vereda">
					</fieldset>

					<fieldset class="form-group">
						<label>Area de cultivo de palma</label> <input type="number"
							value="<c:out value='${finca.areaPalma}' />" class="form-control"
							name="areaPalma">
					</fieldset>

					<fieldset class="form-group">
						<label>Plano de la finca</label> <input type="file"
							value="<c:out value='${finca.plano}' />" class="form-control"
							name="plano">
					</fieldset>

					<fieldset class="form-group">
						<label>Fecha Inicio Siembra</label> <input type="date"
							value="<c:out value='${finca.inicioSiembra}' />"
							class="form-control" name="plano">
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