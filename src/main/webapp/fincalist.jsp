<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fincas</title>
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
				<li><a href="<%=request.getContextPath()%>/finca/list"
					class="nav-link">Fincas</a></li>
			</ul>

		</nav>
	</header>

	<main>
		<div class="row">
			<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

			<div class="container">
				<h3 class="text-center">Listado de Fincas</h3>
				<hr>
				<div class="container text-left">

					<a href="<%=request.getContextPath()%>/finca/new" class="btn btn-success">Agregar
						Nueva Finca</a>
				</div>
				<br>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nombre</th>
							<th>Area</th>
							<th>Asociacion</th>
							<th>Area Palma</th>
							<th>Plano</th>
							<th>Vereda</th>
							<th>Fecha Inicio Siembra</th>
						</tr>
					</thead>
					<tbody>
						<!--   for (Todo todo: todos) {  -->
						<c:forEach var="finca" items="${fincas}">

							<tr>
								<td><c:out value="${finca.id}" /></td>
								<td><c:out value="${finca.nombre}" /></td>
								<td><c:out value="${finca.area}" /></td>
								<td><c:out value="${finca.asociacion.id}" /></td>
								<td><c:out value="${finca.areaPalma} " /></td>
								<td><c:out value="${finca.plano} " /></td>
								<td><c:out value="${finca.vereda} " /></td>
								<td><c:out value="${finca.inicioSiembra} " /></td>
								
								<td><a href="<%=request.getContextPath()%>/finca/edit?id=<c:out value='${finca.id}' />">Editar</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="<%=request.getContextPath()%>/finca/delete?id=<c:out value='${finca.id}' />">Eliminar</a></td>
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