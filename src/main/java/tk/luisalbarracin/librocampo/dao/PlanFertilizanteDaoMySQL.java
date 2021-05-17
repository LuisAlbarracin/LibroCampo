package tk.luisalbarracin.librocampo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tk.luisalbarracin.librocampo.modelo.Fertilizante;
import tk.luisalbarracin.librocampo.modelo.PlanFertilizante;
import tk.luisalbarracin.librocampo.util.ConexionMySQL;

public class PlanFertilizanteDaoMySQL implements Dao<PlanFertilizante> {

	private ConexionMySQL conexion;

	private static final String INSERTAR = "INSERT INTO planfertilizante (fertilizante, numeroBultos, gramosPalma) VALUES (?, ?, ?);";
	private static final String ACTUALIZAR = "UPDATE planfertilizante SET fertilizante = ?, numeroBultos = ?, gramosPalma = ?WHERE id = ?;";
	private static final String ELIMINAR = "DELETE * FROM planfertilizante WHERE id = ?;";
	private static final String BUSCAR = "SELECT * FROM planfertilizante WHERE id = ?;";
	private static final String LISTAR = "SELECT * FROM planfertilizante";
	
	
	public PlanFertilizanteDaoMySQL() {
		this.conexion = ConexionMySQL.getConexion();
	}
	
	
	@Override
	public void insertar(PlanFertilizante planFertilizante) throws SQLException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERTAR);

			preparedStatement.setInt(1, planFertilizante.getFertilizante().getId());
			preparedStatement.setInt(2, planFertilizante.getNumeroBultos());
			preparedStatement.setFloat(3, planFertilizante.getGramosPalma());
			
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

				Integer fertilizanteId = rs.getInt("fertilizante");
				Integer numeroBultos = rs.getInt("numeroBultos");
				Float gramosPalma = rs.getFloat("gramosPalma");
				
				Fertilizante fertilizante = new Fertilizante();
				fertilizante.setId(fertilizanteId);
				
				planFertilizante = new PlanFertilizante(id, fertilizante, numeroBultos, gramosPalma);
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
				Integer fertilizanteId = rs.getInt("fertilizante");
				Integer numeroBultos = rs.getInt("numeroBultos");
				Float gramosPalma = rs.getFloat("gramosPalma");
				
				Fertilizante fertilizante = new Fertilizante();
				fertilizante.setId(fertilizanteId);
				
				planesFertilizantes.add(new PlanFertilizante(id, fertilizante, numeroBultos, gramosPalma));
				
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
			preparedStatement.setInt(2, planFertilizante.getNumeroBultos());
			preparedStatement.setFloat(3, planFertilizante.getGramosPalma());
			preparedStatement.setInt(4, planFertilizante.getId());

			conexion.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
