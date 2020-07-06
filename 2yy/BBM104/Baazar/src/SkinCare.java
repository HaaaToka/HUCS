
import java.util.ArrayList;
import java.util.List;

public class SkinCare extends Cosmetic {
	
	protected int isBabySensitive=0;
	protected String manufacturer,brand;
	static List<SkinCare> skincares = new ArrayList<SkinCare>();
	static int skinCareStock=0;
	
	/**
	 * empty constructor
	 */
	public SkinCare(){}
	
	/**
	 * @param price skincare's cost
	 * @param type skincare's type
	 * @param manufacturer skincare's manufacturer
	 * @param brand skincare's brand
	 * @param organic skincare's is organic?
	 * @param exprationDate skincare's expiration date
	 * @param weight skincare's weight
	 * @param babySensitive skincare's is baby sensitive?
	 */
	public SkinCare(double price,String type,String manufacturer,String brand,int organic,String exprationDate,int weight,int babySensitive){
		super(price,type,exprationDate,organic,weight);
		this.isBabySensitive=babySensitive;
		this.manufacturer=manufacturer;
		this.brand=brand;
		SkinCare.skinCareStock++;
		SkinCare.skincares.add(this);
	}
	/**
	 * @return skincare's manufacturer
	 */
	public String getManufacturer(){return this.manufacturer;}
	/**
	 * @return skincare's brand
	 */
	public String getBrand(){return this.brand;}
	/**
	 * @return skincare's is baby sensitive?
	 */
	public int getisBabySensitve(){return this.isBabySensitive;}
	public String yesnoBaby(){if(this.isBabySensitive==1) return "Yes"; return "No";}
	
	@Override
	public String toString(){
		return String.format("%s: %s\n%s: %d\n%s: %.01f $\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %d\n%s: %s",
				"Item Type",super.getItemType(),"Item ID",super.getId(),"Price",super.getPrice(),"Manufacturer",this.getManufacturer(),
				"Brand",this.getBrand(),"Organic",super.yesnoOrganic(),"Expration Date",super.getExprationDate(),
				"Weight",super.getWeight(),"Baby Sensitive",this.yesnoBaby());
	}
}
