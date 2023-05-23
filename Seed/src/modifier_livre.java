import java.awt.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class modifier_livre extends JFrame {
    
    private JTable table;
    private DefaultTableModel model;
    private JTextField nom,prix,type,auteur,resume;
    private JTextField image;
    private JTextField studio;


    public modifier_livre() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(802, 652);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setLayout(null);


        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nom");
        model.addColumn("Prix");
        model.addColumn("Auteur");
        model.addColumn("Studio");
        model.addColumn("Type");
        model.addColumn("Resume");
        model.addColumn("Image");


        table = new JTable(model);
        JScrollPane tableau = new JScrollPane(table);
        getContentPane().add(tableau);
        tableau.setBounds(10, 97, 498, 200);


        nom = new JTextField();
        getContentPane().add(nom);
        nom.setBounds(25, 330, 100, 20);

        prix = new JTextField();
        getContentPane().add(prix);
        prix.setBounds(281, 330, 100, 20);
        
        type = new JTextField();
        getContentPane().add(type);
        type.setBounds(153, 402, 100, 20);
        
        auteur = new JTextField();
        getContentPane().add(auteur);
        auteur.setBounds(25, 402, 100, 20);
        
        resume = new JTextField();
        getContentPane().add(resume);
        resume.setBounds(52, 484, 244, 56);
        
        

        JLabel lblNom = new JLabel("Nom");
        lblNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNom.setBounds(48, 307, 45, 13);
        getContentPane().add(lblNom);
        
        JLabel lblStudio = new JLabel("Studio");
        lblStudio.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblStudio.setBounds(168, 307, 45, 13);
        getContentPane().add(lblStudio);
        
        JLabel lblType = new JLabel("Type");
        lblType.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblType.setBounds(168, 380, 74, 13);
        getContentPane().add(lblType);
        
        JLabel lblPrix = new JLabel("Prix");
        lblPrix.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPrix.setBounds(311, 307, 45, 13);
        getContentPane().add(lblPrix);
        
        JLabel lblAuteur = new JLabel("Auteur");
        lblAuteur.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblAuteur.setBounds(48, 380, 60, 13);
        getContentPane().add(lblAuteur);
        
        JLabel lblResume = new JLabel("Resume");
        lblResume.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblResume.setBounds(134, 460, 74, 13);
        getContentPane().add(lblResume);
        
        JLabel lblImage = new JLabel("Image");
        lblImage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblImage.setBounds(311, 380, 90, 13);
        getContentPane().add(lblImage);

        JButton modifierButton = new JButton("Modifier");
        modifierButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        getContentPane().add(modifierButton);
        modifierButton.setBounds(318, 484, 144, 56);
        
        JButton btnRetour = new JButton("<--- Retour");
        btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Admin adm = new Admin();
				adm.setVisible(true);
			}
		});
        		
        	
        btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnRetour.setBounds(559, 23, 219, 62);
        getContentPane().add(btnRetour);
        
        JRadioButton btnRadioJeu = new JRadioButton("FILM");
        btnRadioJeu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		modifier_film modif_film = new modifier_film();
        		modif_film.setVisible(true);

        		
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
        
        JLabel lblNewLabel = new JLabel("Modifier un livre\r\n");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
        lblNewLabel.setBounds(25, 23, 228, 43);
        getContentPane().add(lblNewLabel);
        
        JLabel lblChangerOeuvre = new JLabel("Changer oeuvre :");
        lblChangerOeuvre.setFont(new Font("Tahoma", Font.PLAIN, 23));
        lblChangerOeuvre.setBounds(483, 362, 228, 43);
        getContentPane().add(lblChangerOeuvre);
        
        image = new JTextField();
        image.setBounds(281, 402, 100, 20);
        getContentPane().add(image);
        
        studio = new JTextField();
        studio.setBounds(153, 330, 100, 20);
        getContentPane().add(studio);
        
        
        
        
        modifierButton.addActionListener(e -> modifierDonnees());
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/seed", "root", "");
            PreparedStatement st = conn.prepareStatement("SELECT * FROM livre");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getInt("id"));
                row.add(rs.getString("nom"));
                row.add(rs.getFloat("prix"));
                row.add(rs.getString("auteur"));
                row.add(rs.getString("studio"));
                row.add(rs.getString("type"));
                row.add(rs.getString("resume"));
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
            String nouveauNom = nom.getText();
            float  nouveauPrix = Float.parseFloat(prix.getText());
            String nouveauAuteur = auteur.getText();
            String nouveauStudio = studio.getText();
            String nouveauType= type.getText();
            String nouveauxResume = resume.getText();
            String nouvelleImage = image.getText();
            
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/seed", "root", "");
                PreparedStatement stmt = conn.prepareStatement("UPDATE livre SET nom=?, prix=?, auteur=? , studio=? , type=? , resume=?,  img_url=?");
                stmt.setString(1, nouveauNom);
                stmt.setFloat(2, nouveauPrix);
                stmt.setString(3, nouveauAuteur);
                stmt.setString(4, nouveauStudio);
                stmt.setString(5, nouveauType);
                stmt.setString(6, nouveauxResume);
                stmt.setString(7, nouvelleImage);
                stmt.executeUpdate();
                conn.close();
 
                model.setValueAt(nouveauNom, selectedRow, 1);
                model.setValueAt(nouveauPrix, selectedRow, 2);
                model.setValueAt(nouveauAuteur, selectedRow, 3);
                model.setValueAt(nouveauStudio, selectedRow, 4);
                model.setValueAt(nouveauType, selectedRow, 5);
                model.setValueAt(nouveauxResume, selectedRow, 6);
                

                
                


            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "sélectionner une oeuvre à modifier.");
        }
    }
}
