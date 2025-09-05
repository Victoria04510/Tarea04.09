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

        this.getContentPane().setBackground(Color.decode("#ADD8E6"));
        etiquetaSaludo.setFont(new Font("Arial", Font.BOLD, 14));
    }

    private void addComponentsToFrame() {
        this.add(campoTexto);
        this.add(botonSaludar);
        this.add(etiquetaSaludo);
    }

    private void setupListeners() {
        // Añade un KeyListener para detectar cuando se presiona la tecla Enter.
        campoTexto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    saludar();
                }
            }
        });

        // Añade un ActionListener al botón.
        botonSaludar.addActionListener(e -> saludar());
    }

    private void saludar() {
        String nombre = campoTexto.getText().trim();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa tu nombre.");
            etiquetaSaludo.setText("");
        } else {
            etiquetaSaludo.setText("¡Hola, " + nombre + "!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaSaludo().setVisible(true);
        });
    }
}