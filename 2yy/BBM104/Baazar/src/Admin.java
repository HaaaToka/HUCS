
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * @author HaaToka
 *
 */
public class Admin extends Employee{
	
	/**
	 * keep every admin at this arrayList
	 */
	static List<Admin> admins = new ArrayList<Admin>();
	private String password;
	
	
	/**
	 * empty constructer
	 */
	public Admin(){}
	
	/**
	 * @param name admin's name
	 * @param mail admin's mail
	 * @param birthDay admin's birthday
	 * @param salar admin's salary
	 * @param passwd admin's password
	 */
	public Admin(String name, String mail, Date birthDay,int salar,String passwd) {
		super(name, mail, birthDay,salar);
		this.password=passwd;
		Admin.admins.add(this);
		}
	
	
	/**
	 * @return learn admin's passwords
	 */
	public String getPassWd(){return password;}
	
	
	/**
	 * @param adminName admin's name
	 * @return if admin's name is in adminList, return true ,else false
	 */
	public boolean isAdmin(String adminName){
		for(Admin x : Admin.admins) if(x.getName().equals(adminName)) return true;
		return false;
		}
	/**
	 * adding new customer
	 * @param customerBirth we want his/her birthDay because our company celebrate their birthday :)
	 */
	public void addCustomer(String adminName,String customerName,String customerMail,Date customerBirth,double initBalance,String customerPassword){
		if(isAdmin(adminName)) new Customer(customerName,customerMail,customerBirth,initBalance,customerPassword);
		else System.out.println("No admin person named "+adminName+" exists!");
	}
	
	/**
	 * @param adminName admin's name
	 * @param customerID wanted customer's ID
	 * if admin exists,print customer's info
	 */
	public void showCustomer(String adminName,int customerID){
		if(isAdmin(adminName)) System.out.println(Customer.customers.get(customerID-1));
		else System.out.println("No admin person named "+adminName+" exists!");
	}
	
	/**
	 * @param adminName admin's name
	 * show all customer informations
	 */
	public void showCustomers(String adminName){
		if(isAdmin(adminName)) for(Customer x : Customer.customers) System.out.println(x);
		else System.out.println("No admin person named "+adminName+" exists!");
	}
	
	/**
	 * @param adminName admin's name
	 * @param startDay campaign's start date
	 * @param endDay campaign's finish date
	 * @param itemType which item type will decrease its cost
	 * @param rate decrease price rate
	 * create new campaign
	 */
	public void createCampaigne(String adminName,String startDay,String endDay,String itemType,int rate){
		if(isAdmin(adminName)) new Campaign(startDay,endDay,itemType,rate);
		else System.out.println("No admin person named "+adminName+" exists!");
	}
	
	/**
	 * @param wasAdminName exist admin's name
	 * @param newAdminName new admin's name
	 * @param newAdminMail new admin's mail
	 * @param newAdminBirthDay new admin's birthday
	 * @param newAdminSalary new admin's salary
	 * @param newAdminPass new admin's password
	 * add new admin
	 */
	public void addAdmin(String wasAdminName,String newAdminName,String newAdminMail,Date newAdminBirthDay,int newAdminSalary,String newAdminPass){
		if(isAdmin(wasAdminName)) new Admin(newAdminName,newAdminMail,newAdminBirthDay,newAdminSalary,newAdminPass);
		else System.out.println("No admin person named "+wasAdminName+" exists!");
	}
	
	/**
	 * @param adminName admin's name
	 * @param newTechName new technician's name
	 * @param newTechMail new technician's mail
	 * @param newTechBirthDay new technician's birthday
	 * @param newTechSalary new technician's salary
	 * @param senior new technician's is senior?
	 * add new technician
	 */
	public void addTechnician(String adminName,String newTechName,String newTechMail,Date newTechBirthDay,int newTechSalary,int senior){
		if(isAdmin(adminName)) new Technician(newTechName,newTechMail,newTechBirthDay,newTechSalary,senior);
		else System.out.println("No admin person named "+adminName+" exists!");
	}
	
	/**
	 * @param adminName admin's name
	 * print wanted admin's info
	 */
	public void showAdminInfo(String adminName){
		if(isAdmin(adminName)){
			for(Admin x : Admin.admins){
				if(x.getName().equals(adminName)){
            		System.out.println("----------- Admin info -----------");
					System.out.println(x);break;}}}
		else System.out.println("No admin person named "+adminName+" exists!");
	}
	
	@Override
	public String toString(){
		return String.format("%s: %s\n%s: %s\n%s: %s",
				"Admin name",super.getName(),"Admin e-mail",super.getMail(),
				"Admin date of birth",super.getBirth().toString());
	}
}
