<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Libro Campo</title>
</head>
<body>

	<h1>BIENVENIDO A LIBRO CAMPO</h1>

	<main>
		<section>
			<h2>Iniciar Session</h2>
			<form action="propietario/login" method="post">
				<div>
					<label>Email</label> <input type="email" name="email"
						placeholder="example@dominio" required>
				</div>

				<div>
					<label>Contraseña</label> <input type="password" name="contraseña"
						required>
				</div>

				<input type="submit" name="login" value="Iniciar Session">

			</form>
		</section>

		<section>
			<h2>Registrar Usuario</h2>
			<form action="propietario/registrar" method="post">
				<div>
					<label>Nombre</label>
					<input type="text" name="nombre" placeholder="Digite su Nombre" required>
				</div>
				
				<div>
					<label>Apellido</label>
					<input type="text" name="apellido" placeholder="Digite su Apellido" required>
				</div>
				
				<div>
					<label>Número de Cedula</label>
					<input type="text" name="noCedula" placeholder="Digite su número de Cedula" required>
				</div>
				
				<div>
					<label>Email</label>
					<input type="email" name="email" placeholder="Digite su Email" required>
				</div>
				
				<div>
					<label>Contraseña</label>
					<input type="password" name="contrasenia" required>
				</div>
				
				<input type="submit" name="registrar" value="Registrarme">
			
			</form>
			
		</section>
	</main>

</body>
</html>