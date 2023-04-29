package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuPrincipale extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipale frame = new MenuPrincipale();
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
	Connection con;
	PreparedStatement pst;
	private JTextField textField_6;
	public MenuPrincipale() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 174, 528);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(MenuPrincipale.class.getResource("/Vue/Profile-24_3.png")));
		lblNewLabel.setBounds(10, 11, 127, 45);
		panel.add(lblNewLabel);
		
		JButton btnVendre = new JButton("VENDRE\r\n");
		btnVendre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connect();
					String sql = "update vente set disponible =disponible-? where matricule=?";
					pst = con.prepareStatement(sql);
					pst.setString(1,textField_6.getText());
					pst.setString(2, textField.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Vendu");
					tablevoiture();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnVendre.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnVendre.setBounds(10, 103, 154, 30);
		panel.add(btnVendre);
		
		
		JLabel lblNewLabel_1 = new JLabel("BONJOUR, JBDEV95");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 67, 154, 25);
		panel.add(lblNewLabel_1);
		
		JButton btnActualiser = new JButton("ACTUALISER");
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
			}
		});
		btnActualiser.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnActualiser.setBounds(10, 144, 154, 30);
		panel.add(btnActualiser);
		
		JButton btnActualiser_1 = new JButton("DECONNECTER");
		btnActualiser_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipale.this.dispose();
                Login login = new Login();
                login.setVisible(true);
			}
		});
		btnActualiser_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnActualiser_1.setBounds(10, 185, 154, 30);
		panel.add(btnActualiser_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(194, 11, 620, 54);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Liste de mes voitures disponibles\r\n");
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 11, 304, 33);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(194, 88, 620, 451);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Matricules :");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 268, 112, 27);
		panel_2.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textField.setBounds(132, 268, 144, 27);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(132, 306, 144, 27);
		panel_2.add(textField_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Nom :");
		lblNewLabel_3_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(10, 306, 112, 27);
		panel_2.add(lblNewLabel_3_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(132, 344, 144, 27);
		panel_2.add(textField_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("Model :");
		lblNewLabel_3_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_3_2.setBounds(10, 344, 112, 27);
		panel_2.add(lblNewLabel_3_2);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(132, 382, 144, 27);
		panel_2.add(textField_3);
		
		JLabel lblNewLabel_3_3 = new JLabel("Année :");
		lblNewLabel_3_3.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_3_3.setBounds(10, 382, 112, 27);
		panel_2.add(lblNewLabel_3_3);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(132, 413, 144, 27);
		panel_2.add(textField_4);
		
		JLabel lblNewLabel_3_4 = new JLabel("Distances :");
		lblNewLabel_3_4.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_3_4.setBounds(10, 413, 112, 27);
		panel_2.add(lblNewLabel_3_4);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("SansSerif", Font.BOLD, 47));
		textField_5.setColumns(10);
		textField_5.setBounds(408, 306, 177, 96);
		panel_2.add(textField_5);
		
		JLabel lblNewLabel_3_5 = new JLabel("Prix :");
		lblNewLabel_3_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_5.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_3_5.setBounds(286, 306, 112, 96);
		panel_2.add(lblNewLabel_3_5);
		
		JLabel lblNewLabel_3_5_1 = new JLabel("€");
		lblNewLabel_3_5_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_3_5_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_5_1.setFont(new Font("SansSerif", Font.BOLD, 47));
		lblNewLabel_3_5_1.setBounds(595, 306, 48, 96);
		panel_2.add(lblNewLabel_3_5_1);
		
		JLabel lblNewLabel_3_6 = new JLabel("Disponibles :");
		lblNewLabel_3_6.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_3_6.setBounds(286, 268, 112, 27);
		panel_2.add(lblNewLabel_3_6);
		
		JButton btnVoiture = new JButton("AJOUTER");
		btnVoiture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connect();
					String sql= "insert into vente(matricule, nom, model, annee, distance, disponible, prix)"
							+ "values(?,?,?,?,?,?,?)";
					pst = con.prepareStatement(sql);
					pst.setString(1,textField.getText() );
					pst.setString(2,textField_1.getText() );
					pst.setString(3,textField_2.getText() );
					pst.setString(4,textField_3.getText() );
					pst.setString(5,textField_4.getText() );
					pst.setString(6,textField_6.getText() );
					pst.setString(7,textField_5.getText() );
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "ajouter");
					pst.close();
					con.close();
					tablevoiture();
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
				
		});
		btnVoiture.setBounds(408, 411, 177, 30);
		panel_2.add(btnVoiture);
		btnVoiture.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 11, 625, 246);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int selectionner = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				textField.setText(model.getValueAt(selectionner, 0).toString());
				textField_1.setText(model.getValueAt(selectionner, 1).toString());
				textField_2.setText(model.getValueAt(selectionner, 2).toString());
				textField_3.setText(model.getValueAt(selectionner, 3).toString());
				textField_4.setText(model.getValueAt(selectionner, 4).toString());
				textField_6.setText(model.getValueAt(selectionner, 5).toString());
				textField_5.setText(model.getValueAt(selectionner, 6).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textField_6.setColumns(10);
		textField_6.setBounds(408, 268, 177, 27);
		panel_2.add(textField_6);
		tablevoiture();
		
		
	}

	private void tablevoiture() {
		Connect();
		String colonne [] = {
		"Matricule",
		"Nom",
		"Model",
		"Année",
		"Distance",
		"Disponible",
		"Prix"};
		DefaultTableModel model = new DefaultTableModel(null,colonne);
		try {
			Statement st = con.createStatement();
			ResultSet rs  = st.executeQuery("select  * from vente");
		    while (rs.next()) {
				Object o [] = {
						rs.getString("matricule"),
						rs.getString("nom"),
						rs.getString("model"),
						rs.getString("annee"),
						rs.getString("distance"),
						rs.getString("disponible"),
						rs.getString("prix")
				};
				model.addRow(o);
			}
		    table.setModel(model);
		    st.close();
		    rs.close();
		    con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void Connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:demoVoiture.db");
			System.out.println("connection établie");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("erreur de connection");
		}
	}
}
