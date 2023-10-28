package dao_ccdtye;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import entidades.CCDTyE;
import entidades.Fuerza;

public class Dao_CCDTyE {
    private final String url = "jdbc:mysql://localhost:3306/CCDTyE";
    private final String usuario = "root";
    private final String contrasenia = "root";

    public void addCCDTyE(CCDTyE ccdTyE) {
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            String query = "INSERT INTO CCDTyE (Nombre, Ubicacion, Fecha_puesta_en_marcha, Fecha_de_cierre) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, ccdTyE.getNombre());
            preparedStatement.setString(2, ccdTyE.getUbicacion());
            preparedStatement.setObject(3, ccdTyE.getFechaPuestaEnMarcha());
            preparedStatement.setObject(4, ccdTyE.getFechaCierre());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CCDTyE getCCDTyE(int id) {
        CCDTyE ccdTyE = null;
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            String query = "SELECT * FROM CCDTyE WHERE ID_CCDTyE = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nombre = resultSet.getString("Nombre");
                String ubicacion = resultSet.getString("Ubicacion");
                LocalDate fechaPuestaEnMarcha = resultSet.getDate("Fecha_puesta_en_marcha").toLocalDate();
                LocalDate fechaCierre = resultSet.getDate("Fecha_de_cierre").toLocalDate();
                ArrayList<Fuerza> fuerzas = new ArrayList<>();
                int ID = resultSet.getInt("ID_CCDTyE");
                ccdTyE = new CCDTyE();
                ccdTyE.setNombre(nombre);
                ccdTyE.setUbicacion(ubicacion);
                ccdTyE.setFechaPuestaEnMarcha(fechaPuestaEnMarcha);
                ccdTyE.setFechaCierre(fechaCierre);
                ccdTyE.setFuerzasAlMando(fuerzas);
                ccdTyE.setID(ID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ccdTyE;
    }

    public void updateCCDTyE(CCDTyE ccdTyE) {
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            String query = "UPDATE CCDTyE SET Nombre = ?, Ubicacion = ?, Fecha_puesta_en_marcha = ?, Fecha_de_cierre = ? WHERE ID_CCDTyE = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, ccdTyE.getNombre());
            preparedStatement.setString(2, ccdTyE.getUbicacion());
            preparedStatement.setObject(3, ccdTyE.getFechaPuestaEnMarcha());
            preparedStatement.setObject(4, ccdTyE.getFechaCierre());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCCDTyE(int id) {
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            String query = "DELETE FROM CCDTyE WHERE ID_CCDTyE = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<CCDTyE> getAllCCDTyE() {
        ArrayList<CCDTyE> listaCCDTyE = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            String query = "SELECT * FROM CCDTyE";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nombre = resultSet.getString("Nombre");
                String ubicacion = resultSet.getString("Ubicacion");
                LocalDate fechaPuestaEnMarcha = resultSet.getDate("Fecha_puesta_en_marcha").toLocalDate();
                LocalDate fechaCierre = resultSet.getDate("Fecha_de_cierre").toLocalDate();
                ArrayList<Fuerza> fuerzas = new ArrayList<>();
                int ID = resultSet.getInt("ID_CCDTyE");
                CCDTyE ccdTyE = new CCDTyE();
                ccdTyE.setNombre(nombre);
                ccdTyE.setUbicacion(ubicacion);
                ccdTyE.setFechaPuestaEnMarcha(fechaPuestaEnMarcha);
                ccdTyE.setFechaCierre(fechaCierre);
                ccdTyE.setFuerzasAlMando(fuerzas);
                ccdTyE.setID(ID);
                
                listaCCDTyE.add(ccdTyE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCCDTyE;
    }
}
