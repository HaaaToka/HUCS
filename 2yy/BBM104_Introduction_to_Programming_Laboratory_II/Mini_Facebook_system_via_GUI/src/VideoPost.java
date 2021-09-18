import java.util.ArrayList;

public class VideoPost extends TextPost
{
	private String videoFilename;
	private int videoDuration;
	final static int MAX_VIDEO_LENGTH = 10;
	
	public VideoPost(String textContent, Double latitude, Double longitude, String videoFilename, int videoDuration, ArrayList<User> taggedUsersList)
	{
		super(textContent, latitude, longitude, taggedUsersList);
		this.videoFilename = videoFilename;
		this.videoDuration = videoDuration;
	}
	
	public VideoPost(String textContent, Double latitude, Double longitude, String videoFilename, int videoDuration)
	{
		super(textContent, latitude, longitude);
		this.videoFilename = videoFilename;
		this.videoDuration = videoDuration;
	}
}
