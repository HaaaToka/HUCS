
import java.util.ArrayList;
import java.util.List;

public class Tablet extends Computer {

	protected int dimensions;
	protected String manufacturer,brand;
	static List<Tablet> tablets = new ArrayList<Tablet>();
	static int tabletStock=0;
	
	/**
	 * empty constructor
	 */
	public Tablet() {}

	/**
	 * @param price tablet's cost
	 * @param type tablet's type
	 * @param manufacturer tablet's manufacturer
	 * @param brand tablet's brand
	 * @param maxVolt tablet's maximum volt
	 * @param maxPower tablet's maximum power
	 * @param operatingSystem tablet's operating system
	 * @param cpu tablet's cpu
	 * @param RAMcapacity tablet's ram capacity
	 * @param HDDcapacity tablet's hdd capacity
	 * @param dimension tablet's dimension
	 */
	public Tablet(double price,String type,String manufacturer,String brand,int maxVolt, int maxPower, String operatingSystem, String cpu, String RAMcapacity,String HDDcapacity,int dimension) {
		super(price,type,maxVolt, maxPower, operatingSystem, cpu, RAMcapacity, HDDcapacity);
		this.dimensions=dimension;
		this.manufacturer=manufacturer;
		this.brand=brand;
		Tablet.tabletStock++;
		Tablet.tablets.add(this);
	}
	/**
	 * @return tablet's manufacturer
	 */
	public String getManufacturer(){return this.manufacturer;}
	/**
	 * @return tablet's brand
	 */
	public String getBrand(){return this.brand;}
	/**
	 * @return tablet's dimensions
	 */
	public int getDimensions(){return this.dimensions;}
	
	@Override
	public String toString(){
		return String.format("%s: %s\n%s: %d\n%s: %.01f $\n%s: %s\n%s: %s\n%s: %d V.\n%s: %d W.\n%s: %s\n%s: %s\n%s: %s GB.\n%s: %s GB.\n%s: %d",
				"Item Type",super.getItemType(),"Item ID",super.getId(),"Price",super.getPrice(),"Manufacturer",this.getManufacturer(),"Brand",this.getBrand(),
				"Max Volt",super.getMaxVolt(),"Max Watt",super.getMaxPower(),"Operating System",super.getOperatingSystem(),
				"CPU Type",super.getCPU(),"RAM Capacity",super.getRAMcapacity(),"HDD Capacity",super.RAMcapacity,"Dimensions",this.getDimensions());
	}
}
