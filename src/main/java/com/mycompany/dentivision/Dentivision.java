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
                        break;
                    case 2:
                        listar.leer();
                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    default:
                        System.out.println("Opcion invalida.");
                }
            } while (true);
        } catch (Exception e) {
            //e.printStackTrace();
        }

    }
}
