import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class CreateUser extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField passwordreTypeField;
	private JTextField passwordField;
	private JTextField nameSurnameField;
	private JTextField schoolGraduatedField;
	private JTextField dateOfBirthField;
	public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Launch the application.
	 */
	public static void createUserScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					CreateUser frame = new CreateUser();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreateUser() {
		setTitle("Create User");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 324, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox relationshipComboBox = new JComboBox();
		relationshipComboBox.setModel(new DefaultComboBoxModel(new String[] {"Single", "In a relationship", "Complicated", "Divorced"}));
		relationshipComboBox.setBounds(125, 287, 118, 20);
		contentPane.add(relationshipComboBox);
		
		JLabel logoLabel = new JLabel("");
		Image facebookLogo = new ImageIcon(this.getClass().getResource("/Images/Facebooklogo1.png")).getImage();
		logoLabel.setIcon(new ImageIcon(facebookLogo));
		logoLabel.setBounds(9, 11, 300, 90);
		contentPane.add(logoLabel);
		
		JLabel createUserLabel = new JLabel("Create User");
		createUserLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		createUserLabel.setBounds(110, 100, 97, 14);
		contentPane.add(createUserLabel);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(11, 140, 118, 14);
		contentPane.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(11, 165, 118, 14);
		contentPane.add(passwordLabel);
		
		JLabel passwordreTypeLabel = new JLabel("Password (re-type)");
		passwordreTypeLabel.setBounds(11, 190, 118, 14);
		contentPane.add(passwordreTypeLabel);
		
		JLabel lblNameSurname = new JLabel("Name Surname");
		lblNameSurname.setBounds(11, 215, 118, 14);
		contentPane.add(lblNameSurname);
		
		JLabel lblSchoolGraduated = new JLabel("School Graduated");
		lblSchoolGraduated.setBounds(11, 240, 118, 14);
		contentPane.add(lblSchoolGraduated);
		
		JLabel lblBirthdate = new JLabel("Birth Date");
		lblBirthdate.setBounds(11, 265, 118, 14);
		contentPane.add(lblBirthdate);
		
		JLabel lblRelationshipStatus = new JLabel("Relationship Status");
		lblRelationshipStatus.setBounds(11, 290, 118, 14);
		contentPane.add(lblRelationshipStatus);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UserCollection.createUser(nameSurnameField.getText(), usernameField.getText(), passwordField.getText(), passwordreTypeField.getText(),
							dateOfBirthField.getText(), schoolGraduatedField.getText(), relationshipComboBox.getSelectedItem().toString());
					dispose();
				} 
				catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "Birt date field must be like dd/MM/yyyy!", null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(114, 334, 89, 23);
		contentPane.add(btnNewButton);
		
		usernameField = new JTextField();
		usernameField.setBounds(125, 137, 86, 20);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		passwordreTypeField = new JTextField();
		passwordreTypeField.setColumns(10);
		passwordreTypeField.setBounds(125, 187, 86, 20);
		contentPane.add(passwordreTypeField);
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		passwordField.setBounds(125, 162, 86, 20);
		contentPane.add(passwordField);
		
		nameSurnameField = new JTextField();
		nameSurnameField.setColumns(10);
		nameSurnameField.setBounds(125, 212, 186, 20);
		contentPane.add(nameSurnameField);
		
		schoolGraduatedField = new JTextField();
		schoolGraduatedField.setColumns(10);
		schoolGraduatedField.setBounds(125, 237, 186, 20);
		contentPane.add(schoolGraduatedField);
		
		dateOfBirthField = new JTextField();
		dateOfBirthField.setColumns(10);
		dateOfBirthField.setBounds(125, 262, 86, 20);
		contentPane.add(dateOfBirthField);
	}
}
