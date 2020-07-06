

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Cosmetic extends Item {
	
	protected int isOrganic,weight;
	protected String exprationDate;
	static protected List<Cosmetic> cosmetics = new ArrayList<Cosmetic>();	
	
	/**
	 * empty constructor
	 */
	public Cosmetic(){}
	
	/**
	 * @param price cosmetic item's cost
	 * @param type cosmetic item's type
	 * @param exprationDate cosmetic item's expiration date
	 * @param organic cosmetic item's is organic?
	 * @param weight cosmetic item's weight
	 */
	public Cosmetic(double price,String type,String exprationDate,int organic,int weight){
		super(price,type);
		this.exprationDate=exprationDate;
		this.isOrganic=organic;
		this.weight=weight;
		Cosmetic.cosmetics.add(this);
	}
	
	/**
	 * @return learn cosmetic item's expiration date
	 */
	public String getExprationDate(){return this.exprationDate;}
	/**
	 * @return learn cosmetic item's is organic?
	 */
	public int getisOrganic(){return this.isOrganic;}
	public String yesnoOrganic(){if(this.getisOrganic()==1) return "Yes"; return "No";}
	/**
	 * @return learn cosmetic item's weight
	 */
	public int getWeight(){return this.weight;}
}
