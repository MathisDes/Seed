import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class pageihm {

	private JFrame frame;

	public static void main(String[] args) {
		pageihm window = new pageihm();
		window.frame.setVisible(true);
	}




	public void changerpass() {
		frame = new JFrame();
		frame.setSize(700,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		JLabel lblDeco = new JLabel("Se déconnecter :");
		lblDeco.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblDeco.setBounds(53, 66, 175, 42);
		frame.getContentPane().add(lblDeco);

		JLabel lblChangePass = new JLabel("Mot de passe : ");
		lblChangePass.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblChangePass.setBounds(53, 163, 134, 52);
		frame.getContentPane().add(lblChangePass);

		JButton btnNewButton = new JButton("Déconnexion");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(226, 70, 167, 42);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Changer");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(197, 172, 140, 42);
		frame.getContentPane().add(btnNewButton_1);
	}
}
