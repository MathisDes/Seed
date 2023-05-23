import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Connexion {

	private JFrame frame;
	private JTextField textFieldMail;
	private JPasswordField passwordField;
	private Connection conn;




	public Connexion() {
		
		 PreparedStatement ps;
		 ResultSet rs;
		 
        frame = new JFrame();
        frame.setSize(700,480);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblConnexion = new JLabel("Connexion");
		lblConnexion.setFont(new Font("Arial", Font.PLAIN, 27));
		lblConnexion.setBounds(283, 21, 138, 62);
		frame.getContentPane().add(lblConnexion);
		
		JLabel lblMail = new JLabel("Mail :");
		lblMail.setFont(new Font("Arial", Font.PLAIN, 25));
		lblMail.setBounds(322, 79, 66, 47);
		frame.getContentPane().add(lblMail);
		
		textFieldMail = new JTextField();
		textFieldMail.setBounds(240, 136, 213, 26);
		frame.getContentPane().add(textFieldMail);
		textFieldMail.setColumns(10);
		
		JLabel lblMDP = new JLabel("Mot de passe :");
		lblMDP.setFont(new Font("Arial", Font.PLAIN, 25));
		lblMDP.setBounds(283, 172, 169, 62);
		frame.getContentPane().add(lblMDP);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(240, 244, 213, 26);
		frame.getContentPane().add(passwordField);
		
		JButton btnSeConnecter = new JButton("Se Connecter");
		btnSeConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
					if (textFieldMail.getText().isEmpty() || passwordField.getText().isEmpty())
					{
					JOptionPane.showMessageDialog(frame,"Merci de remplir les champs");
					}else{
						String sql = "SELECT * FROM adherent WHERE email = ? AND password = ?;";
						try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/seed", "root", "");
								PreparedStatement stmt = conn.prepareStatement(sql)) {
							//hachage du mdp
							
							MessageDigest digest = MessageDigest.getInstance("SHA-256");

				              // Conversion du mot de passe en tableau de bytes
				              byte[] passwordBytes = passwordField.getText().getBytes(StandardCharsets.UTF_8);

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
				           
					         
				              
				            //hachage du mdp
				              
				              stmt.setString(1, textFieldMail.getText());
					          stmt.setString(2, hashedPassword);
						        // Requête pour récupérer les informations sur le produit correspondant
							
					          try (ResultSet rs = stmt.executeQuery()) {
					        	  if (rs.next()) {
					                    // L'adhérent a été trouvé
					                   
					                    Acceuil nouvelleAcceuil = new Acceuil(textFieldMail.getText());
					                    
					                } else {
					                    // L'adhérent n'a pas été trouvé
					                    System.out.println("Identifiants incorrects.");
					                }
					            }

					        } catch (SQLException e) {
				        // Erreur de connexion à la base de données
				        JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données : " + e.getMessage());
				        e.printStackTrace();
				    } catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
							
						}

				
					


		         
			}
			
		});
		btnSeConnecter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSeConnecter.setBounds(283, 299, 150, 47);
		frame.getContentPane().add(btnSeConnecter);
		
		JButton btnInscrire = new JButton("S'inscrire");
		btnInscrire.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInscrire.setBounds(294, 356, 127, 34);
		frame.getContentPane().add(btnInscrire);
		btnInscrire.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        		Inscription pageInscri = new Inscription ();
        	}
        });
		this.frame.setVisible(true);
		
	}
	
}
