
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public abstract class Post
{
	//ATTRIBUTES
	private UUID postID;
	protected String textContent;
	private Date postOriginatedDate;
	public Location location;
	public ArrayList<User> taggedUsers;
		
	//ABSTRACT METHODS
	public abstract void showTaggedUsers();
	public abstract void showPostLocation();
	
	//CONSTRUCTOR
	public Post()
	{
		
	}
	public Post(String textContent, Double latitude, Double longitude, ArrayList taggedUsersList)
	{
		this.postID = UUID.randomUUID();
		this.textContent = textContent;
		this.postOriginatedDate = new Date();
		this.location = new Location(latitude, longitude);
		this.taggedUsers = taggedUsersList;
	}
	
	public Post(String textContent, Double latitude, Double longitude)
	{
		this.postID = UUID.randomUUID();
		this.textContent = textContent;
		this.postOriginatedDate = new Date();
		this.location = new Location(latitude, longitude);
		this.taggedUsers = new ArrayList<User>();
	}
}
