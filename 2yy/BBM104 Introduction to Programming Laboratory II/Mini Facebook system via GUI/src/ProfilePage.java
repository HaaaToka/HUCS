import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;	
import java.awt.Font;
import java.awt.Image;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JList;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.border.SoftBevelBorder;
import java.awt.Component;

public class ProfilePage extends JFrame {

	private JPanel contentPane;
	private JTextField searchField;
	public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private JTextField updateSchoolField;
	private JTextField updateDateOfBirthField;
	private JTextField updateNameSurnameField;
	/**
	 * Launch the application.
	 */
	public static void ProfilePageScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ProfilePage frame = new ProfilePage();
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
	public ProfilePage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProfilePage.class.getResource("/Images/personicon8.png")));
		setTitle("Profile Page");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 750);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel searchFriendsLabel = new JLabel("Search Friends");
		searchFriendsLabel.setForeground(Color.WHITE);
		searchFriendsLabel.setBounds(177, 15, 89, 14);
		contentPane.add(searchFriendsLabel);
		
		searchField = new JTextField();
		searchField.setColumns(10);
		searchField.setBounds(268, 12, 179, 20);
		contentPane.add(searchField);
		
		JButton createPostButton = new JButton("Create a Post");
		createPostButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPost addPost = new AddPost();
				addPost.AddPostScreen();
			}
		});
		createPostButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		createPostButton.setBounds(514, 11, 121, 23);
		contentPane.add(createPostButton);
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserCollection.logout(UserCollection.whoLoggedIn);
				dispose();
			}
		});
		logoutButton.setFont(new Font("Dialog", Font.PLAIN, 12));
		logoutButton.setBounds(645, 11, 89, 23);
		contentPane.add(logoutButton);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.BLUE);
		topPanel.setBounds(0, 0, 744, 43);
		contentPane.add(topPanel);

		JLabel nameSurnameL = new JLabel("");
		nameSurnameL.setText(UserCollection.whoLoggedIn.getNameSurname());
		nameSurnameL.setFont(new Font("Tahoma", Font.BOLD, 20));
		nameSurnameL.setBounds(197, 173, 531, 23);
		contentPane.add(nameSurnameL);
		
		JPanel friendsPanel = new JPanel();
		friendsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		friendsPanel.setBounds(12, 491, 212, 218);
		contentPane.add(friendsPanel);
		friendsPanel.setLayout(null);
		JList<User> friendsList = new JList<User>();
		friendsList.setAutoscrolls(false);
		friendsList.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		friendsList.setVisibleRowCount(100);
		friendsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		friendsList.setFont(new Font("Dialog", Font.PLAIN, 12));
		friendsList.setBounds(12, 12, 188, 157);
		DefaultListModel<User> friends = new DefaultListModel<User>();
		DefaultListModel<User> blockedUsers = new DefaultListModel<User>();
		for(User user : UserCollection.whoLoggedIn.friends)
		{
			friends.addElement(user);
		}
		friendsPanel.add(friendsList);
		friendsList.setModel(friends);
	
		JPanel informationPanel = new JPanel();
		informationPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		informationPanel.setBounds(10, 219, 214, 232);
		contentPane.add(informationPanel);
		informationPanel.setLayout(null);
		
		JLabel dateOfBirthLabel = new JLabel("Date of Birth");
		dateOfBirthLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		dateOfBirthLabel.setBounds(12, 23, 190, 16);
		informationPanel.add(dateOfBirthLabel);
		
		JLabel dateOfBirthL = new JLabel("");
		dateOfBirthL.setText(formatter.format(UserCollection.whoLoggedIn.getDateOfBirth()));
		dateOfBirthL.setFont(new Font("Dialog", Font.PLAIN, 12));
		dateOfBirthL.setBounds(12, 45, 190, 16);
		informationPanel.add(dateOfBirthL);
		
		JLabel schoolGraduatedLabel = new JLabel("School Graduated");
		schoolGraduatedLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		schoolGraduatedLabel.setBounds(12, 73, 190, 16);
		informationPanel.add(schoolGraduatedLabel);
		
		JLabel schoolGraduatedL = new JLabel("");
		schoolGraduatedL.setText(UserCollection.whoLoggedIn.getSchoolGraduated());
		schoolGraduatedL.setFont(new Font("Dialog", Font.PLAIN, 12));
		schoolGraduatedL.setBounds(12, 101, 190, 16);
		informationPanel.add(schoolGraduatedL);
		
		JLabel relationshipStatusLabel = new JLabel("Relationship Status");
		relationshipStatusLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		relationshipStatusLabel.setBounds(12, 129, 190, 16);
		informationPanel.add(relationshipStatusLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setFont(new Font("Dialog", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Single", "In relationship", "Complicated", "Divorced"}));
		comboBox.setBounds(12, 157, 149, 25);
		comboBox.setSelectedItem(UserCollection.whoLoggedIn.getRelationship());
		informationPanel.add(comboBox);
		
		JButton updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (updateButton.getText().equals("Update"))
				{
					updateNameSurnameField.setVisible(true);
					updateSchoolField.setVisible(true);
					updateDateOfBirthField.setVisible(true);
					comboBox.setEnabled(true);
					updateButton.setText("Save");
					schoolGraduatedL.setVisible(false);
					dateOfBirthL.setVisible(false);
					updateSchoolField.setText(UserCollection.whoLoggedIn.getSchoolGraduated());
					updateDateOfBirthField.setText(formatter.format(UserCollection.whoLoggedIn.getDateOfBirth()));
					updateNameSurnameField.setText(UserCollection.whoLoggedIn.getNameSurname());
				}
				else
				{
					updateSchoolField.setVisible(false);
					updateDateOfBirthField.setVisible(false);
					updateNameSurnameField.setVisible(false);
					UserCollection.whoLoggedIn.setSchoolGraduated(updateSchoolField.getText());
					schoolGraduatedL.setText(UserCollection.whoLoggedIn.getSchoolGraduated());
					UserCollection.whoLoggedIn.setRelationship(comboBox.getSelectedItem().toString());
					UserCollection.whoLoggedIn.setNameSurname(updateNameSurnameField.getText());
					nameSurnameL.setText(UserCollection.whoLoggedIn.getNameSurname());
					comboBox.setSelectedItem(UserCollection.whoLoggedIn.getRelationship());
					comboBox.setEnabled(false);
					schoolGraduatedL.setVisible(true);
					dateOfBirthL.setVisible(true);
					nameSurnameL.setVisible(true);
					updateButton.setText("Update");
					try {
						UserCollection.whoLoggedIn.setDateOfBirth(formatter.parse(updateDateOfBirthField.getText()));
						dateOfBirthL.setText(formatter.format(UserCollection.whoLoggedIn.getDateOfBirth()));
						
					} 
					catch (ParseException e) {
						
					}
				}
					
			}
		});
		updateButton.setFont(new Font("Dialog", Font.PLAIN, 12));
		updateButton.setBounds(12, 194, 98, 26);
		informationPanel.add(updateButton);
		
		updateSchoolField = new JTextField();
		updateSchoolField.setVisible(false);
		updateSchoolField.setBounds(12, 100, 190, 20);
		informationPanel.add(updateSchoolField);
		updateSchoolField.setColumns(10);
		
		updateDateOfBirthField = new JTextField();
		updateDateOfBirthField.setVisible(false);
		updateDateOfBirthField.setBounds(12, 44, 190, 20);
		informationPanel.add(updateDateOfBirthField);
		updateDateOfBirthField.setColumns(10);
		
		JLabel personIconLabel = new JLabel("");
		Image facebookLogo = new ImageIcon(this.getClass().getResource("/Images/personicon8.png")).getImage();
		personIconLabel.setIcon(new ImageIcon(facebookLogo));
		personIconLabel.setBounds(36, 55, 149, 141);
		contentPane.add(personIconLabel);
		
		JLabel friendsLabel = new JLabel("Friends");
		friendsLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		friendsLabel.setBounds(20, 463, 55, 16);
		contentPane.add(friendsLabel);
		ButtonGroup radioGroup = new ButtonGroup();
		
		JRadioButton normalRadio = new JRadioButton("Normal");
		normalRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				friends.removeAllElements();
				for(User user : UserCollection.whoLoggedIn.friends)
				{
					friends.addElement(user);
				}
				friendsPanel.add(friendsList);
				friendsList.setModel(friends);
			}
		});
		normalRadio.setSelected(true);
		normalRadio.setFont(new Font("Dialog", Font.PLAIN, 12));
		normalRadio.setBounds(79, 459, 66, 24);
		contentPane.add(normalRadio);
		radioGroup.add(normalRadio);
		
		JRadioButton blockedRadio = new JRadioButton("Blocked");
		blockedRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				blockedUsers.removeAllElements();
				for(User user : UserCollection.whoLoggedIn.blockedUsers)
				{
					blockedUsers.addElement(user);
				}
				friendsPanel.add(friendsList);
				friendsList.setModel(blockedUsers);
			}
		});
		blockedRadio.setFont(new Font("Dialog", Font.PLAIN, 12));
		blockedRadio.setBounds(149, 459, 75, 24);
		contentPane.add(blockedRadio);
		radioGroup.add(blockedRadio);
		
		JButton removeSelectedUserButton = new JButton("Remove Selected User");
		removeSelectedUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User selected = friendsList.getSelectedValue();
				UserCollection.whoLoggedIn.removeFriend(selected);
				UserCollection.whoLoggedIn.unblockFriend(selected);
				friends.removeElement(selected);
				blockedUsers.removeElement(selected);
			}
		});
		removeSelectedUserButton.setFont(new Font("Dialog", Font.PLAIN, 12));
		removeSelectedUserButton.setBounds(12, 181, 188, 26);
		friendsPanel.add(removeSelectedUserButton);
		
		updateNameSurnameField = new JTextField();
		updateNameSurnameField.setVisible(false);
		updateNameSurnameField.setBounds(195, 173, 214, 23);
		contentPane.add(updateNameSurnameField);
		updateNameSurnameField.setColumns(10);
		
		
		
		JTabbedPane postsTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		postsTabbedPane.setBounds(234, 219, 500, 491);
		contentPane.add(postsTabbedPane);
		
		JScrollPane myPosts = new JScrollPane();
		myPosts.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		myPosts.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		postsTabbedPane.addTab("My Posts", null, myPosts, null);
		
		JPanel myPostInner = new JPanel();
		myPosts.setViewportView(myPostInner);
		myPostInner.setLayout(new BoxLayout(myPostInner, BoxLayout.Y_AXIS));
		
		JScrollPane friendsPosts = new JScrollPane();
		friendsPosts.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		friendsPosts.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		postsTabbedPane.addTab("Friends' Posts", null, friendsPosts, null);
		
		JPanel friendsPostInner = new JPanel();
		friendsPosts.setViewportView(friendsPostInner);
		friendsPostInner.setLayout(new BoxLayout(friendsPostInner, BoxLayout.Y_AXIS));
		
		for (Post post : UserCollection.whoLoggedIn.posts)
		{
			JPanel myPost = new JPanel();
			myPost.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			myPost.setAlignmentY(Component.TOP_ALIGNMENT);
			myPost.setAlignmentX(Component.LEFT_ALIGNMENT);
			myPost.setMaximumSize(new Dimension(1000, 100));
			myPostInner.add(myPost);
			myPost.setLayout(new BorderLayout(0, 0));
			
			if (post instanceof ImagePost)
			{
				JLabel postTypeLabel = new JLabel("I");
				postTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
				myPost.add(postTypeLabel, BorderLayout.WEST);
			}
			else if (post instanceof VideoPost)
			{
				JLabel postTypeLabel = new JLabel("V");
				postTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
				myPost.add(postTypeLabel, BorderLayout.WEST);
			}
			else
			{
				JLabel postTypeLabel = new JLabel("T");
				postTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
				myPost.add(postTypeLabel, BorderLayout.WEST);
			}
				
			
			JLabel taggedUsersLabel = new JLabel("Tagged Users: " + post.taggedUsers.toString().replace("[", "").replace("]", ""));
			myPost.add(taggedUsersLabel, BorderLayout.SOUTH);
			
			JLabel postContentLabel = new JLabel(post.textContent);
			myPost.add(postContentLabel, BorderLayout.NORTH);
			
			JButton tagFriendsButton = new JButton("Tag Friends");
			myPost.add(tagFriendsButton, BorderLayout.EAST);
			tagFriendsButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					TagUser tagUser = new TagUser();
					tagUser.TagUserScreen();
				}
			});
		}
		
		
		for (User user : UserCollection.whoLoggedIn.friends)
		{
			for (Post post : user.posts)
			{
				JPanel friendPost = new JPanel();
				friendPost.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
				friendPost.setAlignmentY(Component.TOP_ALIGNMENT);
				friendPost.setAlignmentX(Component.LEFT_ALIGNMENT);
				friendPost.setMaximumSize(new Dimension(1000, 100));
				friendsPostInner.add(friendPost);
				friendPost.setLayout(new BorderLayout(0, 0));
				
				if (post instanceof ImagePost)
				{
					JLabel postTypeLabel = new JLabel("I");
					postTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
					friendPost.add(postTypeLabel, BorderLayout.WEST);
				}
				else if (post instanceof VideoPost)
				{
					JLabel postTypeLabel = new JLabel("V");
					postTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
					friendPost.add(postTypeLabel, BorderLayout.WEST);
				}
				else
				{
					JLabel postTypeLabel = new JLabel("T");
					postTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
					friendPost.add(postTypeLabel, BorderLayout.WEST);
				}
				
				ArrayList<User> unTaggedList = new ArrayList<User>();
				for (User friend : UserCollection.whoLoggedIn.friends)
				{
					if (!post.taggedUsers.equals(friend))
					{
						unTaggedList.add(friend);
					}
				}
				JLabel taggedUsersLabel = new JLabel("Tagged Users: " + post.taggedUsers.toString().replace("[", "").replace("]", ""));
				friendPost.add(taggedUsersLabel, BorderLayout.SOUTH);
				
				JLabel postContentLabel = new JLabel(post.textContent);
				friendPost.add(postContentLabel, BorderLayout.NORTH);
				
				JButton tagFriendsButton = new JButton("Tag Friends");
				friendPost.add(tagFriendsButton, BorderLayout.EAST);
			}
		}	
	}
}
