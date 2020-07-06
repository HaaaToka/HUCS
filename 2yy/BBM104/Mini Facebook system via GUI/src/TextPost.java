
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TextPost extends Post
{
	public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public void showTaggedUsers()
	{
		//SHOW TAGGED USERS IMPLEMENTS
	}


	public void showPostLocation() 
	{
		//SHOW POST LOCATION IMPLEMENTS
	}
	
	public TextPost(String textContent, Double latitude, Double longitude, ArrayList<User> taggedUsersList)
	{
		super(textContent, latitude, longitude, taggedUsersList);
	}
	
	public TextPost(String textContent, Double latitude, Double longitude)
	{
		super(textContent, latitude, longitude);
	}
}
