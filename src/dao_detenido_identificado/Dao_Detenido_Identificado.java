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
                String biografiaPersonal = resultSet.getString("Biografia_personal");
                String rutaMaterialAudiovisual = resultSet.getString("Ruta_material_audiovisual");
                int tiempoEnCautiverio = resultSet.getInt("Tiempo_en_cautiverio");
                boolean sobrevivio = resultSet.getBoolean("Sobrevivio");
                

                
                DetenidoIdentificado detenido = new DetenidoIdentificado();
                detenido.setNombre(nombre);
                detenido.setDNI(DNI);
                detenido.setLugarSecuestro(lugarDeSecuestro);
                detenido.setUltVezVisto(ultimaVezVisto);
                detenido.setBiografiaPersonal(biografiaPersonal);
                detenido.setRutaMaterialAudiovisual(rutaMaterialAudiovisual);
                detenido.setTiempoEnCautiverio(tiempoEnCautiverio);

                listaDetenidoIdentificado.add(detenido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDetenidoIdentificado;
    }
}
