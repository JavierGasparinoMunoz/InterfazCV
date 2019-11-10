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
import static java.awt.image.ImageObserver.ERROR;
import static java.awt.image.ImageObserver.PROPERTIES;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import static javax.swing.JComponent.TOOL_TIP_TEXT_KEY;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import utils.Persona;

/**
 *
 * @author Javierino
 */
public class PestaniaInsertar extends JPanel implements ActionListener, ChangeListener {

    JLabel titulo;
    JSpinner spinnerAnos;
    JPanel panelIzquierda, panelDerecha, panelSuperior, panelRadios, panelExperiencia, panelBotones;
    JTextField tNombre, tDireccion, tTelefono, tDNI;
    JRadioButton rSoltero, rCasado, rDivorciado;
    ButtonGroup grupoRadios;
    SpinnerNumberModel modeloNumeros;
    String estado;
    JButton insertarDatos, salir;
    JList listaEstudios;
    DefaultListModel modeloLista;
    String[] estudios = {"Ingenieria informatica", "Ingenieria industrial", "Ingenieria Telecomunicaciones", "Arquitectura", "Derecho"};
    public static Persona p;

    public PestaniaInsertar() {
        initGUI();
    }

    private void initGUI() {
        instancias();
        configurarPanel();
        acciones();
    }

    private void instancias() {
        titulo = new JLabel("Por favor, rellena los datos de tu curriculum");
        modeloNumeros = new SpinnerNumberModel(0, 0, 99, 1);
        spinnerAnos = new JSpinner(modeloNumeros);
        panelIzquierda = new JPanel();
        panelDerecha = new JPanel();
        panelSuperior = new JPanel();
        panelRadios = new JPanel();
        panelExperiencia = new JPanel();
        panelBotones = new JPanel();
        tNombre = new JTextField(25);
        tDireccion = new JTextField(25);
        tTelefono = new JTextField(25);
        tDNI = new JTextField(25);
        insertarDatos = new JButton("Insertar Datos");
        insertarDatos.setActionCommand(Constantes.ACC_1);
        salir = new JButton("Salir");
        salir.setActionCommand(Constantes.ACC_3);
        rSoltero = new JRadioButton("Soltero", false);
        rCasado = new JRadioButton("Casado", true);
        rDivorciado = new JRadioButton("Divorciado", false);
        grupoRadios = new ButtonGroup();
        grupoRadios.add(rSoltero);
        grupoRadios.add(rCasado);
        grupoRadios.add(rDivorciado);
        //modeloLista = new DefaultListModel();
        //modeloLista.addElement(estudios);
        listaEstudios = new JList<String>(estudios);
        listaEstudios.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        PestaniaBuscar.pb = new ArrayList<Persona>();
    }

