/**
 * 
 */
package tk.luisalbarracin.librocampo.dao;

import java.sql.SQLException;
import java.util.List;

import tk.luisalbarracin.librocampo.modelo.Propietario;

/**
 * @author luis-albarracin
 *
 */
public interface PropietarioDao {
	public void insertar(Propietario propietario) throws SQLException;
	public void registrar(Propietario propietario) throws SQLException;
	public Propietario buscar(Integer id);
	public List<Propietario> selectAll();
	public void eliminar(Integer id) throws SQLException;
	public void actualizar(Propietario propietario) throws SQLException;
	public Integer login(String email, String contrasenia);
}
