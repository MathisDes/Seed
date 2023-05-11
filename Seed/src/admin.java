
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
		setSize(941,530);
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
		        supprimer supp = new supprimer();
		        supp.setVisible(true);
			}
		});
		btnSupprimer.setBounds(96, 182, 117, 65);
		contentPane.add(btnSupprimer);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        dispose();
		        ajout_film aj = new ajout_film();
		        aj.setVisible(true);
			}
		});
		btnAjouter.setBounds(419, 182, 117, 65);
		contentPane.add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        modifier modif = new modifier();
		        modif.setVisible(true);
			}
		});
		btnModifier.setBounds(763, 182, 117, 65);
		contentPane.add(btnModifier);

	}
}