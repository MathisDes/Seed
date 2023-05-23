import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.Font;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Button;
import javax.swing.JSlider;
import javax.swing.JLabel;

public class WindowBuilder extends JFrame {

	private JPanel contentPane;
	private Button button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilder frame = new WindowBuilder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WindowBuilder() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 402);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("Inception");
		label.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 24));
		label.setBounds(199, 29, 449, 37);
		contentPane.add(label);
		
		Panel panel = new Panel();
		panel.setBounds(10, 31, 183, 233);
		contentPane.add(panel);
		
		Label label_1 = new Label("Sortie en");
		label_1.setForeground(Color.GRAY);
		label_1.setFont(new Font("Montserrat", Font.BOLD, 12));
		label_1.setBounds(208, 103, 66, 21);
		contentPane.add(label_1);
		
		Label label_2 = new Label("New label");
		label_2.setForeground(Color.GRAY);
		label_2.setFont(new Font("Montserrat", Font.PLAIN, 12));
		label_2.setBounds(281, 103, 71, 21);
		contentPane.add(label_2);
		
		Label label_1_1 = new Label("De");
		label_1_1.setForeground(Color.GRAY);
		label_1_1.setFont(new Font("Montserrat", Font.BOLD, 12));
		label_1_1.setBounds(208, 172, 24, 21);
		contentPane.add(label_1_1);
		
		Label label_2_1 = new Label("New label");
		label_2_1.setForeground(Color.GRAY);
		label_2_1.setFont(new Font("Montserrat", Font.PLAIN, 12));
		label_2_1.setBounds(238, 172, 71, 21);
		contentPane.add(label_2_1);
		
		Label label_1_1_1 = new Label("Avec");
		label_1_1_1.setForeground(Color.GRAY);
		label_1_1_1.setFont(new Font("Montserrat", Font.BOLD, 12));
		label_1_1_1.setBounds(206, 137, 42, 21);
		contentPane.add(label_1_1_1);
		
		Label label_1_1_1_1 = new Label("Christian Bale, Heath Ledger, Aaron Eckhart");
		label_1_1_1_1.setForeground(Color.GRAY);
		label_1_1_1_1.setFont(new Font("Montserrat", Font.PLAIN, 12));
		label_1_1_1_1.setBounds(246, 137, 375, 21);
		contentPane.add(label_1_1_1_1);
		
		Label label_1_2 = new Label("Synopsis :");
		label_1_2.setForeground(Color.GRAY);
		label_1_2.setFont(new Font("Montserrat", Font.BOLD, 12));
		label_1_2.setBounds(208, 203, 81, 21);
		contentPane.add(label_1_2);
		
		JTextPane synopsis_txt = new JTextPane();
		synopsis_txt.setForeground(Color.GRAY);
		synopsis_txt.setFont(new Font("Montserrat", Font.PLAIN, 15));
		synopsis_txt.setText("Un voleur professionnel s’infiltre dans les rêves de ses cibles pour leur voler des secrets.");
		synopsis_txt.setBackground(SystemColor.menu);
		synopsis_txt.setBounds(288, 203, 318, 65);
		contentPane.add(synopsis_txt);
		
		Label label_1_1_1_2 = new Label("Genre");
		label_1_1_1_2.setForeground(Color.GRAY);
		label_1_1_1_2.setFont(new Font("Montserrat", Font.BOLD, 12));
		label_1_1_1_2.setBounds(208, 72, 143, 21);
		contentPane.add(label_1_1_1_2);

        // Champ de sélection de chiffre entre 1 et 9
        SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, 9, 1);
        
        Panel panel_1 = new Panel();
        panel_1.setBounds(261, 268, 403, 87);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        JSlider slider = new JSlider();
        slider.setBounds(10, 47, 200, 22);
        panel_1.add(slider);
        slider.setValue(2);
        slider.setMaximum(8);
        slider.setToolTipText("");
        slider.setPaintLabels(true);
        
                int sliderValue = slider.getValue();
                
                     
        JLabel lblNewLabel = new JLabel(sliderValue + " Semaines");
        lblNewLabel.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 13));
        lblNewLabel.setBounds(53, 24, 157, 13);
        panel_1.add(lblNewLabel);
        

        JButton btnNewButton = new JButton("Louer");
        btnNewButton.setBounds(273, 9, 120, 58);
        panel_1.add(btnNewButton);
        btnNewButton.setBackground(new Color(34, 139, 34));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 24));
        
        button = new Button("Back");
        button.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        button.setBounds(10, 329, 81, 26);
        contentPane.add(button);
        
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            }
        });
	}
}
