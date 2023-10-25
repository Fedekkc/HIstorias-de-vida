package dao_fuerzas;
import java.sql.*;
import java.util.ArrayList;

public class Dao_Fuerzas {
    private final String url = "jdbc:mysql://localhost:3306/CCDTyE";
    private final String usuario = "root";
    private final String contrasenia = "root";
	
	
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
	
	
}
