package com.controller;

import com.model.Estudiante;
import com.model.EstudianteDTO;
import com.view.TablaEstudiantes;
import com.view.Ventanas;
import java.util.ArrayList;

public class Controller {

    //Objetos
    private EstudianteDTO dto= new EstudianteDTO();
    private TablaEstudiantes tabla;
    private Ventanas dialogo = new Ventanas();
    private String[] datos = new String[8];
    private String[] mensajes = {"Ingresar nombres:","Ingresar apellidos:","Ingresar fecha de nacimiento (YYYY-MM-DD):","Ingresar correo institucional:","Ingresar correo personal:","Ingresar número de celular:","Ingresar número fijo:","Ingresar programa:"};
    private String pivote;
    
    public Controller(){}

    //metodos
    public void inits(int opcion){ 
        switch (opcion){
            case 1 -> ingresarEstudiante();
            case 2 -> buscarEstudiante();
            case 3 -> modificarEstudiante();
            case 4 -> eliminarEstudiante();
            case 5 -> mostrarDirectorio();
            case 6 -> salir(); 
        }
    }
    
    private void ingresarEstudiante(){
        dialogo.aviso("Ingresar estudiante");
        for (int i = 0; i <8; i++){
            pivote = dialogo.estradaDatos(mensajes[i]);
            if (pivote == null){
                datos = null;
                break;
            }else{
                datos[i] = pivote;
            }
        }
        if (datos != null){
            Estudiante estudianteNuevo = new Estudiante(datos[0],datos[1],datos[2],datos[3],datos[4],Long.parseLong(datos[5]),Long.parseLong(datos[6]),datos[7]);
            if(dto.getDao().agregarEstudiante(estudianteNuevo,dto.getEstudiantes(),dto.getFile())){
                dialogo.aviso("Se agregó el estudiante");
            }else {
                dialogo.aviso("No se pudo crear estudiante");
            }        
        }
    }
    
    private void buscarEstudiante(){
        dialogo.aviso("Buscar estudiante");
        pivote = dialogo.estradaDatos(mensajes[3]);
        Estudiante rta = dto.getDao().buscarEstudiante(pivote, dto.getEstudiantes());
        if (rta == null){
            dialogo.aviso("Estudiante no existe");
        }else{
            dialogo.aviso(rta.toString(),"Información del estudiante");
        }
    }
    
    private void modificarEstudiante(){
        dialogo.aviso("Modificar estudiante");
        for (int i = 3; i <5; i++){
            pivote = dialogo.estradaDatos(mensajes[i]);
            if (pivote == null){
                datos = null;
                break;
            }else{
                datos[i] = pivote;
            }
        }
        if (datos != null){
            Estudiante student;
            student = dto.getDao().buscarEstudiante(datos[3], dto.getEstudiantes());
            if(student != null){
                for (int i = 5; i <8; i++){
                    pivote = dialogo.estradaDatos(mensajes[i]);
                    if (pivote == null){
                        datos = null;
                        break;
                    }else{
                        datos[i] = pivote;
                    }
                }    
                if (datos != null){
                    student.setFijo(Long.parseLong(datos[6]));
                    student.setPrograma(datos[7]);
                    dto.getDao().eliminarEstudiante(student.getCorreo1(),dto.getEstudiantes(), dto.getFile());
                    dto.getDao().agregarEstudiante(student, dto.getEstudiantes(), dto.getFile());
                    dialogo.aviso("Se modificó estudiante");
                }
            }else{
                dialogo.aviso("Estudiante no Existe");
            }
        }
    }
    
    private void eliminarEstudiante(){
        dialogo.aviso("Eliminar estudiante");
        pivote = dialogo.estradaDatos(mensajes[3]);
        if (!(pivote == null || pivote.equals(""))){
            Estudiante student = new Estudiante("","","",pivote,"",0L,0L,"");
            student = dto.getDao().buscarEstudiante(pivote, dto.getEstudiantes());
            if(student != null){
                if(dialogo.pregunta("¿Desea eliminar al siguiente estudiante?\n\n"+student, "Eliminar") == 0){
                    dto.getDao().eliminarEstudiante(pivote, dto.getEstudiantes(), dto.getFile());
                    dialogo.aviso("Estudiante Eliminado!");
                }else{
                    dialogo.aviso("proceso cancelado!");
                }
            }else{
                dialogo.aviso("Estudiante no existe");
            }
        }
    }
    
    public ArrayList<Estudiante> mostrarDirectorio(){
        if (dto.getEstudiantes().isEmpty()){
            dialogo.aviso("Directorio vacio");
        }
        return dto.getEstudiantes();
    }
    
    private void salir(){        
        if (dialogo.pregunta("¿Desea salir?", "Salir") == 0){
            dialogo.aviso("Hasta pronto");
            System.exit(0);            
        }            
    }
}