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
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand"> Gestión de Calidad </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Calidad</a></li>
			</ul>
		</nav>
	</header>

	<main>

		<div class="container col-md-5">
			<div class="card">
				<div class="card-body">

					<c:if test="${calidad != null}">
						<form action="calidad/update" method="post">
					</c:if>
					<c:if test="${calidad == null}">
						<form action="calidad/insert" method="post">
					</c:if>

					<caption>
						<h2>
							<c:if test="${calidad != null}">
                                    Editar Calidad
                                </c:if>
							<c:if test="${calidad == null}">
                                    Agregar Nuevo Calidad
                                </c:if>
						</h2>
					</caption>

					<c:if test="${calidad != null}">
						<input type="hidden" name="id"
							value="<c:out value='${calidad.id}' />" />
					</c:if>

					<fieldset class="form-group">
						<label>Fecha</label> <input type="date"
							value="<c:out value='${calidad.fecha}' />" class="form-control"
							name="fecha" required="required">
					</fieldset>



					<select class="form-select" name="cultivo"
						aria-label="Default select example">
						<c:forEach var="cultivo" items="${cultivos}">
							<option value="<c:out value='${cultivo.id}' />"
								<c:if test="${cultivo.id == calidad.cultivo.id}">
									selected
								</c:if>><c:out
									value='${cultivo.id}' /></option>
						</c:forEach>
					</select>

					<fieldset class="form-group">
						<label>Porcentaje Verdes</label> <input type="number"
							value="<c:out value='${calidad.porcentajeVerdes}' />"
							class="form-control" name="porcentajeVerdes">
					</fieldset>

					<fieldset class="form-group">
						<label>Porcentaje Sobremaduros</label> <input type="number"
							value="<c:out value='${calidad.porcentajesobremaduros}' />"
							class="form-control" name="porcentajeSobremaduros">
					</fieldset>

					<fieldset class="form-group">
						<label>Porcentaje Pedunculo Largo</label> <input type="number"
							value="<c:out value='${calidad.porcentajePedunculoLargo}' />"
							class="form-control" name="porcentajePedunculoLargo">
					</fieldset>

					<fieldset class="form-group">
						<label>Porcentaje Podridos</label> <input type="number"
							value="<c:out value='${calidad.porcentajePodridos}' />"
							class="form-control" name="porcentajePodridos">
					</fieldset>


					<select class="form-select" name="cultivo"
						aria-label="Default select example">
						<option value="1"
							<c:if test="${1 == calidad.impurezas}">
									selected
								</c:if>>1</option>
						<option value="0"
							<c:if test="${0 == calidad.impurezas}">
									selected
								</c:if>>0</option>
					</select>


					<button type="submit" class="btn btn-success m-3">Guardar</button>
					</form>
				</div>
			</div>
		</div>
	</main>
</body>
</html>