import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.Font;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Button;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class WindowBuilder extends JFrame {

	private JFrame frame;
	private JTextField barreRecherche;
	private Session maSession;
	private JLabel   txtTitreFilm, txtTitreLivre, txtTitreJeux, texte, lblImageFilm , lblImageLivre, lblImageJeux;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilder frame = new WindowBuilder();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WindowBuilder() {
		
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
			
			// Créer un composant d'image
	        ImageIcon imageIcon = new ImageIcon("C:/laragon/www/Seed_directory/Seed/src/others/logo.png");
	        JLabel label = new JLabel(imageIcon);

	        // Ajouter le composant à la fenêtre
	        getContentPane().add(label);
	        label.setVisible(true);
	   
			
			
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
			
			frame.getContentPane().add(panel);
			
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setBounds(20, 10, 123, 80);
			panel.add(lblNewLabel);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(71, 146, 1268, 468);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(new GridLayout(1, 0, 0, 0));
			
			JLabel lblNewLabel_1 = new JLabel("Mes Reservations en cours");
			lblNewLabel_1.setFont(new Font("Montserrat", Font.BOLD, 22));
			lblNewLabel_1.setBounds(501, 110, 412, 43);
			frame.getContentPane().add(lblNewLabel_1);
			frame.setVisible(true);
      
	}
}
