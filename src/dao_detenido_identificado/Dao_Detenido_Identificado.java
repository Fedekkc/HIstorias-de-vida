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
            String query = "SELECT * FROM Detenidos_Identificados INNER JOIN Lugares_de_secuestro On Detenidos_Identificados.ID_Lugar_de_secuestro = Lugares_de_secuestro.ID_Lugar";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nombre = resultSet.getString("Nombre");
                String DNI = resultSet.getString("DNI");
                int lugarDeSecuestro = resultSet.getInt("Lugares_de_secuestro.ID_Lugar");
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
    public void addDetenidoIdentificado(DetenidoIdentificado detenido) {
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            String query = "INSERT INTO Detenidos_Identificados (Nombre, DNI, ID_Lugar_de_secuestro, Ultima_vez_visto, Biografia_personal, Ruta_material_audiovisual, Tiempo_en_cautiverio, Sobrevivio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pStmt = conn.prepareStatement(query);
            pStmt.setString(1, detenido.getNombre());
            pStmt.setString(2, detenido.getDNI());
            pStmt.setInt(3, detenido.getLugarSecuestro());
            pStmt.setDate(4, java.sql.Date.valueOf(detenido.getUltVezVisto()));
            pStmt.setString(5, detenido.getBiografiaPersonal());
            pStmt.setString(6, detenido.getRutaMaterialAudiovisual());
            pStmt.setInt(7, detenido.getTiempoEnCautiverio());
            pStmt.setBoolean(8, detenido.getSobrevivio());
            pStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDetenidoIdentificado(int idPersona) {
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            String query = "DELETE FROM Detenidos_Identificados WHERE ID_Persona = ?";
            PreparedStatement pStmt = conn.prepareStatement(query);
            pStmt.setInt(1, idPersona);
            pStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDetenidoIdentificado(DetenidoIdentificado detenido) {
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            String query = "UPDATE Detenidos_Identificados SET Nombre = ?, DNI = ?, ID_Lugar_de_secuestro = ?, Ultima_vez_visto = ?, Biografia_personal = ?, Ruta_material_audiovisual = ?, Tiempo_en_cautiverio = ?, Sobrevivio = ? WHERE DNI = ?";
            PreparedStatement pStmt = conn.prepareStatement(query);
            pStmt.setString(1, detenido.getNombre());
            pStmt.setString(2, detenido.getDNI());
            pStmt.setInt(3, detenido.getLugarSecuestro());
            pStmt.setDate(4, java.sql.Date.valueOf(detenido.getUltVezVisto()));
            pStmt.setString(5, detenido.getBiografiaPersonal());
            pStmt.setString(6, detenido.getRutaMaterialAudiovisual());
            pStmt.setInt(7, detenido.getTiempoEnCautiverio());
            pStmt.setBoolean(8, detenido.getSobrevivio());
            pStmt.setString(9, detenido.getDNI()); // O cualquier otro campo que sea único en tu base de datos
            pStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DetenidoIdentificado getDetenidoIdentificado(int idPersona) {
        DetenidoIdentificado detenido = null;
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            String query = "SELECT * FROM Detenidos_Identificados WHERE ID_Persona = ?";
            PreparedStatement pStmt = conn.prepareStatement(query);
            pStmt.setInt(1, idPersona);
            ResultSet rs = pStmt.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("Nombre");
                String DNI = rs.getString("DNI");
                int lugarDeSecuestro = rs.getInt("ID_Lugar_de_secuestro");
                LocalDate ultimaVezVisto = rs.getDate("Ultima_vez_visto").toLocalDate();
                String biografiaPersonal = rs.getString("Biografia_personal");
                String rutaMaterialAudiovisual = rs.getString("Ruta_material_audiovisual");
                int tiempoEnCautiverio = rs.getInt("Tiempo_en_cautiverio");
                boolean sobrevivio = rs.getBoolean("Sobrevivio");

                detenido = new DetenidoIdentificado();
                detenido.setNombre(nombre);
                detenido.setDNI(DNI);
                detenido.setLugarSecuestro(lugarDeSecuestro);
                detenido.setUltVezVisto(ultimaVezVisto);
                detenido.setBiografiaPersonal(biografiaPersonal);
                detenido.setRutaMaterialAudiovisual(rutaMaterialAudiovisual);
                detenido.setTiempoEnCautiverio(tiempoEnCautiverio);
                detenido.setSobrevivio(sobrevivio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detenido;
    }
    
    public String getLugarDeSecuestro(DetenidoIdentificado dt) {
    	String lugar = "";
    	try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            String query = "SELECT * FROM Detenidos_Identificados INNER JOIN Lugares_de_secuestro ON Detenidos_Identificados.ID_Lugar_de_secuestro = Lugares_de_secuestro.ID_Lugar WHERE ID_Detenido_Identificado = ?";
            PreparedStatement pStmt = conn.prepareStatement(query);
            pStmt.setInt(1, dt.getLugarSecuestro());
            ResultSet rs = pStmt.executeQuery();
            if (rs.next()) {
            	lugar = rs.getString("Lugares_de_secuestro.Nombre");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	return lugar;
    }
}
