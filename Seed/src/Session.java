import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Session {
	
	private String email,username,role;

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getRole() {
		return role;
	}

	public Session(String email) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/seed", "root", "");
		         Statement stmt = conn.createStatement()) {

		        // Requête pour récupérer les informations sur le produit correspondant
			String sql = "SELECT email, ROLE, username FROM adherent WHERE email = '" + email + "';";
		        try (ResultSet rs = stmt.executeQuery(sql)) {
		        	
		        	if (rs.next()) {
		        		this.email = rs.getString("email");
		        		this.role = rs.getString("role");
		        		this.username = rs.getString("username");
		        		
		        	}
		        	else {JOptionPane.showMessageDialog(null, "Produit introuvable !");}
		        }
	} catch (SQLException e) {
        // Erreur de connexion à la base de données
        JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données : " + e.getMessage());
        e.printStackTrace();
    }
	}
	
	

}
