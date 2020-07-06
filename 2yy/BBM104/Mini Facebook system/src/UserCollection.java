import java.util.*;

public class UserCollection {
	
	static List<User> users = new ArrayList<User>();

	static User whoIsOnlineNow=null;
	
	/**
	 * empty constructor
	 */
	public UserCollection(){}
	
	/**
	 * checking he/she is a user? 
	 * @param userName checking person's username
	 * @return if this username is in system users list , return its ID
	 */
	public static String isUser(String userName){
		for(User x:UserCollection.users) if(x.getUserName().equals(userName)) return Integer.toString(UserCollection.users.indexOf(x));
		return "inf"; //He/She is not a user
	}

	
	/**
	 * add new user to system
	 * @param name new user's name
	 * @param nick new user's username
	 * @param pass new user's passwords
	 * @param birth new user's birthday
	 * @param school new user's school
	 * @return true
	 */
	public static boolean addUser(String name,String nick,String pass,Date birth,String school){
		User u=new User(name,nick,pass,birth,school);
		UserCollection.users.add(u);
		return true;
	}
	
	/**
	 * remove user
	 * @param id removing users's ID
	 * @return if this ID is in system return true
	 */
	public static boolean removeUser(int id){
		if(id<=UserCollection.users.size()) {UserCollection.users.remove(id-1); return true;}
		return false;
	}
	
	/**
	 * sign in system
	 * @param userName signing user's username
	 * @param pass user's password
	 * @return true or false :)
	 */
	public static boolean userSignin(String userName,String pass){
		String stemp=isUser(userName);
		if(stemp.equals("inf")){ System.out.println("No such user!"); return false;}
		else {
			int itemp=Integer.parseInt(stemp);
			return UserCollection.users.get(itemp-1).signin(itemp,pass);
		}
	}
	
	/**
	 * show all post
	 * @param userName username
	 */
	public static void showPosts(String userName){
		String temp=isUser(userName);
		if(temp.equals("inf")) System.out.print("No such user!");
		else {
			System.out.println("**************\n"+userName+"'s Posts\n**************");
			for(Post x: UserCollection.users.get(Integer.parseInt(temp)).getPosts()) System.out.println(x+"\n----------------------");
		}
	}
}
