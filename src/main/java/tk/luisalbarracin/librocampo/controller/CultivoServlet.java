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
import tk.luisalbarracin.librocampo.dao.FincaDao;
import tk.luisalbarracin.librocampo.dao.FincaDaoMySQL;
import tk.luisalbarracin.librocampo.modelo.Cultivo;
import tk.luisalbarracin.librocampo.modelo.Finca;

/**
 * Servlet implementation class CultivoServlet
 */
@WebServlet("/cultivo/*")
public class CultivoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CultivoDao cultivoDao;
	private FincaDao fincaDao;

    /**
     * Default constructor. 
     */
    public CultivoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.cultivoDao = new CultivoDaoMySQL();
		this.fincaDao = new FincaDaoMySQL();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getRequestURI();

		try {
			switch (action) {
			case "/libroCampo/cultivo/new":
				showNewForm(request, response);
				break;
			case "/libroCampo/cultivo/insert":
				insertarCultivo(request, response);
				break;
			case "/libroCampo/cultivo/delete":
				eliminarCultivo(request, response);
				break;
			case "/libroCampo/cultivo/edit":
				showEditForm(request, response);
				break;
			case "/libroCampo/cultivo/update":
				actualizarCultivo(request, response);
				break;
			default:
				listCultivos(request, response);
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
		
		Cultivo cultivoActual = this.cultivoDao.buscar(id);
		List<Finca> fincas = this.fincaDao.selectAll();
		
		request.setAttribute("cultivo", cultivoActual);
		request.setAttribute("fincas", fincas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cultivo.jsp");
		dispatcher.forward(request, response);
	}

	private void listCultivos(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		List<Cultivo> cultivos = this.cultivoDao.selectAll();
		
		request.setAttribute("cultivos", cultivos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cultivolist.jsp");
		dispatcher.forward(request, response);
	}

	private void actualizarCultivo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		Integer fincaId = Integer.parseInt(request.getParameter("finca"));
		Integer numero = Integer.parseInt(request.getParameter("numero"));
		String nombre = request.getParameter("nombre");
		
		Finca finca = this.fincaDao.buscar(fincaId);
		
		Cultivo cultivo = new Cultivo(id, finca, numero, nombre);
		this.cultivoDao.actualizar(cultivo);
		
		response.sendRedirect("list");
	}

	private void eliminarCultivo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		this.cultivoDao.eliminar(id);
		
		response.sendRedirect("list");
	}

	private void insertarCultivo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		Integer fincaId = Integer.parseInt(request.getParameter("finca"));
		Integer numero = Integer.parseInt(request.getParameter("numero"));
		String nombre = request.getParameter("nombre");
		
		Finca finca = this.fincaDao.buscar(fincaId);
		
		Cultivo cultivo = new Cultivo(finca, numero, nombre);
		
		
		this.cultivoDao.insertar(cultivo);
		
		response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Finca> fincas = this.fincaDao.selectAll();
		request.setAttribute("fincas", fincas);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cultivo.jsp");
		dispatcher.forward(request, response);
	}

	

}
