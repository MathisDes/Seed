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

public class page1 {

	private JFrame frame;
	private JTextField barreRecherche;

	public static void main(String[] args) {

		page1 window = new page1();
		window.frame.setVisible(true);

	}


	public page1() {
        frame = new JFrame();
        frame.setSize(1400,700);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 1400, 100);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnPanier = new JButton("Mes réservations");
		btnPanier.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnPanier.setBounds(1193, 10, 180, 80);
		panel.add(btnPanier);
		
		JButton btnCompte = new JButton("Mon compte\r\n");
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
		
		JLabel title = new JLabel("Bienvenue sur le SEED");
		title.setFont(new Font("Tahoma", Font.PLAIN, 22));
		title.setBounds(10, 110, 255, 44);
		frame.getContentPane().add(title);
		
		JButton btnLivre = new JButton("Livre");
		btnLivre.setFont(new Font("Eras Bold ITC", Font.PLAIN, 25));
		btnLivre.setBounds(69, 193, 196, 85);
		frame.getContentPane().add(btnLivre);
		
		JButton btnFilm = new JButton("Film");
		btnFilm.setFont(new Font("Eras Bold ITC", Font.PLAIN, 25));
		btnFilm.setBounds(600, 193, 196, 85);
		frame.getContentPane().add(btnFilm);
		
		JButton btnJeux = new JButton("Jeux");
		btnJeux.setFont(new Font("Eras Bold ITC", Font.PLAIN, 25));
		btnJeux.setBounds(1163, 193, 196, 85);
		frame.getContentPane().add(btnJeux);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 128, 0));
		panel_1.setBounds(69, 320, 1290, 294);
		frame.getContentPane().add(panel_1);
	}
}
