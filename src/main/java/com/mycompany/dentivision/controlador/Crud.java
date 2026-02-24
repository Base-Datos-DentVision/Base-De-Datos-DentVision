package com.mycompany.dentivision.controlador;

import com.mycompany.dentivision.Configuracion.conexion;
import com.mycompany.dentivision.modelo.Usuarios;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Crud {

    private Usuarios modelo;

    // METODO CREATE
    public void Crear(Usuarios registrar) {
        String crear = "INSERT INTO Usuarios (tipo_documento, documento, nombres, apellidos, correo, confirmacion_correo, contrasena, confirmarcion_contrasena) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = conexion.getConexion();
                PreparedStatement ps = conn.prepareStatement(crear)) {

            ps.setString(1, registrar.getTipo_documento());
            ps.setInt(2, registrar.getDocumento());
            ps.setString(3, registrar.getNombres());
            ps.setString(4, registrar.getApellidos());
            ps.setString(5, registrar.getCorreo());
            ps.setString(6, registrar.getConfirmar_correo());
            ps.setString(7, registrar.getContrasena());
            ps.setString(8, registrar.getConfirmar_contrasena());

            ps.executeUpdate();
            System.out.println("Usuario registrado satisfactoriamente");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // METODO READ
    public List<Usuarios> leer() {
        List<Usuarios> lista = new ArrayList<>();
        String read = "SELECT * FROM Usuarios";

        try (Connection conn = conexion.getConexion();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(read)) {

            while (rs.next()) {
                lista.add(new Usuarios(
                        rs.getInt("documento"),
                        rs.getString("tipo_documento"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("correo")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // METODO READ POR DOCUMENTO
    public Usuarios buscarPorDocumento(int documento) {
        String sql = "SELECT * FROM Usuarios WHERE documento = ?";
        Usuarios usuario = null;

        try (Connection conn = conexion.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql)) { // <-- CORRECCIÓN AQUÍ

            ps.setInt(1, documento); // asigna parámetro
            try (ResultSet rs = ps.executeQuery()) { // Ejecuta la consulta
                if (rs.next()) {
                    usuario = new Usuarios();
                    usuario.setTipo_documento(rs.getString("tipo_documento"));
                    usuario.setDocumento(rs.getInt("documento"));
                    usuario.setNombres(rs.getString("nombres"));
                    usuario.setApellidos(rs.getString("apellidos"));
                    usuario.setCorreo(rs.getString("correo"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    // METODO UPDATE
    public void actualizar(Usuarios actualizar) {
        String update = "UPDATE Usuarios SET tipo_documento=?, nombres=?, apellidos=?, correo=?, contrasena=? WHERE documento=?";

        try (Connection conn = conexion.getConexion();
                PreparedStatement ps = conn.prepareStatement(update)) {

            ps.setString(1, actualizar.getTipo_documento());
            ps.setString(2, actualizar.getNombres());
            ps.setString(3, actualizar.getApellidos());
            ps.setString(4, actualizar.getCorreo());
            ps.setString(5, actualizar.getContrasena());
            ps.setInt(6, actualizar.getDocumento());

            ps.executeUpdate();
            System.out.println("Usuario actualizado satisfactoriamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // METODO DELETE
    public void delete(int documento) {
        String delete = "DELETE FROM Usuarios WHERE documento=?";

        try (Connection conn = conexion.getConexion();
                PreparedStatement ps = conn.prepareStatement(delete)) {

            ps.setInt(1, documento);
            ps.executeUpdate();
            System.out.println("Usuario Eliminado Exitosamente");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}