import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class Suppr_livre extends JFrame {
	private JPanel contentPane;
	   private JTable table;
	   private JButton btnSuppr;

	
	

	public Suppr_livre() {
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


	         ResultSet rs = stmt.executeQuery("SELECT * FROM livre");
	         

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
	    	         String primaryKey = model.getValueAt(selectedRow, 0).toString();
	    	         
	    	 
	    	         String url = "jdbc:mysql://localhost:3306/seed";
	    	         String user = "root";
	    	         String password = "";
	    	         try {
	    	            Connection con = DriverManager.getConnection(url, user, password);
	    	            Statement stmt = con.createStatement();
	    	            
	    	           
	    	            String sql = "DELETE FROM livre WHERE id = '" + primaryKey + "'";
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
	      tableau.setBounds(28, 100, 452, 218);
	      getContentPane().add(tableau);
	      setVisible(true);

		
		JLabel lblPrincipal = new JLabel("Supprimer un livre");
		lblPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPrincipal.setBounds(49, 31, 230, 47);
		contentPane.add(lblPrincipal);
		
		JRadioButton btnRadioFilm = new JRadioButton("FILM");
		btnRadioFilm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRadioFilm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Suppr_film suppr_fil = new Suppr_film();
				suppr_fil.setVisible(true);
			}
		});
		btnRadioFilm.setBounds(572, 271, 136, 47);
		contentPane.add(btnRadioFilm);
		
		JRadioButton btnRadioJeu = new JRadioButton("JEU");
		btnRadioJeu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRadioJeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Suppr_jeu suppr_jeu = new Suppr_jeu();
				suppr_jeu.setVisible(true);
				
			}
		});
		btnRadioJeu.setBounds(572, 320, 153, 47);
		contentPane.add(btnRadioJeu);
		
		JButton btnRetour = new JButton("<- Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Admin adm = new Admin();
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