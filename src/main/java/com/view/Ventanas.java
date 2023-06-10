package com.view;

import javax.swing.JOptionPane;

public class Ventanas {
    
    public String estradaDatos(String mensaje){
        String valor;
        valor = JOptionPane.showInputDialog(null, mensaje,"", JOptionPane.QUESTION_MESSAGE);
        if (valor == null || valor.equals("")){
            aviso("Proceso cancelado");
            valor = null;
        }        
        return valor;
    }
    
    public void aviso(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "", JOptionPane.CANCEL_OPTION);
    }
    
    public void aviso(String mensaje, String aviso){
        JOptionPane.showMessageDialog(null, mensaje, aviso, JOptionPane.OK_OPTION);
    }
    
    public int pregunta(String mensaje, String titulo){
    return JOptionPane.showConfirmDialog(null,mensaje,titulo, JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
    }
}