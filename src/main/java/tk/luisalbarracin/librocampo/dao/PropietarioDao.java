package tk.luisalbarracin.librocampo.dao;

import java.sql.SQLException;
import java.util.List;

import tk.luisalbarracin.librocampo.modelo.Propietario;


public interface PropietarioDao {
	public void insertar(Propietario usuario) throws SQLException;
	public Propietario buscar(Integer id);
	public List<Propietario> selectAll();
	public void eliminar(Integer id) throws SQLException;
	public void actualizar(Propietario propietarios) throws SQLException;
}
