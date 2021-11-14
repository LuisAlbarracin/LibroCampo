<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cultivo Plan</title>
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
				<a href="#" class="navbar-brand"> Gestión de Cultivo Plan </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Cultivo Plan</a></li>
			</ul>
		</nav>
	</header>

	<main>

		<div class="container col-md-5">
			<div class="card">
				<div class="card-body">

					<c:if test="${cultivoplan != null}">
						<form action="<%=request.getContextPath()%>/cultivoplan/update" method="post">
					</c:if>
					<c:if test="${cultivoplan == null}">
						<form action="<%=request.getContextPath()%>/cultivoplan/insert" method="post">
					</c:if>

					<caption>
						<h2>
							<c:if test="${cultivoplan != null}">
                                    Editar Cultivo Plan
                                </c:if>
							<c:if test="${cultivoplan == null}">
                                    Agregar Nuevo Cultivo Plan
                                </c:if>
						</h2>
					</caption>

					<c:if test="${cultivoplan != null}">
						<input type="hidden" name="id"
							value="<c:out value='${cultivoplan.id}' />" />
					</c:if>


					<select class="form-select" name="cultivo"
						aria-label="Default select example">
						<c:forEach var="cultivo" items="${cultivos}">
							<option value="<c:out value='${cultivo.id}' />"
								<c:if test="${cultivo.id == cultivoplan.cultivo.id}">
									selected
								</c:if>><c:out
									value='${cultivo.id}' /></option>
						</c:forEach>
					</select> <select class="form-select" name="plan"
						aria-label="Default select example">
						<c:forEach var="planfertilizante" items="${planesfertilizantes}">
							<option value="<c:out value='${planfertilizante.id}' />"
								<c:if test="${planfertilizante.id == cultivoplan.planfertilizante.id}">
									selected
								</c:if>><c:out
									value='${planfertilizante.id}' /></option>
						</c:forEach>
					</select> <select class="form-select" name="anio"
						aria-label="Default select example">
						<option value="1990"
							<c:if test="${ 1990 == cultivoplan.anio}">
									selected
								</c:if>>1990</option>
						<option value="1991"
							<c:if test="${ 1991 == cultivoplan.anio}">
									selected
								</c:if>>1991</option>
						<option value="1992"
							<c:if test="${ 1992 == cultivoplan.anio}">
									selected
								</c:if>>1992</option>
						<option value="1993"
							<c:if test="${ 1993 == cultivoplan.anio}">
									selected
								</c:if>>1993</option>
						<option value="1994"
							<c:if test="${ 1994 == cultivoplan.anio}">
									selected
								</c:if>>1994</option>
						<option value="1995"
							<c:if test="${ 1995 == cultivoplan.anio}">
									selected
								</c:if>>1995</option>
						<option value="1996"
							<c:if test="${ 1996 == cultivoplan.anio}">
									selected
								</c:if>>1996</option>
						<option value="1997"
							<c:if test="${ 1997 == cultivoplan.anio}">
									selected
								</c:if>>1997</option>
						<option value="1998"
							<c:if test="${ 1998 == cultivoplan.anio}">
									selected
								</c:if>>1998</option>
						<option value="1999"
							<c:if test="${ 1999 == cultivoplan.anio}">
									selected
								</c:if>>1999</option>
						<option value="2000"
							<c:if test="${ 2000 == cultivoplan.anio}">
									selected
								</c:if>>2000</option>
						<option value="2001"
							<c:if test="${ 2001 == cultivoplan.anio}">
									selected
								</c:if>>2001</option>
						<option value="2002"
							<c:if test="${ 2002 == cultivoplan.anio}">
									selected
								</c:if>>2002</option>
						<option value="2003"
							<c:if test="${ 2003 == cultivoplan.anio}">
									selected
								</c:if>>2003</option>
						<option value="2004"
							<c:if test="${ 2004 == cultivoplan.anio}">
									selected
								</c:if>>2004</option>
						<option value="2005"
							<c:if test="${ 2005 == cultivoplan.anio}">
									selected
								</c:if>>2005</option>
						<option value="2006"
							<c:if test="${ 2006 == cultivoplan.anio}">
									selected
								</c:if>>2006</option>
						<option value="2007"
							<c:if test="${ 2007 == cultivoplan.anio}">
									selected
								</c:if>>2007</option>
						<option value="2008"
							<c:if test="${ 2008 == cultivoplan.anio}">
									selected
								</c:if>>2008</option>
						<option value="2009"
							<c:if test="${ 2009 == cultivoplan.anio}">
									selected
								</c:if>>2009</option>
						<option value="2010"
							<c:if test="${ 2010 == cultivoplan.anio}">
									selected
								</c:if>>2010</option>
						<option value="2011"
							<c:if test="${ 2011 == cultivoplan.anio}">
									selected
								</c:if>>2011</option>
						<option value="2012"
							<c:if test="${ 2012 == cultivoplan.anio}">
									selected
								</c:if>>2012</option>
						<option value="2013"
							<c:if test="${ 2013 == cultivoplan.anio}">
									selected
								</c:if>>2013</option>
						<option value="2014"
							<c:if test="${ 2014 == cultivoplan.anio}">
									selected
								</c:if>>2014</option>
						<option value="2015"
							<c:if test="${ 2015 == cultivoplan.anio}">
									selected
								</c:if>>2015</option>
						<option value="2016"
							<c:if test="${ 2016 == cultivoplan.anio}">
									selected
								</c:if>>2016</option>
						<option value="2017"
							<c:if test="${ 2017 == cultivoplan.anio}">
									selected
								</c:if>>2017</option>
						<option value="2018"
							<c:if test="${ 2018 == cultivoplan.anio}">
									selected
								</c:if>>2018</option>
						<option value="2019"
							<c:if test="${ 2019 == cultivoplan.anio}">
									selected
								</c:if>>2019</option>
						<option value="2020"
							<c:if test="${ 2020 == cultivoplan.anio}">
									selected
								</c:if>>2020</option>
						<option value="2021"
							<c:if test="${ 2021 == cultivoplan.anio}">
									selected
								</c:if>>2021</option>
						<option value="2022"
							<c:if test="${ 2022 == cultivoplan.anio}">
									selected
								</c:if>>2022</option>
						<option value="2023"
							<c:if test="${ 2023 == cultivoplan.anio}">
									selected
								</c:if>>2023</option>
						<option value="2024"
							<c:if test="${ 2024 == cultivoplan.anio}">
									selected
								</c:if>>2024</option>
						<option value="2025"
							<c:if test="${ 2025 == cultivoplan.anio}">
									selected
								</c:if>>2025</option>
					</select> <select class="form-select" name="mes"
						aria-label="Default select example">
						<option value="1"
							<c:if test="${ 1 == cultivoplan.mes}">
									selected
								</c:if>>Enero</option>
						<option value="2"
							<c:if test="${ 2 == cultivoplan.mes}">
									selected
								</c:if>>Febrero</option>
						<option value="3"
							<c:if test="${ 3 == cultivoplan.mes}">
									selected
								</c:if>>Marzo</option>
						<option value="4"
							<c:if test="${ 4 == cultivoplan.mes}">
									selected
								</c:if>>Abril</option>
						<option value="5"
							<c:if test="${ 5 == cultivoplan.mes}">
									selected
								</c:if>>Mayo</option>
						<option value="6"
							<c:if test="${ 6 == cultivoplan.mes}">
									selected
								</c:if>>Junio</option>
						<option value="7"
							<c:if test="${ 7 == cultivoplan.mes}">
									selected
								</c:if>>Julio</option>
						<option value="8"
							<c:if test="${ 8 == cultivoplan.mes}">
									selected
								</c:if>>Agosto</option>
						<option value="9"
							<c:if test="${ 9 == cultivoplan.mes}">
									selected
								</c:if>>Septiembre</option>
						<option value="10"
							<c:if test="${ 10 == cultivoplan.mes}">
									selected
								</c:if>>Octubre</option>
						<option value="11"
							<c:if test="${ 11 == cultivoplan.mes}">
									selected
								</c:if>>Noviembre</option>
						<option value="12"
							<c:if test="${ 12 == cultivoplan.mes}">
									selected
								</c:if>>Diciembre</option>
					</select>



					<button type="submit" class="btn btn-success m-3">Guardar</button>
					</form>
				</div>
			</div>
		</div>
	</main>
</body>
</html>