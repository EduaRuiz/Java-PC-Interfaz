package com.model;

import java.io.*;
import java.util.ArrayList;

public class Archivo {

    public Archivo(File archivo){
        if (!archivo.exists()){
            try {
                archivo.createNewFile();

            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void escribirArchivo(ArrayList<Estudiante> estudiantes, File archivo){
        try {
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(estudiantes);
            oos.close();
        }catch (
                IOException ioe){
            ioe.printStackTrace();
        }
    }

    public ArrayList<Estudiante> leerArchivo(File archivo){
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            estudiantes = (ArrayList<Estudiante>) ois.readObject();
            ois.close();
            fis.close();
        }catch (EOFException eofe){

        }catch (IOException io){
            io.printStackTrace();
        }catch (ClassNotFoundException c){
            c.printStackTrace();

        }
        return estudiantes;
    }
}