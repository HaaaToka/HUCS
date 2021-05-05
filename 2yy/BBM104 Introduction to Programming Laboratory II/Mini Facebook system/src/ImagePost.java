import java.util.*;

public class ImagePost extends TextPost {

    private String filePath,resolution;

    /**
     * empty constructor
     */
    public ImagePost(){}

    /**
     * create new Image Post
     * @param text post's text
     * @param locate1 Location's X
     * @param locate2 Location's Y
     * @param taggeds who are tagged your photo
     * @param filePath where is the your photo
     * @param resolution photo's resolution
     */
    public ImagePost(String text,Double locate1,Double locate2,String[] taggeds,String filePath,String resolution){
        super(text,locate1,locate2,taggeds);
        this.filePath=filePath;
        this.resolution=resolution;
    }

    @Override
    public String toString(){
        return this.text+"\nDate: "+this.postDate+
                "\nLocation: "+this.location+"\nImage: "+this.filePath+
                "\nImage resolution: "+this.resolution+"\nFriends tagged in this post: "+this.ttt;
    }
}
