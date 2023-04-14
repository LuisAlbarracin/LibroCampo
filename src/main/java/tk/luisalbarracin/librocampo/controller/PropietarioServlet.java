package tk.luisalbarracin.librocampo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tk.luisalbarracin.librocampo.dao.PropietarioDao;
import tk.luisalbarracin.librocampo.dao.PropietarioDaoFactory;
import tk.luisalbarracin.librocampo.modelo.Propietario;

/**
 * Servlet implementation class PropietarioServlet
 */
@WebServlet("/propietario/*")
public class PropietarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PropietarioDao propietarioDao;
	

	/**
	 * Default constructor.
	 */
	public PropietarioServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		String type = getServletContext().getInitParameter("type");
		this.propietarioDao = PropietarioDaoFactory.getUsuarioDao(type);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// String action = request.getServletPath();
		String action = request.getRequestURI();
		System.out.println(action);

		try {
			switch (action) {
			case "/libroCampo/propietario/new":
				showNewForm(request, response);
				break;
			case "/libroCampo/propietario/insert":
				insertarPropietario(request, response);
				break;
			case "/libroCampo/propietario/registrar":
				registrarPropietario(request, response);
				break;
			case "/libroCampo/propietario/delete":
				eliminarPropietario(request, response);
				break;
			case "/libroCampo/propietario/edit":
				showEditForm(request, response);
				break;
			case "/libroCampo/propietario/update":
				System.out.println("Entrando a actualizar");
				actualizarPropietario(request, response);
				break;
			case "/libroCampo/propietario/login":
				loginPropietario(request, response);
				break;
			default:
				listPropietarios(request, response);
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

		Integer id = Integer.parseInt(request.getParameter("id"));

		Propietario propietarioActual = this.propietarioDao.buscar(id);

		request.setAttribute("propietario", propietarioActual);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/propietario.jsp");
		dispatcher.forward(request, response);
	}

	private void listPropietarios(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		List<Propietario> propietarios = this.propietarioDao.selectAll();
		request.setAttribute("propietarios", propietarios);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/propietariolist.jsp");
		dispatcher.forward(request, response);
	}

	private void actualizarPropietario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Integer id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String noCedula = request.getParameter("noCedula");
		String telefono = request.getParameter("telefono");
		String expedicionCedula = request.getParameter("expedicionCedula");
		String email = request.getParameter("email");
		String contrasenia = request.getParameter("contrasenia");

		Propietario propietario = new Propietario(id, nombre, apellido, noCedula, telefono, expedicionCedula, email,
				contrasenia);
		try {
			this.propietarioDao.actualizar(propietario);
		} catch (MySQLIntegrityConstraintViolationException exMysql) {
			request.setAttribute("error", exMysql.getMessage());
		}
		response.sendRedirect("list");

	}

	private void eliminarPropietario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Integer id = Integer.parseInt(request.getParameter("id"));

		this.propietarioDao.eliminar(id);

		response.sendRedirect("list");
	}

	private void insertarPropietario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub

		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String coCedula = request.getParameter("noCedula");
		String telefono = request.getParameter("telefono");
		String expedicionCedula = request.getParameter("expedicionCedula");
		String email = request.getParameter("email");
		String contrasenia = request.getParameter("contrasenia");

		Propietario propietario = new Propietario(nombre, apellido, coCedula, telefono, expedicionCedula, email,
				contrasenia);

		try {
			this.propietarioDao.insertar(propietario);
		} catch (MySQLIntegrityConstraintViolationException exMysql) {
			request.setAttribute("error", exMysql.getMessage());
		}

		response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher dispatcher = request.getRequestDispatcher("/propietario.jsp");
		dispatcher.forward(request, response);
	}

	private void loginPropietario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub

		String email = request.getParameter("email");
		String contrasenia = request.getParameter("contrasenia");

		Boolean isExist = this.propietarioDao.login(email, contrasenia);
		
		if (isExist) {
			HttpSession session = request.getSession();
			session.setAttribute("propietario", email);
			this.listPropietarios(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void registrarPropietario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String coCedula = request.getParameter("noCedula");
		String email = request.getParameter("email");
		String contrasenia = request.getParameter("contrasenia");

		Propietario propietario = new Propietario();
		propietario.setNombre(nombre);
		propietario.setApellido(apellido);
		propietario.setNoCedula(coCedula);
		propietario.setEmail(email);
		propietario.setContrasenia(contrasenia);

		try {
			this.propietarioDao.registrar(propietario);
		} catch (MySQLIntegrityConstraintViolationException exMysql) {
			request.setAttribute("error", exMysql.getMessage());
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/propietariolist.jsp");
		dispatcher.forward(request, response);
	}
	

}
