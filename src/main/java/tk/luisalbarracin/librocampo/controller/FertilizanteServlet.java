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
import tk.luisalbarracin.librocampo.modelo.Fertilizante;

/**
 * Servlet implementation class FertilizanteServlet
 */
@WebServlet("/fertilizante")
public class FertilizanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FertilizanteDao fertilizanteDao;
    /**
     * Default constructor. 
     */
    public FertilizanteServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.fertilizanteDao = new FertilizanteDaoMySQL();
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
				insertarFertilizante(request, response);
				break;
			case "/delete":
				eliminarFertilizante(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				actualizarFertilizante(request, response);
				break;
			default:
				listFertilizantes(request, response);
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
		
		Fertilizante fertilizanteActual = this.fertilizanteDao.buscar(id);
		
		request.setAttribute("fertilizante", fertilizanteActual);
		RequestDispatcher dispatcher = request.getRequestDispatcher("fertilizante.jsp");
		dispatcher.forward(request, response);
	}

	private void listFertilizantes(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		List<Fertilizante> fertilizantes = this.fertilizanteDao.selectAll();
		request.setAttribute("fertilizantes", fertilizantes);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("fertilizantelist.jsp");
		dispatcher.forward(request, response);
	}

	private void actualizarFertilizante(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		
		Fertilizante fertilizante = new Fertilizante(id, nombre, descripcion);
		this.fertilizanteDao.actualizar(fertilizante);
		
		response.sendRedirect("list");
	}

	private void eliminarFertilizante(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		this.fertilizanteDao.eliminar(id);
		
		response.sendRedirect("list");
	}

	private void insertarFertilizante(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		
		Fertilizante fertilizante = new Fertilizante(nombre, descripcion);
		this.fertilizanteDao.insertar(fertilizante);
		
		response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("fertilizante.jsp");
		dispatcher.forward(request, response);
	}

}
