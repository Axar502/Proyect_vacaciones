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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Bienvenida_proyecto extends JFrame {

    private JTextField campoNombre;
    private JButton botonSiguiente;
    private JLabel etiquetaLogo, etiquetaLeyenda;

    public Bienvenida_proyecto() {
        // Configuración de la ventana
        setTitle("Bienvenida");
        setSize(400, 350);
        getContentPane().setBackground(Color.decode("#111310"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana
        setLayout(null); // Layout absoluto para colocar componentes manualmente

        // Logotipo (imagen PNG en la ventana, ajustada)
        ImageIcon logoIcon = new ImageIcon("src/proyect_vacaciones/img/Logo_ArtTec.png");
        Image imagen = logoIcon.getImage();
        Image imagenEscalada = imagen.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
        ImageIcon logoIconEscalado = new ImageIcon(imagenEscalada);

        etiquetaLogo = new JLabel(logoIconEscalado);
        etiquetaLogo.setBounds(125, 20, 150, 100);
        add(etiquetaLogo);

        // Campo de texto para el nombre con placeholder
        campoNombre = new JTextField("Introduce tu nombre");
        campoNombre.setBounds(100, 130, 200, 30);
        campoNombre.setForeground(Color.GRAY);

        // Agregar FocusListener para simular el placeholder
        campoNombre.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (campoNombre.getText().equals("Introduce tu nombre")) {
                    campoNombre.setText("");
                    campoNombre.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (campoNombre.getText().isEmpty()) {
                    campoNombre.setForeground(Color.GRAY);
                    campoNombre.setText("Introduce tu nombre");
                }
            }
        });
        add(campoNombre);

        // Botón para pasar a la siguiente pantalla
        botonSiguiente = new JButton("Siguiente");
        botonSiguiente.setBounds(150, 180, 100, 30);
        add(botonSiguiente);

        // Acción del botón "Siguiente"
        botonSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = campoNombre.getText();
                if (nombreUsuario.equals("") || nombreUsuario.equals("Introduce tu nombre")) {
                    JOptionPane.showMessageDialog(null, "Por favor, introduce tu nombre.");
                } else {
                    // Abrir la pantalla de términos y condiciones y pasar el nombre del usuario
                    new TerminosCondiciones(nombreUsuario).setVisible(true);
                    dispose(); // Cerrar la pantalla de bienvenida
                }
            }
        });

        // Leyenda al pie
        etiquetaLeyenda = new JLabel("©2024 Studio ArTec Company", SwingConstants.CENTER);
        etiquetaLeyenda.setBounds(0, 240, 400, 30);
        etiquetaLeyenda.setForeground(Color.WHITE);
        add(etiquetaLeyenda);

        // Configurar el ícono de la aplicación en la barra del formulario
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/proyect_vacaciones/img/Logo_ArtTec.png"));

        // Hacer visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        new Bienvenida_proyecto();
    }
}
