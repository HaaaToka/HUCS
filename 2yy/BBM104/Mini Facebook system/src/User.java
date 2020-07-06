import java.util.*;

public class User {
	private static int counter=0;
	private String name,userName,password,graduatedSchool;
	private Date birthday,lastLogin;
	private int userID;
	private boolean isOnline=false;
	
	private List<User> friends = new ArrayList<User>();
	private List<User> blockedFriends = new ArrayList<User>();
	private List<User> blockedUsers = new ArrayList<User>();
	private List<Post> posts = new ArrayList<Post>();
	
	/**
	 * empty constructor
	 */
	public User(){}
	/**
	 * create new User object
	 * @param name user's name
	 * @param userName user's nick name
	 * @param passwd user's  password 
	 * @param birth user's birthday
	 * @param graduatedSchool which school did user go
	 */
	public User(String name,String userName,String passwd,Date birth,String graduatedSchool){
		this.userID=++counter;
		this.name=name;
		this.userName=userName;
		this.password=passwd;
		this.birthday=birth;
		this.graduatedSchool=graduatedSchool;
	}

	/**
	 * check online perso and one user who's username's userName
	 * @param userName checking person
	 * @return if one is in your friend list return his/her number
	 */
	public String isFriend(String userName){
		for(User x:this.friends) if(x.getUserName().equals(userName)) return Integer.toString(UserCollection.users.indexOf(x));
		return "inf"; //inf  they are not friend
	}

	/**
	 * checking his/her password is correct
	 * @param id user ID
	 * @param pass user Password
	 * @return if his/her password correct return true
	 */
	public static boolean correctPass(int id, String pass){
		if(UserCollection.users.get(id).getPassword().equals(pass)) return true;
		return false;
	}

	//after 16 line is getting object's property and change its properties methods
	public String getName(){return this.name;}  
	public void setName(String name){this.name=name;}
	public String getUserName(){return this.userName;}
	public void setUserName(String userName){this.userName=userName;}
	public String getPassword(){return this.password;}
	public void setPassword(String pass){this.password=pass;}
	public Date getBirthday(){return this.birthday;}
	public void setBirthday(Date birth){this.birthday=birth;}
	public String getGraduatedSchool(){return this.graduatedSchool;}
	public void setGraduatedSchool(String school){this.graduatedSchool=school;}
	public int getUserID(){return this.userID;}
	public boolean getOnline(){return this.isOnline;}
	public void setOnline(boolean inout){this.isOnline=inout; setLastLogin(new Date());}
	public Date getLastLogin(){return this.lastLogin;}
	public void setLastLogin(Date time){this.lastLogin=time;}
	public List<Post> getPosts(){return this.posts;}
	/**
	 * add post to user's post list
	 * @param x new post
	 */
	public void addPosttoPosts(Post x){this.posts.add(x);}
	/**
	 * remove post which is number index
	 * @param index removing post's index
	 */
	public void removePost(int index){this.posts.remove(index);}


	/**
	 * add friend
	 * @param userName added person's name
	 */
	public void addFriend(String userName){
		if(!isFriend(userName).equals("inf")) {System.out.println("This user is already in your friend list!");}
		else{
			String temp=UserCollection.isUser(userName);
			if(temp.equals("inf")) System.out.println("No such user!");
			else{this.friends.add(UserCollection.users.get(Integer.parseInt(temp))); System.out.println(userName+" has been successfully added to your friend list.");}
			//System.out.println(UserCollection.users.get(Integer.parseInt(temp)));
		}
	}

	/**
	 * remove your friend
	 * @param userName removing user which is userName 
	 */
	public void removeFriend(String userName){
		String temp = isFriend(userName);
		if(!temp.equals("inf")){ this.friends.remove(Integer.parseInt(temp)-1);System.out.println(userName+" has been successfully removed from your friend list.");}
		else System.out.println("No such friend!");
	}


	public boolean signin(int ID,String pass){
		if(UserCollection.whoIsOnlineNow==null){
			if (correctPass(ID, pass)) {
				System.out.println("You have succesfully signed in.");
				UserCollection.users.get(ID - 1).setOnline(true);
				UserCollection.whoIsOnlineNow=UserCollection.users.get(ID);
				return true;
			} else {
				System.out.println("Invalid username or password!Please try again.");
				return false;
			}}
		else return false;
	}
	/**
	 * sign out system
	 */
	public void signout(){UserCollection.whoIsOnlineNow=null;System.out.println("You have succesfully signed out.");}

