import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;

public class Film extends JFrame {

    private JPanel FilmPanel;
    private String idCompte;

    public Film() {

        setTitle("Bibliothèque de films");
        setSize(1400, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

    
        FilmPanel = new JPanel();
        FilmPanel.setBounds(0, 0, 1386, 663);
        FilmPanel.setLayout(new GridLayout(1, 4)); 
        getContentPane().add(FilmPanel);
        FilmPanel.setBounds(0, 0, 1386, 663);
    }

    public void affiche() {
        try {
    
            String url = "jdbc:mysql://localhost:3306/seed";
            String utilisateur = "root";
            String motDePasse = "";
            Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);

 
            String requete = "SELECT titre, annee, genre, img_url FROM films ORDER BY id DESC LIMIT 4";
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
     
                String titre = resultat.getString("titre");
                String annee = resultat.getString("annee");
                String genre = resultat.getString("genre");
                String imageUrl = resultat.getString("img_url");

               
                JPanel moviePanel = new JPanel(new GridBagLayout());

                JLabel infoLabel = new JLabel("<html><b>Titre:</b> " + titre + "<br><b>Année:</b> " + annee + "<br><b>Genre:</b> " + genre + "</html>");
                infoLabel.setFont(new Font("Arial", Font.BOLD, 16));

                
                GridBagConstraints infoConstraints = new GridBagConstraints();
                infoConstraints.gridx = 0;
                infoConstraints.gridy = 0;
                infoConstraints.anchor = GridBagConstraints.CENTER;
                moviePanel.add(infoLabel, infoConstraints);

          
                try {
                    URL urlImage = new URL(imageUrl);
                    ImageIcon imageIcon = new ImageIcon(urlImage);
                    Image image = imageIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
                    JLabel imageLabel = new JLabel(new ImageIcon(image));

                    
                    GridBagConstraints imageConstraints = new GridBagConstraints();
                    imageConstraints.gridx = 0;
                    imageConstraints.gridy = 1;
                    imageConstraints.anchor = GridBagConstraints.CENTER;
                    moviePanel.add(imageLabel, imageConstraints);
                } catch (IOException e) {
                    e.printStackTrace();
                }

      
                FilmPanel.add(moviePanel);
            }

  
            resultat.close();
            statement.close();
            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
       
            Film interfaceGraphique = new Film();
            interfaceGraphique.setVisible(true);
            interfaceGraphique.affiche();
        ;
    }
}
