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

public class ajout_livre extends JFrame {
	private JPanel contentPane;
	private JTextField textField_Nom;
	private JTextField textField_Prix;
	private JTextField textField_Auteur;
	private JTextField textField_Annee;
	private JTextField textField_Type;
	private JTextField textField_Resume;
	private JTextField textField_url;

	public static void main(String[] args) {

		ajout_livre frame = new ajout_livre();
		frame.setVisible(true);

	}
	

	public ajout_livre() {
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
		
		JLabel lblNewLabel = new JLabel("Ajouter un livre");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(49, 31, 175, 47);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Confirmer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/seed","root", "");
					PreparedStatement st = (PreparedStatement) connection.prepareStatement("INSERT INTO livre (nom, prix, auteur, annee, type, resume, img_url) VALUES (?, ?, ?, ?, ?, ?, ?) ");
					st.setString(1,textField_Nom.getText());
					st.setString(2,textField_Prix.getText());
					st.setString(3,textField_Auteur.getText());
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
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(33, 275, 191, 54);
		contentPane.add(btnNewButton);
		
		textField_Nom = new JTextField();
		textField_Nom.setBounds(106, 106, 96, 19);
		contentPane.add(textField_Nom);
		textField_Nom.setColumns(10);
		
		textField_Prix = new JTextField();
		textField_Prix.setColumns(10);
		textField_Prix.setBounds(106, 152, 96, 19);
		contentPane.add(textField_Prix);
		
		textField_Auteur = new JTextField();
		textField_Auteur.setColumns(10);
		textField_Auteur.setBounds(106, 201, 96, 19);
		contentPane.add(textField_Auteur);
		
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
		
		JLabel lblTitre = new JLabel("nom");
		lblTitre.setBounds(37, 109, 45, 13);
		contentPane.add(lblTitre);
		
		JLabel lblAnnee = new JLabel("prix");
		lblAnnee.setBounds(33, 155, 45, 13);
		contentPane.add(lblAnnee);
		
		JLabel lblGenre = new JLabel("auteur");
		lblGenre.setBounds(37, 204, 45, 13);
		contentPane.add(lblGenre);
		
		JLabel lblRealisateur = new JLabel("annee");
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
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("FILM");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ajout_film ajout_fil = new ajout_film();
				ajout_fil.setVisible(true);
			}
		});
		rdbtnNewRadioButton.setBounds(454, 199, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("JEU");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ajout_jeu ajout_jeu = new ajout_jeu();
				ajout_jeu.setVisible(true);
				
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