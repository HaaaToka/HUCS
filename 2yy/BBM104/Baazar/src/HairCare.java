

import java.util.ArrayList;
import java.util.List;

public class HairCare extends Cosmetic {
	protected int isMedicated=0;
	protected String manufacturer,brand;
	static List<HairCare> haircares = new ArrayList<HairCare>();
	static int hairCareStock=0;
	
	/**
	 * empty constructor
	 */
	public HairCare(){}
	
	/**
	 * @param price haircare's cost
	 * @param type haircare's type
	 * @param manufacturer haircare's manufacturer
	 * @param brand haircare's brand
	 * @param organic haircare's is organic?
	 * @param exprationDate haircare's expiration date
	 * @param weight haircare's weight
	 * @param medicat haircare's is medicated?
	 */
	public HairCare(double price,String type,String manufacturer,String brand,int organic,String exprationDate,int weight,int medicat){
		super(price,type,exprationDate,organic,weight);
		this.isMedicated=medicat;
		this.manufacturer=manufacturer;
		this.brand=brand;
		HairCare.hairCareStock++;
		HairCare.haircares.add(this);
	}
	/**
	 * @return learn haircare's manufacturer
	 */
	public String getManufacturer(){return this.manufacturer;}
	/**
	 * @return learn haircare's brand
	 */
	public String getBrand(){return this.brand;}
	/**
	 * @return learn haircare's is medicated?
	 */
	public int getisMedicated(){return this.isMedicated;}
	public String yesnoMedi(){if(this.getisMedicated()==1) return "Yes"; return "No";}
	
	@Override
	public String toString(){
		return String.format("%s: %s\n%s: %d\n%s: %.01f $\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %d\n%s: %s",
				"Item Type",super.getItemType(),"Item ID",super.getId(),"Price",super.getPrice(),"Manufacturer",this.getManufacturer(),
				"Brand",this.getBrand(),"Organic",super.yesnoOrganic(),"Expration Date",super.getExprationDate(),
				"Weight",super.getWeight(),"Medicated",this.yesnoMedi());
	}
	
}
