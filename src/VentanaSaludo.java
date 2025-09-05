import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;

public class VentanaSaludo extends JFrame {

    private JTextField campoTexto;
    private JButton botonSaludar;
    private JLabel etiquetaSaludo;

    public VentanaSaludo() {
        super("App de Saludo ICC490");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        // Métodos auxiliares para organizar el código
        initializeComponents();
        addComponentsToFrame();
        setupListeners();
    }

    private void initializeComponents() {
        campoTexto = new JTextField();
        campoTexto.setBounds(50, 30, 200, 25);

        botonSaludar = new JButton("Saludar");
        botonSaludar.setBounds(270, 30, 100, 25);

        etiquetaSaludo = new JLabel("");
        etiquetaSaludo.setBounds(50, 80, 300, 25);
    }

    private void addComponentsToFrame() {
        this.add(campoTexto);
        this.add(botonSaludar);
        this.add(etiquetaSaludo);
    }

    private void setupListeners() {
        botonSaludar.addActionListener(e -> saludar());
    }

    private void saludar() {
        String nombre = campoTexto.getText().trim();
        etiquetaSaludo.setText("Hola, " + nombre);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaSaludo().setVisible(true);
        });
    }
}