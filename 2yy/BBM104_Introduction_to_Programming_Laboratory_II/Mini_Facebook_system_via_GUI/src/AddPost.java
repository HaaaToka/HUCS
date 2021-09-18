import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPost extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField latitudeField;
	private JTextField longitudeField;
	private JTextField filenameField;
	private JTextField widthField;
	private JTextField heightField;
	private JTextField durationField;

	/**
	 * Launch the application.
	 */
	public static void AddPostScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					AddPost frame = new AddPost();
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
	public AddPost() {
		setTitle("Create Post");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 512, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(79, 61, 419, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		latitudeField = new JTextField();
		latitudeField.setBounds(79, 86, 126, 20);
		contentPane.add(latitudeField);
		latitudeField.setColumns(10);
		
		longitudeField = new JTextField();
		longitudeField.setColumns(10);
		longitudeField.setBounds(284, 86, 126, 20);
		contentPane.add(longitudeField);
		
		JLabel filenameLabel = new JLabel("Filename:");
		filenameLabel.setVisible(false);
		filenameLabel.setBounds(10, 125, 59, 14);
		contentPane.add(filenameLabel);
		
		filenameField = new JTextField();
		filenameField.setVisible(false);
		filenameField.setBounds(79, 122, 222, 20);
		contentPane.add(filenameField);
		filenameField.setColumns(10);
		
		JLabel widthLabel = new JLabel("Width:");
		widthLabel.setVisible(false);
		widthLabel.setBounds(10, 150, 59, 14);
		contentPane.add(widthLabel);
		
		widthField = new JTextField();
		widthField.setVisible(false);
		widthField.setBounds(79, 147, 86, 20);
		contentPane.add(widthField);
		widthField.setColumns(10);
		
		JLabel heightLabel = new JLabel("Height");
		heightLabel.setVisible(false);
		heightLabel.setBounds(175, 150, 59, 14);
		contentPane.add(heightLabel);
		
		heightField = new JTextField();
		heightField.setVisible(false);
		heightField.setColumns(10);
		heightField.setBounds(215, 147, 86, 20);
		contentPane.add(heightField);
		
		JLabel durationLabel = new JLabel("Duration");
		durationLabel.setVisible(false);
		durationLabel.setBounds(10, 150, 46, 14);
		contentPane.add(durationLabel);
		
		durationField = new JTextField();
		durationField.setVisible(false);
		durationField.setBounds(79, 147, 86, 20);
		contentPane.add(durationField);
		durationField.setColumns(10);
		
		JLabel postTypeLabel = new JLabel("Post Type");
		postTypeLabel.setBounds(10, 26, 59, 14);
		contentPane.add(postTypeLabel);
		
		JLabel textLabel = new JLabel("Text:");
		textLabel.setBounds(10, 64, 59, 14);
		contentPane.add(textLabel);
		
		JLabel latitudeLabel = new JLabel("Latitude:");
		latitudeLabel.setBounds(10, 89, 59, 14);
		contentPane.add(latitudeLabel);
		
		JLabel longitudeLabel = new JLabel("Longitude:");
		longitudeLabel.setBounds(215, 89, 59, 14);
		contentPane.add(longitudeLabel);
		
		
		
		JComboBox postTypeComboBox = new JComboBox();
		postTypeComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (postTypeComboBox.getSelectedItem().equals("ImagePost"))
				{
					filenameLabel.setVisible(true);
					filenameField.setVisible(true);
					widthLabel.setVisible(true);
					widthField.setVisible(true);
					widthField.setVisible(true);
					durationLabel.setVisible(false);
					durationField.setVisible(false);
				}
				else if (postTypeComboBox.getSelectedItem().equals("VideoPost"))
				{
					filenameLabel.setVisible(true);
					filenameField.setVisible(true);
					widthLabel.setVisible(false);
					widthField.setVisible(false);
					widthField.setVisible(false);
					durationLabel.setVisible(true);
					durationField.setVisible(true);
				}
				else if (postTypeComboBox.getSelectedItem().equals("TextPost"))
				{
					filenameLabel.setVisible(false);
					filenameField.setVisible(false);
					widthLabel.setVisible(false);
					widthField.setVisible(false);
					widthField.setVisible(false);
					durationLabel.setVisible(false);
					durationField.setVisible(false);
				}
			}
		});
		postTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"TextPost", "ImagePost", "VideoPost"}));
		postTypeComboBox.setBounds(79, 23, 158, 20);
		contentPane.add(postTypeComboBox);
		
		JButton addPostButton = new JButton("Add Post");
		addPostButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					if (postTypeComboBox.getSelectedItem().toString().equals("TextPost"))
					{
						UserCollection.whoLoggedIn.createTextPost(textField.getText(),Double.parseDouble(latitudeField.getText()), Double.parseDouble(longitudeField.getText()));
						dispose();
					}
					else if (postTypeComboBox.getSelectedItem().toString().equals("ImagePost"))
					{
						String resolution = widthField.getText() + "x" + heightField.getText();
						UserCollection.whoLoggedIn.createImagePost(textField.getText(),Double.parseDouble(latitudeField.getText()), Double.parseDouble(longitudeField.getText()),
								filenameField.getText(), resolution);
						dispose();
					}
					else if (postTypeComboBox.getSelectedItem().toString().equals("VideoPost"))
					{
						if (Integer.parseInt(durationField.getText()) < VideoPost.MAX_VIDEO_LENGTH)
						{
							UserCollection.whoLoggedIn.createVideoPost(textField.getText(),Double.parseDouble(latitudeField.getText()), Double.parseDouble(longitudeField.getText()),
									filenameField.getText(), Integer.parseInt(durationField.getText()));
							dispose();
						}
						else
							JOptionPane.showMessageDialog(null, "The duration of video can not be more than " + VideoPost.MAX_VIDEO_LENGTH + " minutes!", null, JOptionPane.WARNING_MESSAGE);
					}
				}
				catch (NumberFormatException emptyString)
				{
					JOptionPane.showMessageDialog(null, "Please fill the missing fields!", null, JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		addPostButton.setBounds(409, 22, 89, 23);
		contentPane.add(addPostButton);
		
		
	}
}
