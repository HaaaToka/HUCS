import java.util.*;

public interface PostInterface {
	//in interface, every methods are abstract method that's why we don't write "abstract void..."
	
	/**
	 * change post's text 
	 * @param text new post's text
	 */
	public void setText(String text);
	/**
	 * learn  post's text
	 * @return post's text
	 */
	public String getText();
	/**
	 * learn post's ID
	 * @return post's ID
	 */
	public UUID getID();
	/**
	 * learn when you share post
	 * @return post's Date
	 */
	public Date getDate();
}
