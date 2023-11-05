package dao_ccdtye;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import entidades.CCDTyE;
import entidades.Fuerza;

public class Dao_CCDTyE {
    private final String url = "jdbc:mysql://localhost:3306/CCDTyE";
    private final String usuario = "root";
    private final String contrasenia = "root";

    public void addCCDTyE(CCDTyE ccdTyE) {
    	ArrayList<Integer> fuerzaAlMando = ccdTyE.getFuerzasAlMando();

        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            String query = "INSERT INTO CCDTyE (Nombre, Ubicacion, Fecha_puesta_en_marcha, Fecha_de_cierre) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, ccdTyE.getNombre());
            preparedStatement.setString(2, ccdTyE.getUbicacion());
            preparedStatement.setObject(3, ccdTyE.getFechaPuestaEnMarcha());
            preparedStatement.setObject(4, ccdTyE.getFechaCierre());
            preparedStatement.executeUpdate( );
            
            ResultSet rs = preparedStatement.getGeneratedKeys();
            int last_inserted_id = 0;
            if(rs.next())
            {
				last_inserted_id = rs.getInt(1);
            }

            for (int i = 0; i <= fuerzaAlMando.size() - 1; i++) {
        		String query2 = "INSERT INTO CCDTyE_Fuerzas (CCDTyE_id, Fuerzas_id) VALUES (?, ?)";
                PreparedStatement preparedStatement2 = conn.prepareStatement(query2);
                preparedStatement2.setInt(1, last_inserted_id);
                preparedStatement2.setInt(2, fuerzaAlMando.get(i));
                preparedStatement2.executeUpdate();
        	}
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
                ArrayList<Integer> fuerzas = new ArrayList<>();
                int ID = resultSet.getInt("ID_CCDTyE");

                // Obteniendo las fuerzas al mando
                String queryFuerzas = "SELECT Fuerzas_id FROM CCDTyE_Fuerzas WHERE CCDTyE_id = ?";
                PreparedStatement preparedStatementFuerzas = conn.prepareStatement(queryFuerzas);
                preparedStatementFuerzas.setInt(1, id);
                ResultSet rsFuerzas = preparedStatementFuerzas.executeQuery();
                while (rsFuerzas.next()) {
                    fuerzas.add(rsFuerzas.getInt("Fuerzas_id"));
                }

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
            preparedStatement.setInt(5, ccdTyE.getID());
            preparedStatement.executeUpdate();

            // Actualizar la tabla CCDTyE_Fuerzas
            String deleteFuerzasQuery = "DELETE FROM CCDTyE_Fuerzas WHERE CCDTyE_id = ?";
            PreparedStatement deleteStatement = conn.prepareStatement(deleteFuerzasQuery);
            deleteStatement.setInt(1, ccdTyE.getID());
            deleteStatement.executeUpdate();

            for (int fuerza : ccdTyE.getFuerzasAlMando()) {
                String insertFuerzasQuery = "INSERT INTO CCDTyE_Fuerzas (CCDTyE_id, Fuerzas_id) VALUES (?, ?)";
                PreparedStatement insertStatement = conn.prepareStatement(insertFuerzasQuery);
                insertStatement.setInt(1, ccdTyE.getID());
                insertStatement.setInt(2, fuerza);
                insertStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCCDTyE(int id) {
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasenia)) {
            // Eliminar las referencias en CCDTyE_Fuerzas
            String deleteFuerzasQuery = "DELETE FROM CCDTyE_Fuerzas WHERE CCDTyE_id = ?";
            PreparedStatement deleteStatement = conn.prepareStatement(deleteFuerzasQuery);
            deleteStatement.setInt(1, id);
            deleteStatement.executeUpdate();

            // Eliminar la entrada correspondiente en CCDTyE
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
                ArrayList<Integer> fuerzas = new ArrayList<>();
                int ID = resultSet.getInt("ID_CCDTyE");

                // Obteniendo las fuerzas al mando
                String queryFuerzas = "SELECT Fuerzas_id FROM CCDTyE_Fuerzas WHERE CCDTyE_id = ?";
                PreparedStatement preparedStatementFuerzas = conn.prepareStatement(queryFuerzas);
                preparedStatementFuerzas.setInt(1, ID);
                ResultSet rsFuerzas = preparedStatementFuerzas.executeQuery();
                while (rsFuerzas.next()) {
                    fuerzas.add(rsFuerzas.getInt("Fuerzas_id"));
                }

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