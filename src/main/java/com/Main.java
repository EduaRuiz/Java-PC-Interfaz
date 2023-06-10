/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.controller.Controller;
import com.view.Menu;

/**
 *
 * @author eduar
 */
public class Main {
    public static void main(String[] args) {
        Controller crl = new Controller();
        new Menu(crl).setVisible(true);
    }
}