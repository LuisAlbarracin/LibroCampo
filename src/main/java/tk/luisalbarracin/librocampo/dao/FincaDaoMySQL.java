package tk.luisalbarracin.librocampo.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tk.luisalbarracin.librocampo.modelo.Asociacion;
import tk.luisalbarracin.librocampo.modelo.Finca;
import tk.luisalbarracin.librocampo.modelo.Propietario;
import tk.luisalbarracin.librocampo.util.ConexionMySQL;

public class FincaDaoMySQL implements FincaDao {
	
	private ConexionMySQL conexion;

	private static final String INSERTAR = "INSERT INTO finca (nombre, area, asociacion, areaPalma, plano, propietario, vereda, inicioSiembra) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String ACTUALIZAR = "UPDATE finca SET nombre = ?, area = ?, asociacion = ?, areaPalma = ?, plano = ?, propietario = ?, vereda = ?, inicioSiembra = ? WHERE id = ?;";
	private static final String ELIMINAR = "DELETE FROM finca WHERE id = ?;";
	private static final String BUSCAR = "SELECT * FROM finca WHERE id = ?;";
	private static final String LISTAR = "SELECT * FROM finca";
	private static final String LISTAR_BY_PROPIETARIO = "SELECT * FROM finca WHERE propietario = ?";
	private static final String LISTAR_BY_ASOCIACION = "SELECT * FROM finca WHERE asociacion = ?";


	public FincaDaoMySQL() {
		this.conexion = ConexionMySQL.getConexion();
	}
	
	@Override
	public void insertar(Finca finca) throws SQLException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERTAR);

			preparedStatement.setString(1, finca.getNombre());
			preparedStatement.setFloat(2, finca.getArea());
			if(finca.getAsociacion() != null)
				preparedStatement.setInt(3, finca.getAsociacion().getId());
			else
				preparedStatement.setInt(3, -1);
			preparedStatement.setFloat(4, finca.getAreaPalma());
			preparedStatement.setString(5, finca.getPlano());
			preparedStatement.setInt(6, finca.getPropietario().getId());
			preparedStatement.setString(7, finca.getVereda());
			preparedStatement.setDate(8, new java.sql.Date(finca.getInicioSiembra().getTime()));
			
			conexion.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}
	}

	@Override
	public Finca buscar(Integer id) {
		// TODO Auto-generated method stub
		Finca finca = null;
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(BUSCAR);

			preparedStatement.setInt(1, id);

			ResultSet rs = conexion.query();

			while (rs.next()) {

				String nombre = rs.getString("nombre");
				Float area = rs.getFloat("area");
				Integer asociacionId = rs.getInt("asociacion");
				Float areaPalma = rs.getFloat("areaPalma");
				String plano = rs.getString("plano");
				Integer propietarioId = rs.getInt("propietario");
				String vereda = rs.getString("vereda");
				Date inicioSiembra = rs.getDate("inicioSiembra");
				
				Asociacion asociacion = new Asociacion();
				asociacion.setId(asociacionId);
				
				Propietario propietario = new Propietario();
				propietario.setId(propietarioId);
				
				finca = new Finca(id, nombre, area, asociacion, areaPalma, plano, propietario, vereda, inicioSiembra);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}

		return finca;
	}

	@Override
	public List<Finca> selectAll() {
		// TODO Auto-generated method stub
		List<Finca> fincas = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(LISTAR);
			ResultSet rs = conexion.query();

			while (rs.next()) {
				Integer id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				Float area = rs.getFloat("area");
				Integer asociacionId = rs.getInt("asociacion");
				Float areaPalma = rs.getFloat("areaPalma");
				String plano = rs.getString("plano");
				Integer propietarioId = rs.getInt("propietario");
				String vereda = rs.getString("vereda");
				Date inicioSiembra = rs.getDate("inicioSiembra");
				
				Asociacion asociacion = new Asociacion();
				asociacion.setId(asociacionId);
				
				Propietario propietario = new Propietario();
				propietario.setId(propietarioId);
				
				fincas.add(new Finca(id, nombre, area, asociacion, areaPalma, plano, propietario, vereda, inicioSiembra));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}

		return fincas;
	}

	@Override
	public void eliminar(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(ELIMINAR);

			preparedStatement.setInt(1, id);

			conexion.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void actualizar(Finca finca) throws SQLException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(ACTUALIZAR);

			preparedStatement.setString(1, finca.getNombre());
			preparedStatement.setFloat(2, finca.getArea());
			preparedStatement.setInt(3, finca.getAsociacion().getId());
			preparedStatement.setFloat(4, finca.getAreaPalma());
			preparedStatement.setString(5, finca.getPlano());
			preparedStatement.setInt(6, finca.getPropietario().getId());
			preparedStatement.setString(7, finca.getVereda());
			preparedStatement.setDate(8, new java.sql.Date(finca.getInicioSiembra().getTime()));
			preparedStatement.setInt(9, finca.getId());

			conexion.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}
	}

	@Override
	public List<Finca> selectByPropietario(Integer propietarioFinca) {
		List<Finca> fincas = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(LISTAR_BY_PROPIETARIO);
			preparedStatement.setInt(1, propietarioFinca);
			
			ResultSet rs = conexion.query();

			while (rs.next()) {
				Integer id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				Float area = rs.getFloat("area");
				Integer asociacionId = rs.getInt("asociacion");
				Float areaPalma = rs.getFloat("areaPalma");
				String plano = rs.getString("plano");
				Integer propietarioId = rs.getInt("propietario");
				String vereda = rs.getString("vereda");
				Date inicioSiembra = rs.getDate("inicioSiembra");
				
				Asociacion asociacion = new Asociacion();
				asociacion.setId(asociacionId);
				
				Propietario propietario = new Propietario();
				propietario.setId(propietarioId);
				
				fincas.add(new Finca(id, nombre, area, asociacion, areaPalma, plano, propietario, vereda, inicioSiembra));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}

		return fincas;
	}

	@Override
	public List<Finca> selectByAsociacion(Integer asociacionFinca) {
		List<Finca> fincas = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(LISTAR_BY_ASOCIACION);
			preparedStatement.setInt(1, asociacionFinca);
			
			ResultSet rs = conexion.query();

			while (rs.next()) {
				Integer id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				Float area = rs.getFloat("area");
				Integer asociacionId = rs.getInt("asociacion");
				Float areaPalma = rs.getFloat("areaPalma");
				String plano = rs.getString("plano");
				Integer propietarioId = rs.getInt("propietario");
				String vereda = rs.getString("vereda");
				Date inicioSiembra = rs.getDate("inicioSiembra");
				
				Asociacion asociacion = new Asociacion();
				asociacion.setId(asociacionId);
				
				Propietario propietario = new Propietario();
				propietario.setId(propietarioId);
				
				fincas.add(new Finca(id, nombre, area, asociacion, areaPalma, plano, propietario, vereda, inicioSiembra));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		return fincas;
	}

}
