import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Ajout_film extends JFrame {
	private JPanel contentPane;
	private JTextField textField_Titre;
	private JTextField textField_Annee;
	private JTextField textField_Genre;
	private JTextField textField_Realisateur;
	private JTextField textField_Acteur;
	private JTextField textField_Syno;
	private JTextField textField_url;

	

	public Ajout_film() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(859,496);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		JLabel lblPrincipal = new JLabel("Ajouter un film");
		lblPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPrincipal.setBounds(49, 31, 175, 47);
		contentPane.add(lblPrincipal);
		
		JButton btnConfirmer = new JButton("Confirmer");
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/seed","root", "");
					PreparedStatement st = (PreparedStatement) connection.prepareStatement("INSERT INTO films (titre, annee, genre, realisateur, acteurs, synopsis, img_url) VALUES (?, ?, ?, ?, ?, ?, ?) ");
					st.setString(1,textField_Titre.getText());
					st.setString(2,textField_Annee.getText());
					st.setString(3,textField_Genre.getText());
					st.setString(4,textField_Realisateur.getText());
					st.setString(5,textField_Acteur.getText());
					st.setString(6,textField_Syno.getText());
					st.setString(7,textField_url.getText());
					st.executeUpdate();
					connection.close();
					JOptionPane.showMessageDialog(null, "Insertion réussie");
					
					dispose();
					Ajout_film ajout_film = new Ajout_film();
					ajout_film.setVisible(true);
					
					
					
				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
			
		});
		btnConfirmer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConfirmer.setBounds(37, 351, 191, 54);
		contentPane.add(btnConfirmer);
		
		textField_Titre = new JTextField();
		textField_Titre.setBounds(106, 106, 96, 19);
		contentPane.add(textField_Titre);
		textField_Titre.setColumns(10);
		
		textField_Annee = new JTextField();
		textField_Annee.setColumns(10);
		textField_Annee.setBounds(106, 152, 96, 19);
		contentPane.add(textField_Annee);
		
		textField_Genre = new JTextField();
		textField_Genre.setColumns(10);
		textField_Genre.setBounds(106, 201, 96, 19);
		contentPane.add(textField_Genre);
		
		textField_Realisateur = new JTextField();
		textField_Realisateur.setColumns(10);
		textField_Realisateur.setBounds(312, 106, 96, 19);
		contentPane.add(textField_Realisateur);
		
		textField_Acteur = new JTextField();
		textField_Acteur.setColumns(10);
		textField_Acteur.setBounds(312, 152, 96, 19);
		contentPane.add(textField_Acteur);
		
		textField_Syno = new JTextField();
		textField_Syno.setColumns(10);
		textField_Syno.setBounds(292, 201, 153, 68);
		contentPane.add(textField_Syno);
		
		JLabel lblTitre = new JLabel("titre\r\n");
		lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitre.setBounds(37, 109, 45, 13);
		contentPane.add(lblTitre);
		
		JLabel lblAnnee = new JLabel("annee\r\n");
		lblAnnee.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnnee.setBounds(33, 155, 45, 13);
		contentPane.add(lblAnnee);
		
		JLabel lblGenre = new JLabel("genre");
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGenre.setBounds(37, 204, 45, 16);
		contentPane.add(lblGenre);
		
		JLabel lblRealisateur = new JLabel("realisateur");
		lblRealisateur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRealisateur.setBounds(230, 109, 70, 13);
		contentPane.add(lblRealisateur);
		
		JLabel lblActeur = new JLabel("acteur");
		lblActeur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblActeur.setBounds(230, 155, 45, 13);
		contentPane.add(lblActeur);
		
		JLabel lblSyno = new JLabel("synopsis");
		lblSyno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSyno.setBounds(230, 204, 56, 13);
		contentPane.add(lblSyno);
		
		textField_url = new JTextField();
		textField_url.setBounds(509, 106, 96, 19);
		contentPane.add(textField_url);
		textField_url.setColumns(10);
		
		JLabel lblNewLabel_image = new JLabel("image");
		lblNewLabel_image.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_image.setBounds(454, 105, 45, 13);
		contentPane.add(lblNewLabel_image);
		
		JRadioButton btnRadioJeu = new JRadioButton("JEU");
		btnRadioJeu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRadioJeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Ajout_jeu ajout_jeu = new Ajout_jeu();
				ajout_jeu.setVisible(true);
			}
		});
		btnRadioJeu.setBounds(572, 271, 136, 47);
		contentPane.add(btnRadioJeu);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("LIVRE");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Ajout_livre ajout_liv = new Ajout_livre();
				ajout_liv.setVisible(true);
				
			}
		});
		rdbtnNewRadioButton_1.setBounds(572, 320, 153, 47);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JButton btnRetour = new JButton("<- Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Admin adm = new Admin();
				adm.setVisible(true);
			}
		});
		
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnRetour.setBounds(619, 33, 191, 68);
		contentPane.add(btnRetour);
		
		JLabel lblNewLabel = new JLabel("Changer oeuvre :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(516, 222, 220, 47);
		contentPane.add(lblNewLabel);
		


	}
}