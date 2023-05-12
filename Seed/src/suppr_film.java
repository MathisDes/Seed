import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class suppr_film extends JFrame {
	private JPanel contentPane;
	   private JTable table;
	   private JButton btnSuppr;

	public static void main(String[] args) {

		suppr_film frame = new suppr_film();
		frame.setVisible(true);

	}
	

	public suppr_film() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(859,496);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

	      String url = "jdbc:mysql://localhost:3306/seed";
	      String user = "root";
	      String password = "";
	      try {
	         Connection con = DriverManager.getConnection(url, user, password);
	         Statement stmt = con.createStatement();


	         ResultSet rs = stmt.executeQuery("SELECT * FROM films");
	         

	         DefaultTableModel model = new DefaultTableModel();
	         table = new JTable(model);


	         ResultSetMetaData meta = rs.getMetaData();
	         int columnCount = meta.getColumnCount();
	         for (int i = 1; i <= columnCount; i++) {
	            model.addColumn(meta.getColumnLabel(i));
	         }


	         while (rs.next()) {
	            Object[] row = new Object[columnCount];
	            for (int i = 1; i <= columnCount; i++) {
	               row[i-1] = rs.getObject(i);
	            }
	            model.addRow(row);
	         }


	         rs.close();
	         stmt.close();
	         con.close();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }


	      btnSuppr = new JButton("Supprimer");
	      btnSuppr.setFont(new Font("Tahoma", Font.PLAIN, 20));
	      btnSuppr.setBounds(82, 359, 166, 46);
	      btnSuppr.addActionListener(new ActionListener() {
	    	   public void actionPerformed(ActionEvent e) {
	    	      int selectedRow = table.getSelectedRow();
	    	      if (selectedRow != -1) {
	    	         DefaultTableModel model = (DefaultTableModel) table.getModel();
	    	         String primaryKey = model.getValueAt(selectedRow, 0).toString(); // Remplacez "0" par l'index de la colonne contenant la clé primaire
	    	         
	    	 
	    	         String url = "jdbc:mysql://localhost:3306/seed";
	    	         String user = "root";
	    	         String password = "";
	    	         try {
	    	            Connection con = DriverManager.getConnection(url, user, password);
	    	            Statement stmt = con.createStatement();
	    	            
	    	           
	    	            String sql = "DELETE FROM films WHERE id = '" + primaryKey + "'";
	    	            stmt.executeUpdate(sql);
	    	            stmt.close();
	    	            con.close();
	    	            model.removeRow(selectedRow);
	    	            JOptionPane.showMessageDialog(null, "Suppression réussie");
	    	         } catch (SQLException ex) {
	    	            ex.printStackTrace();
	    	         }
	    	      }
	    	   }
	    	});
	      getContentPane().setLayout(null);
	      getContentPane().add(btnSuppr);


	      JScrollPane tableau = new JScrollPane(table);
	      tableau.setBounds(28, 100, 365, 218);
	      getContentPane().add(tableau);
	      setVisible(true);

		
		JLabel lblPrincipal = new JLabel("Supprimer un film");
		lblPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPrincipal.setBounds(49, 31, 238, 47);
		contentPane.add(lblPrincipal);
		
		JRadioButton btnRadioJeu = new JRadioButton("JEU");
		btnRadioJeu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRadioJeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				suppr_jeu suppr_jeu = new suppr_jeu();
				suppr_jeu.setVisible(true);
			}
		});
		btnRadioJeu.setBounds(572, 271, 136, 47);
		contentPane.add(btnRadioJeu);
		
		JRadioButton btnRadioLivre = new JRadioButton("LIVRE");
		btnRadioLivre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRadioLivre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				suppr_livre suppr_liv = new suppr_livre();
				suppr_liv.setVisible(true);
				
			}
		});
		btnRadioLivre.setBounds(572, 320, 153, 47);
		contentPane.add(btnRadioLivre);
		
		JButton btnRetour = new JButton("<- Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				admin adm = new admin();
				adm.setVisible(true);
			}
		});
		
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnRetour.setBounds(619, 33, 191, 68);
		contentPane.add(btnRetour);
		
		JLabel lblChOeuvre = new JLabel("Changer oeuvre :");
		lblChOeuvre.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblChOeuvre.setBounds(516, 222, 220, 47);
		contentPane.add(lblChOeuvre);
		


	}
}