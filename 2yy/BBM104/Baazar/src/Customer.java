
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Status {
	
	private String stat;
	public int discnt=0;
	
	/**
	 * start status
	 */
	public Status(){this.stat="CLASSIC";}

	/**
	 * @param spendedMoney customer's  spending money
	 * change customer's status  
	 */
	public void changeStatus(double spendedMoney){
		if (spendedMoney>5000 && !getStatus().equals("GOLDEN")){this.stat="GOLDEN";this.discnt=15;
			System.out.println("Congratulations! You have been upgraded to a GOLDEN MEMBER! You have earned a permanent discount of 15% on all purchases.");}
		else if (spendedMoney>1000 && spendedMoney<5000 && !getStatus().equals("SILVER")){this.stat="SILVER";this.discnt=10;
			System.out.println("Congratulations! You have been upgraded to a SILVER MEMBER! You have earned a discount of 10% on all purchases.");
			System.out.println("You need to spend "+(5000-spendedMoney)+" more TL to become a GOLDEN MEMBER.");}
		else if(spendedMoney<1000 && spendedMoney>0){this.stat="CLASSIC";System.out.println("You need to spend "+(1000-spendedMoney)+" more TL to become a SILVER MEMBER.");}
	}
	
	/**
	 * @return learn status's discount
	 */
	public int getStatDiscnt(){
		return this.discnt;
	}	
	/**
	 * @return learn customer's status
	 */
	public String getStatus(){return this.stat;}
}

////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////

class Cart {

	protected List<Item> sepet=new ArrayList<Item>();
	
	/**
	 * empty cart constructor
	 */
	public Cart() {}
	
	/**
	 * @param x added item
	 * add item to cart 
	 */
	public void addItemtoCart(Item x){sepet.add(x);}
	
	/**
	 * @param cCc customer
	 * purchase items in customer's cart
	 */
	public void buy(Customer cCc){ //"The cart has been emptied."???
		double totalCost=0,forStatMoney=0;
		Date date = new Date();
		if(cCc.c.sepet.size()>0){//this.sepet.size()
			for(Item i : cCc.c.sepet){ totalCost=totalCost+i.getSellPrice();forStatMoney=forStatMoney+i.getPrice();}	
			totalCost=totalCost-(totalCost/100*cCc.learnStatusDiscnt());
			if(cCc.getHasMoney()>=totalCost){
				for(Item i: cCc.c.sepet){
					switch(i.getItemType()){
						case "CDDVD" : if(Cddvd.cddvdStock!=0) Cddvd.cddvdStock--; break;
						case "BOOK" : if(Book.bookStock!=0) Book.bookStock--; break;
						case "SMARTPHONE" : if(SmartPhone.smartPhoneStock!=0) SmartPhone.smartPhoneStock--;  break;
						case "TV" : if(TV.tvStock!=0) TV.tvStock--; break;
						case "LAPTOP" : if(Laptop.laptopStock!=0) Laptop.laptopStock--; break;
						case "TABLET" : if(Tablet.tabletStock!=0) Tablet.tabletStock--; break;
						case "DESKTOP" : if(Desktop.desktopStock!=0) Desktop.desktopStock--; break;
						case "HAIRCARE" : if(HairCare.hairCareStock!=0) HairCare.hairCareStock--;break;
						case "SKINCARE" : if(SkinCare.skinCareStock!=0) SkinCare.skinCareStock--;break;
						case "PERFUME" : if(Perfume.perfumeStock!=0) Perfume.perfumeStock--;break;	
						}
					}
				System.out.println("Done! Your order will be delivered as soon as possible. Thank you!");
				cCc.setSpendingMoney(forStatMoney);
				cCc.setHasMoney(totalCost);
				new Order(date,cCc.getCustomerID(),totalCost,cCc.c.sepet.size());
				cCc.c.sepet.clear();
				}
			else System.out.println("Order could not be placed. Insufficient funds."); 
			}
	else {System.out.println("You should add some items to your cart before order request!");}
	}
}				

////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////

public class Customer extends Person{
	
