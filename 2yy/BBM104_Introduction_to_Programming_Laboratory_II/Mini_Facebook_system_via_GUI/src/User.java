import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class User
{
	private String nameSurname;
	private String username;
	private String password;
	private Date dateOfBirth;
	private String schoolGraduated;
	private String relationship;
	private Date lastLoginDate;
	public boolean loginStatus;
	protected ArrayList<User> friends;
	public static DefaultListModel<User> friendsList = new DefaultListModel<User>();
	protected ArrayList<User> blockedUsers;
	protected ArrayList<Post> posts;
	
	//CONSTRUCTOR OF USER
	public User(String nameSurname, String username, String password, Date dateOfBirth, String schoolGraduated, String relationship)
	{
		this.nameSurname = nameSurname;
		this.username = username;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.schoolGraduated = schoolGraduated;
		this.relationship = relationship;
		friends = new ArrayList<User>();
		blockedUsers = new ArrayList<User>();
		posts = new ArrayList<Post>();
	}
	
	//TO STRING OF USER
	public String toString()
	{
		return username;
	}
	
	//GETTERS AND SETTERS
	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}
	
	public String getNameSurname() {
		return nameSurname;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public String getRelationship() {
		return relationship;
	}
	
	public String getSchoolGraduated() {
		return schoolGraduated;
	}
	
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	
	public void setSchoolGraduated(String schoolGraduated) {
		this.schoolGraduated = schoolGraduated;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public void setNameSurname(String nameSurname) {
		this.nameSurname = nameSurname;
	}
	//LOGIN
	public void login()
	{
		loginStatus = true;
	}
	
	//LOGOUT
	public void logout()
	{
		loginStatus = false;
		lastLoginDate = new Date();
	}
	
	//UPDATE PROFILE
	public void updateProfile()

	{
		this.nameSurname = nameSurname;
		this.schoolGraduated = schoolGraduated;
		this.dateOfBirth = dateOfBirth;
		this.relationship = relationship;
	}
	
	//ADD FRIEND
	public void addFriend(String username, String friendUsername)
	{
		if (!friends.contains(UserCollection.users.get(friendUsername)))
		{
			UserCollection.users.get(username).friends.add(UserCollection.users.get(friendUsername));
			UserCollection.users.get(friendUsername).friends.add(UserCollection.users.get(username));
		}		
	}

	
	//BLOCK FRIEND
	public void blockFriend(String username, String friendUsername)
	{
		try
		{
			UserCollection.users.get(username).blockedUsers.add(UserCollection.users.get(friendUsername));
			UserCollection.users.get(friendUsername).blockedUsers.add(UserCollection.users.get(username));
			UserCollection.users.get(username).friends.remove(UserCollection.users.get(friendUsername));
			UserCollection.users.get(friendUsername).friends.remove(UserCollection.users.get(username));
		}
		catch (NullPointerException noFriend)
		{
			
		}
	}
	
	//UNBLOCK FRIEND
		public void unblockFriend(User user)
		{
			try
			{
				UserCollection.users.get(username).blockedUsers.remove(user);
				UserCollection.users.get(user.getUsername()).blockedUsers.remove(UserCollection.whoLoggedIn);
			}
			catch (NullPointerException noFriend)
			{
				
			}
		}
	
	//REMOVE FRIEND
	public void removeFriend(User user)
	{
		try 
		{
			friends.remove(user);
			user.friends.remove(UserCollection.whoLoggedIn);
		}
		catch (NullPointerException noFriend)
		{
			
		}
	}
	
	//ADDPOST-TEXT
	public void addTextPost(String textContent, Double longitude, Double latitude, String taggedUsersStr)
	{
		String[] taggedUsersArray = taggedUsersStr.split(":");
		ArrayList<User> taggedUsersList = new ArrayList<User>();
		for (int i=0; i<taggedUsersArray.length; i++)
		{
			taggedUsersList.add(UserCollection.users.get(taggedUsersArray[i]));
		}
		TextPost textPost = new TextPost(textContent, longitude, latitude, taggedUsersList);
		posts.add(textPost);
	}
	
	//ADDPOST-IMAGE
	public void addImagePost(String textContent, Double latitude, Double longitude, String imageFilename, String resolution, String taggedUsersStr)
	{
		String[] resolutionArray = resolution.split("<x>");
		String[] taggedUsersArray = taggedUsersStr.split(":");
		ArrayList<User> taggedUsersList = new ArrayList<User>();
		for (int i=0; i<taggedUsersArray.length; i++)
		{
			taggedUsersList.add(UserCollection.users.get(taggedUsersArray[i]));
		}
		
		ImagePost imagePost = new ImagePost(textContent, longitude, latitude, imageFilename, Integer.parseInt(resolutionArray[0]), Integer.parseInt(resolutionArray[1]), taggedUsersList);
		posts.add(imagePost);
	}
	
	//ADDPOST-VIDEO
	public void addVideoPost(String textContent, Double latitude, Double longitude, String videoFilename, int videoDuration, String taggedUsersStr)
	{
		String[] taggedUsersArray = taggedUsersStr.split(":");
		ArrayList<User> taggedUsersList = new ArrayList<User>();
		for (int i=0; i<taggedUsersArray.length; i++)
		{
			taggedUsersList.add(UserCollection.users.get(taggedUsersArray[i]));
		}
		VideoPost videoPost = new VideoPost(textContent, longitude, latitude, videoFilename, videoDuration, taggedUsersList);
		posts.add(videoPost);
	}
	
	
	
	//CREATEPOST-TEXT
		public void createTextPost(String textContent, Double longitude, Double latitude)
		{
			TextPost textPost = new TextPost(textContent, longitude, latitude);
			posts.add(textPost);
		}
		
		//CREATEPOST-IMAGE
		public void createImagePost(String textContent, Double latitude, Double longitude, String imageFilename, String resolution)
		{
			String[] resolutionArray = resolution.split("<x>");
			ImagePost imagePost = new ImagePost(textContent, longitude, latitude, imageFilename, Integer.parseInt(resolutionArray[0]), Integer.parseInt(resolutionArray[1]));
			posts.add(imagePost);
		}
		
		//CREATEPOST-VIDEO
		public void createVideoPost(String textContent, Double latitude, Double longitude, String videoFilename, int videoDuration)
		{
			VideoPost videoPost = new VideoPost(textContent, longitude, latitude, videoFilename, videoDuration);
			posts.add(videoPost);
		}
}
