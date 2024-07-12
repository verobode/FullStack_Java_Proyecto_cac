/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Suscripcion;

/**
 *
 * @author Vero
 */
public class SuscripcionDAO {
    
    public boolean crearSuscripcion(Suscripcion suscriptor) {
        String sql = "INSERT INTO suscriptores (email) VALUES (?)";

        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, suscriptor.getEmail());

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