	/**
	 * update your profile information
	 * @param name new Name
	 * @param birth new birthday
	 * @param school new school
	 */
	public void updateProfile(String name,String birth,String school){
		String[] birthday=birth.split("/");
		int year=Integer.parseInt(birthday[2]),month=Integer.parseInt(birthday[0]),day=Integer.parseInt(birthday[1]);
		this.setName(name);
		this.setBirthday(new Date(year,month,day));
		this.setGraduatedSchool(school);
		System.out.println("Your user profile has been successfully updated.");
	}

	/**
	 * change your password
	 * @param old your old password
	 * @param newp your new password
	 */
	public void chancePassword(String old,String newp){
		if(this.getPassword().equals(old)) this.setPassword(newp);
		else System.out.println("Password mismatch! Please, try again.");
	}

	/**
	 * block someone
	 * @param userName you block one who is username
	 */
	public void block(String userName){
		String temp=UserCollection.isUser(userName);
		if(temp.equals("inf")) System.out.println("No such user!");
		else{
			if(!isFriend(userName).equals("inf")){this.blockedFriends.add(UserCollection.users.get(Integer.parseInt(temp)));this.blockedUsers.add(UserCollection.users.get(Integer.parseInt(temp)));}
			else this.blockedUsers.add(UserCollection.users.get(Integer.parseInt(temp)-1));
			System.out.println(userName+" has been successfully blocked.");
		}
	}

	/**
	 * unblock friend
	 * @param userName you unblock one who is username
	 */
	public void unBlock(String userName){
		boolean flag=false;
		if(this.blockedUsers.size()!=0){
			for(User x:this.blockedUsers) if(x.getUserName().equals(userName)){ this.blockedUsers.remove(x); System.out.println(userName+" has been successfully unblocked."); flag=true; break;}
			for(User x:this.blockedFriends) if(x.getUserName().equals(userName)){ this.blockedFriends.remove(x); break;}
			if (!flag) System.out.println("No such user in your blocked users list!");
		}
		else System.out.println("No such user in your blocked users list!");
	}

	/**
	 * show your friends
	 */
	public void listFriends(){
		if(this.friends.size()!=0) for(User x:this.friends) System.out.println(x+"\n---------------------------");
		else System.out.println("You haven’t added any friends yet!");
	}

	/**
	 * show all users
	 */
	public void listUsers(){
		for(User x:UserCollection.users) System.out.println(x+"\n---------------------------");
	}

	/**
	 * show blocked friends
	 */
	public void showBlockedFriends(){
		if(this.blockedUsers.size()!=0){if(this.blockedFriends.size()!=0) for(User x:this.blockedFriends) System.out.println(x+"\n---------------------------"); else{System.out.println("You haven't added any friends yet!");}}
		else System.out.println("You haven't added any users yet!");

	}

	/**
	 * show your blocked person
	 */
	public void showBlockedUsers(){
		if(this.blockedUsers.size()!=0) for(User x:this.blockedUsers) System.out.println(x+"\n---------------------------");
		else System.out.println("You haven’t added any users yet!");
	}

	
	//After 3 methods is crate post
	
	/**
     * add new Text post
     * @param text text post's text
     * @param locate1 text post's location x
     * @param locate2 text post's location y
     * @param taggeds who are tagged your text post's
	 */
	public void addPostTEXT(String text,Double locate1,Double locate2,String[] taggeds){
		new TextPost(text,locate1,locate2,taggeds);
	}
	/**
	 * add new Video Post
     * @param text text post's text
     * @param locate1 text post's location x
     * @param locate2 text post's location y
     * @param taggeds who are tagged your text post's
     * @param filePath where is the your photo
	 * @param videoDuration videos duration time
	 */
	public void addPostVIDEO(String text,Double locate1,Double locate2,String[] taggeds,String filePath,String videoDuration){
		new VideoPost(text,locate1,locate2,taggeds,filePath,videoDuration);
	}
	/**
     * add new Image post
     * @param text text post's text
     * @param locate1 text post's location x
     * @param locate2 text post's location y
     * @param taggeds who are tagged your text post's
     * @param filePath where is the your photo
     * @param resolution photo's resolution
	 */
	public void addPostIMAGE(String text,Double locate1,Double locate2,String[] taggeds,String filePath,String resolution){
		new ImagePost(text,locate1,locate2,taggeds,filePath,resolution);
	}

	/**
	 * remove last post
	 */
	public void removeLastPost(){
		if(this.posts.size()==0) System.out.println("Error: You don't have any posts.");
		else{
			this.posts.remove(this.posts.size()-1);
			System.out.println("Your last post has been successfully removed.");
		}
	}

	@Override
	public String toString(){
		return "Name: "+this.getName()+"\nUsername: "+this.getUserName()+"\nDate of Birth: "+this.getBirthday().getDate()+"/"+this.getBirthday().getMonth()+"/"+this.getBirthday().getYear()+
				"\nSchool: "+this.getGraduatedSchool();
	}
}
