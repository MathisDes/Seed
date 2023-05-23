import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JSlider;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Mes_resa {

	private JFrame frame;
	private JTextField barreRecherche;
	private Session maSession;
	private JLabel   txtTitreFilm, txtTitreLivre, txtTitreJeux, texte, lblImageFilm , lblImageLivre, lblImageJeux;
	public static void main(String[] args) {

		Mes_resa window = new Mes_resa("hugo@gmail.com");
		window.frame.setVisible(true);

	}


	public Mes_resa(String id) {
		
		
	
		
		
		maSession = new Session(id);
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
		
		     
        JLabel image = new JLabel();
        image.setIcon(new ImageIcon(new ImageIcon("C:/laragon/www/Seed_directory/Seed/src/others/logo.png").getImage().getScaledInstance(173, 150, Image.SCALE_DEFAULT)));
        
        image.setBounds(5, 0, 160, 100);
        panel.add(image);

        JLabel lblNewLabel_1 = new JLabel("Mes Reservations en cours");
		lblNewLabel_1.setFont(new Font("Montserrat", Font.BOLD, 22));
		lblNewLabel_1.setBounds(501, 110, 412, 43);
		frame.getContentPane().add(lblNewLabel_1);
		
		
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(71, 200, 1268, 468);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 10, 10)); // GridLayout avec 2 colonnes et un espacement de 10 pixels

		frame.setVisible(true);

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/seed", "root", "");
		     Statement stmt = conn.createStatement()) {

		    // Requête pour récupérer les informations sur le produit correspondant
		    String sql = "SELECT e.id, e.date_emprunt, e.date_retour, \r\n"
		    		+ "       IF(e.item_type = 'jeu', j.nom, IF(e.item_type = 'livre', l.nom, f.titre)) AS item_nom,\r\n"
		    		+ "       IF(e.item_type = 'jeu', j.img_url, IF(e.item_type = 'livre', l.img_url, f.img_url)) AS item_img_url,\r\n"
		    		+ "       IF(e.item_type = 'jeu', j.prix, IF(e.item_type = 'livre', l.prix, NULL)) AS item_prix,\r\n"
		    		+ "       IF(e.item_type = 'jeu', j.studio, IF(e.item_type = 'livre', l.auteur, f.realisateur)) AS item_auteur_realisateur,\r\n"
		    		+ "       IF(e.item_type = 'jeu', j.annee, IF(e.item_type = 'livre', l.studio, f.annee)) AS item_annee_studio,\r\n"
		    		+ "       IF(e.item_type = 'jeu', j.resume, IF(e.item_type = 'livre', l.resume, f.synopsis)) AS item_resume_synopsis,\r\n"
		    		+ "       IF(e.item_type = 'jeu', j.img_url, IF(e.item_type = 'livre', l.img_url, f.img_url)) AS item_img_url,\r\n"
		    		+ "       IF(e.item_type = 'jeu', 'jeu', IF(e.item_type = 'livre', 'livre', 'film')) AS item_type\r\n"
		    		+ "FROM emprunts e\r\n"
		    		+ "LEFT JOIN jeux j ON e.id_jeu = j.id\r\n"
		    		+ "LEFT JOIN livre l ON e.id_livre = l.id\r\n"
		    		+ "LEFT JOIN films f ON e.id_film = f.id\r\n"		    		
		    		+ "WHERE e.utilisateur = '"+ maSession.getEmail()+"';\r\n"
		    		+ "";
		    try (ResultSet rs = stmt.executeQuery(sql)) {
		    	int nbrProduit = 0;
		    	while (rs.next()) {
		    		nbrProduit = nbrProduit + 1;
		    	    String nomItem = rs.getString("item_nom");
		    	    String itemType = rs.getString("item_type");
		    	    String itemUrl = rs.getString("item_img_url");
		    	    String dateEmprunt = rs.getString("date_emprunt");
		    	    String dateRetour = rs.getString("date_retour");

		    	    LocalDate startDate = LocalDate.parse(dateEmprunt);
		    	    LocalDate endDate = LocalDate.parse(dateRetour);

		    	    long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

		    	    // Création et configuration du JLabel pour afficher les informations de l'emprunt
		    	    JLabel label = new JLabel("<html><b>" + nomItem + "</b><br><br><br><br><br>"
		    	            + "Type de produit: " + itemType + "<br>"
		    	            + "Date d'emprunt: " + dateEmprunt + "<br>"
		    	            + "Date de retour: " + dateRetour + "<br>"
		    	            + "Nombre jours restants: " + daysBetween + "<br></html>");

		    	    JLabel imageLabel = new JLabel();
		    	    try {
		    	        URL imageUrl = new URL(itemUrl);
		    	        BufferedImage imageRender = ImageIO.read(imageUrl);
		    	        ImageIcon icon = new ImageIcon(imageRender);
		    	        imageLabel.setIcon(new ImageIcon(icon.getImage().getScaledInstance(173, 150, Image.SCALE_DEFAULT)));
		    	    } catch (IOException e) {
		    	        e.printStackTrace();
		    	    }

		    	    // Création d'un JPanel pour contenir l'image et l'étiquette des informations de l'emprunt
		    	    JPanel empruntPanel = new JPanel();
		    	    empruntPanel.setLayout(new BorderLayout());

		    	    JPanel textPanel = new JPanel(new BorderLayout());
		    	    textPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0)); // Ajout d'une marge de 10 pixels en haut du texte
		    	    textPanel.add(label, BorderLayout.NORTH);

		    	    JPanel imagePanel = new JPanel();
		    	    imagePanel.add(imageLabel);

		    	    empruntPanel.add(textPanel, BorderLayout.CENTER);
		    	    empruntPanel.add(imagePanel, BorderLayout.WEST);

		    	    panel_1.add(empruntPanel); // Ajout du JPanel de l'emprunt au JPanel principal
		    	}
		     
		    	if (nbrProduit >4) {
		    		frame.setSize(1400,700+((nbrProduit-4)*65));
		    	}
		    }
		} catch (SQLException e) {
		    // Erreur de connexion à la base de données
		    JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données : " + e.getMessage());
		    e.printStackTrace();
		}

}}