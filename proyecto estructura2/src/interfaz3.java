import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class interfaz3 extends JFrame {
	    
    public interfaz3() {
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
                btnPractica.setBackground(new Color(255, 255, 255));
                btnPractica.setBounds(0, 11, 93, 23);
                panel.add(btnPractica);
                btnPractica.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                	}
                });
                btnPractica.setAlignmentX(Component.CENTER_ALIGNMENT);
                
                        JButton btnTeoria = new JButton("Teoria");
                        btnTeoria.setBackground(new Color(192, 192, 192));
                        btnTeoria.setBounds(103, 11, 92, 23);
                        panel.add(btnTeoria);
                        btnTeoria.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		 interfaz2 frame = new interfaz2();
                                 frame.setLocationRelativeTo(null);
                                 frame.setVisible(true);
                                 dispose();
                        	}
                        });
                        btnTeoria.setAlignmentX(Component.CENTER_ALIGNMENT);

       
        JPanel footerPanel = new JPanel();
        JLabel lblFooter = new JLabel("GeLic. Nius");
        lblFooter.setBounds(10, 510, 74, 14);
        mainPanel.add(lblFooter);
        
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

        System.out.println("Recorrido por anchura/ (inciando en el vertice 4): ");
        grafo.recorridoAnchura(4);
    }
}

