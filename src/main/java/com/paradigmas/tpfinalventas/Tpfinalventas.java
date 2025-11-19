package com.paradigmas.tpfinalventas;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.paradigmas.tpfinalventas.ui.Principal;

import javax.swing.*;

public class Tpfinalventas {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        Principal inicio = new Principal();
        inicio.setVisible(true);
        inicio.setLocationRelativeTo(null);
    }
}
