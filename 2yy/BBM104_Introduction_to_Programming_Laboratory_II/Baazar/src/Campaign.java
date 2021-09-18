

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Campaign extends Shop {
	
	/**
	 * keep every campaign at this arrayList
	 */
	static List<Campaign> campaigns=new ArrayList<Campaign>(); 
	
	protected String itemType,startDate,endDate;
	protected int rate;	
	
	/**
	 * empty constructor
	 */
	public Campaign() {}
	
	/**
	 * @param beginDate campaign's start date
	 * @param finishDate campaign's end date
	 * @param itemType campaign's item type
	 * @param rate campaign's rate
	 */
	public Campaign(String beginDate,String finishDate,String itemType,int rate){
		this.startDate=beginDate;
		this.endDate=finishDate;
		this.itemType=itemType;
		if(rate<=50){
			this.rate=rate;
			Campaign.campaigns.add(this);
			switch(itemType){
			case "CDDVD" : for(Cddvd x : Cddvd.cddvds) x.setPrice(x.getPrice()-(x.getPrice()*rate/100));
			case "BOOK" : for(Book x : Book.books) x.setPrice(x.getPrice()-(x.getPrice()*rate/100));
			case "SMARTPHONE" : for(SmartPhone x : SmartPhone.smartphones) x.setPrice(x.getPrice()-(x.getPrice()*rate/100));
			case "TV" : for(TV x : TV.tvs) x.setPrice(x.getPrice()-(x.getPrice()*rate/100));
			case "LAPTOP" : for(Laptop x : Laptop.laptops) x.setPrice(x.getPrice()-(x.getPrice()*rate/100));
			case "TABLET" : for(Tablet x : Tablet.tablets) x.setPrice(x.getPrice()-(x.getPrice()*rate/100));
			case "DESKTOP" : for(Desktop x : Desktop.desktops) x.setPrice(x.getPrice()-(x.getPrice()*rate/100));
			case "HAIRCARE" : for(HairCare x : HairCare.haircares) x.setPrice(x.getPrice()-(x.getPrice()*rate/100));
			case "SKINCARE" : for(SkinCare x : SkinCare.skincares) x.setPrice(x.getPrice()-(x.getPrice()*rate/100));
			case "PERFUME" : for(Perfume x : Perfume.perfumes) x.setPrice(x.getPrice()-(x.getPrice()*rate/100));
			}
		}
		else{System.out.println("Campaign was not created. Discount rate exceeds maximum rate of 50%.");}	
	}
	
	/**
	 * @return learn campaign's rate
	 */
	public int getRate(){return this.rate;}
	/**
	 * @return learn which item type's campaign's
	 */
	public String getType(){return this.itemType;}
	/**
	 * @return learn campaign's end date
	 */
	public String getEndDate(){return this.endDate.toString();}

}
