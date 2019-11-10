/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazcv;

import javax.swing.SwingUtilities;

/**
 *
 * @author Javierino
 */
public class EntradaInterfaz {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Ventana v = new Ventana();
                v.pack();
                v.initGUI();
            }
        });
    }
    
}
