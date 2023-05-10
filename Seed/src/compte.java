import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class compte extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {

		compte frame = new compte();
		frame.setVisible(true);

	}

	public compte() {

	}
	public compte(String compte) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,400);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDeco = new JLabel("Se déconnecter :");
		lblDeco.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblDeco.setBounds(53, 66, 175, 42);
		contentPane.add(lblDeco);



		JButton btnDeconnexion = new JButton("Déconnexion");
		btnDeconnexion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDeconnexion.setBounds(226, 70, 167, 42);
		btnDeconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Vous etes déconnecté");
				dispose();
				accueil ac = new accueil();
			}
		});
		contentPane.add(btnDeconnexion);

		JLabel lblChangePass = new JLabel("Mot de passe : ");
		lblChangePass.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblChangePass.setBounds(53, 163, 134, 52);
		contentPane.add(lblChangePass);



		JButton btnChanger = new JButton("Changer");
		btnChanger.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnChanger.setBounds(197, 172, 140, 42);
		btnChanger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changerpwd bo = new changerpwd(compte);
				bo.setVisible(true);

			}
		});
		contentPane.add(btnChanger);
	}
}