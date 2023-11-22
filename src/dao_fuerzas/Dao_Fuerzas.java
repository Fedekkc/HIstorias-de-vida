package dao_fuerzas;
import java.sql.*;
import java.util.ArrayList;

public class Dao_Fuerzas {
    private final String url = "jdbc:mysql://localhost:3306/CCDTyE";
    private final String usuario = "root";
    private final String contrasenia = "admin";
	
	
    public ArrayList<String> getAllFuerzas() {
        ArrayList<String> fuerzas = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            String query = "SELECT Nombre FROM Fuerzas";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                fuerzas.add(rs.getString("Nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return fuerzas;
    }
	
    
    
    public int getFuerzaID(String Nombre) {
    	int ID = 0;
    	try(Connection conn = DriverManager.getConnection(url,usuario,contrasenia)) {
    		String q = "SELECT ID_Fuerza FROM Fuerzas WHERE Nombre = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(q);
            preparedStatement.setString(1, Nombre);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                ID = rs.getInt("ID_Fuerza");
            }
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return ID;
    	
    }
    
    public String getFuerzaNombre(int id) {
        String nombre = "";
        try(Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            String q = "SELECT Nombre FROM Fuerzas WHERE ID_Fuerza = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(q);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                nombre = rs.getString("Nombre");
                System.out.println("ASD: " + nombre);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return nombre;
    }

    
}
