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
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand"> Gestión de Cultivos </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Cultivos</a></li>
			</ul>
		</nav>
	</header>

	<main>

		<div class="container col-md-5">
			<div class="card">
				<div class="card-body">

					<c:if test="${cultivo != null}">
						<form action="cultivo/update" method="post">
					</c:if>
					<c:if test="${cultivo == null}">
						<form action="cultivo/insert" method="post">
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

					<select class="form-select" name="finca" aria-label="Default select example">
						<c:forEach var="finca" items="${fincas}">
							<option value="<c:out value='${asociacion.id}' />"
								<c:if test="${finca.id == cultivo.finca.id}">
									selected
								</c:if>><c:out
									value='${finca.id}' /></option>
						</c:forEach>
					</select>

					<fieldset class="form-group">
						<label>Número identificador cultivo</label> <input type="number"
							value="<c:out value='${finca.numero}' />"
							class="form-control" name="numero">
					</fieldset>


					<button type="submit" class="btn btn-success m-3">Guardar</button>
					</form>
				</div>
			</div>
		</div>
	</main>
</body>
</html>