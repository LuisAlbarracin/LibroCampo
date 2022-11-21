<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cosechas</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>


	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/cosecha/list"
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

					<fieldset class="form-group">
						<label>Cultivo</label> <select class="form-select" name="cultivo"
							aria-label="Default select example">
							<c:forEach var="cultivo" items="${cultivos}">
								<option value="<c:out value='${cultivo.id}' />"
									<c:if test="${cultivo.id == cosecha.cultivo.id}">
									selected
								</c:if>><c:out
										value='${cultivo.id}' /></option>
							</c:forEach>
						</select>
					</fieldset>

					<fieldset class="form-group">
						<label>Fecha</label> <input type="date"
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
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>