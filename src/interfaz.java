import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class interfaz extends JFrame {
	
    public interfaz() {
        setTitle("Estructura GeLic. Nius");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

      
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 255, 255));
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        mainPanel.setLayout(null);

      
        JLabel lblTitle = new JLabel("Estructura ");
        lblTitle.setBounds(76, 11, 215, 28);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 35));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(lblTitle);

      
        JLabel lblSubtitle = new JLabel("Aprendizaje disponible para todos");
        lblSubtitle.setBounds(76, 105, 215, 17);
        lblSubtitle.setFont(new Font("Arial", Font.ITALIC, 14));
        lblSubtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(lblSubtitle);

        
        JButton btnPractica = new JButton("Practica");
        btnPractica.setBackground(new Color(192, 192, 192));
        btnPractica.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		interfaz3 frame = new interfaz3();
        		frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                dispose();
        	}
        });
        btnPractica.setBounds(62, 226, 117, 48);
        btnPractica.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(btnPractica);

        JButton btnTeoria = new JButton("Teoria");
        btnTeoria.setBackground(new Color(192, 192, 192));
        btnTeoria.setBounds(210, 226, 117, 48);
        btnTeoria.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(btnTeoria);
        btnTeoria.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                interfaz2 frame = new interfaz2();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                dispose();
                
            }
        });
        
        JLabel lblNewLabel = new JLabel("GeLic. Nius");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
        lblNewLabel.setBounds(76, 50, 232, 44);
        mainPanel.add(lblNewLabel);
        JLabel lblFooter = new JLabel("GeLic. Nius");
        lblFooter.setBounds(10, 510, 74, 14);
        mainPanel.add(lblFooter);

        
        JPanel footerPanel = new JPanel();
        getContentPane().add(footerPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                interfaz frame = new interfaz();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
