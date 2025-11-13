package com.paradigmas.tpfinalventas.ui;

import com.paradigmas.tpfinalventas.ui.abm.AbmCliente;
import com.paradigmas.tpfinalventas.ui.abm.AbmFactura;
import com.paradigmas.tpfinalventas.ui.abm.AbmProducto;
import com.paradigmas.tpfinalventas.ui.abm.ContentInicio;
import java.awt.*;
import javax.swing.*;

public class PrincipalLateral extends JFrame {

    private JPanel content;

    public PrincipalLateral() {
        initComponents();
        showPanel(new ContentInicio());
    }

    private void showPanel(JPanel panel) {
        content.removeAll();
        content.add(panel, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    private void initComponents() {
        // Panel principal
        JPanel bg = new JPanel(new BorderLayout());
        bg.setBackground(new Color(230, 230, 230)); // fondo general claro

        // Menú lateral
        JPanel sideMenu = new JPanel();
        sideMenu.setLayout(new BoxLayout(sideMenu, BoxLayout.Y_AXIS));
        sideMenu.setBackground(new Color(33, 33, 33)); // gris oscuro
        sideMenu.setPreferredSize(new Dimension(200, 600));

        // Título del sistema
        JLabel title = new JLabel("Sistema de Ventas");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        sideMenu.add(title);

        // Botones modernos
        JButton btnInicio = createMenuButton("Inicio");
        JButton btnCliente = createMenuButton("Clientes");
        JButton btnProducto = createMenuButton("Productos");
        JButton btnFactura = createMenuButton("Facturas");

        // Acciones
        btnInicio.addActionListener(e -> showPanel(new ContentInicio()));
        btnCliente.addActionListener(e -> {
            try {
                showPanel(new AbmCliente());
            } catch (Exception ex) {
                System.getLogger(PrincipalLateral.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        });
        btnProducto.addActionListener(e -> showPanel(new AbmProducto()));
        btnFactura.addActionListener(e -> showPanel(new AbmFactura()));

        // Agregar botones al menú
        sideMenu.add(btnInicio);
        sideMenu.add(Box.createVerticalStrut(10));
        sideMenu.add(btnCliente);
        sideMenu.add(Box.createVerticalStrut(10));
        sideMenu.add(btnProducto);
        sideMenu.add(Box.createVerticalStrut(10));
        sideMenu.add(btnFactura);

        // Panel de contenido
        content = new JPanel(new BorderLayout());
        content.setBackground(Color.WHITE);

        // Agregar al panel principal
        bg.add(sideMenu, BorderLayout.WEST);
        bg.add(content, BorderLayout.CENTER);

        // Configuración de ventana
        setContentPane(bg);
        setTitle("Sistema de Ventas - Interfaz Moderna");
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Método para crear botones modernos
    private JButton createMenuButton(String text) {
        JButton button = new JButton(text);
        button.setMaximumSize(new Dimension(180, 45));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBackground(new Color(55, 71, 79)); // azul grisáceo
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Efecto hover
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(38, 50, 56));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(55, 71, 79));
            }
        });

        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PrincipalLateral().setVisible(true));
    }
}
