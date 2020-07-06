
import java.util.ArrayList;
import java.util.List;

public class TV extends Electronic {

	protected String manufacturer,brand,screenSize;
	static List<TV> tvs = new ArrayList<TV>();
	static int tvStock;
	
	/**
	 * empty constructor
	 */
	public TV() {}

	/**
	 * @param price tv's cost
	 * @param type tv's type
	 * @param manufacturer tv's manufacturer
	 * @param brand tv's brand
	 * @param maxVolt tv's maximum volt
	 * @param maxPower tv's maximum power
	 * @param screenSize tv's screen size
	 */
	public TV(double price,String type,String manufacturer,String brand,int maxVolt, int maxPower,String screenSize) {
		super(price,type,maxVolt, maxPower);
		this.screenSize=screenSize;
		this.manufacturer=manufacturer;
		this.brand=brand;
		TV.tvStock++;
		TV.tvs.add(this);
	}
	/**
	 * @return tv's manufacturer
	 */
	public String getManufacturer(){return this.manufacturer;}
	/**
	 * @return tv's brand
	 */
	public String getBrand(){return this.brand;}
	/**
	 * @return tv's screen size
	 */
	public String getScreenSize(){return this.screenSize;}
	
	@Override
	public String toString(){
		return String.format("%s: %s\n%s: %d\n%s: %.01f $\n%s: %s\n%s: %s\n%s: %d V.\n%s: %d W.\n%s: %s",
				"Item Type",super.getItemType(),"Item ID",super.getId(),"Price",super.getPrice(),"Manufacturer",this.getManufacturer(),"Brand",this.getBrand(),
				"Max Volt",super.getMaxVolt(),"Max Watt",super.getMaxPower(),"Screen size",this.getScreenSize());
	}
}
