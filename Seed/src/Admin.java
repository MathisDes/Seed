import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class Admin extends JFrame {
	private JPanel contentPane;

	


	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,400);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        dispose();
		        Suppr_film supp = new Suppr_film();
		        supp.setVisible(true);
			}
		});
		btnSupprimer.setBounds(270, 169, 117, 65);
		contentPane.add(btnSupprimer);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        dispose();
		        Ajout_film aj = new Ajout_film();
		        aj.setVisible(true);
			}
		});
		btnAjouter.setBounds(57, 169, 117, 65);
		contentPane.add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifier_film modif_fil = new modifier_film();
		        modif_fil.setVisible(true);
			}
		});
		btnModifier.setBounds(476, 169, 117, 65);
		contentPane.add(btnModifier);

	}
}