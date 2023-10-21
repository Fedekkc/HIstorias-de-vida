package dao_testigos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Testigo;

public class Dao_testigos {

	public void addTestigo(Testigo testigo) {
		String url = "jdbc:mysql://localhost:3306/CCDTyE";
		String usuario = "root";
		String contrasenia = "root";
		int filasAfectadas = 0;
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, usuario, contrasenia);
			System.out.println("[+] Creando persona en la Base de datos");
			PreparedStatement pStmt = conn.prepareStatement("INSERT INTO `Testigos` (`Nombre`,`DNI`, `Testimonio`) VALUES (?,?,?)");
			pStmt.setString(1, testigo.getNombre());
			pStmt.setString(2, testigo.getDNI());
			pStmt.setString(3, testigo.getTestimonio());

			filasAfectadas = pStmt.executeUpdate();
			if(filasAfectadas == 1)
			{
				System.out.println("Testigo registrado correctamente");
			}

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
		
	}
	
	public Testigo getTestigo(String DNI)
	{
		String url = "jdbc:mysql://localhost:3306/CCDTyE";
		String usuario = "root";
		String contrasenia = "root";
		Testigo testigo = null;		
		Connection conn = null;
		
		
		try {
			conn = DriverManager.getConnection(url, usuario, contrasenia);
			System.out.println("[+] Obteniendo persona de la Base de datos");
			PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM  `Testigos` WHERE `DNI` = `?` ");
			pStmt.setString(1,DNI);
			ResultSet rs = pStmt.executeQuery();

			
			while(rs.next())
			{
	            String nombreTestigo = rs.getString("Nombre");
	            String dni = rs.getString("DNI");
	            String testimonio = rs.getString("Testimonio");
	            testigo = new Testigo(nombreTestigo, dni, testimonio);
			}

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
		return testigo;
		
	}
	
	public void deleteTestigo(String DNI) {
	    String url = "jdbc:mysql://localhost:3306/CCDTyE";
	    String usuario = "root";
	    String contrasenia = "root";
	    int filasAfectadas = 0;
	    Connection conn = null;
	    
	    try {
	        conn = DriverManager.getConnection(url, usuario, contrasenia);
	        System.out.println("[+] Eliminando registro de la base de datos");
	        PreparedStatement pStmt = conn.prepareStatement("DELETE FROM Testigos WHERE DNI = ?");
	        pStmt.setString(1, DNI);
	        filasAfectadas = pStmt.executeUpdate();
	        if (filasAfectadas > 0) {
	            System.out.println("Testigo eliminado correctamente");
	        } else {
	            System.out.println("No se encontró ningún testigo con el nombre especificado.");
	        }

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
	}
	
	public void updateTestigo(Testigo testigo) {
	    String url = "jdbc:mysql://localhost:3306/CCDTyE";
	    String usuario = "root";
	    String contrasenia = "root";
	    int filasAfectadas = 0;
	    Connection conn = null;
	    try {
	        conn = DriverManager.getConnection(url, usuario, contrasenia);
	        System.out.println("[+] Actualizando registro de la base de datos");
	        PreparedStatement pStmt = conn.prepareStatement("UPDATE Testigos SET DNI = ?, Testimonio = ? WHERE Nombre = ?");
	        pStmt.setString(1, testigo.getDNI());
	        pStmt.setString(2, testigo.getTestimonio());
	        pStmt.setString(3, testigo.getNombre());

	        filasAfectadas = pStmt.executeUpdate();
	        if (filasAfectadas > 0) {
	            System.out.println("Testigo actualizado correctamente");
	        } else {
	            System.out.println("No se encontró ningún testigo con el nombre especificado.");
	        }

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
	}


	
	
	
	
	
}
	
	
