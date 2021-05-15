package tk.luisalbarracin.librocampo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionMySQL {

	private Connection con = null;
	private static ConexionMySQL db;
	private PreparedStatement preparedStatement;

	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String DBNAME = "libro_campo";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";

	private ConexionMySQL() {

			try {
				Class.forName(DRIVER);
				this.con = (Connection) DriverManager.getConnection(URL + DBNAME, USERNAME, PASSWORD);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	public void cerrarConexion() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ConexionMySQL getConexion() {
		if (db == null) {
			db = new ConexionMySQL();
		}

		return db;
	}

	public ResultSet query() throws SQLException {
		ResultSet res = preparedStatement.executeQuery();
		return res;
	}

	public int execute() throws SQLException {
		int result = preparedStatement.executeUpdate();
		return result;
	}

	public Connection getCon() {
		return this.con;
	}

	public PreparedStatement setPreparedStatement(String sql)  {

			try {
				this.preparedStatement = con.prepareStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
	
			return this.preparedStatement;
	}
}
