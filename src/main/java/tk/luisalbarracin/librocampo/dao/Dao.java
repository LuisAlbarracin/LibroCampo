package tk.luisalbarracin.librocampo.dao;

import java.sql.SQLException;
import java.util.List;

import tk.luisalbarracin.librocampo.modelo.Propietario;


public interface Dao<T> {
	public void insertar(T objeto) throws SQLException;
	public T buscar(Integer id);
	public List<T> selectAll();
	public void eliminar(Integer id) throws SQLException;
	public void actualizar(T objeto) throws SQLException;
}
