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
    
    
    private static final String URL = "jdbc:mysql://localhost:3306/Registro";
    private static final String User = "root";
    private static final String Psw = "";
    
    public static Connection getConexion(){
        try{
            
            return DriverManager.getConnection(URL, User, Psw);
        }catch(SQLException e){
            System.out.println("Error al conectar: "+ e.getMessage());
        }
        return null;
    }
}
