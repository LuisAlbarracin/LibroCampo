<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
</head>
<body>

	<div class="container ">
		<section class="row">
			<div class="flex m-auto">
				<h2>Iniciar Session</h2>
				<form action="propietario/login" method="post">
					<div class="form-group">
						<label>Email</label> <input type="email" class="form-control"
							name="email" placeholder="example@dominio" required>
					</div>

					<div class="form-group">
						<label>Contraseña</label> <input type="password"
							class="form-control" name="contrasenia" required>
					</div>

					<input type="submit" name="login" value="Iniciar Session"
						class="btn btn-primary m-3">

				</form>
			</div>
		</section>
	</div>


	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>