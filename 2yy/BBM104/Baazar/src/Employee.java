

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee extends Person {
	
	protected int salary;
	/**
	 * keep every employee at this arrayList
	 */
	static List<Employee> employees = new ArrayList<Employee>();	
	
	/**
	 * empty constructor
	 */
	public Employee() {}
	
	/**
	 * @param name employee's name
	 * @param mail employee's mail
	 * @param birthDay employee's birthday
	 * @param salar employee's salary
	 */
	public Employee(String name, String mail, Date birthDay,int salar) {
		super(name, mail, birthDay);
		this.salary=salar;
		Employee.employees.add(this);
	}
	public boolean isEmployee(String name){		//altsinifa gecerken overla bunu!!!!!
		for(Employee x : Employee.employees) if(x.getName().equals(name)) return true;
		return false;
		}
	
	/**
	 * @return learn employee's salary
	 */
	public int getSalary(){return salary;}

	/**
	 * @param name employee's name
	 * if name is correct , print stock of item types'
	 */
	public void showItemsLowonStock(String name){
		if(isEmployee(name)){System.out.println("Book : "+Book.books.size()+"\nCDDVD : "+Cddvd.cddvds.size()+"\nDesktop : "+Desktop.desktops.size()
		+"\nLaptop : "+Laptop.laptops.size()+"\nTablet : "+Tablet.tablets.size()+"\nTV : "+TV.tvs.size()+"\nSmartPhone : "+SmartPhone.smartphones.size()
		+"\nHairCare : "+HairCare.haircares.size()+"\nPerfume : "+Perfume.perfumes.size()+"\nSkinCare : "+SkinCare.skincares.size());}
		else System.out.println("No admin or technician person named"+name+"exists!!");
	}

	/**
	 * @param name employee's name
	 * @param maxStock wanted maximum stock of item types'
	 * if any item type's stock minor ,it prints
	 */
	public void showItemsLowonStock(String name,int maxStock){
		if(isEmployee(name)){
			if(Book.bookStock<maxStock) System.out.println("Book : "+Book.bookStock);
			if(Cddvd.cddvdStock<maxStock) System.out.println("CDDVD : "+Cddvd.cddvdStock);
			if(Desktop.desktopStock<maxStock) System.out.println("Desktop : "+Desktop.desktopStock);
			if(Laptop.laptopStock<maxStock) System.out.println("Laptop : "+Laptop.laptopStock);
			if(Tablet.tabletStock<maxStock) System.out.println("Tablet : "+Tablet.tabletStock);
			if(TV.tvStock<maxStock) System.out.println("TV : "+TV.tvStock);
			if(SmartPhone.smartPhoneStock<maxStock) System.out.println("SmartPhone : "+SmartPhone.smartPhoneStock);
			if(HairCare.hairCareStock<maxStock) System.out.println("HairCare : "+HairCare.hairCareStock);
			if(Perfume.perfumeStock<maxStock) System.out.println("Perfume : "+Perfume.perfumeStock);
			if(SkinCare.skinCareStock<maxStock) System.out.println("SkinCare : "+SkinCare.skinCareStock);
		}
		else System.out.println("No admin or technician person named"+name+"exists!!");
	}
	
	/**
	 * @param name employee's name
	 * prints all item with detail information
	 */
	public void listItems(String name){
		if(isEmployee(name)){
			for(Item x: Item.items){
				switch(x.getItemType()){
				case "CDDVD" : System.out.println("-----------------------\n"+(Cddvd) x); break;
				case "BOOK" : System.out.println("-----------------------\n"+(Book) x); break;
				case "SMARTPHONE" : System.out.println("-----------------------\n"+(SmartPhone) x); break;
				case "TV" : System.out.println("-----------------------\n"+(TV) x); break;
				case "LAPTOP" : System.out.println("-----------------------\n"+(Laptop) x);break;
				case "TABLET" : System.out.println("-----------------------\n"+(Tablet) x);break;
				case "DESKTOP" : System.out.println("-----------------------\n"+(Desktop) x);break;
				case "HAIRCARE" : System.out.println("-----------------------\n"+(HairCare) x);break;
				case "SKINCARE" : System.out.println("-----------------------\n"+(SkinCare) x);break;
				case "PERFUME" : System.out.println("-----------------------\n"+(Perfume) x);break;
				}
			}
		}
		else System.out.println("No admin or technician person named "+name+" exists!");
	}

	/**
	 * @param name employee's name
	 * if any customer is GOLDEN status , prints his/her detail info
	 */
	public void showVIP(String name){
		if(isEmployee(name)){ for(Customer t: Customer.customers) if(t.getStatus().equals("GOLDEN")) System.out.println(t);}
		else System.out.println("No admin or technician person named "+name+" exists!");
	}
	
	@Override
	public String toString(){
		return String.format("%s: %s\t%s: %s\t%s: %s\t%s: %d",
				"Customer Name",super.getName(),"e-mail",super.getMail(),
				"Date of Birth",super.getBirth(),"Salary",getSalary());
	}
	
}
