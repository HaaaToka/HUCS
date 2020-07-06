import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;

public class TagUser extends JFrame {

	private JPanel contentPane;
	DefaultListModel<User> unTaggedFriends = new DefaultListModel<User>();

	/**
	 * Launch the application.
	 */
	public static void TagUserScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					TagUser frame = new TagUser();
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
	public TagUser() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 233, 263);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel taggableLabel = new JLabel("Taggable Friends");
		taggableLabel.setBounds(10, 11, 171, 14);
		contentPane.add(taggableLabel);
		
		JList unTaggedJList = new JList();
		unTaggedJList.setBounds(10, 38, 207, 158);
		unTaggedJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		unTaggedJList.setModel(unTaggedFriends);
		contentPane.add(unTaggedJList);
		
		JButton btnNewButton = new JButton("Tag Friend");
		btnNewButton.setBounds(72, 205, 83, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
	}
}
