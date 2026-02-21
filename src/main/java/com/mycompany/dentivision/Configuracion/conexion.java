/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dentivision.Configuracion;

import java.sql.*;
/**
 *
 * @author Creyese23
 */
public class conexion {
   
    
    public static Connection getConexion(){
        
    String URL = "jdbc:mysql://localhost:3306/registro";
    String User = "root";
    String Psw = "";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, User, Psw);
        }catch (ClassNotFoundException e) {
            System.out.println("No fue posible cargar el driver.");

        } catch (SQLException e) {
            System.out.println("Hubo un error al acceder a la base de datos: " + e.getMessage());
        }
        return null;
    }
}