    private void acciones() {
        tNombre.addActionListener(this);
        tDireccion.addActionListener(this);
        tTelefono.addKeyListener(new ManejoTeclas());
        tDNI.addKeyListener(new ManejoTeclass());
        tNombre.addKeyListener(new ManejoTeclasN());
        rSoltero.addChangeListener(this);
        rCasado.addChangeListener(this);
        rDivorciado.addChangeListener(this);
        insertarDatos.addActionListener(this);
        salir.addActionListener(this);
        listaEstudios.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (listaEstudios.getValueIsAdjusting()) {
                    System.out.println(listaEstudios.getSelectedIndex());
                }
            }
        });
    }

    private void configurarPanel() {
        this.setLayout(new BorderLayout());
        this.add(configurarIzquierda(), BorderLayout.WEST);
        this.add(configurarSuperior(), BorderLayout.NORTH);
        this.add(configurarDerecha(), BorderLayout.EAST);
        //this.add(configurarGrupoRadios(), BorderLayout.EAST);
    }

    public JPanel configurarSuperior() {
        panelSuperior.setLayout(new FlowLayout());
        panelSuperior.add(titulo);
        return panelSuperior;
    }

    public JPanel configurarIzquierda() {
        panelIzquierda.setLayout(new GridBagLayout());
        configurarGridBagI(0, 0, 1, 1, 1, 0.125, GridBagConstraints.WEST, GridBagConstraints.NONE, new JLabel("Nombre"));
        //configurarGridBagI(3, 0, 1, 1, 0.16, 0.16, GridBagConstraints.WEST, GridBagConstraints.NONE, new JLabel("Selecciona tus estudios"));
        configurarGridBagI(0, 1, 1, 1, 1, 0.125, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, tNombre);
        //configurarGridBagI(3, 1, 1, 3, 0.16, 0.16, GridBagConstraints.WEST, GridBagConstraints.VERTICAL, listaEstudios);
        configurarGridBagI(0, 2, 1, 1, 1, 0.125, GridBagConstraints.WEST, GridBagConstraints.NONE, new JLabel("Direccion"));
        configurarGridBagI(0, 3, 1, 1, 1, 0.125, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, tDireccion);
        configurarGridBagI(0, 4, 1, 1, 1, 0.125, GridBagConstraints.WEST, GridBagConstraints.NONE, new JLabel("Telefono"));
        //configurarGridBagI(3, 4, 1, 1, 0.16, 0.16, GridBagConstraints.WEST, GridBagConstraints.NONE, rSoltero);
        //configurarGridBagI(4, 4, 1, 1, 0.16, 0.16, GridBagConstraints.WEST, GridBagConstraints.NONE, rCasado);
        //configurarGridBagI(5, 4, 1, 1, 0.16, 0.16, GridBagConstraints.WEST, GridBagConstraints.NONE, rDivorciado);
        configurarGridBagI(0, 5, 1, 1, 1, 0.125, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, tTelefono);
        //configurarGridBagI(3, 5, 1, 1, 0.16, 0.16, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new JLabel("Años de experiencia"));
        //configurarGridBagI(4, 5, 1, 1, 0.16, 0.16, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, SpinnerAnos);
        configurarGridBagI(0, 6, 1, 1, 1, 0.125, GridBagConstraints.WEST, GridBagConstraints.NONE, new JLabel("DNI"));
        configurarGridBagI(0, 7, 1, 1, 1, 0.125, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, tDNI);
        return panelIzquierda;
    }

    public void configurarGridBagI(int pX, int pY, int tX, int tY, double peX, double peY, int anc, int fill, JComponent component) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = pX;
        constraints.gridy = pY;
        constraints.gridwidth = tX;
        constraints.gridheight = tY;
        constraints.weightx = peX;
        constraints.weighty = peY;
        constraints.fill = fill;
        constraints.anchor = anc;
        panelIzquierda.add(component, constraints);
    }

    public JPanel configurarDerecha() {
        panelDerecha.setLayout(new GridBagLayout());
        configurarGridBagD(0, 0, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new JLabel("Selecciona tus estudios"));
        configurarGridBagD(0, 1, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new JScrollPane(listaEstudios));
        configurarGridBagD(0, 4, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE, configurarGrupoRadios());
        configurarGridBagD(0, 5, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE, configurarExperiencia());
        configurarGridBagD(0, 6, 1, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE, configurarBotones());
        return panelDerecha;
    }

    public JPanel configurarGrupoRadios() {
        panelRadios.setLayout(new FlowLayout());
        panelRadios.add(rSoltero);
        panelRadios.add(rCasado);
        panelRadios.add(rDivorciado);
        return panelRadios;
    }

    public JPanel configurarExperiencia() {
        panelExperiencia.setLayout(new FlowLayout());
        panelExperiencia.add(new JLabel("Años de experiencia"));
        panelExperiencia.add(spinnerAnos);
        return panelExperiencia;
    }

    public JPanel configurarBotones() {
        panelBotones.setLayout(new FlowLayout());
        panelBotones.add(insertarDatos);
        panelBotones.add(salir);
        return panelBotones;
    }

    /*public void configurarGridBagB(int pX, int pY, int tX, int tY, double peX, double peY, int anc, int fill, JComponent component) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = pX;
        constraints.gridy = pY;
        constraints.gridwidth = tX;
        constraints.gridheight = tY;
        constraints.weightx = peX;
        constraints.weighty = peY;
        constraints.fill = fill;
        constraints.anchor = anc;
        panelRadios.add(component, constraints);
    }*/
    public void configurarGridBagD(int pX, int pY, int tX, int tY, double peX, double peY, int anc, int fill, JComponent component) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = pX;
        constraints.gridy = pY;
        constraints.gridwidth = tX;
        constraints.gridheight = tY;
        constraints.weightx = peX;
        constraints.weighty = peY;
        constraints.fill = fill;
        constraints.anchor = anc;
        panelDerecha.add(component, constraints);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (rDivorciado.isSelected()) {
            estado = "Divorciado";
        } else if (rSoltero.isSelected()) {
            estado = "Soltero";
        } else if (rCasado.isSelected()) {
            estado = "Casado";
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case Constantes.ACC_1:
                String nombreS = tNombre.getText();
                String direccionS = tDireccion.getText();
                int telefonoI = Integer.valueOf(tTelefono.getText().toString());
                String dniS = tDNI.getText();
                int experienciaI = Integer.valueOf(spinnerAnos.getModel().getValue().toString());
                String estudiosS = estudios.toString();

                p = new Persona(nombreS, direccionS, estado, estudiosS, telefonoI, dniS, experienciaI);
                PestaniaBuscar.pb.add(p);
                System.out.println(p);
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
            } else if (tTelefono.getText().length() > 8) {
                e.consume();
            }
        }
    }

    class ManejoTeclasN extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent e) {
            char tecla = e.getKeyChar();
            if (Character.isDigit(tecla)) {
                e.consume();
            }
        }
    }

    class ManejoTeclass extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent e) {
            char tecla = e.getKeyChar();
            if (tDNI.getText().length() > 8) {
                e.consume();
            }
        }
    }
}
