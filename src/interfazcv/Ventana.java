/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazcv;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import paneles.PestaniaBuscar;
import paneles.PestaniaInsertar;

/**
 *
 * @author Javierino
 */
public class Ventana extends JFrame {

    JTabbedPane panelPestanias;
    Container container;
    PestaniaInsertar pestaniaInsertar;
    PestaniaBuscar pestaniaBuscar;

    public void initGUI() {
        instancias();
        configurarContainer();
        this.setSize(new Dimension(600, 500));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("CV");
        this.setVisible(true);
    }

    private void configurarContainer() {
        container.add(panelPestanias);
        panelPestanias.addTab("Insertar", pestaniaInsertar);
        panelPestanias.addTab("Buscar", pestaniaBuscar);
    }

    private void instancias() {
        container = this.getContentPane();
        panelPestanias = new JTabbedPane(SwingConstants.TOP);
        pestaniaInsertar = new PestaniaInsertar();
        pestaniaBuscar = new PestaniaBuscar();
    }

}
