package tk.luisalbarracin.librocampo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tk.luisalbarracin.librocampo.dao.CalidadDao;
import tk.luisalbarracin.librocampo.dao.CalidadDaoMySQL;
import tk.luisalbarracin.librocampo.dao.CultivoDao;
import tk.luisalbarracin.librocampo.dao.CultivoDaoMySQL;
import tk.luisalbarracin.librocampo.modelo.Calidad;
import tk.luisalbarracin.librocampo.modelo.Cultivo;

/**
 * Servlet implementation class CalidadServlet
 */
@WebServlet("/calidad/*")
public class CalidadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CalidadDao calidadDao;
	private CultivoDao cultivoDao;

    /**
     * Default constructor. 
     */
    public CalidadServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.calidadDao = new CalidadDaoMySQL();
		this.cultivoDao = new CultivoDaoMySQL();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getRequestURI();

		try {
			switch (action) {
			case "/libroCampo/calidad/new":
				showNewForm(request, response);
				break;
			case "/libroCampo/calidad/insert":
				insertarCalidad(request, response);
				break;
			case "/libroCampo/calidad/delete":
				eliminarCalidad(request, response);
				break;
			case "/libroCampo/calidad/edit":
				showEditForm(request, response);
				break;
			case "/libroCampo/calidad/update":
				actualizarCalidad(request, response);
				break;
			default:
				listCalidades(request, response);
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
		
		Calidad calidadActual = this.calidadDao.buscar(id);
		List<Cultivo> cultivos = this.cultivoDao.selectByFinca(1);
		
		request.setAttribute("calidad", calidadActual);
		request.setAttribute("cultivos", cultivos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/calidad.jsp");
		dispatcher.forward(request, response);
	}

	private void listCalidades(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		List<Calidad> calidades = this.calidadDao.selectAll();
		request.setAttribute("calidades", calidades);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/calidadlist.jsp");
		dispatcher.forward(request, response);
	}

	private void actualizarCalidad(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		Integer cultivoId = Integer.parseInt(request.getParameter("cultivo"));
		LocalDate fechaS = LocalDate.parse(request.getParameter("fecha"));
		Float porcentajeVerdes = Float.parseFloat(request.getParameter("porcentajeVerdes"));
		Float porcentajeSobremaduros = Float.parseFloat(request.getParameter("porcentajeSobremaduros"));
		Float porcentajePedunculoLargo = Float.parseFloat(request.getParameter("porcentajePedunculoLargo"));
		Float porcentajePodridos = Float.parseFloat(request.getParameter("porcentajePodridos"));
		Boolean impurezas = Boolean.parseBoolean(request.getParameter("impurezas"));
		
		Cultivo cultivo = this.cultivoDao.buscar(cultivoId);
		
		Calidad calidad = new Calidad(id, cultivo, fechaS, porcentajeVerdes, porcentajeSobremaduros, porcentajePedunculoLargo, porcentajePodridos, impurezas);
		
		this.calidadDao.actualizar(calidad);
		
		response.sendRedirect("list");
	}

	private void eliminarCalidad(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		this.calidadDao.eliminar(id);
		
		response.sendRedirect("list");
	}

	private void insertarCalidad(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		
		Integer cultivoId = Integer.parseInt(request.getParameter("cultivo"));
		LocalDate fechaS = LocalDate.parse(request.getParameter("fecha"));
		Float porcentajeVerdes = Float.parseFloat(request.getParameter("porcentajeVerdes"));
		Float porcentajeSobremaduros = Float.parseFloat(request.getParameter("porcentajeSobremaduros"));
		Float porcentajePedunculoLargo = Float.parseFloat(request.getParameter("porcentajePedunculoLargo"));
		Float porcentajePodridos = Float.parseFloat(request.getParameter("porcentajePodridos"));
		Boolean impurezas = Boolean.parseBoolean(request.getParameter("impurezas"));
		Cultivo cultivo = this.cultivoDao.buscar(cultivoId);
		
		Calidad calidad = new Calidad(cultivo, fechaS, porcentajeVerdes, porcentajeSobremaduros, porcentajePedunculoLargo, porcentajePodridos, impurezas);
		
		this.calidadDao.insertar(calidad);
		
		response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Cultivo> cultivos = this.cultivoDao.selectByFinca(1);
		request.setAttribute("cultivos", cultivos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/calidad.jsp");
		dispatcher.forward(request, response);
	}


}
