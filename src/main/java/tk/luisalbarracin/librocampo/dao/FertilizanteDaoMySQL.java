package tk.luisalbarracin.librocampo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tk.luisalbarracin.librocampo.modelo.Fertilizante;
import tk.luisalbarracin.librocampo.util.ConexionMySQL;

public class FertilizanteDaoMySQL implements FertilizanteDao{

	private ConexionMySQL conexion;

	private static final String INSERTAR = "INSERT INTO fertilizante (nombre, descripcion) VALUES (?, ?);";
	private static final String ACTUALIZAR = "UPDATE fertilizante SET nombre = ?, descripcion = ? WHERE id = ?;";
	private static final String ELIMINAR = "DELETE * FROM fertilizante WHERE id = ?;";
	private static final String BUSCAR = "SELECT * FROM fertilizante WHERE id = ?;";
	private static final String LISTAR = "SELECT * FROM fertilizante";
	
	
	public FertilizanteDaoMySQL() {
		this.conexion = ConexionMySQL.getConexion();
	}
	
	
	@Override
	public void insertar(Fertilizante fertilizante) throws SQLException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERTAR);

			preparedStatement.setString(1, fertilizante.getNombre());
			preparedStatement.setString(2, fertilizante.getDescripcion());
			
			conexion.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Fertilizante buscar(Integer id) {
		// TODO Auto-generated method stub
		Fertilizante fertilizante = null;
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(BUSCAR);

			preparedStatement.setInt(1, id);

			ResultSet rs = conexion.query();

			while (rs.next()) {

				String nombre = rs.getString("nombre");
				String descripcion = rs.getString("descripcion");
				
				fertilizante = new Fertilizante(id, nombre, descripcion);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fertilizante;
	}

	@Override
	public List<Fertilizante> selectAll() {
		// TODO Auto-generated method stub
		List<Fertilizante> fertilizantes = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(LISTAR);
			ResultSet rs = conexion.query();

			while (rs.next()) {
				Integer id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String descripcion = rs.getString("descripcion");
				
				fertilizantes.add(new Fertilizante(id, nombre, descripcion));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fertilizantes;
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
	public void actualizar(Fertilizante fertilizante) throws SQLException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(ACTUALIZAR);


			preparedStatement.setString(1, fertilizante.getNombre());
			preparedStatement.setString(2, fertilizante.getDescripcion());
			preparedStatement.setInt(3, fertilizante.getId());

			conexion.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
