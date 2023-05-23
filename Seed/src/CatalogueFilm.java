import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class CatalogueFilm {

    private JFrame frame;
    private JPanel panel_1;
    private JTextField barreRecherche;
    private Session maSession;

    

    public CatalogueFilm(String id) {
    	maSession = new Session(id);
        frame = new JFrame();
        frame.setSize(1400, 700);
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

        JLabel imageLogo = new JLabel();
		 imageLogo.setIcon(new ImageIcon(new ImageIcon("C:/laragon/www/Seed_directory/Seed/src/others/logo.png")
	                .getImage().getScaledInstance(173, 150, Image.SCALE_DEFAULT)));

		 imageLogo.setBounds(5, 0, 160, 100);
	        panel.add(imageLogo);
	        imageLogo.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) { 
	            	frame.dispose();
	            	Acceuil pageAcceuil = new Acceuil(id);
	            }
	        });
        
        panel.add(imageLogo);

        JLabel lblNewLabel_1 = new JLabel("Catalogue des Films");
        lblNewLabel_1.setFont(new Font("Montserrat", Font.BOLD, 22));
        lblNewLabel_1.setBounds(501, 110, 412, 43);
        frame.getContentPane().add(lblNewLabel_1);

        JButton btnPanier = new JButton("Mes réservations");
		btnPanier.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnPanier.setBounds(1193, 10, 180, 80);
		panel.add(btnPanier);
		btnPanier.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        		Mes_resa pageResa = new Mes_resa(id);
        	}
        });

        JButton btnCompte = new JButton("Acceuil\r\n");
		btnCompte.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCompte.setBounds(967, 10, 180, 80);
		panel.add(btnCompte);
		btnCompte.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
            	Acceuil pageAcceuil = new Acceuil(id);
        	}
        });

        barreRecherche = new JTextField();
        barreRecherche.setForeground(new Color(128, 128, 128));
        barreRecherche.setFont(new Font("Tahoma", Font.PLAIN, 17));
        barreRecherche.setText("Rechercher...");
        barreRecherche.setBounds(193, 27, 719, 49);
        panel.add(barreRecherche);
        barreRecherche.setColumns(10);

    
        panel_1 = new JPanel();
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(panel_1);
        scrollPane.setBounds(71, 200, 1268, 468);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        frame.getContentPane().add(scrollPane);

        frame.setVisible(true);

        // Connexion à la base de données et récupération des films
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/seed?useSSL=false", "root",
                "")) {

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM films";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int filmId = rs.getInt("id");
                String filmTitre = rs.getString("titre");
                String filmAnnee = rs.getString("annee");
                String filmGenre = rs.getString("genre");
                String filmRealisateur = rs.getString("realisateur");
                String filmActeurs = rs.getString("acteurs");
                String filmSynopsis = rs.getString("synopsis");
                String filmImgUrl = rs.getString("img_url");
                String filmPrix = rs.getString("prix");

                JLabel label = new JLabel("<html><b>" + filmTitre + "</b><br><br>" + "Année: " + filmAnnee + "<br>"
                        + "Genre: " + filmGenre + "<br>" + "Réalisateur: " + filmRealisateur + "<br>" + "Acteurs: "
                        + filmActeurs + "<br>" + "Synopsis: " + filmSynopsis + "<br>" + "Prix: " + filmPrix + "<br><br></html>");

                JLabel imageLabel = new JLabel();
                try {
                    URL imageUrl = new URL(filmImgUrl);
                    BufferedImage imageRender = ImageIO.read(imageUrl);
                    ImageIcon icon = new ImageIcon(imageRender);
                    imageLabel.setIcon(
                            new ImageIcon(icon.getImage().getScaledInstance(173, 150, Image.SCALE_DEFAULT)));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                JButton btnFilm = new JButton("Voir plus");
                btnFilm.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	 ProduitPageFilm PageFilm= new ProduitPageFilm(filmId, maSession.getEmail());
                    }
                });

                JPanel filmPanel = new JPanel();
                filmPanel.setLayout(new BorderLayout());

                JPanel textPanel = new JPanel(new BorderLayout());
                textPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
                textPanel.add(label, BorderLayout.NORTH);

                JPanel imagePanel = new JPanel();
                imagePanel.add(imageLabel);

                JPanel btnPanel = new JPanel();
                btnPanel.add(btnFilm);

                filmPanel.add(textPanel, BorderLayout.CENTER);
                filmPanel.add(imagePanel, BorderLayout.WEST);
                filmPanel.add(btnPanel, BorderLayout.SOUTH);

                panel_1.add(filmPanel);
            }

            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Erreur de connexion à la base de données : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
