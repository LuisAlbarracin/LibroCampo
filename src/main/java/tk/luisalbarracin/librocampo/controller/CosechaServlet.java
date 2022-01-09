package tk.luisalbarracin.librocampo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tk.luisalbarracin.librocampo.dao.CosechaDao;
import tk.luisalbarracin.librocampo.dao.CosechaDaoMySQL;
import tk.luisalbarracin.librocampo.dao.CultivoDao;
import tk.luisalbarracin.librocampo.dao.CultivoDaoMySQL;
import tk.luisalbarracin.librocampo.modelo.Cosecha;
import tk.luisalbarracin.librocampo.modelo.Cultivo;

/**
 * Servlet implementation class CosechaServlet
 */
@WebServlet("/cosecha/*")
public class CosechaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CosechaDao cosechaDao;
	private CultivoDao cultivoDao;

	/**
	 * Default constructor.
	 */
	public CosechaServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.cosechaDao = new CosechaDaoMySQL();
		this.cultivoDao = new CultivoDaoMySQL();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getRequestURI();

		try {
			switch (action) {
			case "/libroCampo/cosecha/new":
				showNewForm(request, response);
				break;
			case "/libroCampo/cosecha/insert":
				insertarCosecha(request, response);
				break;
			case "/libroCampo/cosecha/delete":
				eliminarCosecha(request, response);
				break;
			case "/libroCampo/cosecha/edit":
				showEditForm(request, response);
				break;
			case "/libroCampo/cosecha/update":
				actualizarCosecha(request, response);
				break;
			default:
				listCosechas(request, response);
				break;

			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));

		Cosecha cosechaActual = this.cosechaDao.buscar(id);
		List<Cultivo> cultivos = this.cultivoDao.selectByFinca(1);

		request.setAttribute("cosecha", cosechaActual);
		request.setAttribute("cultivos", cultivos);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/cosecha.jsp");
		dispatcher.forward(request, response);
	}

	private void listCosechas(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		List<Cosecha> cosechas = this.cosechaDao.selectAll();
		request.setAttribute("cosechas", cosechas);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/cosechalist.jsp");
		dispatcher.forward(request, response);
	}

	private void actualizarCosecha(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		Integer cultivoId = Integer.parseInt(request.getParameter("cultivo"));
		String fechaS = request.getParameter("fecha");
		Integer numeroRacimos = Integer.parseInt(request.getParameter("numeroRacimos"));
		Float pesoTotal = Float.parseFloat(request.getParameter("pesoTotal"));
		Float precioVenta = Float.parseFloat(request.getParameter("precioVenta"));

		Cultivo cultivo = this.cultivoDao.buscar(cultivoId);

		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		Date fecha = null;
		try {
			fecha = formato.parse(fechaS);
		} catch (ParseException ex) {
			System.out.println(ex);
		}

		Cosecha cosecha = new Cosecha(id, cultivo, fecha, numeroRacimos, pesoTotal, precioVenta);

		this.cosechaDao.actualizar(cosecha);

		response.sendRedirect("list");
	}

	private void eliminarCosecha(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));

		this.cosechaDao.eliminar(id);

		response.sendRedirect("list");
	}

	private void insertarCosecha(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub

		Integer cultivoId = Integer.parseInt(request.getParameter("cultivo"));
		String fechaS = request.getParameter("fecha");
		Integer numeroRacimos = Integer.parseInt(request.getParameter("numeroRacimos"));
		Float pesoTotal = Float.parseFloat(request.getParameter("pesoTotal"));
		Float precioVenta = Float.parseFloat(request.getParameter("precioVenta"));

		Cultivo cultivo = this.cultivoDao.buscar(cultivoId);

		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		Date fecha = null;
		try {
			fecha = formato.parse(fechaS);
		} catch (ParseException ex) {
			System.out.println(ex);
		}

		Cosecha cosecha = new Cosecha(cultivo, fecha, numeroRacimos, pesoTotal, precioVenta);

		this.cosechaDao.insertar(cosecha);

		response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Cultivo> cultivos = this.cultivoDao.selectByFinca(1);
		
		request.setAttribute("cultivos", cultivos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cosecha.jsp");
		dispatcher.forward(request, response);
	}

}
