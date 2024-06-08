import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class interfaz2 extends JFrame {
	
	 	private JPanel mainPanel;
	    private CardLayout cardLayout;
	    private String[] teoriaContenido;
	    private ImageIcon[] teoriaImagenes;
	    private int currentIndex = 0;
	
    public interfaz2() {
        setTitle("Estructura GeLic. Nius");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

       
        JPanel mainPanel = new JPanel();
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
                btnPractica.setBackground(new Color(192, 192, 192));
                btnPractica.setBounds(0, 11, 93, 23);
                panel.add(btnPractica);
                btnPractica.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		interfaz3 frame = new interfaz3();
                		frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                        dispose();
                	}
                });
                btnPractica.setAlignmentX(Component.CENTER_ALIGNMENT);
                
                        JButton btnTeoria = new JButton("Teoria");
                        btnTeoria.setBackground(new Color(255, 255, 255));
                        btnTeoria.setBounds(103, 11, 92, 23);
                        panel.add(btnTeoria);
                        btnTeoria.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                            	cardLayout.show(mainPanel, "teoria");
                            }
                        });
                        btnTeoria.setAlignmentX(Component.CENTER_ALIGNMENT);

       
        JPanel footerPanel = new JPanel();
        JLabel lblFooter = new JLabel("GeLic. Nius");
        lblFooter.setBounds(10, 510, 104, 14);
        mainPanel.add(lblFooter);
        
        //
        cardLayout = new CardLayout();
        JPanel teoriaPanel = new JPanel(cardLayout);
        teoriaPanel.setBounds(50, 160, 300, 300);
        mainPanel.add(teoriaPanel);

        teoriaContenido = new String[]{
            "Teoría 1: Introducción a los grafos",
            "Teoría 2: Partes de un grafo",
            "Teoría 3: Recorrido por anchura..."
        };

        teoriaImagenes = new ImageIcon[]{
            new ImageIcon("ruta/a/imagen1.png"),
            new ImageIcon("ruta/a/imagen2.png"),
            new ImageIcon("ruta/a/imagen3.png")
        };

       
        for (int i = 0; i < teoriaContenido.length; i++) {
            JPanel panelTeoria = new JPanel();
            panelTeoria.setLayout(new BorderLayout());

            JLabel lblTeoria = new JLabel(teoriaContenido[i]);
            lblTeoria.setFont(new Font("Arial", Font.PLAIN, 16));
            lblTeoria.setHorizontalAlignment(JLabel.CENTER);
            panelTeoria.add(lblTeoria, BorderLayout.NORTH);

            JLabel imgTeoria = new JLabel(teoriaImagenes[i]);
            imgTeoria.setHorizontalAlignment(JLabel.CENTER);
            panelTeoria.add(imgTeoria, BorderLayout.CENTER);

            teoriaPanel.add(panelTeoria, "Teoria" + i);
        }

        JPanel btnPanel = new JPanel();
        JButton btnAnterior = new JButton("Anterior");
        btnAnterior.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentIndex > 0) {
                    currentIndex--;
                    cardLayout.show(teoriaPanel, "Teoria" + currentIndex);
                }
            }
        });

        JButton btnSiguiente = new JButton("Siguiente");
        btnSiguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentIndex < teoriaContenido.length - 1) {
                    currentIndex++;
                    cardLayout.show(teoriaPanel, "Teoria" + currentIndex);
                }
            }
        });

        btnPanel.add(btnAnterior);
        btnPanel.add(btnSiguiente);
        btnPanel.setBounds(100, 470, 200, 50);
        mainPanel.add(btnPanel);

        
        cardLayout.show(teoriaPanel, "Teoria0");
    
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                interfaz2 frame = new interfaz2();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

