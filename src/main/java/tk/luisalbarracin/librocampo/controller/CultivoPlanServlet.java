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
import tk.luisalbarracin.librocampo.dao.CultivoDao;
import tk.luisalbarracin.librocampo.dao.CultivoDaoMySQL;
import tk.luisalbarracin.librocampo.dao.CultivoPlanDao;
import tk.luisalbarracin.librocampo.dao.CultivoPlanDaoMySQL;
import tk.luisalbarracin.librocampo.dao.PlanFertilizanteDao;
import tk.luisalbarracin.librocampo.dao.PlanFertilizanteDaoMySQL;
import tk.luisalbarracin.librocampo.modelo.Cultivo;
import tk.luisalbarracin.librocampo.modelo.CultivoPlan;
import tk.luisalbarracin.librocampo.modelo.PlanFertilizante;

/**
 * Servlet implementation class CultivoPlan
 */
@WebServlet("/cultivoplan/*")
public class CultivoPlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CultivoPlanDao cultivoPlanDao;
	private PlanFertilizanteDao planFertilizanteDao;
	private CultivoDao cultivoDao;

    /**
     * Default constructor. 
     */
    public CultivoPlanServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.cultivoPlanDao = new CultivoPlanDaoMySQL();
		this.planFertilizanteDao = new PlanFertilizanteDaoMySQL();
		this.cultivoDao = new CultivoDaoMySQL();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getRequestURI();

		try {
			switch (action) {
			case "/libroCampo/cultivoplan/new":
				showNewForm(request, response);
				break;
			case "/libroCampo/cultivoplan/insert":
				insertarCultivoPlan(request, response);
				break;
			case "/libroCampo/cultivoplan/delete":
				eliminarCultivoPlan(request, response);
				break;
			case "/libroCampo/cultivoplan/edit":
				showEditForm(request, response);
				break;
			case "/libroCampo/cultivoplan/update":
				actualizarCultivoPlan(request, response);
				break;
			default:
				listCultivoPlanes(request, response);
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
		
		CultivoPlan cultivoPlan = this.cultivoPlanDao.buscar(id);
		List<PlanFertilizante> planFertilizantes = this.planFertilizanteDao.selectAll();
		List<Cultivo> cultivos = this.cultivoDao.selectAll();
		
		request.setAttribute("cultivoplan", cultivoPlan);
		request.setAttribute("planesfertilizantes", planFertilizantes);
		request.setAttribute("cultivos", cultivos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cultivoplan.jsp");
		dispatcher.forward(request, response);
	}

	private void listCultivoPlanes(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		List<CultivoPlan> cultivoPlanes = this.cultivoPlanDao.selectAll();
		List<PlanFertilizante> planFertilizantes = this.planFertilizanteDao.selectAll();
		List<Cultivo> cultivos = this.cultivoDao.selectAll();
		
		request.setAttribute("cultivoplanes", cultivoPlanes);
		request.setAttribute("planesfertilizantes", planFertilizantes);
		request.setAttribute("cultivos", cultivos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cultivoplanlist.jsp");
		dispatcher.forward(request, response);
	}

	private void actualizarCultivoPlan(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		Integer cultivoId = Integer.parseInt(request.getParameter("cultivo"));
		Integer planFertilizanteId = Integer.parseInt(request.getParameter("planFertilizante"));
		Integer mes = Integer.parseInt(request.getParameter("mes"));
		Integer anio = Integer.parseInt(request.getParameter("anio"));
		
		Cultivo cultivo = this.cultivoDao.buscar(cultivoId);
		PlanFertilizante planFertilizante = this.planFertilizanteDao.buscar(planFertilizanteId);
		
		
		CultivoPlan cultivoPlan = new CultivoPlan(id, cultivo, planFertilizante, mes, anio);
		this.cultivoPlanDao.actualizar(cultivoPlan);
		
		response.sendRedirect("list");
	}

	private void eliminarCultivoPlan(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		this.cultivoPlanDao.eliminar(id);
		
		response.sendRedirect("list");
	}

	private void insertarCultivoPlan(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		
		Integer cultivoId = Integer.parseInt(request.getParameter("cultivo"));
		Integer planFertilizanteId = Integer.parseInt(request.getParameter("planFertilizante"));
		Integer mes = Integer.parseInt(request.getParameter("mes"));
		Integer anio = Integer.parseInt(request.getParameter("anio"));
		
		Cultivo cultivo = this.cultivoDao.buscar(cultivoId);
		PlanFertilizante planFertilizante = this.planFertilizanteDao.buscar(planFertilizanteId);
		
		
		CultivoPlan cultivoPlan = new CultivoPlan(cultivo, planFertilizante, mes, anio);
		
		this.cultivoPlanDao.insertar(cultivoPlan);
		
		response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cultivoplan.jsp");
		dispatcher.forward(request, response);
	}
	

}
