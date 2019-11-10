/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import Componentes.Constantes;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import utils.Persona;

/**
 *
 * @author Javierino
 */
public class PestaniaBuscar extends JPanel implements ActionListener {

    JTextField telefono, dni;
    JPanel panelCentro, panelAños, panelBotones;
    JSpinner spinerAnos;
    SpinnerNumberModel modeloAnos;
    JList listaEstudios;
    DefaultListModel modeloLista;
    String[] estudiosB = {"Ingenieria informatica","Ingenieria industrial","Ingenieria Telecomunicaciones","Arquitectura","Derecho"};
    public static ArrayList<Persona> pb;
    JTextArea textoBuscar;
    JButton buscar, salir;

    public PestaniaBuscar() {
        initGUI();
    }

    private void initGUI() {
        instancias();
        configurarPanel();
        acciones();

    }

    private void instancias() {
        panelCentro = new JPanel();
        panelAños = new JPanel();
        panelBotones = new JPanel();
        //telefono = new JTextField(Integer.max(1000, 600));
        telefono = new JTextField(84);
        dni = new JTextField(84);
        modeloAnos = new SpinnerNumberModel(0, 0, 99, 1);
        spinerAnos = new JSpinner(modeloAnos);
        //modeloLista = new DefaultListModel();
        listaEstudios = new JList<String>(estudiosB);
        //listaEstudios.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        //modeloLista.addElement(estudiosB);
        textoBuscar = new JTextArea(5, 84);
        buscar = new JButton("Buscar");
        buscar.setActionCommand(Constantes.ACC_2);
        salir = new JButton("Salir");
        salir.setActionCommand(Constantes.ACC_3);
        pb = new ArrayList<Persona>();

    }

    private void acciones() {
       telefono.addKeyListener(new ManejoTeclas());
        dni.addKeyListener(new ManejoTeclass());
        buscar.addActionListener(this);
        salir.addActionListener(this);
       /*listaEstudios.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (listaEstudios.getValueIsAdjusting()) {
                    System.out.println((listaEstudios.getSelectedIndex()));
                }
            }
        });*/
    }

    private void configurarPanel() {
        this.setLayout(new BorderLayout());
        this.add(configurarCentro(), BorderLayout.WEST);
    }

    public JPanel configurarCentro() {
        panelCentro.setLayout(new GridBagLayout());
        configurarGridBag(0, 0, 1, 1, 0.14, 0.14, GridBagConstraints.WEST, GridBagConstraints.NONE, new JLabel("Telefono"));
        configurarGridBag(0, 1, 1, 1, 0.14, 0.14, GridBagConstraints.WEST, GridBagConstraints.NONE, telefono);
        configurarGridBag(0, 2, 1, 1, 0.14, 0.14, GridBagConstraints.WEST, GridBagConstraints.NONE, new JLabel("DNI"));
        configurarGridBag(0, 3, 1, 1, 0.14, 0.14, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, dni);
        configurarGridBag(0, 4, 1, 1, 1, 0.14, GridBagConstraints.WEST, GridBagConstraints.NONE, configurarAños());
        configurarGridBag(0, 5, 1, 1, 0.14, 0.14, GridBagConstraints.WEST, GridBagConstraints.NONE, new JLabel("Selecciona tus estudios"));
        configurarGridBag(0, 6, 1, 1, 0.14, 0.14, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new JScrollPane(listaEstudios));
        configurarGridBag(0, 7, 1, 1, 0.14, 0.14, GridBagConstraints.WEST, GridBagConstraints.NONE, new JLabel("Resultados de busqueda"));
        configurarGridBag(0, 8, 1, 1, 0.14, 0.14, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, textoBuscar);
        configurarGridBag(0, 9, 1, 3, 0.14, 0.14, GridBagConstraints.CENTER, GridBagConstraints.NONE, configurarBotones());
        return panelCentro;
    }

    public void configurarGridBag(int pX, int pY, int tX, int tY, double peX, double peY, int anc, int fill, JComponent component) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = pX;
        constraints.gridy = pY;
        constraints.gridwidth = tX;
        constraints.gridheight = tY;
        constraints.weightx = peX;
        constraints.weighty = peY;
        constraints.fill = fill;
        constraints.anchor = anc;
        panelCentro.add(component, constraints);
    }

    public JPanel configurarBotones() {
        panelBotones.setLayout(new FlowLayout());
        panelBotones.add(buscar);
        panelBotones.add(salir);
        return panelBotones;
    }

    public JPanel configurarAños() {
        panelAños.setLayout(new FlowLayout());
        panelAños.add(new JLabel("Años de experiencia"));
        panelAños.add(spinerAnos);
        return panelAños;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case Constantes.ACC_2:
                if (!telefono.getText().isEmpty() && !dni.getText().isEmpty() && !listaEstudios.getSelectedValue().toString().isEmpty()) {
                    int telefonoS = Integer.valueOf(telefono.getText().toString());
                    String dniS = dni.getText().toString();
                    int experienciaI = Integer.valueOf(spinerAnos.getValue().toString());
                    String estudiosS = listaEstudios.getSelectedValue().toString();

                    //pb = new Persona(telefonoS, dni, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, ERROR, TOOL_TIP_TEXT_KEY, PROPERTIES);

                    for (Persona item : pb) {
                        //if (item.getTelefono() == telefonoS && item.getDni().equals(dniS) && item.getExperiencia() == experienciaI && item.getEstudio().equals(estudiosS)) {
                            textoBuscar.setText(textoBuscar.getText() + "\n" + item.toString());
                        //}
                    }
                } else {
                    textoBuscar.setText("Introduce datos");
                }
                break;
            case Constantes.ACC_3:
                System.exit(0);
                break;
        }
    }

    class ManejoTeclas extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent e) {
            char tecla = e.getKeyChar();
            if (!Character.isDigit(tecla)) {
                e.consume();
            } else if (telefono.getText().length() > 8) {
                e.consume();
            }
        }
    }

    class ManejoTeclass extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent e) {
            char tecla = e.getKeyChar();
            if (dni.getText().length() > 8) {
                e.consume();
            }
        }
    }
}
