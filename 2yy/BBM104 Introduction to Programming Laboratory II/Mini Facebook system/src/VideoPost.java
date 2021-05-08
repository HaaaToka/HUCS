import java.util.*;

public class VideoPost extends TextPost{
    private String filePath,videoDuration;

    /**
     * empty constructor
     */
    public VideoPost(){}

    /**
	 * create new Video Post
     * @param text text post's text
     * @param locate1 text post's location x
     * @param locate2 text post's location y
     * @param taggeds who are tagged your text post's
     * @param filePath where is the your photo
	 * @param videoDuration videos duration time
     */
    public VideoPost(String text,Double locate1,Double locate2,String[] taggeds,String filePath,String videoDuration){
        super(text,locate1,locate2,taggeds);
        this.filePath=filePath;
        this.videoDuration=videoDuration;
    }

    @Override
    public String toString(){
        return this.text+"\nDate: "+this.postDate+
                "\nLocation: "+this.location+"\nVideo: "+this.filePath+
                "\nVideo duration: "+this.videoDuration+"\nFriends tagged in this post: "+this.ttt;
    }
}
