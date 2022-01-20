package tk.luisalbarracin.librocampo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tk.luisalbarracin.librocampo.modelo.Propietario;
import tk.luisalbarracin.librocampo.util.ConexionMySQL;

public class PropietarioDaoMySQL implements PropietarioDao {

	private ConexionMySQL conexion;

	private static final String INSERTAR = "INSERT INTO propietario (nombre, apellido, noCedula, telefono, expedicionCedula, email, contrasenia) VALUES (?, ?, ?, ?, ?, ?, ?);";
	private static final String ACTUALIZAR = "UPDATE propietario SET nombre = ?, apellido = ?, noCedula = ?, telefono = ?, expedicionCedula = ?, email = ?, contrasenia = ? WHERE id = ?;";
	private static final String ELIMINAR = "DELETE FROM propietario WHERE id = ?;";
	private static final String BUSCAR = "SELECT * FROM propietario WHERE id = ?;";
	private static final String LISTAR = "SELECT * FROM propietario;";
	private static final String LOGIN = "SELECT id FROM propietario WHERE email=? AND contrasenia=?";
	private static final String REGISTRAR = "INSERT INTO propietario (nombre, apellido, noCedula, email, contrasenia) VALUES (?, ?, ?, ?, ?);";
	

	public PropietarioDaoMySQL() {
		this.conexion = ConexionMySQL.getConexion();
	}

	public void insertar(Propietario propietario) {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERTAR);

			preparedStatement.setString(1, propietario.getNombre());
			preparedStatement.setString(2, propietario.getApellido());
			preparedStatement.setString(3, propietario.getNoCedula());
			preparedStatement.setString(4, propietario.getTelefono());
			preparedStatement.setString(5, propietario.getExpedicionCedula());
			preparedStatement.setString(6, propietario.getEmail());
			preparedStatement.setString(7, propietario.getContrasenia());

			conexion.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}
	}

	public void actualizar(Propietario propietario) throws SQLException {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(ACTUALIZAR);

			preparedStatement.setString(1, propietario.getNombre());
			preparedStatement.setString(2, propietario.getApellido());
			preparedStatement.setString(3, propietario.getNoCedula());
			preparedStatement.setString(4, propietario.getTelefono());
			preparedStatement.setString(5, propietario.getExpedicionCedula());
			preparedStatement.setString(6, propietario.getEmail());
			preparedStatement.setString(7, propietario.getContrasenia());
			preparedStatement.setInt(8, propietario.getId());

			conexion.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}
	}

	public void eliminar(Integer id) throws SQLException {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(ELIMINAR);

			preparedStatement.setInt(1, id);

			conexion.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}

	}

	public Propietario buscar(Integer id) {
		Propietario propietario = null;
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(BUSCAR);

			preparedStatement.setInt(1, id);

			ResultSet rs = conexion.query();

			while (rs.next()) {

				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String noCedula = rs.getString("noCedula");
				String telefono = rs.getString("telefono");
				String expedicionCedula = rs.getString("expedicionCedula");
				String email = rs.getString("email");
				String contrasenia = rs.getString("contrasenia");

				propietario = new Propietario(id, nombre, apellido, noCedula, telefono, expedicionCedula, email, contrasenia);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}

		return propietario;

	}

	public List<Propietario> selectAll() {
		List<Propietario> propietarios = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(LISTAR);
			ResultSet rs = conexion.query();

			while (rs.next()) {
				Integer id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String noCedula = rs.getString("noCedula");
				String telefono = rs.getString("telefono");
				String expedicionCedula = rs.getString("expedicionCedula");
				String email = rs.getString("email");
				String contrasenia = rs.getString("contrasenia");

				propietarios.add(new Propietario(id, nombre, apellido, noCedula, telefono, expedicionCedula, email, contrasenia));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return propietarios;

	}
	
	public Boolean login(String email, String contrasenia) {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(LOGIN);

			preparedStatement.setString(1, email);
			preparedStatement.setString(2, contrasenia);

			ResultSet rs = conexion.query();
			

			System.out.println(email);
			System.out.println(contrasenia);

			while (rs.next()) {

				System.out.println(rs.getInt("id"));
				return true;
			}
			
			return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}

		return false;
		
	}
	
	public void registrar(Propietario propietario) {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(REGISTRAR);

			preparedStatement.setString(1, propietario.getNombre());
			preparedStatement.setString(2, propietario.getApellido());
			preparedStatement.setString(3, propietario.getNoCedula());
			preparedStatement.setString(4, propietario.getEmail());
			preparedStatement.setString(5, propietario.getContrasenia());

			conexion.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			e.printStackTrace();
			
		}finally {
		}
	}
}