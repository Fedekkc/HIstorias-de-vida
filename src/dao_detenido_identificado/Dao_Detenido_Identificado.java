package dao_detenido_identificado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import entidades.DetenidoIdentificado;

public class Dao_Detenido_Identificado {
	private final String url = "jdbc:mysql://localhost:3306/CCDTyE";
    private final String usuario = "root";
    private final String contrasenia = "root";
    
    public ArrayList<DetenidoIdentificado> getAllDetenidos_Identificados() {
        ArrayList<DetenidoIdentificado> listaDetenidoIdentificado = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            String query = "SELECT * FROM Detenidos_Identificados";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nombre = resultSet.getString("Nombre");
                String DNI = resultSet.getString("DNI");
                String lugarDeSecuestro = resultSet.getString("Lugar_de_secuestro");
                LocalDate ultimaVezVisto = resultSet.getDate("Ultima_vez_visto").toLocalDate();
                
                int ID = resultSet.getInt("ID_CCDTyE");

                // Obteniendo las fuerzas al mando
                String queryFuerzas = "SELECT Fuerzas_id FROM CCDTyE_Fuerzas WHERE CCDTyE_id = ?";
                PreparedStatement preparedStatementFuerzas = conn.prepareStatement(queryFuerzas);
                preparedStatementFuerzas.setInt(1, ID);
                ResultSet rsFuerzas = preparedStatementFuerzas.executeQuery();
                while (rsFuerzas.next()) {
                    fuerzas.add(rsFuerzas.getInt("Fuerzas_id"));
                }

                DetenidoIdentificado ccdTyE = new DetenidoIdentificado();
                DetenidoIdentificado.setNombre(nombre);

                listaCCDTyE.add(ccdTyE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCCDTyE;
    }
}