	static List<Customer> customers = new ArrayList<Customer>();
	
	
	static int cs=0;
	private String passwd;
	private int customerID;
	private double hasMoney,spendingMoney=0;
	Status customerStatus= new Status();
	Cart c=new Cart();
	
	/**
	 * empty constructor
	 */
	public Customer(){}
	
	/**
	 * @param customerName customer's name
	 * @param mail customer's mail
	 * @param birthDay customer's birthday
	 * @param balance customer's money in account
	 * @param password customer's password
	 */
	public Customer(String customerName, String mail, Date birthDay,double balance,String password) {
		super(customerName, mail, birthDay);
		this.passwd=password;
		this.hasMoney=balance;
		this.customerID=++Customer.cs;
		Customer.customers.add(this);

	}
	/**
	 * @param customerId customer's ID
	 * @return learn is customer's ID in customers 
	 */
	public boolean isCustomer(int customerId){
		if(customerId>Customer.customers.size()) return false;
		return true;
	}

	
	/**
	 * @return learn customer's ID
	 */
	public int getCustomerID(){return this.customerID;}
	/**
	 * @return learn customer's spending money
	 */
	public double getSpendingMoney(){return this.spendingMoney;}
	/**
	 * @return learn ccustomer's moneys count
	 */
	public double getHasMoney(){return this.hasMoney;}
	/**
	 * @param b added money count
	 * add money customer's account
	 */
	public void upHasMoney(double b){this.hasMoney=this.hasMoney+b;}
	/**
	 * @return learn customer's password
	 */
	public String getpsd(){return this.passwd;}
	/**
	 * @return learn customer's status
	 */
	public String getStatus(){return this.customerStatus.getStatus();}
	/**
	 * @return learn customer's discount
	 */
	public int learnStatusDiscnt(){return customerStatus.getStatDiscnt();}
	/**
	 * @param psd new password
	 * chance password
	 */
	public void setpsd(String psd){this.passwd=psd;}
	/**
	 * @param a spent money count with campaings and his/her discount
	 */
	public void setHasMoney(double a){this.hasMoney=this.hasMoney-a;}
	/**
	 * @param a spent money count
	 * update customer's spending money count
	 */
	public void setSpendingMoney(double a){this.spendingMoney=this.spendingMoney+a; customerStatus.changeStatus(this.spendingMoney);}

	
	/**
	 * @param customerID customer's ID
	 * @param oldPass customer's old password
	 * @param newPass customer's new passward
	 * change passward
	 */
	public void changePassWd(int customerID,String oldPass,String newPass){
		if(isCustomer(customerID)){
			if(Customer.customers.get(customerID-1).getpsd().equals(oldPass)){ Customer.customers.get(customerID-1).passwd=newPass;System.out.println("The password has been successfully changed.");}
			else System.out.println("The given password does not match the current password. Please try again.");
		}
		else System.out.println("No customer with ID number "+customerID+" exist!");
	}
	
