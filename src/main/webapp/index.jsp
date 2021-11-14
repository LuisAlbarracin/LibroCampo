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

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand"> LIBRO CAMPO </a>
			</div>
		</nav>
	</header>
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
					<label>Contraseña</label> <input type="password" class="form-control" name="contraseña"
						required>
				</div>

				<input type="submit" name="login" value="Iniciar Session" class="btn btn-success m-3">

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
					<label>Número de Cedula</label>
					<input type="text" name="noCedula" class="form-control" placeholder="Digite su número de Cedula" required>
				</div>
				
				<div class="form-group">
					<label>Email</label>
					<input type="email" name="email" class="form-control" placeholder="Digite su Email" required>
				</div>
				
				<div class="form-group">
					<label>Contraseña</label>
					<input type="password" name="contrasenia" class="form-control" required>
				</div>
				
				<input type="submit" name="registrar" value="Registrarme" class="btn btn-success m-3">
			
			</form>
			
		</section>
	</main>

</body>
</html>