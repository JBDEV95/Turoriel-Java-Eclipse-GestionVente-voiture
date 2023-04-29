package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	MenuPrincipale men = new MenuPrincipale();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(112, 93, 513, 236);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONNEXION\r\n");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 493, 40);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOM UTILISATEUR :\r\n");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 62, 159, 31);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("MOT DE PASSE :\r\n\r\n");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 104, 159, 31);
		panel.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField.setBounds(176, 62, 301, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("SansSerif", Font.PLAIN, 14));
		passwordField.setBounds(176, 104, 301, 31);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("CONNECTER\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nom = textField.getText();
					String mdp = passwordField.getText();
					if(nom.equals("ADMIN")&& mdp.equals("ADMIN")) {
						Login.this.dispose();
						men.setVisible(true);
						
					}else {
						JOptionPane.showMessageDialog(null, "Erreur de connexion", "Danger!!", JOptionPane.ERROR_MESSAGE);
					}
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		btnNewButton.setBounds(303, 146, 174, 31);
		panel.add(btnNewButton);
		
		JButton btnActualiser = new JButton("ACTUALISER");
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				passwordField.setText(null);
			}
		});
		btnActualiser.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		btnActualiser.setBounds(303, 188, 174, 31);
		panel.add(btnActualiser);
		
		JLabel lblNewLabel_3 = new JLabel("NOM DE VOTRE LOGICIEL OU VOTRE ENTREPRISE\r\n");
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 11, 705, 63);
		contentPane.add(lblNewLabel_3);
	}
}