	/**
	 * @param customerId customer's ID
	 * show campaigns
	 */
	public void showCampaings(int customerId){
		if(isCustomer(customerId)){ 
			if(Campaign.campaigns.size()!=0){ System.out.println("Active campaigns:"); for (Campaign x:Campaign.campaigns) System.out.println(x.getRate()+"% sale of "+x.getType()+" until "+x.getEndDate().replace(".", "/"));}
			else System.out.println("No campaign has been created so far!");}
		else {System.out.println("No customer with ID number 1 exists!");}
	}
	
	
	/**
	 * @param customerId customer's ID
	 * @param itemId item' ID
	 * add to cart item
	 */
	public void addCart(int customerId,int itemId){
		if(isCustomer(customerId)){
			if(itemId<=Item.itemcounter){
				for(Item x: Item.items){
					if (x.getId()==itemId){
					switch(x.getItemType()){
					case "CDDVD" : if(Cddvd.cddvdStock!=0) {Customer.customers.get(customerId-1).c.addItemtoCart((Cddvd) x); System.out.println("The item CDDVD has been successfully added to your cart.");} else System.out.println("We are sorry. The item is temporarily unavailable."); break;
					case "BOOK" : if(Book.bookStock!=0) {Customer.customers.get(customerId-1).c.addItemtoCart((Book) x); System.out.println("The item Book has been successfully added to your cart.");} else System.out.println("We are sorry. The item is temporarily unavailable."); break;
					case "SMARTPHONE" : if(SmartPhone.smartPhoneStock!=0) { Customer.customers.get(customerId-1).c.addItemtoCart((SmartPhone) x); System.out.println("The item SmartPhone has been successfully added to your cart.");} else System.out.println("We are sorry. The item is temporarily unavailable."); break;
					case "TV" : if(TV.tvStock!=0) {Customer.customers.get(customerId-1).c.addItemtoCart((TV) x); System.out.println("The item TV has been successfully added to your cart.");} else System.out.println("We are sorry. The item is temporarily unavailable."); break;
					case "LAPTOP" : if(Laptop.laptopStock!=0) { Customer.customers.get(customerId-1).c.addItemtoCart((Laptop) x); System.out.println("The item Laptop has been successfully added to your cart.");}  else System.out.println("We are sorry. The item is temporarily unavailable."); break;
					case "TABLET" : if(Tablet.tabletStock!=0) {Customer.customers.get(customerId-1).c.addItemtoCart((Tablet) x);System.out.println("The item ablet has been successfully added to your cart.");}  else System.out.println("We are sorry. The item is temporarily unavailable."); break;
					case "DESKTOP" : if(Desktop.desktopStock!=0) {Customer.customers.get(customerId-1).c.addItemtoCart((Desktop) x);System.out.println("The item Desktop has been successfully added to your cart.");} else System.out.println("We are sorry. The item is temporarily unavailable."); break;
					case "HAIRCARE" : if(HairCare.hairCareStock!=0) {Customer.customers.get(customerId-1).c.addItemtoCart((HairCare) x);System.out.println("The item HairCare has been successfully added to your cart.");}  else System.out.println("We are sorry. The item is temporarily unavailable."); break;
					case "SKINCARE" : if(SkinCare.skinCareStock!=0) {Customer.customers.get(customerId-1).c.addItemtoCart((SkinCare) x);System.out.println("The item SkinCare has been successfully added to your cart.");}  else System.out.println("We are sorry. The item is temporarily unavailable."); break;
					case "PERFUME" : if(Perfume.perfumeStock!=0) {Customer.customers.get(customerId-1).c.addItemtoCart((Perfume) x);System.out.println("The item Perfume has been successfully added to your cart.");}  else System.out.println("We are sorry. The item is temporarily unavailable."); break;
					}}}}
			else System.out.println("Invalid item ID");
		}
		else System.out.println("No customer with ID number "+customerId+" exists!");
	}
		
	/**
	 * @param customerId customer's ID
	 * @param pass customer's password
	 * buy in customer's cart
	 */
	public void order(int customerId,String pass){
		if(isCustomer(customerId)){boolean flag=true;
			for(Customer x:Customer.customers) if(x.getpsd().equals(pass)){ c.buy(x); flag = false;break;}
				if(flag) System.out.println("Order could not be placed. Invalid password.");
			}
		else System.out.println("No customer with ID number "+customerId+" exists!");
	}
	
	/**
	 * @param customerId customer's ID
	 * delete items in customer's cart
	 */
	public void emptycart(int customerId){Customer.customers.get(customerId-1).c.sepet.clear(); System.out.println("The cart has been emptied.");}
	
	/**
	 * @param customerId customer's ID
	 * @param money add money count
	 * add some money to customer's account
	 */
	public void deposityMoney(int customerId,double money){
		if(isCustomer(customerId)) Customer.customers.get(customerId-1).upHasMoney(money);
		else System.out.println("No customer with ID number "+customerId+" exists!");
	}
	
	
	@Override
	public String toString(){
		return String.format("%s: %s\t%s: %d\t%s: %s\t%s: %s\t%s: %s",
				"Customer name",super.getName(),"ID",this.customerID,"e-mail",super.getMail(),
				"Date of Birth",super.getBirth(),"Status",customerStatus.getStatus());
	}
	
	
}
