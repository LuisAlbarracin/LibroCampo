<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Plan Fertilizante</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>

	<header>
		<%@ include file = "partials/menu.jsp" %>
	</header>

	<main>

		<div class="container col-md-5">
			<div class="card">
				<div class="card-body">

					<c:if test="${planfertilizante != null}">
						<form
							action="<%=request.getContextPath()%>/planfertilizante/update"
							method="post">
					</c:if>
					<c:if test="${planfertilizante == null}">
						<form
							action="<%=request.getContextPath()%>/planfertilizante/insert"
							method="post">
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

					<fieldset class="form-group">
						<label>Nombre</label> <input type="text"
							value="<c:out value='${planfertilizante.nombre}' />"
							class="form-control" name="nombre" required="required">
					</fieldset>

					<fieldset class=form-group>
					<label>Fertilizante</label>
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
					</fieldset>

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

					<div class="d-flex justify-content-end">
						<button type="submit" class="btn btn-success m-3">Guardar</button>
					</div>

					</form>
				</div>
			</div>
		</div>
	</main>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>