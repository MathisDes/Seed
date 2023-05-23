import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AutrePage extends JFrame implements ActionListener  {

    private JButton bouton;
    private String type = "films";
    private int id = 1;

    public AutrePage() {
        this.setTitle("Autre page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        bouton = new JButton("Afficher produit");
        bouton.addActionListener(this);
        panel.add(bouton);
        this.add(panel);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bouton) {
            // Ouvrir la page produit et passer les variables
            ProduitPageFilm produit = new ProduitPageFilm(id, type);
            produit.setVisible(true);
        }
    }
    
   

   

}



