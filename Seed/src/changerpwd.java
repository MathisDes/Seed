import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class changerpwd extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JLabel lblEnterNewPassword;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public changerpwd(String name) {
        setBounds(450, 360, 734, 356);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField = new JTextField();
        textField.setBounds(384, 35, 326, 67);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 34));
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnSearch = new JButton("Confirmer");
        btnSearch.setBounds(347, 225, 363, 59);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String pstr = textField.getText();
                try {
                    System.out.println("update password name " + name);
                    System.out.println("update password");

                    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/seed",
                        "root", "");

                    PreparedStatement st = (PreparedStatement) con
                        .prepareStatement("Update adherent set password=? where username=?");

                    st.setString(1, pstr);
                    st.setString(2, name);
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(btnSearch, "Mot de passe changé ");
                    dispose();
                    accueil ac = new accueil();
                    
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }

            }
        });
        btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 29));
        btnSearch.setBackground(new Color(240, 240, 240));
        contentPane.add(btnSearch);

        lblEnterNewPassword = new JLabel("Nouveau mot de passe :");
        lblEnterNewPassword.setBounds(45, 37, 363, 67);
        lblEnterNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
        contentPane.add(lblEnterNewPassword);
    }
}