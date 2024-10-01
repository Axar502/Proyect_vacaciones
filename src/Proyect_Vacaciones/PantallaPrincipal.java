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

public class PantallaPrincipal extends JFrame {
    private JLabel etiquetaLogo, etiquetaUsuario, etiquetaLeyenda, etiquetaResultado;
    private JTextField campoNombre, campoApellidos, campoResultado;
    private JComboBox<String> comboDepartamento, comboAntiguedad;
    private JButton botonCalcular, botonLimpiar, botonRegresar;

    public PantallaPrincipal(String nombreUsuario) {
        // Configuración de la ventana
        setTitle("Pantalla Principal");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Logotipo (imagen PNG)
        ImageIcon logoIcon = new ImageIcon("src/proyect_vacaciones/img/Logo_ArtTec.png");
        Image imagen = logoIcon.getImage();
        Image imagenEscalada = imagen.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
        ImageIcon logoIconEscalado = new ImageIcon(imagenEscalada);
        etiquetaLogo = new JLabel(logoIconEscalado);
        etiquetaLogo.setBounds(225, 10, 150, 100);
        add(etiquetaLogo);

        // Texto para mostrar el nombre del usuario
        etiquetaUsuario = new JLabel("Usuario: " + nombreUsuario, SwingConstants.CENTER);
        etiquetaUsuario.setBounds(0, 120, 600, 30);
        add(etiquetaUsuario);

        // Campos de texto para nombre y apellidos
        campoNombre = new JTextField();
        campoNombre.setBounds(100, 160, 200, 30);
        add(campoNombre);
        
        // Etiqueta para el nombre
        JLabel labelNombre = new JLabel("Nombre:");
        labelNombre.setBounds(30, 160, 70, 30);
        add(labelNombre);

        // Etiqueta para los apellidos
        JLabel labelApellidos = new JLabel("Apellidos:");
        labelApellidos.setBounds(30, 200, 70, 30);
        add(labelApellidos);

        // Campo de texto para los apellidos
        campoApellidos = new JTextField();
        campoApellidos.setBounds(100, 200, 200, 30);
        add(campoApellidos);


        // Campo de texto para resultado
        etiquetaResultado = new JLabel("Resultado del cálculo:");
        etiquetaResultado.setBounds(100, 240, 200, 30);
        add(etiquetaResultado);

        campoResultado = new JTextField();
        campoResultado.setBounds(100, 270, 200, 30);
        campoResultado.setEditable(false); // Solo lectura
        add(campoResultado);

        // Lista desplegable para seleccionar el departamento
        String[] departamentos = {"Ventas", "Logística", "Finanzas", "IT"};
        comboDepartamento = new JComboBox<>(departamentos);
        comboDepartamento.setBounds(350, 160, 150, 30);
        add(comboDepartamento);

        // Lista desplegable para seleccionar la antigüedad
        String[] antiguedades = {"Menos de 1 año", "1-3 años", "3-5 años"};
        comboAntiguedad = new JComboBox<>(antiguedades);
        comboAntiguedad.setBounds(350, 200, 150, 30);
        add(comboAntiguedad);

        // Botón de calcular
        botonCalcular = new JButton("Calcular Vacaciones");
        botonCalcular.setBounds(100, 320, 150, 30);
        add(botonCalcular);

        // Botón de limpiar
        botonLimpiar = new JButton("Limpiar");
        botonLimpiar.setBounds(260, 320, 100, 30);
        add(botonLimpiar);

        // Botón de regresar
        botonRegresar = new JButton("Regresar");
        botonRegresar.setBounds(370, 320, 100, 30);
        add(botonRegresar);

        // Leyenda al pie
        JLabel etiquetaDesarrollador = new JLabel("©2024 Studio ArTec Company", SwingConstants.CENTER);
        etiquetaDesarrollador.setBounds(0, 420, 600, 30);
        add(etiquetaDesarrollador);

        // Funcionalidad del botón Calcular
        botonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularVacaciones();
            }
        });

        // Funcionalidad del botón Limpiar
        botonLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        // Funcionalidad del botón Regresar
        botonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Bienvenida_proyecto().setVisible(true);
                dispose(); // Cerrar la pantalla actual
            }
        });

        // Configurar el ícono de la aplicación en la barra del formulario
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/proyect_vacaciones/img/Logo_ArtTec.png"));

        // Hacer visible la ventana
        setVisible(true);
    }

    private void calcularVacaciones() {
        String nombre = campoNombre.getText().trim();
        String apellidos = campoApellidos.getText().trim();
        String departamento = (String) comboDepartamento.getSelectedItem();
        String antiguedad = (String) comboAntiguedad.getSelectedItem();
        
        if (nombre.isEmpty() || apellidos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese su nombre y apellidos.");
            return;
        }

        int diasVacaciones = 0;

        // Determinar los días de vacaciones según el departamento y la antigüedad
        if (departamento.equals("Ventas")) {
            if (antiguedad.equals("Menos de 1 año")) {
                diasVacaciones = 6;
            } else if (antiguedad.equals("1-3 años")) {
                diasVacaciones = 14;
            } else if (antiguedad.equals("3-5 años")) {
                diasVacaciones = 20;
            } 
        } else if (departamento.equals("Logística")) {
            if (antiguedad.equals("Menos de 1 año")) {
                diasVacaciones = 7;
            } else if (antiguedad.equals("1-3 años")) {
                diasVacaciones = 15;
            } else if (antiguedad.equals("3-5 años")) {
                diasVacaciones = 22;
            } 
        } else if (departamento.equals("Finanzas")) { // Ajustar según lógica deseada
            if (antiguedad.equals("Menos de 1 año")) {
                diasVacaciones = 10;
            } else if (antiguedad.equals("1-3 años")) {
                diasVacaciones = 20;
            } else if (antiguedad.equals("3-5 años")) {
                diasVacaciones = 30;
            } 
        } else if (departamento.equals("IT")) { // Ajustar según lógica deseada
            if (antiguedad.equals("Menos de 1 año")) {
                diasVacaciones = 10;
            } else if (antiguedad.equals("1-3 años")) {
                diasVacaciones = 20;
            } else if (antiguedad.equals("3-5 años")) {
                diasVacaciones = 30;
            } 
        }

        campoResultado.setText(String.valueOf(diasVacaciones));
    }

    private void limpiarCampos() {
        campoNombre.setText("");
        campoApellidos.setText("");
        campoResultado.setText("");
        comboDepartamento.setSelectedIndex(0);
        comboAntiguedad.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        new PantallaPrincipal("UsuarioEjemplo"); // Pasar un nombre de ejemplo
    }
}