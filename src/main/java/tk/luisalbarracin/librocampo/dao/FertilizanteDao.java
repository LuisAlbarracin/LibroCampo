/**
 * 
 */
package tk.luisalbarracin.librocampo.dao;

import java.sql.SQLException;
import java.util.List;

import tk.luisalbarracin.librocampo.modelo.Fertilizante;

/**
 * @author luis-albarracin
 *
 */
public interface FertilizanteDao {
	public void insertar(Fertilizante objeto) throws SQLException;
	public Fertilizante buscar(Integer id);
	public List<Fertilizante> selectAll();
	public void eliminar(Integer id) throws SQLException;
	public void actualizar(Fertilizante objeto) throws SQLException;
}
