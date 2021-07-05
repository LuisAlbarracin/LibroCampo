/**
 * 
 */
package tk.luisalbarracin.librocampo.dao;

import java.sql.SQLException;
import java.util.List;

import tk.luisalbarracin.librocampo.modelo.Cultivo;

/**
 * @author luis-albarracin
 *
 */
public interface CultivoDao {
	public void insertar(Cultivo objeto) throws SQLException;
	public Cultivo buscar(Integer id);
	public List<Cultivo> selectAll();
	public void eliminar(Integer id) throws SQLException;
	public void actualizar(Cultivo objeto) throws SQLException;
	public List<Cultivo> selectByFinca(Integer cultivoFinca);
}
