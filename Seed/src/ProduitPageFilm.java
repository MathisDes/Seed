import java.sql.*;
import java.time.LocalDate;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ProduitPageFilm extends JFrame {
private JLabel  lblImage, txtTitre,txtActeurs, txtSortie, txtRealisateur, txtGenre;
private JTextPane txtDescription;
private JPanel contentPane;
private JFrame frame;

public ProduitPageFilm(int idFilm,String idCompte) {
    super("Détails du Film ");

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    // Connexion à la base de données
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/seed", "root", "");
         Statement stmt = conn.createStatement()) {

        // Requête pour récupérer les informations sur le produit correspondant
        String sql = "SELECT * FROM films WHERE id = " + idFilm;
        try (ResultSet rs = stmt.executeQuery(sql)) {

            // Si le produit existe, affichage des informations dans l'interface
            if (rs.next()) {
                String titre = rs.getString("titre");
                String description = rs.getString("synopsis");
                String image_url = rs.getString("img_url");
                String sortie = rs.getString("annee");
                String acteurs = rs.getString("acteurs");
                String realisateur = rs.getString("realisateur");
                String genre = rs.getString("genre");
                String prix = rs.getString("prix");

                txtTitre = new JLabel(titre);
           
                txtSortie = new JLabel(sortie);
                txtRealisateur = new JLabel(realisateur);
                txtActeurs = new JLabel(acteurs);
                txtGenre = new JLabel(genre);
                lblImage = new JLabel();
                txtDescription = new JTextPane();

                // Charger l'image à partir d'une URL
                try {
                    URL imageUrl = new URL(image_url);
                    BufferedImage image = ImageIO.read(imageUrl);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
                    lblImage.setIcon(icon);
                    lblImage.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                contentPane = new JPanel();
                contentPane.setLayout(null);

                txtTitre.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 24));
                txtTitre.setBounds(20, 5, 461, 37);
                contentPane.add(txtTitre);

                Panel panel = new Panel();
                panel.setBounds(10, 60, 183, 233);
              
                
                contentPane.add(panel);
                panel.add(lblImage);

                Label label_1 = new Label("Sortie en");
                label_1.setForeground(Color.GRAY);
                label_1.setFont(new Font("Montserrat", Font.BOLD, 12));
                label_1.setBounds(208, 103, 55, 21);
                contentPane.add(label_1);

                txtSortie.setForeground(Color.GRAY);
                txtSortie.setFont(new Font("Montserrat", Font.PLAIN, 12));
                txtSortie.setBounds(270, 103, 200, 21);
                contentPane.add(txtSortie);

                Label label_1_1 = new Label("De");
                label_1_1.setForeground(Color.GRAY);
                label_1_1.setFont(new Font("Montserrat", Font.BOLD, 12));
                label_1_1.setBounds(208, 172, 20, 21);
                contentPane.add(label_1_1);

                txtRealisateur.setForeground(Color.GRAY);
                txtRealisateur.setFont(new Font("Montserrat", Font.PLAIN, 12));
                txtRealisateur.setBounds(230, 171, 200, 21);
                contentPane.add(txtRealisateur);

                Label label_1_1_1 = new Label("Avec");
                label_1_1_1.setForeground(Color.GRAY);
                label_1_1_1.setFont(new Font("Montserrat", Font.BOLD, 12));
                label_1_1_1.setBounds(208, 138, 30, 21);
                contentPane.add(label_1_1_1);

                txtActeurs.setForeground(Color.GRAY);
                txtActeurs.setFont(new Font("Montserrat", Font.PLAIN, 12));
                txtActeurs.setBounds(240, 137, 375, 21);
                contentPane.add(txtActeurs);

                Label label_1_2 = new Label("Synopsis :");
                label_1_2.setForeground(Color.GRAY);
                label_1_2.setFont(new Font("Montserrat", Font.BOLD, 12));
                label_1_2.setBounds(208, 203, 67, 21);
                contentPane.add(label_1_2);

                txtDescription.setForeground(Color.GRAY);
                txtDescription.setFont(new Font("Montserrat", Font.PLAIN, 15));
                txtDescription.setText(description);
                txtDescription.setBackground(SystemColor.menu);
                txtDescription.setBounds(272, 200, 318, 65);
                txtDescription.setEditable(false); // Ajout de cette ligne
                contentPane.add(txtDescription);

                txtGenre.setForeground(new Color(34, 139, 34));
                txtGenre.setFont(new Font("Montserrat", Font.BOLD, 16));
                txtGenre.setBounds(208, 60, 200, 21);
                contentPane.add(txtGenre);
                
                JButton back_button = new JButton("retour");
                back_button.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 11));
                back_button.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		frame.dispose();
                	}
                });
                back_button.setBounds(10, 329, 81, 26);
                contentPane.add(back_button);

                Panel panel_1 = new Panel();
                panel_1.setBounds(261, 268, 403, 87);
                contentPane.add(panel_1);
                panel_1.setLayout(null);
                
              
                
                JButton btnNewButton = new JButton("Louer");
                btnNewButton.setBounds(260, 9, 150, 58);
                panel_1.add(btnNewButton);
                btnNewButton.setBackground(new Color(34, 139, 34));
                btnNewButton.setForeground(new Color(255, 255, 255));
                btnNewButton.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 23));
                JSlider slider = new JSlider();
                slider.setBounds(10, 47, 200, 22);
                panel_1.add(slider);
                slider.setValue(2);
                slider.setMaximum(8);
                slider.setMinimum(1);
                slider.setToolTipText("");
                slider.setPaintLabels(true);
                int sliderValue = slider.getValue();
                JLabel lblNewLabel = new JLabel("Louer " + sliderValue + " Semaines");
                lblNewLabel.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 16));
                lblNewLabel.setForeground(new Color(34, 139, 34));
                lblNewLabel.setBounds(40, 19, 157, 13);
                panel_1.add(lblNewLabel);

                        
                                slider.addChangeListener(new ChangeListener() {
                                    public void stateChanged(ChangeEvent e) {
                                        lblNewLabel.setText("Louer " + slider.getValue() + " Semaines");
                                        Float prixLocation = (slider.getValue())*Float.parseFloat(prix);
                                        btnNewButton.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 13));
                                        btnNewButton.setText("Louer (" + prixLocation +"€)" );
                                    }
                                });
                
                
                
                btnNewButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	String sql = "INSERT INTO emprunts (id_jeu, item_type, utilisateur, date_emprunt, date_retour) VALUES (?, ?, ?, ?, ?)";
                    	try (Connection conn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/seed", "root", "");
                    			PreparedStatement statement = conn2.prepareStatement(sql);) {
                    		
                            

                            // Définir les valeurs des paramètres de la requête
                            
                            statement.setInt(1, idFilm);  // Valeur de l'ID de l'item emprunté
                            statement.setString(2, "film");  // Type de l'item emprunté
                            statement.setString(3, idCompte);  // Utilisateur emprunteur
                            LocalDate dateEmprunt = LocalDate.now();
                            LocalDate dateRetour = dateEmprunt.plusWeeks(slider.getValue());

                            statement.setDate(4, java.sql.Date.valueOf(dateEmprunt));  // Date d'emprunt
                            statement.setDate(5, java.sql.Date.valueOf(dateRetour));  // Date de retour
                            statement.executeUpdate();
                    		conn2.close();
                    		
                    		JOptionPane.showMessageDialog(frame, "L'emprunt a été inséré avec succès. merci de rendre ce Film avant le "+ dateRetour);
                    	}catch (SQLException e1) {
                            // Erreur de connexion à la base de données
                            JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données : " + e1.getMessage());
                            e1.printStackTrace();
                        }
                    	
                    	
                       
                    }
                });
                
                

                
               
                
   

                frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(700,400);
                frame.setLocationRelativeTo(null);
                frame.setContentPane(contentPane);
                frame.setResizable(false);
                frame.setVisible(true);
                pack();
            } else {
                // Produit introuvable
                JOptionPane.showMessageDialog(null, "Produit introuvable !");
            }
        }
    } catch (SQLException e) {
        // Erreur de connexion à la base de données
        JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données : " + e.getMessage());
        e.printStackTrace();
    }
}


}
