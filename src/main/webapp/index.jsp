<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Libro Campo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous" />
</head>
<body>

	<nav class="navbar navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src="/docs/5.1/assets/brand/bootstrap-logo.svg" alt="" width="30"
				height="24" class="d-inline-block align-text-top"> Libro del Campo
			</a>
		</div>
	</nav>
	<h1 class="text-center">BIENVENIDO A LIBRO CAMPO</h1>

	<main class="container">
		<section class="row">
			<h2>Iniciar Session</h2>
			<form action="propietario/login" method="post">
				<div class="form-group">
					<label>Email</label> <input type="email" class="form-control" name="email"
						placeholder="example@dominio" required>
				</div>

				<div class="form-group">
					<label>Contrase�a</label> <input type="password" class="form-control" name="contrase�a"
						required>
				</div>

				<input type="submit" name="login" value="Iniciar Session" class="btn btn-primary m-3">

			</form>
		</section>

		<section>
			<h2>Registrar Usuario</h2>
			<form action="propietario/registrar" method="post">
				<div class="form-group">
					<label>Nombre</label>
					<input type="text" name="nombre" class="form-control" placeholder="Digite su Nombre" required>
				</div>
				
				<div class="form-group">
					<label>Apellido</label>
					<input type="text" name="apellido" class="form-control" placeholder="Digite su Apellido" required>
				</div>
				
				<div class="form-group">
					<label>N�mero de Cedula</label>
					<input type="text" name="noCedula" class="form-control" placeholder="Digite su n�mero de Cedula" required>
				</div>
				
				<div class="form-group">
					<label>Email</label>
					<input type="email" name="email" class="form-control" placeholder="Digite su Email" required>
				</div>
				
				<div class="form-group">
					<label>Contrase�a</label>
					<input type="password" name="contrasenia" class="form-control" required>
				</div>
				
				<div>
					<input type="submit" name="registrar" value="Registrarme" class="btn btn-success m-3">				
				</div>
			
			</form>
			
		</section>
	</main>

</body>
</html>