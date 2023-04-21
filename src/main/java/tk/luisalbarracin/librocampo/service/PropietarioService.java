package tk.luisalbarracin.librocampo.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tk.luisalbarracin.librocampo.dao.FincaDao;
import tk.luisalbarracin.librocampo.dao.PropietarioDao;
import tk.luisalbarracin.librocampo.modelo.Finca;
import tk.luisalbarracin.librocampo.modelo.Propietario;

public class PropietarioService {
	
	private PropietarioDao propietarioDao;
	private FincaDao fincaDao;
	
	public PropietarioService() {
		
	}
	
	public Boolean guardarPropietario(Propietario propietario) {
		try {
			this.propietarioDao.insertar(propietario);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public List<Propietario> mostrarPropietarios() {
		List<Propietario> propietarios = new ArrayList<>();
		for(Propietario propietario: this.mostrarPropietarios()) {
			List<Finca> fincas = this.fincaDao.selectByPropietario(propietario.getId());
			propietario.setFincas(fincas);
			propietarios.add(propietario);
		}
		return propietarios;
	}
	
	public Boolean borrarPropietario(Integer id) {
		try {
			this.propietarioDao.eliminar(id);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public Propietario buscarPropietario(Integer id) {
		Propietario propietario;
		propietario = this.propietarioDao.buscar(id);
		List<Finca> fincas = this.fincaDao.selectByPropietario(propietario.getId());
		propietario.setFincas(fincas);
		return propietario;
	}
	
	public Boolean actualizarPropietario(Propietario propietario) {
		Boolean isUpdate = this.actualizarPropietario(propietario);
		return isUpdate;
	}

}
