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

public class panier {

	private JFrame frame;
	private JTextField barreRecherche;

	public static void main(String[] args) {

		panier window = new panier();
		window.frame.setVisible(true);

	}


	public panier() {
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
		
		JButton btnRetour = new JButton("<- Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnRetour.setBounds(1193, 10, 180, 80);
		panel.add(btnRetour);
		
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.setBackground(new Color(255, 128, 64));
		panel_1.setBounds(689, 138, 416, 499);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnValier = new JButton("Valider");
		btnValier.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnValier.setBounds(119, 427, 174, 42);
		panel_1.add(btnValier);
	}
}