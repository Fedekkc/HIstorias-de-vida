package dao_detenido_identificado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.DetenidoNoIdentificado;

public class Dao_Detenido_No_Identificado {

    private final String url = "jdbc:mysql://localhost:3306/CCDTyE";
    private final String usuario = "root";
    private final String contrasenia = "root";

    public void addDetenidoNoIdentificado(DetenidoNoIdentificado detenidoNoIdentificado) {
        int filasAfectadas = 0;
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            System.out.println("[+] Añadiendo detenido no identificado a la Base de Datos");
            String query = "INSERT INTO `Detenidos_No_Identificados` (`ID_Persona`, `Apodo`, `Descripcion_significativa`) VALUES (?,?,?)";
            PreparedStatement pStmt = conn.prepareStatement(query);
            pStmt.setInt(1, detenidoNoIdentificado.getIdPersona());
            pStmt.setString(2, detenidoNoIdentificado.getApodo());
            pStmt.setString(3, detenidoNoIdentificado.getDescripcionSignificativa());
            filasAfectadas = pStmt.executeUpdate();
            if (filasAfectadas == 1) {
                System.out.println("Detenido no identificado añadido correctamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DetenidoNoIdentificado getDetenidoNoIdentificado(int idPersona) {
        DetenidoNoIdentificado detenidoNoIdentificado = null;
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            System.out.println("[+] Obteniendo detenido no identificado de la Base de Datos");
            String query = "SELECT * FROM `Detenidos_No_Identificados` WHERE `ID_Persona` = ?";
            PreparedStatement pStmt = conn.prepareStatement(query);
            pStmt.setInt(1, idPersona);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_Persona");
                String apodo = rs.getString("Apodo");
                String descripcion = rs.getString("Descripcion_significativa");
                detenidoNoIdentificado = new DetenidoNoIdentificado(id, apodo, descripcion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detenidoNoIdentificado;
    }

    public void deleteDetenidoNoIdentificado(int idPersona) {
        int filasAfectadas = 0;
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            System.out.println("[+] Eliminando detenido no identificado de la base de datos");
            String query = "DELETE FROM Detenidos_No_Identificados WHERE ID_Persona = ?";
            PreparedStatement pStmt = conn.prepareStatement(query);
            pStmt.setInt(1, idPersona);
            filasAfectadas = pStmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Detenido no identificado eliminado correctamente");
            } else {
                System.out.println("No se encontró ningún detenido no identificado con el ID especificado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDetenidoNoIdentificado(DetenidoNoIdentificado detenidoNoIdentificado) {
        int filasAfectadas = 0;
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            System.out.println("[+] Actualizando detenido no identificado en la base de datos");
            String query = "UPDATE Detenidos_No_Identificados SET Apodo = ?, Descripcion_significativa = ? WHERE ID_Persona = ?";
            PreparedStatement pStmt = conn.prepareStatement(query);
            pStmt.setString(1, detenidoNoIdentificado.getApodo());
            pStmt.setString(2, detenidoNoIdentificado.getDescripcionSignificativa());
            pStmt.setInt(3, detenidoNoIdentificado.getIdPersona());
            filasAfectadas = pStmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Detenido no identificado actualizado correctamente");
            } else {
                System.out.println("No se encontró ningún detenido no identificado con el ID especificado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
