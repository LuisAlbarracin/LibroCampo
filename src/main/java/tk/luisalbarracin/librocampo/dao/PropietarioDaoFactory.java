package tk.luisalbarracin.librocampo.dao;

public class PropietarioDaoFactory {

	
	public static Dao getUsuarioDao(String type) {
		switch(type) {
		case "mysql":
			return new PropietarioDaoMySQL();
	
		default:
			return new PropietarioDaoMySQL();
		}
	}
}
