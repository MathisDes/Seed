import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class TestURLImage extends JFrame {
    private JLabel imageLabel;

    public TestURLImage() {
        super("Afficher une image à partir d'une URL");

        // Créer un label pour afficher l'image
        imageLabel = new JLabel();
        add(imageLabel, BorderLayout.CENTER);

        // Charger l'image à partir d'une URL
        try {
            URL imageUrl = new URL("https://fr.web.img2.acsta.net/medias/nmedia/18/70/45/22/19123474.jpg");
            BufferedImage image = ImageIO.read(imageUrl);
            ImageIcon icon = new ImageIcon(image);
            imageLabel.setIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Afficher la fenêtre
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TestURLImage());
    }
}
