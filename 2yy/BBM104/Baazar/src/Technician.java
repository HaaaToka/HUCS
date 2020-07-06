
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Technician extends Employee {
	
	static List<Technician> technicians = new ArrayList<Technician>();
	private int isSenior;
	Order o=new Order();
	
	/**
	 * empty constructor
	 */
	public Technician(){}
	
	/**
	 * @param name technician's name
	 * @param mail technician's mail
	 * @param birthDay technician's birthday
	 * @param salar technician's salary
	 * @param whoisSenior technician's is senior?
	 */
	public Technician(String name, String mail, Date birthDay,int salar,int whoisSenior) {
		super(name, mail, birthDay,salar);
		this.isSenior=whoisSenior;
		Technician.technicians.add(this);
	}
	/**
	 * @param techName technician's name
	 * @return is technician?
	 */
	public boolean isTechman(String techName){
		for(Technician x : Technician.technicians) if(x.getName().equals(techName)) return true;
		return false;
		}
	/**
	 * @param techName technician's name
	 * @return is Senior or not?
	 * to be or not to be! -shakespeare :)
	 */
	public boolean isSenior(String techName){
		for(Technician x : Technician.technicians) if(x.getName().equals(techName)) if(x.isSenior==1) return true;
		return false;
	}
	
	/**
	 * @param name technician's name
	 * @param types wanted item type
	 * print wanted items
	 */
	public void dispitemsof(String name,String[] types){
		if(isTechman(name)){
			for(String x:types){
				switch(x){
				case "CDDVD" : for(Cddvd t:Cddvd.cddvds) System.out.println("-----------------------\n"+t); break;
				case "BOOK" : for(Book t:Book.books) System.out.println("-----------------------\n"+t); break;
				case "SMARTPHONE" : for(SmartPhone t:SmartPhone.smartphones) System.out.println("-----------------------\n"+t); break;
				case "TV" : for(TV t:TV.tvs) System.out.println("-----------------------\n"+t); break;
				case "LAPTOP" : for(Laptop t:Laptop.laptops) System.out.println("-----------------------\n"+t); break;
				case "TABLET" : for(Tablet t:Tablet.tablets) System.out.println("-----------------------\n"+t); break;
				case "DESKTOP" : for(Desktop t:Desktop.desktops) System.out.println("-----------------------\n"+t); break;
				case "HAIRCARE" : for(HairCare t:HairCare.haircares) System.out.println("-----------------------\n"+t); break;
				case "PERFUME" : for(Perfume t:Perfume.perfumes) System.out.println("-----------------------\n"+t); break;
				case "SKINCARE" : for(SkinCare t:SkinCare.skincares) System.out.println("-----------------------\n"+t); break;
			}}}
		else System.out.println("No technician person named "+name+" exists!");
	}
	
	/**
	 * @param name technician name
	 * @param words  new item's properties
	 * add item 
	 */
	public void addItem(String name,String[] words){
		if(isTechman(name)){
			switch(words[0]){
			case "CDDVD" : new Cddvd(Double.parseDouble(words[1]),"CDDVD",Integer.parseInt(words[2]),words[3],words[4],words[5]); break;
			case "BOOK" : new Book(Double.parseDouble(words[1]),"BOOK",Integer.parseInt(words[2]),words[3],words[4],words[5],Integer.parseInt(words[6]));break;
			case "SMARTPHONE" : new SmartPhone(Double.parseDouble(words[1]),"SMARTPHONE",words[2],words[3],Integer.parseInt(words[4]),Integer.parseInt(words[5]),words[6]);break;
			case "TV" : new TV(Double.parseDouble(words[1]),"TV",words[2],words[3],Integer.parseInt(words[4]),Integer.parseInt(words[5]),words[6]);break;
			case "LAPTOP" : new Laptop(Double.parseDouble(words[1]),"LAPTOP",words[2],words[3],Integer.parseInt(words[4]),Integer.parseInt(words[5]),words[6],words[7],words[8],words[9],Integer.parseInt(words[10]));break;
			case "TABLET" : new Tablet(Double.parseDouble(words[1]),"TABLET",words[2],words[3],Integer.parseInt(words[4]),Integer.parseInt(words[5]),words[6],words[7],words[8],words[9],Integer.parseInt(words[10]));break;
			case "DESKTOP" : new Desktop(Double.parseDouble(words[1]),"DESKTOP",words[2],words[3],Integer.parseInt(words[4]),Integer.parseInt(words[5]),words[6],words[7],words[8],words[9],words[10]);break;
			case "HAIRCARE" : new HairCare(Double.parseDouble(words[1]),"HAIRCARE",words[2],words[3],Integer.parseInt(words[4]),words[5],Integer.parseInt(words[6]),Integer.parseInt(words[7]));break;
			case "PERFUME" : new Perfume(Double.parseDouble(words[1]),"PERFUME",words[2],words[3],Integer.parseInt(words[6]),words[5],Integer.parseInt(words[4]),Integer.parseInt(words[7]));break;
			case "SKINCARE" : new SkinCare(Double.parseDouble(words[1]),"SKINCARE",words[2],words[3],Integer.parseInt(words[4]),words[5],Integer.parseInt(words[6]),Integer.parseInt(words[7]));break;
			default : System.out.println("No item type "+words[0]+" found");break;
			}

		}
		else System.out.println("No technician person named "+name+" exists!");
	}
	
	/**
	 * @param techName technician name
	 * print all orders
	 */
	public void showOrdes(String techName){
		if(isTechman(techName)){ if(isSenior(techName)){o.Orders();} 
		else System.out.println(techName+" is not authorized to display orders!");}
		else System.out.println("No technician person named "+techName+" exists!");
	}
}
