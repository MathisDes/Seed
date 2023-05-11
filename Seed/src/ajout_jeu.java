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

public class ajout_jeu extends JFrame {
	private JPanel contentPane;
	private JTextField textField_Titre;
	private JTextField textField_Annee;
	private JTextField textField_Genre;
	private JTextField textField_Realisateur;
	private JTextField textField_Acteur;
	private JTextField textField_Syno;
	private JTextField textField_url;

	public static void main(String[] args) {

		ajout_jeu frame = new ajout_jeu();
		frame.setVisible(true);

	}
	

	public ajout_jeu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,400);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Connection con;
		Statement st;
		ResultSet rs;
		
		JLabel lblNewLabel = new JLabel("Ajouter un jeu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(49, 31, 175, 47);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Confirmer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/seed","root", "");
					PreparedStatement st = (PreparedStatement) connection.prepareStatement("INSERT INTO jeux (nom, prix, editeur, annee, type, resume, disponibilite, img_url) VALUES (?, ?, ?, ?, ?, ?, 1,?) ");
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
					
					
				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(33, 275, 191, 54);
		contentPane.add(btnNewButton);
		
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
		textField_Realisateur.setBounds(285, 106, 96, 19);
		contentPane.add(textField_Realisateur);
		
		textField_Acteur = new JTextField();
		textField_Acteur.setColumns(10);
		textField_Acteur.setBounds(285, 152, 96, 19);
		contentPane.add(textField_Acteur);
		
		textField_Syno = new JTextField();
		textField_Syno.setColumns(10);
		textField_Syno.setBounds(285, 201, 116, 68);
		contentPane.add(textField_Syno);
		
		JLabel lblTitre = new JLabel("nom\r\n");
		lblTitre.setBounds(37, 109, 45, 13);
		contentPane.add(lblTitre);
		
		JLabel lblAnnee = new JLabel("prix\r\n");
		lblAnnee.setBounds(33, 155, 45, 13);
		contentPane.add(lblAnnee);
		
		JLabel lblGenre = new JLabel("editeur");
		lblGenre.setBounds(37, 204, 45, 13);
		contentPane.add(lblGenre);
		
		JLabel lblRealisateur = new JLabel("annee\r\n");
		lblRealisateur.setBounds(230, 109, 56, 13);
		contentPane.add(lblRealisateur);
		
		JLabel lblActeur = new JLabel("type");
		lblActeur.setBounds(230, 155, 45, 13);
		contentPane.add(lblActeur);
		
		JLabel lblSyno = new JLabel("resume");
		lblSyno.setBounds(230, 204, 45, 13);
		contentPane.add(lblSyno);
		
		textField_url = new JTextField();
		textField_url.setBounds(454, 106, 96, 19);
		contentPane.add(textField_url);
		textField_url.setColumns(10);
		
		JLabel lblNewLabel_image = new JLabel("image\r\n");
		lblNewLabel_image.setBounds(399, 109, 45, 13);
		contentPane.add(lblNewLabel_image);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("LIVRE");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ajout_livre ajout_liv = new ajout_livre();
				ajout_liv.setVisible(true);
			}
		});
		rdbtnNewRadioButton.setBounds(454, 199, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("FILM");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ajout_film ajout_fil = new ajout_film();
				ajout_fil.setVisible(true);
				
			}
		});
		rdbtnNewRadioButton_1.setBounds(454, 248, 103, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton_1 = new JButton("<- Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				admin adm = new admin();
				adm.setVisible(true);
			}
		});
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton_1.setBounds(535, 10, 141, 47);
		contentPane.add(btnNewButton_1);
		


	}
}