
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

public class admin extends JFrame {
	private JPanel contentPane;

	public static void main(String[] args) {

		admin frame = new admin();
		frame.setVisible(true);

	}


	public admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,400);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        dispose();
		        suppr_film supp = new suppr_film();
		        supp.setVisible(true);
			}
		});
		btnSupprimer.setBounds(270, 169, 117, 65);
		contentPane.add(btnSupprimer);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        dispose();
		        ajout_film aj = new ajout_film();
		        aj.setVisible(true);
			}
		});
		btnAjouter.setBounds(57, 169, 117, 65);
		contentPane.add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        modifier modif = new modifier();
		        modif.setVisible(true);
			}
		});
		btnModifier.setBounds(476, 169, 117, 65);
		contentPane.add(btnModifier);

	}
}