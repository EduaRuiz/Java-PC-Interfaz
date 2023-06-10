package com.model;

public class Estudiante implements java.io.Serializable{

    private String nombres, apellidos, fechaNacimiento, programa, correo1, correo2;
    private long celular, fijo;

    public Estudiante(String nombres, String apellidos, String fechaNacimiento, String correo1, String correo2, long celular, long fijo, String programa) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.correo1 = correo1;
        this.correo2 = correo2;
        this.celular = celular;
        this.fijo = fijo;
        this.programa = programa;
    }

    public String getNombres() {
        return nombres;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public void setFijo(long fijo) {
        this.fijo = fijo;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo1() {
        return correo1;
    }
    
    public String getCorreo2() {
        return correo1;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getPrograma() {
        return programa;
    }

    public long getCelular() {
        return celular;
    }

    public long getFijo() {
        return fijo;
    }
    

    @Override
    public String toString() {
        return "Nombres: " + nombres +
                "\nApellidos: " + apellidos +
                "\nFechade Nacimiento: " + fechaNacimiento +
                "\nCorreo Institucional: " + correo1 +
                "\nCorreo Personal: " + correo2 +
                "\nNúmero de teléfono celular: " + celular +
                "\nNúmero de teléfono fijo: " + fijo +
                "\nPrograma académico: " + programa +
                "\n";
    }
}