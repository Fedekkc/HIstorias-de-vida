package dao_ccdtye;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dao_CCDTyE {

	public boolean guardar() {
		String url = "jdbc:mysql://localhost:3306/CCDTyE";
		String usuario = "root";
		String contrasenia = "root";
		Connection conn = null;
		int filasAfectas = 0;
		try {
			conn = DriverManager.getConnection(url, usuario, contrasenia);
			System.out.println("Conexion exitosa");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return filasAfectas == 1;
	}

	
}
