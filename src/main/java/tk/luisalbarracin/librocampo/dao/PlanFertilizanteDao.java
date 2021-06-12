/**
 * 
 */
package tk.luisalbarracin.librocampo.dao;

import java.sql.SQLException;
import java.util.List;

import tk.luisalbarracin.librocampo.modelo.PlanFertilizante;

/**
 * @author luis-albarracin
 *
 */
public interface PlanFertilizanteDao {
	public void insertar(PlanFertilizante objeto) throws SQLException;
	public PlanFertilizante buscar(Integer id);
	public List<PlanFertilizante> selectAll();
	public void eliminar(Integer id) throws SQLException;
	public void actualizar(PlanFertilizante objeto) throws SQLException;
}
