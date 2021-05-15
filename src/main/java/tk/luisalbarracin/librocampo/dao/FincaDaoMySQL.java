package tk.luisalbarracin.librocampo.dao;

import java.sql.SQLException;
import java.util.List;

import tk.luisalbarracin.librocampo.modelo.Finca;
import tk.luisalbarracin.librocampo.util.ConexionMySQL;

public class FincaDaoMySQL implements Dao<Finca> {
	
	private ConexionMySQL conexion;

	private static final String INSERTAR = "INSERT INTO finca (nombre, area, asociacion, areaPalma, plano, propietario, vereda, inicioSiembra) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String ACTUALIZAR = "UPDATE finca SET nombre = ?, area = ?, asociacion = ?, areaPalma = ?, plano = ?, propietario = ?, vereda = ?, inicioSiembra = ? WHERE id = ?;";
	private static final String ELIMINAR = "DELETE * FROM finca WHERE id = ?;";
	private static final String BUSCAR = "SELECT * FROM finca WHERE id = ?;";
	private static final String LISTAR = "SELECT * FROM finca";


	@Override
	public void insertar(Finca objeto) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Finca buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Finca> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Finca objeto) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
