package dao_detenido_identificado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.DetenidoNoIdentificado;

public class Dao_Detenido_No_Identificado {

    private final String url = "jdbc:mysql://localhost:3306/CCDTyE";
    private final String usuario = "root";
    private final String contrasenia = "admin";

    
    
    public ArrayList<DetenidoNoIdentificado> getAllDetenidoNoIdentificado() {
        ArrayList<DetenidoNoIdentificado> detenidosNoIdentificados = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            System.out.println("[+] Obteniendo todos los detenidos no identificados de la Base de Datos");
            String query = "SELECT * FROM `Detenidos_No_Identificados`";
            PreparedStatement pStmt = conn.prepareStatement(query);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {

                String apodo = rs.getString("Apodo");
                String descripcion = rs.getString("Descripcion_significativa");
                int id_testigo = rs.getInt("ID_Testigo");
                DetenidoNoIdentificado detenidoNoIdentificado = new DetenidoNoIdentificado(apodo, descripcion,id_testigo);
                detenidosNoIdentificados.add(detenidoNoIdentificado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detenidosNoIdentificados;
    }
    
    public int getIdDetenidoByIdTestigo(int idTestigo) {
        int detenidoID = -1; // Inicializar a un valor que indique que no se encontró ningún ID
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            System.out.println("[+] Obteniendo ID del detenido no identificado por ID de Testigo");
            String query = "SELECT ID_Detenido_No_Identificado FROM `Detenidos_No_Identificados` WHERE `ID_Testigo` = ?";
            PreparedStatement pStmt = conn.prepareStatement(query);
            pStmt.setInt(1, idTestigo);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                detenidoID = rs.getInt("ID_Detenido_No_Identificado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detenidoID;
    }

    
    
    
    public void addDetenidoNoIdentificado(DetenidoNoIdentificado detenidoNoIdentificado) {
        int filasAfectadas = 0;
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            System.out.println("[+] Añadiendo detenido no identificado a la Base de Datos");
            String query = "INSERT INTO `Detenidos_No_Identificados` (`Apodo`, `Descripcion_significativa`, `ID_Testigo`) VALUES (?,?,?)";
            PreparedStatement pStmt = conn.prepareStatement(query);
            pStmt.setString(1, detenidoNoIdentificado.getApodo());
            pStmt.setString(2, detenidoNoIdentificado.getDescripcionSignificativa());
            pStmt.setInt(3, detenidoNoIdentificado.getIdTestigo());
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
            String query = "SELECT * FROM `Detenidos_No_Identificados` WHERE `ID_Detenido_No_Identificado` = ?";
            PreparedStatement pStmt = conn.prepareStatement(query);
            pStmt.setInt(1, idPersona);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                String apodo = rs.getString("Apodo");
                String descripcion = rs.getString("Descripcion_significativa");
                int id_testigo = rs.getInt("ID_Testigo");
                detenidoNoIdentificado = new DetenidoNoIdentificado(apodo, descripcion,id_testigo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detenidoNoIdentificado;
    }

    public void deleteDetenidoNoIdentificado(DetenidoNoIdentificado dt) {
        int filasAfectadas = 0;
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            System.out.println("[+] Eliminando detenido no identificado de la base de datos");
            String query = "DELETE FROM Detenidos_No_Identificados WHERE ID_Detenido_No_Identificado = ?";
            PreparedStatement pStmt = conn.prepareStatement(query);
            pStmt.setInt(1, getIdDetenidoNoIdentificado(dt.getApodo()));
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

    public void updateDetenidoNoIdentificado(int id, DetenidoNoIdentificado detenidoNoIdentificado) {
        int filasAfectadas = 0;
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            System.out.println("[+] Actualizando detenido no identificado en la base de datos");
            String query = "UPDATE Detenidos_No_Identificados SET Apodo = ?, Descripcion_significativa = ?, ID_Testigo = ? WHERE ID_Detenido_No_Identificado = ?";
            PreparedStatement pStmt = conn.prepareStatement(query);
            pStmt.setString(1, detenidoNoIdentificado.getApodo());
            pStmt.setString(2, detenidoNoIdentificado.getDescripcionSignificativa());
            pStmt.setInt(3, detenidoNoIdentificado.getIdTestigo());
            pStmt.setInt(4,id);
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
    
    public int getIdDetenidoNoIdentificado(String nombreDetenido) {
        int idDetenido = -1; // Valor predeterminado en caso de que no se encuentre el detenido

        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            String query = "SELECT ID_Detenido_No_Identificado FROM Detenidos_No_Identificados WHERE Apodo = ?";
            PreparedStatement pStmt = conn.prepareStatement(query);
            pStmt.setString(1, nombreDetenido);
            ResultSet rs = pStmt.executeQuery();

            if (rs.next()) {
                idDetenido = rs.getInt("ID_Detenido_No_Identificado");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idDetenido;
    }
}
