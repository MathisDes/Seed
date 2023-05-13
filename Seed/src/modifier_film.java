import java.awt.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class modifier_film extends JFrame {
    
    private JTable table;
    private DefaultTableModel model;
    private JTextField titre,annee,genre,realisateur,acteur,synopsis,img_url;

	public static void main(String[] args) {

		modifier_film frame = new modifier_film();
		frame.setVisible(true);

	}
    
    
    public modifier_film() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(802, 652);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setLayout(null);


        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Titre");
        model.addColumn("Annee");
        model.addColumn("Genre");
        model.addColumn("Réalisateur");
        model.addColumn("Acteurs");
        model.addColumn("Sysnopsis");
        model.addColumn("Image");


        table = new JTable(model);
        JScrollPane tableau = new JScrollPane(table);
        getContentPane().add(tableau);
        tableau.setBounds(10, 97, 498, 200);


        titre = new JTextField();
        getContentPane().add(titre);
        titre.setBounds(25, 330, 100, 20);

        annee = new JTextField();
        getContentPane().add(annee);
        annee.setBounds(153, 330, 100, 20);
        
        genre = new JTextField();
        getContentPane().add(genre);
        genre.setBounds(281, 330, 100, 20);
        
        realisateur = new JTextField();
        getContentPane().add(realisateur);
        realisateur.setBounds(153, 402, 100, 20);
        
        acteur = new JTextField();
        getContentPane().add(acteur);
        acteur.setBounds(25, 402, 100, 20);
        
        synopsis = new JTextField();
        getContentPane().add(synopsis);
        synopsis.setBounds(52, 484, 244, 56);
        
        img_url = new JTextField();
        getContentPane().add(img_url);
        img_url.setBounds(281, 402, 100, 20);
        

        JLabel lblTitre = new JLabel("Titre");
        lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTitre.setBounds(48, 307, 45, 13);
        getContentPane().add(lblTitre);
        
        JLabel lblGenre = new JLabel("Genre");
        lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblGenre.setBounds(300, 313, 45, 13);
        getContentPane().add(lblGenre);
        
        JLabel lblRalisateur = new JLabel("Réalisateur");
        lblRalisateur.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblRalisateur.setBounds(168, 380, 74, 13);
        getContentPane().add(lblRalisateur);
        
        JLabel lblAnnee = new JLabel("Annee");
        lblAnnee.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblAnnee.setBounds(184, 307, 45, 13);
        getContentPane().add(lblAnnee);
        
        JLabel lblActeur = new JLabel("Acteur");
        lblActeur.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblActeur.setBounds(48, 380, 45, 13);
        getContentPane().add(lblActeur);
        
        JLabel lblSynopsis = new JLabel("Synopsis");
        lblSynopsis.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSynopsis.setBounds(134, 460, 74, 13);
        getContentPane().add(lblSynopsis);
        
        JLabel lblImage = new JLabel("Image");
        lblImage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblImage.setBounds(300, 380, 45, 13);
        getContentPane().add(lblImage);

        JButton modifierButton = new JButton("Modifier");
        modifierButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        getContentPane().add(modifierButton);
        modifierButton.setBounds(318, 484, 144, 56);
        
        JButton btnRetour = new JButton("<--- Retour");
        btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				admin adm = new admin();
				adm.setVisible(true);
			}
		});
        		
        	
        btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnRetour.setBounds(559, 23, 219, 62);
        getContentPane().add(btnRetour);
        
        JRadioButton btnRadioJeu = new JRadioButton("JEU");
        btnRadioJeu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		modifier_jeu modif_jeu = new modifier_jeu();
        		modif_jeu.setVisible(true);

        		
        	}
        });
        btnRadioJeu.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnRadioJeu.setBounds(530, 402, 155, 56);
        getContentPane().add(btnRadioJeu);
        
        JRadioButton btnRadioLivre = new JRadioButton("LIVRE");
        btnRadioLivre.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		modifier_livre modif_livre = new modifier_livre();
        		modif_livre.setVisible(true);
        	}
        });
        btnRadioLivre.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnRadioLivre.setBounds(530, 458, 155, 56);
        getContentPane().add(btnRadioLivre);
        
        JLabel lblNewLabel = new JLabel("Modifier un film");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
        lblNewLabel.setBounds(25, 23, 228, 43);
        getContentPane().add(lblNewLabel);
        
        JLabel lblChangerOeuvre = new JLabel("Changer oeuvre :");
        lblChangerOeuvre.setFont(new Font("Tahoma", Font.PLAIN, 23));
        lblChangerOeuvre.setBounds(483, 362, 228, 43);
        getContentPane().add(lblChangerOeuvre);
        
        
        
        
        modifierButton.addActionListener(e -> modifierDonnees());
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/seed", "root", "");
            PreparedStatement st = conn.prepareStatement("SELECT * FROM films");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getInt("id"));
                row.add(rs.getString("titre"));
                row.add(rs.getInt("annee"));
                row.add(rs.getString("genre"));
                row.add(rs.getString("acteurs"));
                row.add(rs.getString("realisateur"));
                row.add(rs.getString("synopsis"));
                row.add(rs.getString("img_url"));
                model.addRow(row);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        


    }
    
    


    private void modifierDonnees() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String nouveauTitre = titre.getText();
            int nouvelleAnnee = Integer.parseInt(annee.getText());
            String nouveauGenre = genre.getText();
            String nouveauRealisateur = realisateur.getText();
            String nouveauxActeurs = acteur.getText();
            String nouveauSynopsis = synopsis.getText();
            String nouvelleImage = img_url.getText();
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/seed", "root", "");
                PreparedStatement stmt = conn.prepareStatement("UPDATE films SET titre=?, annee=?, genre=? , realisateur=? , acteurs=? , synopsis=? , img_url=?");
                stmt.setString(1, nouveauTitre);
                stmt.setInt(2, nouvelleAnnee);
                stmt.setString(3, nouveauGenre);
                stmt.setString(4, nouveauRealisateur);
                stmt.setString(5, nouveauxActeurs);
                stmt.setString(6, nouveauSynopsis);
                stmt.setString(7, nouvelleImage);
                stmt.executeUpdate();
                conn.close();
 
                model.setValueAt(nouveauTitre, selectedRow, 1);
                model.setValueAt(nouvelleAnnee, selectedRow, 2);
                model.setValueAt(nouveauGenre, selectedRow, 3);
                model.setValueAt(nouveauRealisateur, selectedRow, 4);
                model.setValueAt(nouveauxActeurs, selectedRow, 5);
                model.setValueAt(nouveauSynopsis, selectedRow, 6);
                model.setValueAt(nouvelleImage, selectedRow, 7);
                


            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "sélectionner une oeuvre à modifier.");
        }
    }
}
