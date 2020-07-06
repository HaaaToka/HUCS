import java.util.*;

public class TextPost extends Post{

    /**
     * empty constructor
     */
    public TextPost(){}

    /**
     * create new Text post
     * @param text text post's text
     * @param locate1 text post's location x
     * @param locate2 text post's location y
     * @param taggeds who are tagged your text post's
     */
    public TextPost(String text,Double locate1,Double locate2,String[] taggeds){
        super(text,locate1,locate2,taggeds);
    }

    /* (non-Javadoc)
     * @see Post#showTaggedUsers()
     */
    public  void showTaggedUsers(){
        for(User x:this.taggedFriends) System.out.println(x);
    }
    /* (non-Javadoc)
     * @see Post#showPostLocation()
     */
    public void showPostLocation(){
        System.out.println(this.location);
    }

    @Override
    public String toString(){
        return this.text+"\nDate: "+this.postDate+
                "\nLocation: "+this.location+"\nFriends tagged in this post: "+this.ttt;
    }
}
