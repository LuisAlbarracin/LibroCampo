<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Finca</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Features</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Pricing</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown link
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
      </ul>
    </div>
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

					<fieldset class=form-group">
						<label>Asociación</label>
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
					</fieldset>
					

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
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
	
</body>
</html>