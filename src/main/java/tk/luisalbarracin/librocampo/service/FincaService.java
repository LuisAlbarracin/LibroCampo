package tk.luisalbarracin.librocampo.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tk.luisalbarracin.librocampo.dao.CultivoDao;
import tk.luisalbarracin.librocampo.dao.FincaDao;
import tk.luisalbarracin.librocampo.modelo.Cultivo;
import tk.luisalbarracin.librocampo.modelo.Finca;

public class FincaService {
	
	private FincaDao fincaDao;
	private CultivoDao cultivoDao;
	
	public Boolean registrar(Finca finca) {
		try {
			this.fincaDao.insertar(finca);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public Finca buscar(Integer id) {
		Finca finca = this.fincaDao.buscar(id);
		List<Cultivo> cultivos = this.cultivoDao.selectByFinca(finca.getId());
		finca.setCultivos(cultivos);
		return finca;
	}
	
	public Boolean actualizar(Finca finca) {
		try {
			this.fincaDao.actualizar(finca);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public List<Finca> mostrar(){
		List<Finca> fincas = new ArrayList<>();
		for(Finca finca: this.fincaDao.selectAll()) {
			List<Cultivo> cultivos = this.cultivoDao.selectByFinca(finca.getId());
			finca.setCultivos(cultivos);
			fincas.add(finca);
		}
		return fincas;
	}
	
	public Boolean eliminar(Integer id) {
		try {
			this.fincaDao.eliminar(id);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

}
