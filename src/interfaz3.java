import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class interfaz3 extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private String[] practicaContenido;
    private ImageIcon[] practicaImagenes;
    private int currentIndex = 0;

    public interfaz3() {
        setTitle("Estructura GeLic. Nius");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 255, 255));
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        mainPanel.setLayout(null);

        JLabel lblTitle = new JLabel("Estructura GeLic. Nius");
        lblTitle.setBounds(62, 29, 259, 28);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(lblTitle);

        JLabel lblSubtitle = new JLabel("Aprendizaje disponible para todos");
        lblSubtitle.setBounds(85, 68, 215, 17);
        lblSubtitle.setFont(new Font("Arial", Font.ITALIC, 14));
        lblSubtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(lblSubtitle);

        JPanel panel = new JPanel();
        panel.setBounds(95, 96, 205, 50);
        mainPanel.add(panel);
        panel.setLayout(null);

        JButton btnPractica = new JButton("Practica");
        btnPractica.setBackground(new Color(255, 255, 255));
        btnPractica.setBounds(0, 11, 93, 23);
        panel.add(btnPractica);
        btnPractica.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnPractica1 = new JButton("Teoria");
        btnPractica1.setBackground(new Color(192, 192, 192));
        btnPractica1.setBounds(103, 11, 92, 23);
        panel.add(btnPractica1);
        btnPractica1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                interfaz2 frame = new interfaz2();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                dispose();
            }
        });
        btnPractica1.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel footerPanel = new JPanel();
        JLabel lblFooter = new JLabel("GeLic. Nius");
        lblFooter.setBounds(10, 510, 74, 14);
        mainPanel.add(lblFooter);

       /* cardLayout = new CardLayout();
        JPanel practicapanel = new JPanel(cardLayout);
        practicapanel.setBounds(50, 160, 300, 300);
        mainPanel.add(practicapanel);

        practicaContenido = new String[]{
            "practica 1: Conceptos",
            "practica 2: tipos de grafo",
            "practica 3: Recorridos..."
        };

        practicaImagenes = new ImageIcon[]{
            new ImageIcon("ruta/a/imagen1.png"),
            new ImageIcon("ruta/a/imagen2.png"),
            new ImageIcon("ruta/a/imagen3.png")
        };

        for (int i = 0; i < practicaContenido.length; i++) {
            JPanel panelPractica = new JPanel();
            panelPractica.setLayout(new BorderLayout());

            JLabel lblPractica = new JLabel(practicaContenido[i]);
            lblPractica.setFont(new Font("Arial", Font.PLAIN, 16));
            lblPractica.setHorizontalAlignment(JLabel.CENTER);
            panelPractica.add(lblPractica, BorderLayout.NORTH);

            JLabel lblPractica1 = new JLabel(practicaImagenes[i]);
            lblPractica1.setHorizontalAlignment(JLabel.CENTER);
            panelPractica.add(lblPractica1, BorderLayout.CENTER);

            practicapanel.add(panelPractica, "Practica" + i);
        }

        JPanel btnPanel = new JPanel();
        JButton btnAnterior = new JButton("Anterior");
        btnAnterior.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentIndex > 0) {
                    currentIndex--;
                    cardLayout.show(practicapanel, "Practica" + currentIndex);
                }
            }
        });

        JButton btnSiguiente = new JButton("Siguiente");
        btnSiguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentIndex < practicaContenido.length - 1) {
                    currentIndex++;
                    cardLayout.show(practicapanel, "Practica" + currentIndex);
                }
            }
        });

        btnPanel.add(btnAnterior);
        btnPanel.add(btnSiguiente);
        btnPanel.setBounds(100, 470, 200, 50);
        mainPanel.add(btnPanel);

        cardLayout.show(practicapanel, "Practica0");*/

        // Crear e integrar el grafo
        Grafo grafo = new Grafo();
        grafo.agregarVertice(7);
        grafo.agregarVertice(9);
        grafo.agregarVertice(5);
        grafo.agregarVertice(1);
        grafo.agregarVertice(6);
        grafo.agregarVertice(4);
        grafo.agregarVertice(3);
        grafo.agregarVertice(2);

        grafo.agregarArco(1, 3);
        grafo.agregarArco(1, 2);
        grafo.agregarArco(3, 1);
        grafo.agregarArco(3, 4);
        grafo.agregarArco(2, 4);
        grafo.agregarArco(2, 5);
        grafo.agregarArco(2, 6);
        grafo.agregarArco(5, 4);
        grafo.agregarArco(5, 7);
        grafo.agregarArco(6, 7);
        grafo.agregarArco(7, 9);

        GrafoPanel grafoPanel = new GrafoPanel(grafo);
        grafoPanel.setBounds(50, 150, 300, 300); // Posición y tamaño del panel del grafo
        mainPanel.add(grafoPanel);

        System.out.println("Recorrido por anchura (iniciando en el vertice 4): ");
        grafo.recorridoAnchura(4);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                interfaz3 frame = new interfaz3();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

