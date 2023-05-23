import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

public class Ajout_jeu extends JFrame {
	private JPanel contentPane;
	private JTextField textField_Nom;
	private JTextField textField_Prix;
	private JTextField textField_Editeur;
	private JTextField textField_Annee;
	private JTextField textField_Type;
	private JTextField textField_Resume;
	private JTextField textField_url;

	

	public Ajout_jeu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(859,496);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Connection con;
		Statement st;
		ResultSet rs;
		
		JLabel lblPrincipal = new JLabel("Ajouter un jeu");
		lblPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPrincipal.setBounds(49, 31, 175, 47);
		contentPane.add(lblPrincipal);
		
		JButton btnConfirmer = new JButton("Confirmer");
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/seed","root", "");
					PreparedStatement st = (PreparedStatement) connection.prepareStatement("INSERT INTO jeux (nom, prix, editeur, annee, type, resume, disponibilite, img_url) VALUES (?, ?, ?, ?, ?, ?, 1,?) ");
					st.setString(1,textField_Nom.getText());
					st.setString(2,textField_Prix.getText());
					st.setString(3,textField_Editeur.getText());
					st.setString(4,textField_Annee.getText());
					st.setString(5,textField_Type.getText());
					st.setString(6,textField_Resume.getText());
					st.setString(7,textField_url.getText());
					st.executeUpdate();
					connection.close();
					JOptionPane.showMessageDialog(null, "Insertion réussie");
					
					
				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
			
		});
		btnConfirmer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConfirmer.setBounds(37, 351, 191, 54);
		contentPane.add(btnConfirmer);
		
		textField_Nom = new JTextField();
		textField_Nom.setBounds(106, 106, 96, 19);
		contentPane.add(textField_Nom);
		textField_Nom.setColumns(10);
		
		textField_Prix = new JTextField();
		textField_Prix.setColumns(10);
		textField_Prix.setBounds(106, 152, 96, 19);
		contentPane.add(textField_Prix);
		
		textField_Editeur = new JTextField();
		textField_Editeur.setColumns(10);
		textField_Editeur.setBounds(106, 201, 96, 19);
		contentPane.add(textField_Editeur);
		
		textField_Annee = new JTextField();
		textField_Annee.setColumns(10);
		textField_Annee.setBounds(285, 106, 96, 19);
		contentPane.add(textField_Annee);
		
		textField_Type = new JTextField();
		textField_Type.setColumns(10);
		textField_Type.setBounds(285, 152, 96, 19);
		contentPane.add(textField_Type);
		
		textField_Resume = new JTextField();
		textField_Resume.setColumns(10);
		textField_Resume.setBounds(285, 201, 116, 68);
		contentPane.add(textField_Resume);
		
		JLabel lblTitre = new JLabel("nom\r\n");
		lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitre.setBounds(37, 109, 45, 13);
		contentPane.add(lblTitre);
		
		JLabel lblAnnee = new JLabel("prix\r\n");
		lblAnnee.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnnee.setBounds(33, 155, 45, 13);
		contentPane.add(lblAnnee);
		
		JLabel lblGenre = new JLabel("editeur");
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGenre.setBounds(37, 204, 45, 13);
		contentPane.add(lblGenre);
		
		JLabel lblRealisateur = new JLabel("annee\r\n");
		lblRealisateur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRealisateur.setBounds(230, 109, 56, 13);
		contentPane.add(lblRealisateur);
		
		JLabel lblActeur = new JLabel("type");
		lblActeur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblActeur.setBounds(230, 155, 45, 13);
		contentPane.add(lblActeur);
		
		JLabel lblSyno = new JLabel("resume");
		lblSyno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSyno.setBounds(230, 204, 56, 13);
		contentPane.add(lblSyno);
		
		textField_url = new JTextField();
		textField_url.setBounds(454, 106, 96, 19);
		contentPane.add(textField_url);
		textField_url.setColumns(10);
		
		JLabel lblNewLabel_image = new JLabel("image\r\n");
		lblNewLabel_image.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_image.setBounds(399, 109, 45, 13);
		contentPane.add(lblNewLabel_image);
		
		JRadioButton btnRadioLivre = new JRadioButton("LIVRE");
		btnRadioLivre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRadioLivre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Ajout_livre ajout_liv = new Ajout_livre();
				ajout_liv.setVisible(true);
			}
		});
		btnRadioLivre.setBounds(572, 271, 136, 47);
		contentPane.add(btnRadioLivre);
		
		JRadioButton btnRadioFilm = new JRadioButton("FILM");
		btnRadioFilm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRadioFilm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Ajout_film ajout_fil = new Ajout_film();
				ajout_fil.setVisible(true);
				
			}
		});
		btnRadioFilm.setBounds(572, 320, 153, 47);
		contentPane.add(btnRadioFilm);
		
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