/**
 * 
 */
package tk.luisalbarracin.librocampo.dao;

import java.sql.SQLException;
import java.util.List;

import tk.luisalbarracin.librocampo.modelo.Cosecha;

/**
 * @author luis-albarracin
 *
 */
public interface CosechaDao {
	public void insertar(Cosecha objeto) throws SQLException;
	public Cosecha buscar(Integer id);
	public List<Cosecha> selectAll();
	public void eliminar(Integer id) throws SQLException;
	public void actualizar(Cosecha objeto) throws SQLException;
	public List<Cosecha> selectByCultivo(Integer cosechaCultivo);
}
