import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class connexion {

	private JFrame frame;
	private JTextField textFieldMail;
	private JPasswordField passwordField;
	private Connection conn;

	public static void main(String[] args) {

		connexion window = new connexion();
		window.frame.setVisible(true);


	}


	public connexion() {
		
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
		textFieldMail.setBounds(260, 136, 213, 26);
		frame.getContentPane().add(textFieldMail);
		textFieldMail.setColumns(10);
		
		JLabel lblMDP = new JLabel("Mot de passe :");
		lblMDP.setFont(new Font("Arial", Font.PLAIN, 25));
		lblMDP.setBounds(283, 172, 169, 62);
		frame.getContentPane().add(lblMDP);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(260, 244, 213, 26);
		frame.getContentPane().add(passwordField);
		
		JButton btnSeConnecter = new JButton("Se Connecter");
		btnSeConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try{
					if (textFieldMail.getText().isEmpty() || passwordField.getText().isEmpty())
					{
					JOptionPane.showMessageDialog(frame,"Champs invalide");
					}else{
						page1 info = new page1();
						page1.main(null);
						}}

				
					


		         catch(Exception e ){
		            System.out.println("Veuillez entrez les champs");
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

		try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/seed", "root", "");
            System.out.println("Connexion réussie à la base de données.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
        }
		
	}
	
}
