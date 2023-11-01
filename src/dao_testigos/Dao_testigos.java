package dao_testigos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Testigo;

public class Dao_testigos {

    private final String url = "jdbc:mysql://localhost:3306/CCDTyE";
    private final String usuario = "root";
    private final String contrasenia = "admin";

    public void addTestigo(Testigo testigo) {
        int filasAfectadas = 0;
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            System.out.println("[+] Creando testigo en la Base de datos");
            String query = "INSERT INTO `Testigos` (`Nombre`,`DNI`, `Testimonio`) VALUES (?,?,?)";
            PreparedStatement pStmt = conn.prepareStatement(query);
            pStmt.setString(1, testigo.getNombre());
            pStmt.setString(2, testigo.getDNI());
            pStmt.setString(3, testigo.getTestimonio());
            filasAfectadas = pStmt.executeUpdate();
            if (filasAfectadas == 1) {
                System.out.println("Testigo registrado correctamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Testigo getTestigo(String DNI) {
        Testigo testigo = null;
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            System.out.println("[+] Obteniendo testigo de la Base de datos");
            String query = "SELECT * FROM  `Testigos` WHERE `DNI` = ?";
            PreparedStatement pStmt = conn.prepareStatement(query);
            pStmt.setString(1, DNI);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                String nombreTestigo = rs.getString("Nombre");
                String dni = rs.getString("DNI");
                String testimonio = rs.getString("Testimonio");
                testigo = new Testigo(nombreTestigo, dni, testimonio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return testigo;
    }

    public void deleteTestigo(String DNI) {
        int filasAfectadas = 0;
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            System.out.println("[+] Eliminando testigo de la base de datos");
            String query = "DELETE FROM Testigos WHERE DNI = ?";
            PreparedStatement pStmt = conn.prepareStatement(query);
            pStmt.setString(1, DNI);
            filasAfectadas = pStmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Testigo eliminado correctamente");
            } else {
                System.out.println("No se encontró ningún testigo con el DNI especificado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTestigo(Testigo testigo) {
        int filasAfectadas = 0;
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            System.out.println("[+] Actualizando testigo en la base de datos");
            String query = "UPDATE Testigos SET Nombre = ?, Testimonio = ? WHERE DNI = ?";
            PreparedStatement pStmt = conn.prepareStatement(query);
            pStmt.setString(1, testigo.getNombre());
            pStmt.setString(2, testigo.getTestimonio());
            pStmt.setString(3, testigo.getDNI());
            filasAfectadas = pStmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Testigo actualizado correctamente");
            } else {
                System.out.println("No se encontró ningún testigo con el DNI especificado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
