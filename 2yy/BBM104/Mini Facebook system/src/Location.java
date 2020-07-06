import java.util.*;

public class Location {

    private Double x,y;

    /**
     * empty constructor
     */
    public Location(){}

    /**
     * @param x your post's location's x
     * @param y your post's location's y
     */
    public Location(Double x,Double y){
        this.x=x;
        this.y=y;
    }

    /**
     * learn your post's location's x
     * @return location's x
     */
    public Double getX(){return this.x;}
    /**
     * change your post's location's x
     * @param x new location's x
     */
    public void setX(Double x){this.x=x;}
    /**
     * learn your post's location's y
     * @return location's y
     */
    public Double getY(){return this.y;}
    /**
     * change your post's location's y
     * @param y new location's y
     */
    public void setY(Double y){this.y=y;}

    @Override
    public String toString(){
        return String.format("%.02f, %.02f",x,y);
    }
}
