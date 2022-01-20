package tk.luisalbarracin.librocampo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tk.luisalbarracin.librocampo.modelo.Cultivo;
import tk.luisalbarracin.librocampo.modelo.CultivoPlan;
import tk.luisalbarracin.librocampo.modelo.PlanFertilizante;
import tk.luisalbarracin.librocampo.util.ConexionMySQL;

public class CultivoPlanDaoMySQL implements CultivoPlanDao {

	private ConexionMySQL conexion;

	private static final String INSERTAR = "INSERT INTO cultivoplan (cultivo, plan, mes, anio) VALUES (?, ?, ?, ?);";
	private static final String ACTUALIZAR = "UPDATE cultivoplan SET cultivo = ?, plan = ?, mes = ?, anio = ?, WHERE id = ?;";
	private static final String ELIMINAR = "DELETE FROM cultivoplan WHERE id = ?;";
	private static final String BUSCAR = "SELECT * FROM cultivoplan WHERE id = ?;";
	private static final String LISTAR = "SELECT * FROM cultivoplan";
	private static final String LISTAR_BY_CULTIVO = "SELECT * FROM cultivoplan WHERE cultivo = ?";
	private static final String LISTAR_BY_PLAN = "SELECT * FROM cultivoplan WHERE plan = ?";
	private static final String LISTAR_BY_ANIO = "SELECT * FROM cultivoplan WHERE anio = ?";
	private static final String LISTAR_BY_MES = "SELECT * FROM cultivoplan WHERE mes = ?";
	
	
	public CultivoPlanDaoMySQL() {
		this.conexion = ConexionMySQL.getConexion();
	}
	
	@Override
	public void insertar(CultivoPlan cultivoPlan) throws SQLException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERTAR);

			preparedStatement.setInt(1, cultivoPlan.getCultivo().getId());
			preparedStatement.setInt(2, cultivoPlan.getPlan().getId());
			preparedStatement.setInt(3, cultivoPlan.getMes());
			preparedStatement.setInt(4, cultivoPlan.getAnio());
			
			conexion.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}
	}

	@Override
	public CultivoPlan buscar(Integer id) {
		// TODO Auto-generated method stub
		CultivoPlan cultivoPlan = null;
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(BUSCAR);

			preparedStatement.setInt(1, id);

			ResultSet rs = conexion.query();

			while (rs.next()) {

				Integer cultivoId = rs.getInt("cultivo");
				Integer planId = rs.getInt("plan");
				Integer mes = rs.getInt("mes");
				Integer anio = rs.getInt("anio");
				
				Cultivo cultivo = new Cultivo();
				cultivo.setId(cultivoId);
				
				PlanFertilizante plan = new PlanFertilizante();
				plan.setId(planId);
				
				cultivoPlan = new CultivoPlan(id, cultivo, plan, mes, anio);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}

		return cultivoPlan;
	}

	@Override
	public List<CultivoPlan> selectAll() {
		// TODO Auto-generated method stub
		List<CultivoPlan> cultivoPlan = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(LISTAR);
			ResultSet rs = conexion.query();

			while (rs.next()) {
				Integer cultivoId = rs.getInt("cultivo");
				Integer planId = rs.getInt("plan");
				Integer mes = rs.getInt("mes");
				Integer anio = rs.getInt("anio");
				
				Cultivo cultivo = new Cultivo();
				cultivo.setId(cultivoId);
				
				PlanFertilizante plan = new PlanFertilizante();
				plan.setId(planId);
				
				cultivoPlan.add(new CultivoPlan(cultivo, plan, mes, anio));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}

		return cultivoPlan;
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
		}finally {
		}
	}

	@Override
	public void actualizar(CultivoPlan cultivoPlan) throws SQLException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(ACTUALIZAR);

			preparedStatement.setInt(1, cultivoPlan.getCultivo().getId());
			preparedStatement.setInt(2, cultivoPlan.getPlan().getId());
			preparedStatement.setInt(3, cultivoPlan.getMes());
			preparedStatement.setInt(4, cultivoPlan.getAnio());
			

			conexion.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}
	}

	@Override
	public List<CultivoPlan> selectByCultivo(Integer byCultivo) {
		List<CultivoPlan> cultivoPlan = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(LISTAR_BY_CULTIVO);
			preparedStatement.setInt(1, byCultivo);
			
			ResultSet rs = conexion.query();

			while (rs.next()) {
				Integer cultivoId = rs.getInt("cultivo");
				Integer planId = rs.getInt("plan");
				Integer mes = rs.getInt("mes");
				Integer anio = rs.getInt("anio");
				
				Cultivo cultivo = new Cultivo();
				cultivo.setId(cultivoId);
				
				PlanFertilizante plan = new PlanFertilizante();
				plan.setId(planId);
				
				cultivoPlan.add(new CultivoPlan(cultivo, plan, mes, anio));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}

		return cultivoPlan;
	}

	@Override
	public List<CultivoPlan> selectByPlan(Integer byPlan) {
		List<CultivoPlan> cultivoPlan = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(LISTAR_BY_PLAN);
			preparedStatement.setInt(1, byPlan);
			
			ResultSet rs = conexion.query();

			while (rs.next()) {
				Integer cultivoId = rs.getInt("cultivo");
				Integer planId = rs.getInt("plan");
				Integer mes = rs.getInt("mes");
				Integer anio = rs.getInt("anio");
				
				Cultivo cultivo = new Cultivo();
				cultivo.setId(cultivoId);
				
				PlanFertilizante plan = new PlanFertilizante();
				plan.setId(planId);
				
				cultivoPlan.add(new CultivoPlan(cultivo, plan, mes, anio));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}

		return cultivoPlan;
	}

	@Override
	public List<CultivoPlan> selectByAnio(Integer byAnio) {
		List<CultivoPlan> cultivoPlan = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(LISTAR_BY_ANIO);
			preparedStatement.setInt(1, byAnio);
			
			ResultSet rs = conexion.query();

			while (rs.next()) {
				Integer cultivoId = rs.getInt("cultivo");
				Integer planId = rs.getInt("plan");
				Integer mes = rs.getInt("mes");
				Integer anio = rs.getInt("anio");
				
				Cultivo cultivo = new Cultivo();
				cultivo.setId(cultivoId);
				
				PlanFertilizante plan = new PlanFertilizante();
				plan.setId(planId);
				
				cultivoPlan.add(new CultivoPlan(cultivo, plan, mes, anio));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}

		return cultivoPlan;
	}

	@Override
	public List<CultivoPlan> selectByMes(Integer byMes) {
		List<CultivoPlan> cultivoPlan = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(LISTAR_BY_MES);
			preparedStatement.setInt(1, byMes);
			
			ResultSet rs = conexion.query();

			while (rs.next()) {
				Integer cultivoId = rs.getInt("cultivo");
				Integer planId = rs.getInt("plan");
				Integer mes = rs.getInt("mes");
				Integer anio = rs.getInt("anio");
				
				Cultivo cultivo = new Cultivo();
				cultivo.setId(cultivoId);
				
				PlanFertilizante plan = new PlanFertilizante();
				plan.setId(planId);
				
				cultivoPlan.add(new CultivoPlan(cultivo, plan, mes, anio));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cultivoPlan;
	}

}
