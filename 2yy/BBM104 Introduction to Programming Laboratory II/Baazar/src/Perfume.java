
import java.util.ArrayList;
import java.util.List;


public class Perfume extends Cosmetic {
	
	protected int lastingDuration;
	protected String manufacturer,brand;
	static List<Perfume> perfumes = new ArrayList<Perfume>();
	static int perfumeStock=0;
	
	/**
	 * empty constructor
	 */
	public Perfume(){}
	
	/**
	 * @param price perfume's cost
	 * @param type perfume's type
	 * @param manufacturer perfume's manufacturer
	 * @param brand perfume's brand
	 * @param organic perfume's is organic?
	 * @param exprationDate perfume's expiration date
	 * @param weight perfume's weight
	 * @param lastDuration perfume's lasting duration
	 */
	public Perfume(double price,String type,String manufacturer,String brand,int organic,String exprationDate,int weight,int lastDuration){
		super(price,type,exprationDate,weight,organic);
		this.manufacturer=manufacturer;
		this.brand=brand;
		this.lastingDuration=lastDuration;
		Perfume.perfumeStock++;
		Perfume.perfumes.add(this);
	}
	/**
	 * @return perfume's manufacturer
	 */
	public String getManufacturer(){return this.manufacturer;}
	/**
	 * @return perfume's brand
	 */
	public String getBrand(){return this.brand;}
	/**
	 * @return perfume's lasting duration
	 */
	public int getLastingDuration(){return this.lastingDuration;}
	
	
	@Override
	public String toString(){
		return String.format("%s: %s\n%s: %d\n%s: %.01f $\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %d\n%s: %d min",
				"Item Type",super.getItemType(),"Item ID",super.getId(),"Price",super.getPrice(),"Manufacturer",this.getManufacturer(),
				"Brand",this.getBrand(),"Organic",super.yesnoOrganic(),"Expiration Date",super.getExprationDate(),
				"Weight",super.getWeight(),"Lasting Duration",this.getLastingDuration());
	}
}
