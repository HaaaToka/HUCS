
import java.util.ArrayList;
import java.util.List;

public class SmartPhone extends Electronic {

	protected String manufacturer,brand,screenType;
	static List<SmartPhone> smartphones = new ArrayList<SmartPhone>();
	static int smartPhoneStock=0;
	
	/**
	 * empty constructor
	 */
	public SmartPhone() {}

	/**
	 * @param price smartphone's cost
	 * @param type smartphone's type
	 * @param manufacturer smartphone's manufacturer
	 * @param brand smartphone's brand 
	 * @param maxVolt smartphone's maximum volt
	 * @param maxPower smartphone's maximum power
	 * @param screenType smartphone's screen type
	 */
	public SmartPhone(double price,String type,String manufacturer,String brand,int maxVolt, int maxPower,String screenType) {
		super(price,type,maxVolt, maxPower);
		this.screenType=screenType;
		this.manufacturer=manufacturer;
		this.brand=brand;
		SmartPhone.smartPhoneStock++;
		SmartPhone.smartphones.add(this);
	}
	/**
	 * @return manufacturer
	 */
	public String getManufacturer(){return this.manufacturer;}
	/**
	 * @return smartphone's brand
	 */
	public String getBrand(){return this.brand;}
	/**
	 * @return smartphone's screen type
	 */
	public String getScreenType(){return this.screenType;}
	
	@Override
	public String toString(){
		return String.format("%s: %s\n%s: %d\n%s: %.01f $\n%s: %s\n%s: %s\n%s: %d V.\n%s: %d W.\n%s: %s",
				"Item Type",super.getItemType(),"Item ID",super.getId(),"Price",super.getPrice(),"Manufacturer",this.getManufacturer(),"Brand",this.getBrand(),
				"Max Volt",super.getMaxVolt(),"Max Watt",super.getMaxPower(),"Screen Type",this.getScreenType());
	}
}
