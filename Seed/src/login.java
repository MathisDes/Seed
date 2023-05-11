import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class login extends JFrame {

	private JTextField textField;
	private JPasswordField passwordField;
	private JPanel contentPane;

	public static void main(String[] args) {

		login frame = new login();
		frame.setVisible(true);

	}


	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,400);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblConnexion = new JLabel("Connexion");
		lblConnexion.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblConnexion.setBounds(267, 10, 116, 45);
		contentPane.add(lblConnexion);


		JLabel lblMail = new JLabel("Mail: ");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblMail.setBounds(306, 66, 57, 30);
		contentPane.add(lblMail);

		textField = new JTextField();
		textField.setBounds(244, 106, 169, 30);
		textField.setColumns(10);
		contentPane.add(textField);

		JLabel lblMDP = new JLabel("Mot de passe :");
		lblMDP.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblMDP.setBounds(258, 169, 144, 30);
		contentPane.add(lblMDP);


		passwordField = new JPasswordField();
		passwordField.setBounds(244, 209, 169, 30);
		contentPane.add(passwordField);




		JButton btnConnecter = new JButton("Se connecter");
		btnConnecter.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnConnecter.setBounds(226, 268, 207, 45);
		btnConnecter.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String userName = textField.getText();
				String password = passwordField.getText();
				try {
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/seed",
							"root", "");

					PreparedStatement st = (PreparedStatement) connection
							.prepareStatement("Select *, password from adherent where email=? and password=?");

					st.setString(1, userName);
					st.setString(2, password);
					ResultSet rs = st.executeQuery();
					if (rs.next()) {
						dispose();
						accueil acc = new accueil(userName);
						acc.setVisible(true);
					} else {
							
						JOptionPane.showMessageDialog(btnConnecter, "Mauvais identifiants");
					}
					

				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
			
		});
		
		

		contentPane.add(btnConnecter);

		JButton btnInscrire = new JButton("S'inscrire");
		btnInscrire.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnInscrire.setBounds(258, 323, 155, 30);
		contentPane.add(btnInscrire);

	}
}