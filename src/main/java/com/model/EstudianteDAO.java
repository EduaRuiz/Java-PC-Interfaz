package com.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class EstudianteDAO {
    private Archivo archivo;

    public EstudianteDAO(Archivo archivo){
        this.archivo = archivo;
    }

    public boolean agregarEstudiante(Estudiante estudiante,ArrayList<Estudiante> estudiantes,File file){
        Estudiante nuevo = estudiante;
        if (buscarEstudiante(estudiante.getCorreo1(),estudiantes) == null){
        estudiantes.add(nuevo);
        archivo.escribirArchivo(estudiantes,file);
        return true;
        }
        return false;
    }

    public Estudiante buscarEstudiante(String correo, ArrayList<Estudiante> estudiantes){
        Estudiante encontrado = null;
        for (Estudiante i:estudiantes){
            if(i.getCorreo1().equals(correo)){
                encontrado = i;
            }
        }
        return encontrado;
    }

    public boolean eliminarEstudiante(String correo, ArrayList<Estudiante> estudiantes, File file){
        boolean respuesta = false;
        try {
            Estudiante e = buscarEstudiante(correo,estudiantes);
            if (e != null) {
                estudiantes.remove(e);
                file.delete();
                file.createNewFile();
                archivo.escribirArchivo(estudiantes, file);
                respuesta = true;
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        return respuesta;
    }

    public String verEstudiantes(File file){
        ArrayList<Estudiante> estudiantes = archivo.leerArchivo(file);
        String texto = "";
        for (Estudiante i:estudiantes){
            texto = texto.concat("\n"+i);
        }
        return texto;
    }
}