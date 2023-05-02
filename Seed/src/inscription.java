import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JPasswordField;
import javax.swing.JList;

public class inscription {

	private JFrame frame;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldMail;
	private JTextField textFieldAge;
	private JPasswordField passwordFieldMDP;
	private JPasswordField passwordFieldConf;

	public static void main(String[] args) {

		inscription window = new inscription();
		window.frame.setVisible(true);

	}


	public inscription() {
        frame = new JFrame();
        frame.setSize(700,480);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblnscription = new JLabel("Inscription");
		lblnscription.setBounds(263, 22, 128, 32);
		lblnscription.setFont(new Font("Arial", Font.PLAIN, 27));
		frame.getContentPane().add(lblnscription);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNom.setBounds(38, 94, 46, 39);
		frame.getContentPane().add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prénom : ");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrenom.setBounds(38, 139, 74, 39);
		frame.getContentPane().add(lblPrenom);
		
		JLabel lblMail = new JLabel("Mail :");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMail.setBounds(38, 188, 46, 39);
		frame.getContentPane().add(lblMail);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAge.setBounds(38, 237, 46, 39);
		frame.getContentPane().add(lblAge);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMotDePasse.setBounds(263, 94, 128, 39);
		frame.getContentPane().add(lblMotDePasse);
		
		JLabel lblConfirmation = new JLabel("Confirmation : ");
		lblConfirmation.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblConfirmation.setBounds(263, 155, 128, 39);
		frame.getContentPane().add(lblConfirmation);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(94, 107, 146, 19);
		frame.getContentPane().add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setBounds(120, 152, 120, 19);
		frame.getContentPane().add(textFieldPrenom);
		
		textFieldMail = new JTextField();
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(94, 201, 146, 19);
		frame.getContentPane().add(textFieldMail);
		
		textFieldAge = new JTextField();
		textFieldAge.setColumns(10);
		textFieldAge.setBounds(94, 250, 53, 19);
		frame.getContentPane().add(textFieldAge);
		
		passwordFieldMDP = new JPasswordField();
		passwordFieldMDP.setBounds(401, 107, 151, 19);
		frame.getContentPane().add(passwordFieldMDP);
		
		passwordFieldConf = new JPasswordField();
		passwordFieldConf.setBounds(401, 168, 151, 19);
		frame.getContentPane().add(passwordFieldConf);
		
		JButton btnDejaCompte = new JButton("Deja un compte ?");
		btnDejaCompte.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDejaCompte.setBounds(59, 352, 181, 62);
		frame.getContentPane().add(btnDejaCompte);
		
		JButton btnSenrengister = new JButton("S'enrengister");
		btnSenrengister.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSenrengister.setBounds(401, 230, 181, 39);
		frame.getContentPane().add(btnSenrengister);
	}
}
