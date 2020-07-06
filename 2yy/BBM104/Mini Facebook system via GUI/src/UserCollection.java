import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class UserCollection
{
	static HashMap<String, User> users = new HashMap<String, User>();
	public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	public static User whoLoggedIn;
	
	//ADD USER
	public static void addUser(String nameSurname, String username, String password, Date dateOfBirth, String schoolGraduated, String relationship)
	{
		User user = new User(nameSurname, username, password, dateOfBirth, schoolGraduated, relationship);
		users.put(username, user);
		Main.userList.addElement(user);
	}
	
	//CREATE USER
	public static void createUser(String nameSurname, String username, String password, String passwordreType, String dateOfBirth, String schoolGraduated, String relationship) throws ParseException
	{
		if (nameSurname.equals("") || username.equals("") || password.equals("") || dateOfBirth.equals("") || schoolGraduated.equals("") || relationship.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please fill the missing fields!", null, JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			if (password.equals(passwordreType))
			{
				if (users.containsKey(username))
				{
					JOptionPane.showMessageDialog(null, "The username " + username + " is being used. Please change it.", null, JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					User user = new User(nameSurname, username, password, formatter.parse(dateOfBirth), schoolGraduated, relationship);
					users.put(username, user);
					Main.userList.addElement(user);
					JOptionPane.showMessageDialog(null, "You have successfully created new user!");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Your password does not match re-type password!", null, JOptionPane.WARNING_MESSAGE);
			}
		}
	}
		
	//REMOVE USER
	public static void removeUser(User user)
	{
		try
		{
			users.remove(user);
			JOptionPane.showMessageDialog(null, "User succesfully removed!");
			Main.userList.removeElement(user);
		}
		catch (NullPointerException noSelectedUser)
		{
			JOptionPane.showMessageDialog(null, "You have not selected a user!", null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//LOGIN
	public static void login(String username, String password)
	{
		try
		{
			if ((users.get(username).getUsername()).equals(username) && (users.get(username).getPassword()).equals(password))
			{
				users.get(username).login();
				whoLoggedIn = users.get(username);
				JOptionPane.showMessageDialog(null, "You have successfully logged in!");
			}
			else
				JOptionPane.showMessageDialog(null, "Invalid username or password!", null, JOptionPane.WARNING_MESSAGE);
		}
		catch (NullPointerException noSuchUser)
		{
			JOptionPane.showMessageDialog(null, "No Such User!", null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//LOGOUT
	public static void logout(User whoLoggedIn)
	{
		whoLoggedIn.logout();
		whoLoggedIn = null;
	}
	
}
