/**
 * 
 */
package tk.luisalbarracin.librocampo.dao;

import java.sql.SQLException;
import java.util.List;

import tk.luisalbarracin.librocampo.modelo.Asociacion;

/**
 * @author Luis-Albarracin
 *
 */
public interface AsociacionDao {
	public void insertar(Asociacion asociacion) throws SQLException;

	public Asociacion buscar(Integer id);

	public List<Asociacion> selectAll();

	public void eliminar(Integer id) throws SQLException;

	public void actualizar(Asociacion objeto) throws SQLException;
}
