/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author cristian.barquero
 */
import modelo.Conexion;
 import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LectorDAO {

    public boolean agregarLector(Lector lector) {
        String sql = "INSERT INTO lectores (nombre, email) VALUES (?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, lector.getNombre());
            ps.setString(2, lector.getEmail());
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Lector> listarLectores() {
        List<Lector> lectores = new ArrayList<>();
        String sql = "SELECT * FROM lectores";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Lector lector = new Lector(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("email")
                );
                lectores.add(lector);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lectores;
    }

    // Puedes agregar editar y eliminar de forma similar.
}
