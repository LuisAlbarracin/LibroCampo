package tk.luisalbarracin.librocampo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tk.luisalbarracin.librocampo.modelo.Fertilizante;
import tk.luisalbarracin.librocampo.modelo.PlanFertilizante;
import tk.luisalbarracin.librocampo.util.ConexionMySQL;

public class PlanFertilizanteDaoMySQL implements PlanFertilizanteDao {

	private ConexionMySQL conexion;

	private static final String INSERTAR = "INSERT INTO planfertilizante (nombre, fertilizante, numeroBultos, gramosPalma) VALUES (?, ?, ?, ?);";
	private static final String ACTUALIZAR = "UPDATE planfertilizante SET fertilizante = ?, numeroBultos = ?, gramosPalma = ?WHERE id = ?;";
	private static final String ELIMINAR = "DELETE * FROM planfertilizante WHERE id = ?;";
	private static final String BUSCAR = "SELECT * FROM planfertilizante WHERE id = ?;";
	private static final String LISTAR = "SELECT * FROM planfertilizante";
	private static final String LISTAR_BY_FERTILIZANTE = "SELECT * FROM planfertilizante WHERE fertilizante = ?";
	
	
	public PlanFertilizanteDaoMySQL() {
		this.conexion = ConexionMySQL.getConexion();
	}
	
	
	@Override
	public void insertar(PlanFertilizante planFertilizante) throws SQLException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERTAR);

			preparedStatement.setString(1, planFertilizante.getNombre());
			preparedStatement.setInt(2, planFertilizante.getFertilizante().getId());
			preparedStatement.setInt(3, planFertilizante.getNumeroBultos());
			preparedStatement.setFloat(4, planFertilizante.getGramosPalma());
			
			conexion.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public PlanFertilizante buscar(Integer id) {
		// TODO Auto-generated method stub
		PlanFertilizante planFertilizante = null;
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(BUSCAR);

			preparedStatement.setInt(1, id);

			ResultSet rs = conexion.query();

			while (rs.next()) {
				
				String nombre = rs.getString("nombre");
				Integer fertilizanteId = rs.getInt("fertilizante");
				Integer numeroBultos = rs.getInt("numeroBultos");
				Float gramosPalma = rs.getFloat("gramosPalma");
				
				Fertilizante fertilizante = new Fertilizante();
				fertilizante.setId(fertilizanteId);
				
				planFertilizante = new PlanFertilizante(id, nombre, fertilizante, numeroBultos, gramosPalma);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return planFertilizante;

	}

	@Override
	public List<PlanFertilizante> selectAll() {
		// TODO Auto-generated method stub
		List<PlanFertilizante> planesFertilizantes = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(LISTAR);
			ResultSet rs = conexion.query();

			while (rs.next()) {
				Integer id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				Integer fertilizanteId = rs.getInt("fertilizante");
				Integer numeroBultos = rs.getInt("numeroBultos");
				Float gramosPalma = rs.getFloat("gramosPalma");
				
				Fertilizante fertilizante = new Fertilizante();
				fertilizante.setId(fertilizanteId);
				
				planesFertilizantes.add(new PlanFertilizante(id, nombre, fertilizante, numeroBultos, gramosPalma));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return planesFertilizantes;
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
	public void actualizar(PlanFertilizante planFertilizante) throws SQLException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(ACTUALIZAR);

			preparedStatement.setInt(1, planFertilizante.getFertilizante().getId());
			preparedStatement.setString(2, planFertilizante.getNombre());
			preparedStatement.setInt(3, planFertilizante.getNumeroBultos());
			preparedStatement.setFloat(4, planFertilizante.getGramosPalma());
			preparedStatement.setInt(5, planFertilizante.getId());

			conexion.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public List<PlanFertilizante> selectByFertilizante(Integer byFertilizante) {
		List<PlanFertilizante> planesFertilizantes = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(LISTAR_BY_FERTILIZANTE);
			preparedStatement.setInt(1, byFertilizante);
			
			ResultSet rs = conexion.query();

			while (rs.next()) {
				Integer id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				Integer fertilizanteId = rs.getInt("fertilizante");
				Integer numeroBultos = rs.getInt("numeroBultos");
				Float gramosPalma = rs.getFloat("gramosPalma");
				
				Fertilizante fertilizante = new Fertilizante();
				fertilizante.setId(fertilizanteId);
				
				planesFertilizantes.add(new PlanFertilizante(id, nombre, fertilizante, numeroBultos, gramosPalma));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return planesFertilizantes;
	}

}
