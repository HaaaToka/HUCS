//F*CK this system that my post for this country
import java.util.*;

public abstract class Post implements PostInterface {
	
	protected List<User> taggedFriends=new ArrayList<User>();
	protected String text,ttt="";
	protected Date postDate;
	protected Location location;
	protected UUID uniqePostID;

	
	/**
	 * empty constructor
	 */
	public Post(){}

	/**
	 * create new Post
     * @param text post's text
     * @param locate1 Location's X
     * @param locate2 Location's Y
     * @param taggeds who are tagged your post
	 */
	public Post(String text,Double locate1,Double locate2,String[] taggeds){
		this.uniqePostID=UUID.randomUUID(); //generate random uniqePost ID from UUID 
		this.text=text;
		this.postDate=new Date();
		this.location=new Location(locate1,locate2);
		//check tagged persons who are his/her friends
		for(String x:taggeds){if(UserCollection.whoIsOnlineNow.isFriend(x).equals("inf")){ System.out.println("Username "+x+" is not your friend, and will not be tagged!");} else this.ttt=this.ttt+","+x;}
		System.out.println("The post has been successfully added.");
		UserCollection.whoIsOnlineNow.addPosttoPosts(this); //online person add his/her posts

	}
	
	/* (non-Javadoc)
	 * @see PostInterface#setText(java.lang.String)
	 */
	public void setText(String text){this.text=text;}
	/* (non-Javadoc)
	 * @see PostInterface#getText()
	 */
	public String getText(){return this.text;}
	/* (non-Javadoc)
	 * @see PostInterface#getID()
	 */
	public UUID getID(){return this.uniqePostID;}
	/* (non-Javadoc)
	 * @see PostInterface#getDate()
	 */
	public Date getDate(){return this.postDate;}

	/**
	 * abstract method
	 * show who are tagged post's
	 */
	public abstract void showTaggedUsers();
	/**
	 * abstract method
	 * show post's location
	 */
	public abstract void showPostLocation();

}
