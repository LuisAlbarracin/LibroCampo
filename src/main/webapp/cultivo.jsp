<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cultivo</title>
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
				<li><a href="<%=request.getContextPath()%>/cultivo/list"
					class="nav-link">Cultivos</a></li>
			</ul>
		</nav>
	</header>

	<main>

		<div class="container col-md-5">
			<div class="card">
				<div class="card-body">

					<c:if test="${cultivo != null}">
						<form action="<%=request.getContextPath()%>/cultivo/update"
							method="post">
					</c:if>
					<c:if test="${cultivo == null}">
						<form action="<%=request.getContextPath()%>/cultivo/insert"
							method="post">
					</c:if>

					<caption>
						<h2>
							<c:if test="${cultivo != null}">
                                    Editar Cultivo
                                </c:if>
							<c:if test="${cultivo == null}">
                                    Agregar Nuevo Cultivo
                                </c:if>
						</h2>
					</caption>

					<c:if test="${cultivo != null}">
						<input type="hidden" name="id"
							value="<c:out value='${cultivo.id}' />" />
					</c:if>

					<fieldset class="form-group">
						<label>Nombre</label> <input type="text"
							value="<c:out value='${cultivo.nombre}' />" class="form-control"
							name="nombre">
					</fieldset>

					<fieldset class="form-group">
						<label>Finca</label>
						<select class="form-select" name="finca">
							<c:forEach var="finca" items="${fincas}">
								<option value="<c:out value='${finca.nombre}' />"
									<c:if test="${finca.id == cultivo.finca.id}">
									selected
								</c:if>><c:out
										value='${finca.id}' /></option>
							</c:forEach>
						</select>
					</fieldset>

					<fieldset class="form-group">
						<label>Número</label> <input type="number"
							value="<c:out value='${cultivo.numero}' />" class="form-control"
							name="numero">
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