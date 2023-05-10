import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JToolBar;
import javax.swing.JMenu;

public class film {

	private JFrame frame;
	private JTextField barreRecherche;

	public static void main(String[] args) {

		film window = new film();
		window.frame.setVisible(true);

	}


	public film() {
        frame = new JFrame();
        frame.setSize(1400,700);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 1400, 100);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnPanier = new JButton("Mes réservations");
		btnPanier.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnPanier.setBounds(1193, 10, 180, 80);
		panel.add(btnPanier);
		
		JButton btnCompte = new JButton("Mon compte");
		btnCompte.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCompte.setBounds(967, 10, 180, 80);
		panel.add(btnCompte);
		
		barreRecherche = new JTextField();
		barreRecherche.setForeground(new Color(128, 128, 128));
		barreRecherche.setFont(new Font("Tahoma", Font.PLAIN, 17));
		barreRecherche.setText("Rechercher...");
		barreRecherche.setBounds(193, 27, 719, 49);
		panel.add(barreRecherche);
		barreRecherche.setColumns(10);
		
		JButton btnOeuvre2 = new JButton("FILM2");
		btnOeuvre2.setFont(new Font("Tahoma", Font.PLAIN, 31));
		btnOeuvre2.setBackground(Color.LIGHT_GRAY);
		btnOeuvre2.setBounds(936, 171, 319, 171);
		frame.getContentPane().add(btnOeuvre2);
		
		JButton btnOeuvre3 = new JButton("FILM3");
		btnOeuvre3.setFont(new Font("Tahoma", Font.PLAIN, 31));
		btnOeuvre3.setBackground(Color.LIGHT_GRAY);
		btnOeuvre3.setBounds(936, 458, 319, 171);
		frame.getContentPane().add(btnOeuvre3);
		
		JButton btnOeuvre1 = new JButton("FILM1");
		btnOeuvre1.setFont(new Font("Tahoma", Font.PLAIN, 31));
		btnOeuvre1.setBackground(Color.LIGHT_GRAY);
		btnOeuvre1.setBounds(84, 171, 319, 171);
		frame.getContentPane().add(btnOeuvre1);
		
		JButton btnOeuvre4 = new JButton("FILM4");
		btnOeuvre4.setFont(new Font("Tahoma", Font.PLAIN, 31));
		btnOeuvre4.setBackground(Color.LIGHT_GRAY);
		btnOeuvre4.setBounds(84, 458, 319, 171);
		frame.getContentPane().add(btnOeuvre4);
	}
}