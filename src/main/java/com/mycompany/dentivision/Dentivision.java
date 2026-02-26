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

        try {
            Scanner tec = new Scanner(System.in);
            Crud controlador = new Crud();

            registrar_usuarios ingresar = new registrar_usuarios();
            Crud listar = new Crud();

            int op;
            boolean salir = false;
            String td, doc, nom, ap, correo, conf_correo, contrasena, conf_cont = "";

            do {

                System.out.println("|------------- MENU PRINCIPAL-------------|");
                System.out.println("|------------- 1. Crear Usuarios ------------|");
                System.out.println("|------------- 2. Listar Usuarios ------------|");
                System.out.println("|------------- 3. Actualizar Usuarios -------|");
                System.out.println("|------------- 4. Eliminar Usuarios ---------|");

                System.out.println("Escoja una opcion: ");
                op = tec.nextInt();

                switch (op) {
                    case 1:
                        System.out.println("Digite los datos del usuario");
                        System.out.println("Tipo de documento: ");
                        td = tec.next();
                        ingresar.setTipo_documento(td);
                        System.out.println("Numero documento: ");
                        doc = tec.next();
                        ingresar.setDocumento(Integer.parseInt(doc));
                        System.out.println("Nombres: ");
                        nom = tec.next();
                        ingresar.setNombres(nom);
                        System.out.println("Apellidos: ");
                        ap = tec.next();
                        ingresar.setApellidos(ap);
                        System.out.println("Correo: ");
                        correo = tec.next();
                        ingresar.setCorreo(correo);
                        System.out.println("Confirmar Correo: ");
                        conf_correo = tec.next();
                        ingresar.setConfirmar_correo(conf_correo);
                        System.out.println("Contrasena: ");
                        contrasena = tec.next();
                        ingresar.setContrasena(contrasena);
                        System.out.println("Confirmar Contrasena");
                        conf_cont = tec.next();
                        ingresar.setConfirmar_contrasena(conf_cont);
                        controlador.Crear(ingresar); 
                        //
                        break;
                    case 2:
                        System.out.println("\n|------- USUARIOS REGISTRADOS -------|");
                        for (registrar_usuarios u : controlador.leer()) {
                        System.out.println("Nombre: " + u.getNombres() + " " + u.getApellidos() + " | Correo: " + u.getCorreo());
                    }
                        System.out.println("|------------------------------------|\n");
                        break;
                    case 3:
                        System.out.println("--- ACTUALIZAR DATOS DE USUARIO ---");
                        System.out.print("Digite el documento del usuario a actualizar: ");


                        String docAActualizar = tec.nextLine(); 

                        System.out.println("Ingrese los nuevos datos para el usuario " + docAActualizar + ":");
                       //catura los nuevos datos del usuario
                        System.out.print("Nuevo Nombre: ");
                        String nuevoNombre = tec.nextLine();

                        System.out.print("Nuevo Email: ");
                        String nuevoEmail = tec.nextLine();
                                                                                               
                        System.out.print("¿Confirmar los cambios para el documento " + docAActualizar + "? (S/N): ");
                        String confirnacion = tec.nextLine();

                        if (confirnacion.equalsIgnoreCase("S")) {
    
                        controlador.update(docAActualizar, nuevoNombre, nuevoEmail); 
                        System.out.println("Usuario actualizado exitosamente.");
                        } else {
                        System.out.println("Actualización cancelada.");
                        }
                        break;
                    case 4:
                        System.out.println("--- ELIMINAR USUARIO ---");
                        System.out.print("Digite el documento del usuario a eliminar: ");

                        // 1. CAPTURA COMO STRING 
                        String docAEliminar = tec.next(); 
                            tec.nextLine(); // Limpiar el buffer

                        // 2. CONFIRMACIÓN
                        System.out.print("¿Está seguro que desea eliminar al usuario " + docAEliminar + "? (S/N): ");
                        String confirmacion = tec.nextLine();

                        if (confirmacion.equalsIgnoreCase("S")) {
                        // Ahora sí coinciden: le pasas un String a un método que espera String
                            controlador.delete(docAEliminar); 
                        } else {
                            System.out.println("Operación cancelada.");
                        }

                        break;
                    default:
                        System.out.println("Opcion invalida.");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Saliendo Del Programa");
        }

    }
}
