/**
 * 
 */
package tk.luisalbarracin.librocampo.dao;

import java.sql.SQLException;
import java.util.List;

import tk.luisalbarracin.librocampo.modelo.Calidad;

/**
 * @author Luis-Albarracin
 *
 */
public interface CalidadDao {
	public void insertar(Calidad objeto) throws SQLException;

	public Calidad buscar(Integer id);

	public List<Calidad> selectAll();

	public void eliminar(Integer id) throws SQLException;

	public void actualizar(Calidad objeto) throws SQLException;
}
