import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	public static DefaultListModel<User> userList = new DefaultListModel<User>();
	public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	public static Object emptyFieldLabel;

	/**
	 * Launch the application.
	 * @throws FileNotFoundException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws FileNotFoundException, ParseException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Main frame = new Main();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		//USERS READING
		Scanner users = new Scanner(new FileReader(args[0]));
		while (users.hasNextLine())
		{
			String line = users.nextLine();
			String[] params = line.split("\t");
			UserCollection.addUser(params[0], params[1], params[2], formatter.parse(params[3]), params[4], params[5]);
		}
		users.close();
		
		//COMMANDS READING
		Scanner commands = new Scanner(new FileReader(args[1]));
		while (commands.hasNextLine())
		{
			String line = commands.nextLine();
			String[] params = line.split("\t");
			switch (params[0])
			{
				case "ADDFRIEND":
					UserCollection.users.get(params[1]).addFriend(params[1], params[2]);
					break;
				case "BLOCKFRIEND":
					UserCollection.users.get(params[1]).blockFriend(params[1], params[2]);
					break;
				case "ADDPOST-TEXT":
					UserCollection.users.get(params[1]).addTextPost(params[2], Double.parseDouble(params[3]), Double.parseDouble(params[4]), params[5]);
					break;
				case "ADDPOST-IMAGE":
					UserCollection.users.get(params[1]).addImagePost(params[2], Double.parseDouble(params[3]), Double.parseDouble(params[4]), params[6], params[7], params[5]);
					break;
				case "ADDPOST-VIDEO":
					UserCollection.users.get(params[1]).addVideoPost(params[2], Double.parseDouble(params[3]), Double.parseDouble(params[4]), params[6], Integer.parseInt(params[7]), params[5]);
					break;
			}
		}
		commands.close();
	}
	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("Facebook Login Page");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					UserCollection.login(usernameField.getText(), passwordField.getText());
					ProfilePage profilePage = new ProfilePage();
					profilePage.ProfilePageScreen();
				}
				catch (NullPointerException noUser)
				{
					
				}
			}
		});
		loginButton.setBounds(448, 131, 86, 23);
		contentPane.add(loginButton);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(381, 68, 81, 30);
		contentPane.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(381, 95, 81, 30);
		contentPane.add(passwordLabel);
		
		usernameField = new JTextField();
		usernameField.setBounds(448, 73, 86, 20);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel logoLabel = new JLabel("");
		Image facebookLogo = new ImageIcon(this.getClass().getResource("/Images/Facebooklogo1.png")).getImage();
		logoLabel.setIcon(new ImageIcon(facebookLogo));
		logoLabel.setBounds(10, 21, 300, 178);
		contentPane.add(logoLabel);
		
		JLabel lblRegisteredUsers = new JLabel("Registered Users");
		lblRegisteredUsers.setBounds(10, 210, 166, 30);
		contentPane.add(lblRegisteredUsers);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(448, 100, 86, 20);
		contentPane.add(passwordField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 241, 524, 46);
		contentPane.add(scrollPane);
		
		JList<User> registeredUserList = new JList<User>();
		registeredUserList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		registeredUserList.setVisibleRowCount(2);
		scrollPane.setViewportView(registeredUserList);
		registeredUserList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		registeredUserList.setModel(userList);
		registeredUserList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				try 
				{
					User selected = registeredUserList.getSelectedValue();
					usernameField.setText(selected.getUsername());
					passwordField.setText(selected.getPassword());
				}
				catch (NullPointerException ex)
				{
					usernameField.setText("");
					passwordField.setText("");
				}
			}
		});
		
		
		JButton removeUserButton = new JButton("Remove User");
		removeUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Do you really want to remove this user?", null, JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION)
				{
					User selected = registeredUserList.getSelectedValue();
					UserCollection.removeUser(selected);
				}
			}
		});
		removeUserButton.setBounds(10, 324, 127, 23);
		contentPane.add(removeUserButton);
		
		JButton newUserButton = new JButton("New User");
		newUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateUser createUser = new CreateUser();
				createUser.createUserScreen();
			}
		});
		newUserButton.setBounds(407, 324, 127, 23);
		contentPane.add(newUserButton);
	}
}
