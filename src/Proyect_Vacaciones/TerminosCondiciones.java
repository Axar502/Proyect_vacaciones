/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyect_Vacaciones;

/**
 *
 * @author Axel
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TerminosCondiciones extends JFrame {

    private JLabel etiquetaLogo, etiquetaUsuario, etiquetaLeyenda;
    private JTextArea campoTerminos;
    private JCheckBox aceptarCheckBox;
    private JButton botonContinuar, botonNoAceptar;
    private String nombreUsuario;

    public TerminosCondiciones(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;

        // Configuración de la ventana
        setTitle("Términos y Condiciones");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Logotipo (imagen PNG)
        ImageIcon logoIcon = new ImageIcon("src/proyect_vacaciones/img/Logo_ArtTec.png");
        Image imagen = logoIcon.getImage();
        Image imagenEscalada = imagen.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
        ImageIcon logoIconEscalado = new ImageIcon(imagenEscalada);
        etiquetaLogo = new JLabel(logoIconEscalado);
        etiquetaLogo.setBounds(175, 10, 150, 100);
        add(etiquetaLogo);

        // Texto para mostrar el nombre del usuario
        etiquetaUsuario = new JLabel("Usuario: " + nombreUsuario, SwingConstants.CENTER);
        etiquetaUsuario.setBounds(0, 110, 500, 30);
        add(etiquetaUsuario);

// Crear un JTextPane para soportar HTML y aplicar negritas
JTextPane campoTerminos = new JTextPane();
        campoTerminos.setContentType("text/html");
        campoTerminos.setText("<html>"
                + "<b>Uso del Programa</b><br><br>"
                + "Este programa calcula días de vacaciones basados en los datos ingresados. Los resultados son estimativos.<br><br>"
                + "<b>Responsabilidad</b><br><br>"
                + "No garantizamos la exactitud total de los cálculos. No nos hacemos responsables de errores o malentendidos derivados del uso del programa.<br><br>"
                + "<b>Privacidad</b><br><br>"
                + "Los datos ingresados no se guardan ni se comparten."
                + "</html>");
        campoTerminos.setEditable(false); // No editable

// Añadir JScrollPane para desplazamiento
        JScrollPane scrollTerminos = new JScrollPane(campoTerminos);
        scrollTerminos.setBounds(50, 150, 400, 150);
        add(scrollTerminos);


        // Checkbox para aceptar términos
        aceptarCheckBox = new JCheckBox("He leído y acepto los términos y condiciones");
        aceptarCheckBox.setBounds(50, 320, 400, 30);
        add(aceptarCheckBox);

        // Botón de continuar
        botonContinuar = new JButton("Continuar");
        botonContinuar.setBounds(150, 370, 100, 30);
        botonContinuar.setEnabled(false); // Deshabilitado hasta que se acepten los términos
        add(botonContinuar);

        // Botón de no aceptar
        botonNoAceptar = new JButton("No aceptar");
        botonNoAceptar.setBounds(260, 370, 100, 30);
        add(botonNoAceptar);

        // Leyenda al pie
        etiquetaLeyenda = new JLabel("©2024 Studio ArTec Company", SwingConstants.CENTER);
        etiquetaLeyenda.setBounds(0, 420, 500, 30);
        add(etiquetaLeyenda);

        // Listener para el checkbox
        aceptarCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (aceptarCheckBox.isSelected()) {
                    botonContinuar.setEnabled(true);
                    botonNoAceptar.setEnabled(false);
                } else {
                    botonContinuar.setEnabled(false);
                    botonNoAceptar.setEnabled(true);
                }
            }
        });

        // Acción del botón "Continuar"
        botonContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new PantallaPrincipal(nombreUsuario).setVisible(true);
            dispose(); // Cerrar la pantalla de términos y condiciones
    }
});

        // Acción del botón "No aceptar"
        botonNoAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Volver a la pantalla de bienvenida
                JOptionPane.showMessageDialog(null, "No has aceptado los términos. Volviendo a la bienvenida.");
                new Bienvenida_proyecto().setVisible(true); // Regresar a la pantalla de bienvenida
                dispose(); // Cerrar la ventana actual
            }
        });

        // Configurar el ícono de la aplicación en la barra del formulario
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/proyect_vacaciones/img/Logo_ArtTec.png"));

        // Hacer visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        // Nombre del usuario pasado desde la pantalla de bienvenida
        String nombreUsuario = "UsuarioEjemplo";
        new TerminosCondiciones(nombreUsuario);
    }
}
