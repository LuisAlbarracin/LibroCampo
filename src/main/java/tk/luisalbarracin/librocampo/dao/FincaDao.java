/**
 * 
 */
package tk.luisalbarracin.librocampo.dao;

import java.sql.SQLException;
import java.util.List;

import tk.luisalbarracin.librocampo.modelo.Finca;

/**
 * @author luis-albarracin
 *
 */
public interface FincaDao {
	public void insertar(Finca objeto) throws SQLException;
	public Finca buscar(Integer id);
	public List<Finca> selectAll();
	public void eliminar(Integer id) throws SQLException;
	public void actualizar(Finca objeto) throws SQLException;
}
