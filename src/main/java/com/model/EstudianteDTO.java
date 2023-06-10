package com.model;

import java.io.File;
import java.util.ArrayList;

public class EstudianteDTO {
    private ArrayList<Estudiante> estudiantes;
    private EstudianteDAO dao;
    private File file = new File("datos_estudiantes.dat");
    private Archivo archivo;

    public EstudianteDTO(){
        archivo = new Archivo(file);
        dao = new EstudianteDAO(archivo);
        estudiantes = archivo.leerArchivo(file);
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;         
    }

    public EstudianteDAO getDao() {
        return dao;
    }

    public File getFile() {
        return file;
    }
}