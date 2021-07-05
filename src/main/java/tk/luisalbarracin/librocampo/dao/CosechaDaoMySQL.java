package tk.luisalbarracin.librocampo.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tk.luisalbarracin.librocampo.modelo.Cosecha;
import tk.luisalbarracin.librocampo.modelo.Cultivo;
import tk.luisalbarracin.librocampo.util.ConexionMySQL;

public class CosechaDaoMySQL implements CosechaDao {

	private ConexionMySQL conexion;

	private static final String INSERTAR = "INSERT INTO cosecha (cultivo, fecha, numeroRacimos, pesoTotal, precioVenta) VALUES (?, ?, ?, ?, ?);";
	private static final String ACTUALIZAR = "UPDATE cosecha SET cultivo = ?, fecha = ?, numeroRacimos = ?, pesoTotal = ?, precioVenta = ? WHERE id = ?;";
	private static final String ELIMINAR = "DELETE * FROM cosecha WHERE id = ?;";
	private static final String BUSCAR = "SELECT * FROM cosecha WHERE id = ?;";
	private static final String LISTAR = "SELECT * FROM cosecha";
	private static final String LISTAR_BY_CULTIVO = "SELECT * FROM cosecha WHERE cosecha = ?";
	
	
	public CosechaDaoMySQL() {
		this.conexion = ConexionMySQL.getConexion();
	}
	
	@Override
	public void insertar(Cosecha cosecha) throws SQLException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERTAR);

			preparedStatement.setInt(1, cosecha.getCultivo().getId());
			preparedStatement.setDate(2, (Date) cosecha.getFecha());
			preparedStatement.setInt(3, cosecha.getNumeroRacimos());
			preparedStatement.setFloat(4, cosecha.getPesoTotal());
			preparedStatement.setFloat(5, cosecha.getPrecioVenta());

			conexion.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Cosecha buscar(Integer id) {
		// TODO Auto-generated method stub
		Cosecha cosecha = null;
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(BUSCAR);

			preparedStatement.setInt(1, id);

			ResultSet rs = conexion.query();

			while (rs.next()) {

				Integer cultivoId = rs.getInt("cultivo");
				Date fecha = rs.getDate("fecha");
				Integer numeroRacimos = rs.getInt("numeroRacimos");
				Float pesoTotal = rs.getFloat("pesoTotal");
				Float precioVenta = rs.getFloat("precioVenta");

				Cultivo cultivo = new Cultivo();
				cultivo.setId(cultivoId);
				cosecha = new Cosecha(id, cultivo, fecha, numeroRacimos, pesoTotal, precioVenta);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cosecha;
	}

	@Override
	public List<Cosecha> selectAll() {
		// TODO Auto-generated method stub
		List<Cosecha> cosechas = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(LISTAR);
			ResultSet rs = conexion.query();

			while (rs.next()) {
				Integer id = rs.getInt("id");
				Integer cultivoId = rs.getInt("cultivo");
				Date fecha = rs.getDate("fecha");
				Integer numeroRacimos = rs.getInt("numeroRacimos");
				Float pesoTotal = rs.getFloat("pesoTotal");
				Float precioVenta = rs.getFloat("precioVenta");

				Cultivo cultivo = new Cultivo();
				cultivo.setId(cultivoId);
				
				cosechas.add(new Cosecha(id, cultivo, fecha, numeroRacimos, pesoTotal, precioVenta));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cosechas;
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
	public void actualizar(Cosecha cosecha) throws SQLException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(ACTUALIZAR);

			preparedStatement.setInt(1, cosecha.getCultivo().getId());
			preparedStatement.setDate(2, (Date) cosecha.getFecha());
			preparedStatement.setInt(3, cosecha.getNumeroRacimos());
			preparedStatement.setFloat(4, cosecha.getPesoTotal());
			preparedStatement.setFloat(5, cosecha.getPrecioVenta());
			preparedStatement.setInt(7, cosecha.getId());

			conexion.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Cosecha> selectByCultivo(Integer cosechaCultivo) {
		List<Cosecha> cosechas = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(LISTAR_BY_CULTIVO);
			preparedStatement.setInt(1, cosechaCultivo);
			
			ResultSet rs = conexion.query();

			while (rs.next()) {
				Integer id = rs.getInt("id");
				Integer cultivoId = rs.getInt("cultivo");
				Date fecha = rs.getDate("fecha");
				Integer numeroRacimos = rs.getInt("numeroRacimos");
				Float pesoTotal = rs.getFloat("pesoTotal");
				Float precioVenta = rs.getFloat("precioVenta");

				Cultivo cultivo = new Cultivo();
				cultivo.setId(cultivoId);
				
				cosechas.add(new Cosecha(id, cultivo, fecha, numeroRacimos, pesoTotal, precioVenta));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cosechas;
	}

}
