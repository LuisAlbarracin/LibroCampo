package tk.luisalbarracin.librocampo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tk.luisalbarracin.librocampo.modelo.Asociacion;
import tk.luisalbarracin.librocampo.util.ConexionMySQL;

public class AsociacionDaoMySQL implements AsociacionDao {
	
private ConexionMySQL conexion;
	
	private static final String INSERTAR = "INSERT INTO asociacion (nombre, descripcion) VALUES (?, ?);";
	private static final String ACTUALIZAR = "UPDATE asociacion SET nombre = ?, descripcion = ? WHERE id = ?;";
	private static final String ELIMINAR = "DELETE FROM asociacion WHERE id = ?;";
	private static final String BUSCAR = "SELECT * FROM asociacion WHERE id = ?;";
	private static final String LISTAR = "SELECT * FROM asociacion";
	
	public AsociacionDaoMySQL() {
		this.conexion = ConexionMySQL.getConexion();
	}
	
	public void insertar(Asociacion asociacion) {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERTAR);
			
			preparedStatement.setString(1, asociacion.getNombre());
			preparedStatement.setString(2, asociacion.getDescripcion());
			
			conexion.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actualizar(Asociacion asociacion) throws SQLException {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(ACTUALIZAR);
		
			preparedStatement.setString(1, asociacion.getNombre());
			preparedStatement.setString(2, asociacion.getDescripcion());
			preparedStatement.setInt(3, asociacion.getId());
			
			conexion.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		}
		
	}
	
	public Asociacion buscar(Integer id) {
		Asociacion asociacion = null;
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(BUSCAR);
		
			preparedStatement.setInt(1, id);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("descripcion");
				
				asociacion = new Asociacion(id, nombre, apellido);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return asociacion;
		
	}
	
	public List<Asociacion> selectAll() {
		List<Asociacion> asociacion = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(LISTAR);
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				Integer id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String descripcion = rs.getString("descripcion");
				
				asociacion.add(new Asociacion(id, nombre, descripcion));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return asociacion;
		
	}


}
