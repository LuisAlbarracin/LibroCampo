/**
 * 
 */
package tk.luisalbarracin.librocampo.dao;

import java.sql.SQLException;
import java.util.List;

import tk.luisalbarracin.librocampo.modelo.CultivoPlan;

/**
 * @author luis-albarracin
 *
 */
public interface CultivoPlanDao {
	public void insertar(CultivoPlan objeto) throws SQLException;
	public CultivoPlan buscar(Integer id);
	public List<CultivoPlan> selectAll();
	public void eliminar(Integer id) throws SQLException;
	public void actualizar(CultivoPlan objeto) throws SQLException;
	public List<CultivoPlan> selectByCultivo(Integer byCultivo);
	public List<CultivoPlan> selectByPlan(Integer byPlan);
	public List<CultivoPlan> selectByAnio(Integer byAnio);
	public List<CultivoPlan> selectByMes(Integer byMes);
}
