

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Item {
	static int itemcounter=0;
	protected int itemID=0;
	protected double EnterPrice,SellPrice;
	protected String type;
	static protected List<Item> items = new ArrayList<Item>();
	static protected List<Item> detailitems = new ArrayList<Item>();
	
	/**
	 * empty constructor
	 */
	public Item(){}
	
	/**
	 * @param price Item's cost
	 * @param type Item's type
	 */
	public Item(double price,String type){
		this.itemID=++Item.itemcounter;
		this.EnterPrice=price;
		this.SellPrice=price;
		this.type=type;
		Item.items.add(this);
	}
	/**
	 * @return learn Item's ID
	 */
	public int getId(){return this.itemID;}
	/**
	 * @return learn item's cost
	 */
	public double getPrice(){return this.EnterPrice;}
	/**
	 * @param newPrice Item's new cost
	 * update Item's sell cost
	 */
	public void setPrice(double newPrice){this.SellPrice=newPrice;}
	/**
	 * @return learn Item's sell cost
	 */
	public double getSellPrice(){return this.SellPrice;}
	/**
	 * @return learn Item's type
	 */
	public String getItemType(){return this.type;}
	
	@Override
	public String toString(){
		return String.format("%s: %d\t%s: %.0f\t","ItemID",getId(),"Item Price",getPrice());
	}
}
