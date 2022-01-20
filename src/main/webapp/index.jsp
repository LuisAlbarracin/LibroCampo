<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Libro Campo</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>

	<nav class="navbar navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Libro Campo</a>
		</div>
	</nav>
	<h1 class="text-center">BIENVENIDO A LIBRO CAMPO</h1>

	<main class="container">

		<section>
			<h2>Registrar Usuario</h2>
			<form action="propietario/registrar" method="post">
				<div class="form-group">
					<label>Nombre</label> <input type="text" name="nombre"
						class="form-control" placeholder="Digite su Nombre" required>
				</div>

				<div class="form-group">
					<label>Apellido</label> <input type="text" name="apellido"
						class="form-control" placeholder="Digite su Apellido" required>
				</div>

				<div class="form-group">
					<label>Número de Cedula</label> <input type="text" name="noCedula"
						class="form-control" placeholder="Digite su número de Cedula"
						required>
				</div>

				<div class="form-group">
					<label>Email</label> <input type="email" name="email"
						class="form-control" placeholder="Digite su Email" required>
				</div>

				<div class="form-group">
					<label>Contraseña</label> <input type="password" name="contrasenia"
						class="form-control" required>
				</div>

				<div class="form-group">
					<label>Confirmar contraseña</label> <input type="password" name="contraseniaC"
						class="form-control" required>
				</div>

				<div>
					<input type="submit" name="registrar" value="Registrarme"
						class="btn btn-primary m-3"><a href="/libroCampo/login.jsp">¿ Ya tiene cuenta ?</a>
				</div>

			</form>

		</section>
	</main>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
	
</body>
</html>