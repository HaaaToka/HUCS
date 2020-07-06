import java.util.ArrayList;

public class ImagePost extends TextPost
{
	private String imageFilename;
	int[] resolution;
	
	//CONSTRUCTOR
	public ImagePost(String textContent, Double latitude, Double longitude, String imageFilename, int width, int height, ArrayList<User> taggedUsersList)
	{
		super(textContent, latitude, longitude, taggedUsersList);
		this.imageFilename = imageFilename;
		resolution = new int[2];
		resolution[0] = width;
		resolution[1] = height;
	}
	
	public ImagePost(String textContent, Double latitude, Double longitude, String imageFilename, int width, int height)
	{
		super(textContent, latitude, longitude);
		this.imageFilename = imageFilename;
		resolution = new int[2];
		resolution[0] = width;
		resolution[1] = height;
	}
}
