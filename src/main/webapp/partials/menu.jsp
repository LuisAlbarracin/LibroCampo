<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="<%=request.getContextPath()%>/">Libro Campo</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>">Inicio</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath()%>/finca">Fincas</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="<%=request.getContextPath()%>/cultivo" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Cultivos
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/cosecha">Cosechas</a></li>
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/calidad">Calidad</a></li>
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/fertilizante">Fertilizantes</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>