
import java.util.*;
import java.io.*;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Assignment2 
 * @author OKAN ALAN
 * @since 10.04.2017 \n
 * HUPROG'17  \n
 * at 2 days I have done this. When you see switch-case,they are stupid code blocks.
 * I don't have enough time.I did first come to my mind.IfI have more time,I can make better.
 */

public class Main {

	public static void main(String[] args){
		
		Admin ad=new Admin();
		Employee ee=new Employee();
		Technician tt=new Technician();
		Customer cu=new Customer();
		
		/**
		 * In here,reading users.txt
		 * I reads line by line and split it.After that, I create users
		 */		
        try {
            Scanner scanner = new Scanner(new File(args[0]));//take input from file which is input.txt java HelloJava Input.txt
            while(scanner.hasNextLine()){ //when we don't know how many input
            	Calendar takvim ; //for long date format like Sun Mar 21 00:00:00 EET 1993
            	Date birthDD; // for date
                String word = scanner.next();   //first word of line
            	String name = scanner.next(),mail=scanner.next(),dg=scanner.next();
            	String[] dogum = dg.split("\\.");//birthDay String
            	int day=Integer.parseInt(dogum[0]),month=Integer.parseInt(dogum[1]),year=Integer.parseInt(dogum[2]);
            	takvim =new GregorianCalendar(year,month,day);
            	birthDD = takvim.getTime();
            	
                if(word.equals("ADMIN")){ 
                	int salary=scanner.nextInt();
                	String pw=scanner.next();
                	new Admin(name,mail,birthDD,salary,pw);              	
                }
                if(word.equals("CUSTOMER")){
                	double initBal=Double.parseDouble(scanner.next());
                	String pw=scanner.next();
                	new Customer(name,mail,birthDD,initBal,pw);
                }
                if(word.equals("TECH")){
                	int salary = scanner.nextInt(),isSenior=scanner.nextInt();
                	new Technician(name,mail,birthDD,salary,isSenior);
                }
            }
            
            /**
             * in here,reading item.txt
             * I reads line by line and split it.After that, I create items.
             */
            
            scanner = new Scanner(new File(args[1]));
            while(scanner.hasNextLine()){
            	String line =scanner.nextLine();
            	String[] words = line.split("\t");
            	if(words[0].equals("BOOK")){
            		new Book(Double.parseDouble(words[1]),"BOOK",Integer.parseInt(words[2]),words[3],words[4],words[5],Integer.parseInt(words[6]));
            	}
            	if(words[0].equals("CDDVD")){
            		new Cddvd(Double.parseDouble(words[1]),"CDDVD",Integer.parseInt(words[2]),words[3],words[4],words[5]);
            	}
            	if(words[0].equals("DESKTOP")){
            		new Desktop(Double.parseDouble(words[1]),"DESKTOP",words[2],words[3],Integer.parseInt(words[4]),Integer.parseInt(words[5]),words[6],words[7],words[8],words[9],words[10]);
            	}
            	if(words[0].equals("LAPTOP")){
            		new Laptop(Double.parseDouble(words[1]),"LAPTOP",words[2],words[3],Integer.parseInt(words[4]),Integer.parseInt(words[5]),words[6],words[7],words[8],words[9],Integer.parseInt(words[10]));
            	}
            	if(words[0].equals("TABLET")){
            		new Tablet(Double.parseDouble(words[1]),"TABLET",words[2],words[3],Integer.parseInt(words[4]),Integer.parseInt(words[5]),words[6],words[7],words[8],words[9],Integer.parseInt(words[10]));
            	}
            	if(words[0].equals("TV")){
            		new TV(Double.parseDouble(words[1]),"TV",words[2],words[3],Integer.parseInt(words[4]),Integer.parseInt(words[5]),words[6]);
            	} 
            	if(words[0].equals("SMARTPHONE")){
            		new SmartPhone(Double.parseDouble(words[1]),"SMARTPHONE",words[2],words[3],Integer.parseInt(words[4]),Integer.parseInt(words[5]),words[6]);
            	}
            	if(words[0].equals("HAIRCARE")){
            		new HairCare(Double.parseDouble(words[1]),"HAIRCARE",words[2],words[3],Integer.parseInt(words[4]),words[5],Integer.parseInt(words[6]),Integer.parseInt(words[7]));
            	}
            	if(words[0].equals("PERFUME")){
            		 new Perfume(Double.parseDouble(words[1]),"PERFUME",words[2],words[3],Integer.parseInt(words[6]),words[5],Integer.parseInt(words[4]),Integer.parseInt(words[7]));
            	}
            	if(words[0].equals("SKINCARE")){
            		new SkinCare(Double.parseDouble(words[1]),"SKINCARE",words[2],words[3],Integer.parseInt(words[4]),words[5],Integer.parseInt(words[6]),Integer.parseInt(words[7]));
            	}
            }
            
            /**
             * in here,reading commands.txt
             * I reads line by line and split it.After that, I create users with above object.
             * I look first word in line and according to that I do that word's mission.
             */
            
            scanner=new Scanner(new File(args[2]));
            while(scanner.hasNextLine()){
            	String line =scanner.nextLine();
            	String[] words = line.split("\t");
            	if(words[0].equals("ADDADMIN")){
            		System.out.println("COMMAND TEXT: <"+words[0]+"\t"+words[1]+"\t"+words[2]+"\t"+words[3]+"\t"+words[4]+"\t"+words[5]+"\t"+words[6]+">\n");
            		Calendar takvim;
            		Date birthDD;
            		String[] dg= words[4].split("\\.");
                	int day=Integer.parseInt(dg[0]),month=Integer.parseInt(dg[1]),year=Integer.parseInt(dg[2]);
                	takvim =new GregorianCalendar(year,month,day);
                	birthDD = takvim.getTime();
            		ad.addAdmin(words[1], words[2], words[3], birthDD, Integer.parseInt(words[5]), words[6]);
            		System.out.println("");
            	}
            	if(words[0].equals("ADDTECH")){
            		System.out.println("COMMAND TEXT: <"+words[0]+"\t"+words[1]+"\t"+words[2]+"\t"+words[3]+"\t"+words[4]+"\t"+words[5]+"\t"+words[6]+">|n");
            		Calendar takvim;
            		Date birthDD;
            		String[] dg= words[4].split("\\.");
                	int day=Integer.parseInt(dg[0]),month=Integer.parseInt(dg[1]),year=Integer.parseInt(dg[2]);
                	takvim =new GregorianCalendar(year,month,day);
                	birthDD = takvim.getTime();
            		ad.addTechnician(words[1], words[2], words[3], birthDD, Integer.parseInt(words[5]), Integer.parseInt(words[6]));
            		System.out.println("");
            	}
            	if(words[0].equals("ADDCUSTOMER")){
            		System.out.println("COMMAND TEXT: <"+words[0]+"\t"+words[1]+"\t"+words[2]+"\t"+words[3]+"\t"+words[4]+"\t"+words[5]+"\t"+words[6]+">\n");
            		Calendar takvim;
            		Date birthDD;
            		String[] dg= words[4].split("\\.");
                	int day=Integer.parseInt(dg[0]),month=Integer.parseInt(dg[1]),year=Integer.parseInt(dg[2]);
                	takvim =new GregorianCalendar(year,month,day);
                	birthDD = takvim.getTime();
            		ad.addCustomer(words[1], words[2],words[3], birthDD, Double.parseDouble(words[5]), words[6]);
            		System.out.println("");
            	}
            	if(words[0].equals("SHOWCUSTOMER")){
            		System.out.println("COMMAND TEXT: <"+words[0]+"\t"+words[1]+"\t"+words[2]+">\n");
            		ad.showCustomer(words[1], Integer.parseInt((words[2])));
            		System.out.println("");
            	}
            	if(words[0].equals("SHOWCUSTOMERS")){
            		System.out.println("COMMAND TEXT: <"+words[0]+"\t"+words[1]+">\n");
            		ad.showCustomers(words[1]);
            		System.out.println("");
            	}       	
            	if(words[0].equals("ADDTOCART")){
            		System.out.println("COMMAND TEXT: <"+words[0]+"\t"+words[1]+"\t"+words[2]+">\n");
            		cu.addCart(Integer.parseInt(words[1]),Integer.parseInt(words[2]));
            		System.out.println("");
            	}
            	
            	if(words[0].equals("ORDER")){
            		System.out.println("COMMAND TEXT: <"+words[0]+"\t"+words[1]+"\t"+words[2]+">\n");
            		cu.order(Integer.parseInt(words[1]), words[2]);
            		System.out.println("");
            	}
            	
            	if(words[0].equals("SHOWADMININFO")){
            		System.out.println("COMMAND TEXT: <"+words[0]+"\t"+words[1]+">\n");
            		ad.showAdminInfo(words[1]);
            		System.out.println("");
            	}
            	if(words[0].equals("CREATECAMPAIGN")){
            		System.out.println("COMMAND TEXT: <"+words[0]+"\t"+words[1]+"\t"+words[2]+"\t"+words[3]+"\t"+words[4]+"\t"+words[5]+">\n");
            		ad.createCampaigne(words[1], words[2], words[3], words[4], Integer.parseInt(words[5]));
            		System.out.println("");
            	}
            	if(words[0].equals("SHOWCAMPAIGNS")){
            		System.out.println("COMMAND TEXT: <"+words[0]+"\t"+words[1]+">\n");
            		cu.showCampaings(Integer.parseInt(words[1]));
            		System.out.println("");
            	}          	
            	if(words[0].equals("DEPOSITMONEY")){
            		System.out.println("COMMAND TEXT: <"+words[0]+"\t"+words[1]+"\t"+words[2]+">\n");
            		cu.deposityMoney(Integer.parseInt(words[1]), Double.parseDouble(words[2]));
            		System.out.println("");
            	}            	
            	if(words[0].equals("CHPASS")){
            		System.out.println("COMMAND TEXT: <"+words[0]+"\t"+words[1]+"\t"+words[2]+"\t"+words[3]+">\n");
            		cu.changePassWd(Integer.parseInt(words[1]), words[2], words[3]);
            		System.out.println("");
            	}            	
            	if(words[0].equals("EMPTYCART")){
            		System.out.println("COMMAND TEXT: <"+words[0]+"\t"+words[1]+">\n");
            		cu.emptycart(Integer.parseInt(words[1]));
            		System.out.println("");
            	}
            	if(words[0].equals("SHOWORDERS")){
            		System.out.println("COMMAND TEXT: <"+words[0]+"\t"+words[1]+">\n");
            		System.out.println("Order History:");
            		tt.showOrdes(words[1]);
            		System.out.println("");
            	}         	
            	if(words[0].equals("SHOWITEMSLOWONSTOCK")){
            		if(words.length==2) {System.out.println("COMMAND TEXT: <"+words[0]+"\t"+words[1]+">\n");ee.showItemsLowonStock(words[1]);}
            		else {System.out.println("COMMAND TEXT: <"+words[0]+"\t"+words[1]+"\t"+words[2]+">\n");ee.showItemsLowonStock(words[1], Integer.parseInt(words[2]));}
            		System.out.println("");
            	}
            	if(words[0].equals("SHOWVIP")){
            		System.out.println("COMMAND TEXT: <"+words[0]+"\t"+words[1]+">\n");
            		ee.showVIP(words[1]);
            		System.out.println("");
            	}
            	if(words[0].equals("ADDITEM")){
            		System.out.println("COMMAND TEXT: <"+words[0]+"\t"+words[1]+"\t"+words[2]+">\n");
            		tt.addItem(words[1], words[2].split(":"));
            		System.out.println("");
            	}
            	if(words[0].equals("LISTITEM")){
            		System.out.println("COMMAND TEXT: <"+words[0]+"\t"+words[1]+">\n");
            		ee.listItems(words[1]);
            		System.out.println("");
            	}
            	if(words[0].equals("DISPITEMSOF")){
            		System.out.println("COMMAND TEXT: <"+words[0]+"\t"+words[1]+"\t"+words[2]+">\n");
            		tt.dispitemsof(words[1], words[2].split(":"));
            		System.out.println("");
            	}
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            System.err.println("No File Found!");
            return;
        }

	}
}
