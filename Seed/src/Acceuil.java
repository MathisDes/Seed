import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class Acceuil {

	private JFrame frame;
	private JTextField barreRecherche;
	private Session maSession;
	private JLabel   txtTitreFilm, txtTitreLivre, txtTitreJeux, texte, lblImageFilm , lblImageLivre, lblImageJeux;
	private Connection connection;


	public Acceuil(String id) {
		
		
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
		JButton searchButton = new JButton("Rechercher");
		searchButton.setBounds(800, 27, 150, 49);
        panel.add(searchButton);
		panel.add(barreRecherche);
		barreRecherche.setColumns(10);
		

		JLabel title = new JLabel("Bienvenue sur le SEED votre adresse mail est " + maSession.getEmail());
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
		
		btnJeux.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ProduitPageJeu PageJeu = new ProduitPageJeu("3",maSession.getEmail());
        	}
        });
		/*btnFilm.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ProduitPageFilm PageFilm = new ProduitPageFilm("3",maSession.getEmail());
        	}
        });*/
		btnLivre.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ProduitPageLivre PageLivre = new ProduitPageLivre("13",maSession.getEmail());
        	}
        });
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 128, 0));
		panel_1.setBounds(69, 320, 1290, 294);
		frame.getContentPane().add(panel_1);
		frame.setVisible(true);
		
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/seed", "root", "");
            PreparedStatement st = conn.prepareStatement("SELECT * FROM films ORDER BY annee DESC LIMIT 1 ");
            PreparedStatement stLivre = conn.prepareStatement("SELECT * FROM livre ORDER BY studio DESC LIMIT 1 ");
            PreparedStatement stJeux = conn.prepareStatement("SELECT * FROM jeux ORDER BY annee DESC LIMIT 1 ");
            ResultSet rs = st.executeQuery();
            ResultSet rsLivre = stLivre.executeQuery();
            ResultSet rsJeux = stJeux.executeQuery();
            if (rs.next()) {
                String titre = rs.getString("titre");
                String image_url = rs.getString("img_url");
              
                
                txtTitreFilm = new JLabel(titre);
                lblImageFilm = new JLabel();
                txtTitreFilm.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 24));
                txtTitreFilm.setBounds(500, 75, 461, 37);
                panel_1.add(txtTitreFilm);

            }
            if (rsLivre.next()) {
                String nom = rsLivre.getString("nom");
                String image_url = rsLivre.getString("img_url");
               
                
                txtTitreLivre = new JLabel(nom);
                lblImageLivre = new JLabel();
                txtTitreLivre.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 24));
                txtTitreLivre.setBounds(20, 75, 461, 37);
                panel_1.add(txtTitreLivre);

              
           
            }
            if (rsJeux.next()) {
                String nom2 = rsJeux.getString("nom");
                String image_url = rsJeux.getString("img_url");
               
              
                
                txtTitreJeux = new JLabel(nom2);
                lblImageJeux = new JLabel();
                txtTitreJeux.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 24));
                txtTitreJeux.setBounds(950, 75, 461, 37);
                panel_1.add(txtTitreJeux);

               
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        texte = new JLabel("Oeuvre les plus récentes");

        texte.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 32));
        texte.setBounds(450, 10, 461, 37);
        panel_1.add(texte);
        
        
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = barreRecherche.getText();
                performSearch(searchTerm);
             
            }
        });
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/seed", "root", "");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
	}
	

	   private void performSearch(String searchTerm ) {
		   List<String> resultsL = new ArrayList<>();
		   List<String> resultsJ = new ArrayList<>();
		   List<String> resultsF = new ArrayList<>();

	        // Rechercher dans la première table
	        String table1Sql = "SELECT * FROM films WHERE titre LIKE ?";
	        try {
	            PreparedStatement statement = connection.prepareStatement(table1Sql);
	            statement.setString(1, "%" + searchTerm + "%");
	            ResultSet resultSet = statement.executeQuery();

	            // Parcourir les résultats de la recherche
	            while (resultSet.next()) {
	                String result = resultSet.getString("id");
	                resultsF.add(result);
	            }

	            statement.close();
	            resultSet.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }

	        // Rechercher dans la deuxième table
	        String table2Sql = "SELECT * FROM livre WHERE nom LIKE ?";
	        try {
	            PreparedStatement statement = connection.prepareStatement(table2Sql);
	            statement.setString(1, "%" + searchTerm + "%");
	            ResultSet resultSet = statement.executeQuery();

	            // Parcourir les résultats de la recherche
	            while (resultSet.next()) {
	                String result = resultSet.getString("id");
	                resultsL.add(result);
	            }

	            statement.close();
	            resultSet.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        // Rechercher dans la troisième table
	        String table3Sql = "SELECT * FROM jeux WHERE nom LIKE ?";
	        try {
	            PreparedStatement statement = connection.prepareStatement(table3Sql);
	            statement.setString(1, "%" + searchTerm + "%");
	            ResultSet resultSet = statement.executeQuery();

	            // Parcourir les résultats de la recherche
	            while (resultSet.next()) {
	                String result = resultSet.getString("id");
	                resultsJ.add(result);
	            }

	            statement.close();
	            resultSet.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }


	        // Traiter les résultats
	        for (String result : resultsJ ) {
	        	ProduitPageJeu PageJeu = new ProduitPageJeu(result , maSession.getEmail());
	        }
	        for (String result : resultsL ) {
	        	ProduitPageLivre PageLivre = new ProduitPageLivre(result , maSession.getEmail());
	        }
	       
	        for (String result : resultsF ) {
	        	ProduitPageFilm PageFilm = new ProduitPageFilm(result, maSession.getEmail());
	        }
	    }

public static void main(String[] args) {

	Acceuil window = new Acceuil("hugo@gmail.com");
	window.frame.setVisible(true);

}
}
