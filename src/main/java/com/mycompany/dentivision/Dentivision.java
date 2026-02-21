/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.dentivision;

import com.mycompany.dentivision.controlador.Crud;
import com.mycompany.dentivision.modelo.registrar_usuarios;
import java.util.Scanner;

/**
 *
 * @author Creyese23
 */
public class Dentivision {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        Crud controlador = new Crud();
        
        registrar_usuarios crear = new registrar_usuarios();
        
        int op;
        boolean salir = false;
        String td, doc, nom, ap, correo, conf_correo, contrasena,conf_cont = "";
        
        do {            
            System.out.println("|------------- MENU PRINCIPAL-------------|");
            System.out.println("|------------- 1. Crear Usuarios ------------|");
            System.out.println("|------------- 2. Listar Usuarios ------------|");
            System.out.println("|------------- 3. Actualizar Usuarios -------|");
            System.out.println("|------------- 4. Eliminar Usuarios ---------|");
            
            op = tec.nextInt();
            
            switch (op) {
                case 1:
                    System.out.println("Digite los datos del usuario");
                    System.out.println("Nombres: ");
                    td = tec.next();
                    crear.setTipo_documento(td);
                    
                    
                    
                    break;
                  case 2:
                      
                      break;
                  case 3:
                      
                      break;
                  case 4:
                      System.out.println("--- ELIMINAR USUARIO ---");
                    System.out.print("Digite el documento del usuario a eliminar: ");
                    int docAEliminar = tec.nextInt();
                    
                    // 2. LLAMADA AL MÉTODO DE TU OTRA CLASE
                    controlador.delete(docAEliminar); 
                      
                      break;
                  
                default:
                    throw new AssertionError();
            }
        } while (salir);

    }
}
