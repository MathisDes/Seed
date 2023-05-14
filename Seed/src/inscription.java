import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class inscription extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JTextField username;
	private JPasswordField passwordField;
	private JButton btnNewButton;


	public static void main(String[] args) {

		inscription frame = new inscription();
		frame.setVisible(true);

	}


	public inscription() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(670, 600);
		setResizable(false);
		contentPane = new JPanel();
        setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewUserRegister = new JLabel("Nouvelle inscription");
		lblNewUserRegister.setBounds(186, 39, 358, 50);
		lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
		contentPane.add(lblNewUserRegister);


		JLabel lblEmailAddress = new JLabel("Email");
		lblEmailAddress.setBounds(319, 362, 124, 36);
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblEmailAddress);



		email = new JTextField();
		email.setBounds(239, 420, 228, 50);

		email.setFont(new Font("Tahoma", Font.PLAIN, 32));
		contentPane.add(email);
		email.setColumns(10);

		username = new JTextField();
		username.setBounds(239, 157, 228, 50);
		username.setFont(new Font("Tahoma", Font.PLAIN, 32));
		contentPane.add(username);
		username.setColumns(10);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(296, 118, 99, 29);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("mdp");
		lblPassword.setBounds(319, 226, 99, 24);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblPassword);


		passwordField = new JPasswordField();
		passwordField.setBounds(239, 283, 228, 50);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		contentPane.add(passwordField);

		btnNewButton = new JButton("s'inscrire");
		btnNewButton.setBounds(263, 489, 178, 42);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String emailId = email.getText();
				String userName = username.getText();
				String password = passwordField.getText();
				String role = "client";


				String query = "INSERT INTO adherent (username, password, email) VALUES (?, ?, ?)";
				if (email.getText().isEmpty() || passwordField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(contentPane,"Merci de remplir les champs");
				}
				else {
				try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/seed", "root", "");
		             PreparedStatement statement = conn.prepareStatement(query)) {
		        	
		        	  MessageDigest digest = MessageDigest.getInstance("SHA-256");

		              // Conversion du mot de passe en tableau de bytes
		              byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);

		              // Calcul du haché du mot de passe
		              byte[] hashedBytes = digest.digest(passwordBytes);

		              // Conversion du haché en une représentation hexadécimale
		              StringBuilder hexString = new StringBuilder();
		              for (byte b : hashedBytes) {
		                  String hex = Integer.toHexString(0xff & b);
		                  if (hex.length() == 1) {
		                      hexString.append('0');
		                  }
		                  hexString.append(hex);
		              }

		              String hashedPassword = hexString.toString();
		            
		        	
		            statement.setString(1, userName);
		            statement.setString(2, hashedPassword);
		            statement.setString(3, emailId);


		            int res= statement.executeUpdate();
		            if (res > 0) {
		                System.out.println("L'inscription a été effectuée avec succès !");
		            }
		           
				}
		        catch (SQLIntegrityConstraintViolationException duplicate) {
					
					JOptionPane.showMessageDialog(contentPane, "Compte deja existant");
					
				}
		        catch (Exception exception) {
					exception.printStackTrace();
				}
				}}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(btnNewButton);
	}
}