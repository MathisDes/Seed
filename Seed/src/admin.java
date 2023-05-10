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

public class admin {

	private JFrame frame;
	private JTextField barreRecherche;

	public static void main(String[] args) {

		admin window = new admin();
		window.frame.setVisible(true);

	}


	public admin() {
        frame = new JFrame();
        frame.setSize(1400,700);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 1400, 100);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnDeco = new JButton("Se deconnecter");
		btnDeco.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDeco.setBounds(967, 10, 180, 80);
		panel.add(btnDeco);
		
		barreRecherche = new JTextField();
		barreRecherche.setForeground(new Color(128, 128, 128));
		barreRecherche.setFont(new Font("Tahoma", Font.PLAIN, 17));
		barreRecherche.setText("Rechercher...\r\n");
		barreRecherche.setBounds(193, 27, 719, 49);
		panel.add(barreRecherche);
		barreRecherche.setColumns(10);
		
		JLabel title = new JLabel("Page ADMIN");
		title.setFont(new Font("Tahoma", Font.PLAIN, 22));
		title.setBounds(587, 110, 125, 44);
		frame.getContentPane().add(title);
		
		JButton btnAjt = new JButton("Ajouter");
		btnAjt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAjt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAjt.setBounds(197, 231, 173, 89);
		frame.getContentPane().add(btnAjt);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnModifier.setBounds(559, 231, 173, 89);
		frame.getContentPane().add(btnModifier);
		
		JButton btnSupp = new JButton("Supprimer");
		btnSupp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSupp.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSupp.setBounds(1020, 231, 173, 89);
		frame.getContentPane().add(btnSupp);
	}
}