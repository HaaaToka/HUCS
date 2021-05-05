

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Order extends Shop {

	static List<Order> orders = new ArrayList<Order>();
	protected int customerID,numberofPurchasedItems;
	protected double totalCost;
	protected Date orderDate;
	
	
	/**
	 * empty constructor
	 */
	public Order() {}
	
	/**
	 * @param orderDate order's date
	 * @param customerID customer's ID
	 * @param totalCost order's total cost
	 * @param numberofitems how many item order
	 */
	public Order(Date orderDate,int customerID,double totalCost,int numberofitems){
		this.orderDate=orderDate;
		this.customerID=customerID;
		this.totalCost=totalCost;
		this.numberofPurchasedItems=numberofitems;
		Order.orders.add(this);
	}
	
	/**
	 * print every order in ordersList
	 */
	public void Orders(){for(Order x:Order.orders) System.out.println(x);}
	
	@Override
	public String toString(){
		return String.format("%s: %s\t%s: %d\t%s: %.01f\t%s: %d",
				"Order date",this.orderDate,"Customer ID",this.customerID,"total cost",this.totalCost,
				"Number of purchased items",this.numberofPurchasedItems);
	}

}
