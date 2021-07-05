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
import tk.luisalbarracin.librocampo.dao.AsociacionDao;
import tk.luisalbarracin.librocampo.dao.AsociacionDaoMySQL;
import tk.luisalbarracin.librocampo.modelo.Asociacion;

/**
 * Servlet implementation class AsociacionServlet
 */
@WebServlet("/asociacion/*")
public class AsociacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AsociacionDao asociacionDao;
    /**
     * Default constructor. 
     */
    public AsociacionServlet() {
    	
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.asociacionDao = new AsociacionDaoMySQL();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertarAsociacion(request, response);
				break;
			case "/delete":
				eliminarAsociacion(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				actualizarAsociacion(request, response);
				break;
			default:
				listAsociaciones(request, response);
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
		
		Asociacion asociacionActual = this.asociacionDao.buscar(id);
		
		request.setAttribute("asociacion", asociacionActual);
		RequestDispatcher dispatcher = request.getRequestDispatcher("asociacion.jsp");
		dispatcher.forward(request, response);
	}

	private void listAsociaciones(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		List<Asociacion> asociaciones = this.asociacionDao.selectAll();
		request.setAttribute("asociaciones", asociaciones);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("asociacionlist.jsp");
		dispatcher.forward(request, response);
	}

	private void actualizarAsociacion(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		
		Asociacion asociacion = new Asociacion(id, nombre, descripcion);
		this.asociacionDao.actualizar(asociacion);
		
		response.sendRedirect("list");
	}

	private void eliminarAsociacion(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		this.asociacionDao.eliminar(id);
		
		response.sendRedirect("list");
	}

	private void insertarAsociacion(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		
		Asociacion asociacion = new Asociacion(nombre, descripcion);
		this.asociacionDao.insertar(asociacion);
		
		response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("asociacion.jsp");
		dispatcher.forward(request, response);
	}

}
