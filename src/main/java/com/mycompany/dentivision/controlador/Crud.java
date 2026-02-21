/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dentivision.controlador;

import com.mycompany.dentivision.Configuracion.conexion;
import com.mycompany.dentivision.modelo.registrar_usuarios;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Creyese23
 */
public class Crud {
    
    private registrar_usuarios modelo;
    
    
    //METODO CREATE
    public void Crear(registrar_usuarios registrar) {


        String crear = "INSERT INTO registro_usuarios (tipo_documento, documento, nombres, apellidos, correo, confirmacion_correo, contrasena, confirmarcion_contrasena) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = conexion.getConexion();
                PreparedStatement ps = conn.prepareStatement(crear)){
            ps.setInt(1, registrar.getDocumento());
            ps.setString(2, registrar.getTipo_documento());
            ps.setString(3, registrar.getNombres());
            ps.setString(4, registrar.getApellidos());
            ps.setString(5, registrar.getCorreo());
            ps.setString(6, registrar.getConfirmar_correo());
            ps.setString(7, registrar.getContrasena());
            ps.setString(8, registrar.getConfirmar_contrasena());
            
            ps.executeUpdate();
            System.out.println("Usuario registrado satisfactorimente");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //METODO READ
    public List<registrar_usuarios> leer(){
        List<registrar_usuarios> lista = new ArrayList<>();
        String read = "SELECT * FROM registro_usuarios;";
        
        try (Connection conn = conexion.getConexion();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(read)){
            while (rs.next()) {                
                lista.add(new registrar_usuarios(
                        rs.getString("Nombres"),
                        rs.getString("Apellidos"),
                        rs.getString("Correo")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    //METODO UPDATE
    public void actualizar(registrar_usuarios actualizar){
        String update = "UPDATE registro_usuarios SET tipo_documento=?, nombres=?, apellidos=?, correo=?, contrasena=? WHERE documento=?";
        
        try (Connection conn = conexion.getConexion();
                PreparedStatement ps = conn.prepareStatement(update)){
            
                ps.setString(1, actualizar.getTipo_documento());
                ps.setInt(2, actualizar.getDocumento());
                ps.setString(3, actualizar.getNombres());
                ps.setString(4, actualizar.getApellidos());
                ps.setString(5, actualizar.getCorreo());
                ps.setString(6, actualizar.getContrasena());
                ps.executeUpdate();
                System.out.println("Usuario actualizado satisfactoriamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //METODO DELETE
    public void delete(int documento){
        String delete = "DELETE FROM registro_usuarios WHERE documento=?";
        
        try (Connection conn = conexion.getConexion();
                PreparedStatement ps = conn.prepareStatement(delete)){
            
            ps.setInt(1, documento);
            ps.executeUpdate();
            System.out.println("Usuario Eliminado Exitosamente");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
