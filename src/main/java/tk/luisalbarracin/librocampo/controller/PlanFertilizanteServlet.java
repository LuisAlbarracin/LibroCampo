package tk.luisalbarracin.librocampo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tk.luisalbarracin.librocampo.dao.FertilizanteDao;
import tk.luisalbarracin.librocampo.dao.FertilizanteDaoMySQL;
import tk.luisalbarracin.librocampo.dao.PlanFertilizanteDao;
import tk.luisalbarracin.librocampo.dao.PlanFertilizanteDaoMySQL;
import tk.luisalbarracin.librocampo.modelo.Fertilizante;
import tk.luisalbarracin.librocampo.modelo.PlanFertilizante;

/**
 * Servlet implementation class PlanFertilizanteServlet
 */
@WebServlet("/planfertilizante/*")
public class PlanFertilizanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlanFertilizanteDao planFertilizanteDao;
	private FertilizanteDao fertilizanteDao;

    /**
     * Default constructor. 
     */
    public PlanFertilizanteServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.planFertilizanteDao = new PlanFertilizanteDaoMySQL();
		this.fertilizanteDao = new FertilizanteDaoMySQL();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getRequestURI();

		try {
			switch (action) {
			case "/libroCampo/planfertilizante/new":
				showNewForm(request, response);
				break;
			case "/libroCampo/planfertilizante/insert":
				insertarPlanFertilizante(request, response);
				break;
			case "/libroCampo/planfertilizante/delete":
				eliminarPlanFertilizante(request, response);
				break;
			case "/libroCampo/planfertilizante/edit":
				showEditForm(request, response);
				break;
			case "/libroCampo/planfertilizante/update":
				actualizarPlanFertilizante(request, response);
				break;
			default:
				listPlanesFertilizantes(request, response);
				break;

			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		PlanFertilizante planFertilizanteActual = this.planFertilizanteDao.buscar(id);
		List<Fertilizante> fertilizantes = this.fertilizanteDao.selectAll();
		
		
		request.setAttribute("planfertilizante", planFertilizanteActual);
		request.setAttribute("fertilizantes", fertilizantes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/planfertilizante.jsp");
		dispatcher.forward(request, response);
	}

	private void listPlanesFertilizantes(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		List<PlanFertilizante> planesFertilizantes = this.planFertilizanteDao.selectAll();
		request.setAttribute("planesfertilizantes", planesFertilizantes);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/planfertilizantelist.jsp");
		dispatcher.forward(request, response);
	}

	private void actualizarPlanFertilizante(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nobmre");
		Integer fertilizanteId = Integer.parseInt(request.getParameter("fertilizante"));
		Integer numeroBultos = Integer.parseInt(request.getParameter("descripcion"));
		Float gramosPalma = Float.parseFloat(request.getParameter("gramosPalma"));
		
		Fertilizante fertilizante = this.fertilizanteDao.buscar(fertilizanteId);
		
		PlanFertilizante planFertilizante = new PlanFertilizante(id, nombre, fertilizante, numeroBultos, gramosPalma);
		this.planFertilizanteDao.actualizar(planFertilizante);
		
		response.sendRedirect("list");
	}

	private void eliminarPlanFertilizante(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		this.planFertilizanteDao.eliminar(id);
		
		response.sendRedirect("list");
	}

	private void insertarPlanFertilizante(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		
		String nombre = request.getParameter("nombre");
		Integer fertilizanteId = Integer.parseInt(request.getParameter("fertilizante"));
		Integer numeroBultos = Integer.parseInt(request.getParameter("descripcion"));
		Float gramosPalma = Float.parseFloat(request.getParameter("gramosPalma"));
		
		Fertilizante fertilizante = this.fertilizanteDao.buscar(fertilizanteId);
		
		PlanFertilizante planFertilizante = new PlanFertilizante(nombre, fertilizante, numeroBultos, gramosPalma);
		this.planFertilizanteDao.insertar(planFertilizante);
		
		response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Fertilizante> fertilizantes = this.fertilizanteDao.selectAll();
		request.setAttribute("fertilizante", fertilizantes);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/planfertilizante.jsp");
		dispatcher.forward(request, response);
	}


}
