/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.dentivision;

import com.mycompany.dentivision.controlador.Crud;
import com.mycompany.dentivision.modelo.Usuarios;
import java.util.List;
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

            Usuarios ingresar = new Usuarios();
            

            int op;
            boolean salir = false;
            String td, doc, nom, ap, correo, conf_correo, contrasena, conf_cont = "";

            do {

                System.out.println("|------------- MENU PRINCIPAL-------------|");
                System.out.println("|------------- 1. Crear Usuarios ------------|");
                System.out.println("|------------- 2. Listar Usuarios ------------|");
                System.out.println("|------------- 3. Actualizar Usuarios -------|");
                System.out.println("|------------- 4. Eliminar Usuarios ---------|");
                System.out.println("|------------- 5. Obtener Usuario por documento---------|");
                System.out.println("|------------- 6. Salir ---------|");

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
                        break;
                    case 2:
                        System.out.println("--- LISTA DE USUARIOS ---");

                        List<Usuarios> listaUsuarios = controlador.leer();

                        for (Usuarios usuario : listaUsuarios) {
                            System.out.println("Documento: " + usuario.getDocumento());
                            System.out.println("Tipo_de_Documento: " + usuario.getTipo_documento());
                            System.out.println("Nombre: " + usuario.getNombres());
                            System.out.println("Apellido: " + usuario.getApellidos());
                            System.out.println("Correo: " + usuario.getCorreo());
                            System.out.println("----------------------------------");
                        }
                        
                        break;
                    case 3:

                        break;
                    case 4:
                        System.out.println("--- ELIMINAR USUARIO ---");
                        System.out.print("Digite el documento del usuario a eliminar: ");

                        // 1. VALIDACIÓN DE ENTRADA
                        while (!tec.hasNextInt()) {
                        System.out.println("Error: ¡Debes ingresar un número válido!");
                        System.out.print("Digite el documento: ");
                        tec.next(); 
                        }
    
                        int docAEliminar = tec.nextInt();
                         tec.nextLine(); // Limpiar el buffer después de leer el entero

                        // 2. CONFIRMACIÓN
                        System.out.print("¿Está seguro que desea eliminar al usuario " + docAEliminar + "? (S/N): ");
                        String confirmacion = tec.nextLine();

                        if (confirmacion.equalsIgnoreCase("S")) {
                            controlador.delete(docAEliminar);
                        } else {
                            System.out.println("Operación cancelada.");
                        }

                        break;
                    case 5:
                      
                        System.out.println("--- OBTENER USUARIO POR DOCUMENTO ---");
                        System.out.print("Digite el documento del usuario: ");

                        // Validación de entrada
                        while (!tec.hasNextInt()) {
                            System.out.println("Error: ¡Debes ingresar un número válido!");
                            System.out.print("Digite el documento: ");
                            tec.next(); 
                        }

                        int docABuscar = tec.nextInt();
                        tec.nextLine(); // limpiar buffer

                        Usuarios usuarioEncontrado = controlador.buscarPorDocumento(docABuscar);
                        if (usuarioEncontrado != null) {
                            System.out.println("Documento: " + usuarioEncontrado.getDocumento());
                            System.out.println("Tipo de Documento: " + usuarioEncontrado.getTipo_documento());
                            System.out.println("Nombre: " + usuarioEncontrado.getNombres());
                            System.out.println("Apellido: " + usuarioEncontrado.getApellidos());
                            System.out.println("Correo: " + usuarioEncontrado.getCorreo());
                        } else {
                            System.out.println("No se encontró ningún usuario con ese documento.");
                        }
                        break;
                    case 6:
                        
                        System.out.println("Saliendo del programa...");
                        salir = true;
                        break;
                        
                    default:
                        System.out.println("Opcion invalida.");
                }
            } while (!salir);
        } catch (Exception e) {
            //e.printStackTrace();
        }

    }
}
