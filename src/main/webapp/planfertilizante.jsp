<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Plan Fertilizante</title>
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
				<a href="#" class="navbar-brand"> Gestión de Plan Fertilizante </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Plan Fertilizante</a></li>
			</ul>
		</nav>
	</header>

	<main>

		<div class="container col-md-5">
			<div class="card">
				<div class="card-body">

					<c:if test="${planfertilizante != null}">
						<form action="<%=request.getContextPath()%>/planfertilizante/update" method="post">
					</c:if>
					<c:if test="${planfertilizante == null}">
						<form action="<%=request.getContextPath()%>/planfertilizante/insert" method="post">
					</c:if>

					<caption>
						<h2>
							<c:if test="${planfertilizante != null}">
                                    Editar Plan Fertilizante
                                </c:if>
							<c:if test="${planfertilizante == null}">
                                    Agregar Nuevo Plan Fertilizante
                                </c:if>
						</h2>
					</caption>

					<c:if test="${planfertilizante != null}">
						<input type="hidden" name="id"
							value="<c:out value='${planfertilizante.id}' />" />
					</c:if>

					<select class="form-select" name="fertilizante"
						aria-label="Default select example">
						<c:forEach var="fertilizante" items="${fertilizantes}">
							<option value="<c:out value='${fertilizante.id}' />"
								<c:if test="${fertilizante.id == planfertilizante.fertilizante.id}">
									selected
								</c:if>><c:out
									value='${fertilizante.id}' /></option>
						</c:forEach>
					</select>

					<fieldset class="form-group">
						<label>Número de Bultos</label> <input type="text"
							value="<c:out value='${planfertilizante.numeroBultos}' />"
							class="form-control" name="numeroBultos" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Gramos Por Palma</label> <input type="number"
							value="<c:out value='${planfertilizante.gramosPalma}' />"
							class="form-control" name="gramosPalma">
					</fieldset>





					<button type="submit" class="btn btn-success m-3">Guardar</button>
					</form>
				</div>
			</div>
		</div>
	</main>
</body>
</html>