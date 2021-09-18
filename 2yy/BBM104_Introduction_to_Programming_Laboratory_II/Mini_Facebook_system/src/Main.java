import java.io.*;
import java.util.*;

/**
 * @author Okan ALAN
 *
 */
public class Main {
	public static void main(String[] args){

		try {
			Scanner scan;
			//scan = new Scanner(new File("users.txt")); //reading users.txt
			scan = new Scanner(new File(args[0]));
			while(scan.hasNextLine()){
				String[] words=scan.nextLine().split("\t"); //split line by tab
				String[] birth=words[3].split("/");
				int year=Integer.parseInt(birth[2]),month=Integer.parseInt(birth[0]),day=Integer.parseInt(birth[1]); //for user's birthday
				UserCollection.addUser(words[0],words[1],words[2],new Date(year,month,day),words[4]);
			}
			//scan = new Scanner(new File("commands.txt")); //reading commands.txt
			scan = new Scanner(new File(args[1]));
			while (scan.hasNextLine()){
				System.out.println("-----------------------");
				String line = scan.nextLine();
				String[] words=line.split("\t");
				System.out.println("Command: "+line);
				switch (words[0]){ //look command and do its mission
					case "ADDUSER":
						String[] birth=words[4].split("/");
						int year=Integer.parseInt(birth[2]),month=Integer.parseInt(birth[0]),day=Integer.parseInt(birth[1]);
						UserCollection.addUser(words[1],words[2],words[3],new Date(year,month,day),words[5]);
						System.out.println(words[1]+" has been successfully added.");break;
					case "REMOVEUSER":
						if(UserCollection.removeUser(Integer.parseInt(words[1]))) System.out.println("User has been successfully removed.");
						else System.out.println("No susch user!"); break;
					case "SHOWPOSTS":
						UserCollection.showPosts(words[1]);break;
					case "SIGNIN":
						UserCollection.userSignin(words[1],words[2]);break;
					case "SIGNOUT":
						UserCollection.whoIsOnlineNow.signout();break;
					case "UPDATEPROFILE":
						if(UserCollection.whoIsOnlineNow==null) System.out.println("Error: Please sign in and try again.");
						else UserCollection.whoIsOnlineNow.updateProfile(words[1],words[2],words[3]);break;
					case "CHPASS":
						if(UserCollection.whoIsOnlineNow==null) System.out.println("Error: Please sign in and try again.");
						else UserCollection.whoIsOnlineNow.chancePassword(words[1],words[2]);break;
					case "ADDFRIEND":
						if(UserCollection.whoIsOnlineNow==null) System.out.println("Error: Please sign in and try again.");
						else UserCollection.whoIsOnlineNow.addFriend(words[1]);break;
					case "REMOVEFRIEND":
						if(UserCollection.whoIsOnlineNow==null) System.out.println("Error: Please sign in and try again.");
						else UserCollection.whoIsOnlineNow.removeFriend(words[1]);break;
					case "ADDPOST-TEXT":
						if(UserCollection.whoIsOnlineNow==null) System.out.println("Error: Please sign in and try again.");
						else UserCollection.whoIsOnlineNow.addPostTEXT(words[1],Double.parseDouble(words[2]),Double.parseDouble(words[3]),words[4].split(":"));break;
					case "ADDPOST-IMAGE":
						if(UserCollection.whoIsOnlineNow==null) System.out.println("Error: Please sign in and try again.");
						else UserCollection.whoIsOnlineNow.addPostIMAGE(words[1],Double.parseDouble(words[2]),Double.parseDouble(words[3]),words[4].split(":"),words[5],words[6]);break;
					case "ADDPOST-VIDEO":
						if(UserCollection.whoIsOnlineNow==null) System.out.println("Error: Please sign in and try again.");
						else UserCollection.whoIsOnlineNow.addPostVIDEO(words[1],Double.parseDouble(words[2]),Double.parseDouble(words[3]),words[4].split(":"),words[5],words[6]);break;
					case "REMOVELASTPOST":
						if(UserCollection.whoIsOnlineNow==null) System.out.println("Error: Please sign in and try again.");
						else UserCollection.whoIsOnlineNow.removeLastPost();break;
					case "BLOCK":
						if(UserCollection.whoIsOnlineNow==null) System.out.println("Error: Please sign in and try again.");
						else UserCollection.whoIsOnlineNow.block(words[1]);break;
					case "UNBLOCK":
						if(UserCollection.whoIsOnlineNow==null) System.out.println("Error: Please sign in and try again.");
						else UserCollection.whoIsOnlineNow.unBlock(words[1]);break;
					case "LISTFRIENDS":
						if(UserCollection.whoIsOnlineNow==null) System.out.println("Error: Please sign in and try again.");
						else UserCollection.whoIsOnlineNow.listFriends();break;
					case "LISTUSERS":
						if(UserCollection.whoIsOnlineNow==null) System.out.println("Error: Please sign in and try again.");
						else UserCollection.whoIsOnlineNow.listUsers();break;
					case "SHOWBLOCKEDFRIENDS":
						if(UserCollection.whoIsOnlineNow==null) System.out.println("Error: Please sign in and try again.");
						else UserCollection.whoIsOnlineNow.showBlockedFriends();break;
					case "SHOWBLOCKEDUSERS":
						if(UserCollection.whoIsOnlineNow==null) System.out.println("Error: Please sign in and try again.");
						else UserCollection.whoIsOnlineNow.showBlockedUsers();break;
				}
			}
			scan.close();
		}
		catch (FileNotFoundException ex) {
		System.err.println("No File Found!");
		return;
	}
	}
}
