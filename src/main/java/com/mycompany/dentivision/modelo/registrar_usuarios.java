/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dentivision.modelo;

/**
 *
 * @author Creyese23
 */
public class registrar_usuarios {
    private int documento;
    private String tipo_documento;
    private String nombres;
    private String apellidos;
    private String correo;
    private String confirmar_correo;
    private String contrasena;
    private String confirmar_contrasena;
    
    public registrar_usuarios(){}


    public registrar_usuarios(int documento, String tipo_documento, String nombres, String apellidos, String correo, String confirmar_correo, String contrasena, String confirmar_contrasena) {
        this.documento = documento;
        this.tipo_documento = tipo_documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.confirmar_correo = confirmar_correo;
        this.contrasena = contrasena;
        this.confirmar_contrasena = confirmar_contrasena;
    }

    public registrar_usuarios(String string, String string0, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getConfirmar_correo() {
        return confirmar_correo;
    }

    public void setConfirmar_correo(String confirmar_correo) {
        this.confirmar_correo = confirmar_correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getConfirmar_contrasena() {
        return confirmar_contrasena;
    }

    public void setConfirmar_contrasena(String confirmar_contrasena) {
        this.confirmar_contrasena = confirmar_contrasena;
    }

    
}
