package com.rm.rectificadoraMundial.repositorio;


import java.sql.*;

import com.rm.rectificadoraMundial.config.DatabaseConfig;
import com.rm.rectificadoraMundial.modelo.Usuario;

public class UsuarioRepository {

    public Usuario obtenerPorId(int id) {
        Usuario usuario = null;

        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setNumeroCelular(rs.getString("numero_celular"));
                usuario.setCedula(rs.getString("cedula"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setIdRol(rs.getInt("id_rol"));
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores
        }

        return usuario;
    }
    
    public Usuario obtenerPorCedula(String cedula) {
        Usuario usuario = null;

        String sql = "SELECT * FROM usuarios WHERE cedula = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cedula);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setNumeroCelular(rs.getString("numero_celular"));
                usuario.setCedula(rs.getString("cedula"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setIdRol(rs.getInt("id_rol"));
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores
        }

        return usuario;
    }

    public boolean insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, correo, numero_celular, cedula, contraseña, id_rol) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getNumeroCelular());
            stmt.setString(4, usuario.getCedula());
            stmt.setString(5, usuario.getContraseña());
            stmt.setInt(6, usuario.getIdRol());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}