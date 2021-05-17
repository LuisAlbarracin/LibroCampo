package tk.luisalbarracin.librocampo.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tk.luisalbarracin.librocampo.modelo.Calidad;
import tk.luisalbarracin.librocampo.modelo.Cultivo;
import tk.luisalbarracin.librocampo.util.ConexionMySQL;

public class CalidadDaoMySQL implements Dao<Calidad> {

	private ConexionMySQL conexion;

	private static final String INSERTAR = "INSERT INTO calidad (cultivo, fecha, porcentajeVerdes, porcentajeSobremaduros, porcentajePedunculoLargo, porcentajePodridos, impurezas) VALUES (?, ?, ?, ?, ?, ?, ?);";
	private static final String ACTUALIZAR = "UPDATE calidad SET cultivo = ?, fecha = ?, porcentajeVerdes = ?, porcentajeSobremaduros = ?, porcentajePedunculoLargo = ?, porcentajePodridos, impurezas = ? WHERE id = ?;";
	private static final String ELIMINAR = "DELETE * FROM calidad WHERE id = ?;";
	private static final String BUSCAR = "SELECT * FROM calidad WHERE id = ?;";
	private static final String LISTAR = "SELECT * FROM calidad";
	
	
	public CalidadDaoMySQL() {
		this.conexion = ConexionMySQL.getConexion();
	}
	
	@Override
	public void insertar(Calidad calidad) throws SQLException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERTAR);

			preparedStatement.setInt(1, calidad.getCultivo().getId());
			preparedStatement.setDate(2, (Date) calidad.getFecha());
			preparedStatement.setFloat(3, calidad.getPorcentajeVerdes());
			preparedStatement.setFloat(4, calidad.getPorcentajeSobremaduros());
			preparedStatement.setFloat(5, calidad.getPorcentajePedunculoLargo());
			preparedStatement.setFloat(6, calidad.getPorcentajePodridos());
			preparedStatement.setBoolean(7, calidad.getImpurezas());

			conexion.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Calidad buscar(Integer id) {
		// TODO Auto-generated method stub
		Calidad calidad = null;
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(BUSCAR);

			preparedStatement.setInt(1, id);

			ResultSet rs = conexion.query();

			while (rs.next()) {

				Integer idCultivo = rs.getInt("cultivo");
				Date fecha = rs.getDate("fecha");
				Float porcentajeVerdes = rs.getFloat("porcentajeVerdes");
				Float porcentajeSobremaduros = rs.getFloat("porcentajeSobremaduros");
				Float porcentajePedunculoLargo = rs.getFloat("porcentajePedunculoLargo");
				Float porcentajePodridos = rs.getFloat("porcentajePodridos");
				Boolean impurezas = rs.getBoolean("impurezas");
				
				Cultivo cultivo = new Cultivo();
				cultivo.setId(idCultivo);
				
				calidad = new Calidad(id, cultivo, fecha, porcentajeVerdes, porcentajeSobremaduros, porcentajePedunculoLargo, porcentajePodridos, impurezas);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return calidad;
	}

	@Override
	public List<Calidad> selectAll() {
		// TODO Auto-generated method stub
		List<Calidad> calidades = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(LISTAR);
			ResultSet rs = conexion.query();

			while (rs.next()) {
				Integer id = rs.getInt("id");
				Integer idCultivo = rs.getInt("cultivo");
				Date fecha = rs.getDate("fecha");
				Float porcentajeVerdes = rs.getFloat("porcentajeVerdes");
				Float porcentajeSobremaduros = rs.getFloat("porcentajeSobremaduros");
				Float porcentajePedunculoLargo = rs.getFloat("porcentajePedunculoLargo");
				Float porcentajePodridos = rs.getFloat("porcentajePodridos");
				Boolean impurezas = rs.getBoolean("impurezas");
				
				Cultivo cultivo = new Cultivo();
				cultivo.setId(idCultivo);
				
				calidades.add(new Calidad(id, cultivo, fecha, porcentajeVerdes, porcentajeSobremaduros, porcentajePedunculoLargo, porcentajePodridos, impurezas));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return calidades;

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
	public void actualizar(Calidad calidad) throws SQLException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(ACTUALIZAR);
			preparedStatement.setInt(1, calidad.getCultivo().getId());
			preparedStatement.setDate(2, (Date) calidad.getFecha());
			preparedStatement.setFloat(3, calidad.getPorcentajeVerdes());
			preparedStatement.setFloat(4, calidad.getPorcentajeSobremaduros());
			preparedStatement.setFloat(5, calidad.getPorcentajePedunculoLargo());
			preparedStatement.setFloat(6, calidad.getPorcentajePodridos());
			preparedStatement.setBoolean(7, calidad.getImpurezas());
			preparedStatement.setInt(8, calidad.getId());
			

			conexion.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
