

import java.util.ArrayList;
import java.util.List;

public class Desktop extends Computer {

	protected String manufacturer,brand,boxColor;
	static List<Desktop> desktops = new ArrayList<Desktop>();
	static int desktopStock=0;
	
	/**
	 * empty constructor
	 */
	public Desktop(){}
	
	/**
	 * @param price desktop's cost
	 * @param type desktop's type
	 * @param manufacturer desktop's manufacturer
	 * @param brand desktop's brand
	 * @param maxVolt desktop's maximum volt
	 * @param maxPower desktop's maximum power
	 * @param operatingSystem desktop's operating system
	 * @param cpu desktop's cpu
	 * @param RAMcapacity desktop's Ram capacity
	 * @param HDDcapacity desktop's hdd capacity
	 * @param boxColor desktop's  box color
	 */
	public Desktop(double price,String type,String manufacturer,String brand,int maxVolt,int maxPower,String operatingSystem,String cpu,String RAMcapacity,String HDDcapacity,String boxColor){
		super(price,type,maxVolt,maxPower,operatingSystem,cpu,RAMcapacity,HDDcapacity);
		this.boxColor=boxColor;
		this.manufacturer=manufacturer;
		this.brand=brand;
		Desktop.desktopStock++;
		Desktop.desktops.add(this);
	}
	/**
	 * @return learn desktop's  box color
	 */
	public String getBoxColor(){return this.boxColor;}
	/**
	 * @return learn desktop's  manufacturer
	 */
	public String getManufacturer(){return this.manufacturer;}
	/**
	 * @return learn desktop's  brand
	 */
	public String getBrand(){return this.brand;}
	
	@Override
	public String toString(){
		return String.format("%s: %s\n%s: %d\n%s: %.01f $\n%s: %s\n%s: %s\n%s: %d V.\n%s: %d W.\n%s: %s\n%s: %s GB.\n%s: %s GB.\n%s: %s",
				"Item Type",super.getItemType(),"Item ID",super.getId(),"Price",super.getPrice(),"Manufacturer",this.getManufacturer(),"Brand",this.getBrand(),
				"Max Volt",super.getMaxVolt(),"Max Watt",super.getMaxPower(),"Operating System",super.getOperatingSystem(),
				"CPU Type",super.getCPU(),"RAM Capacity",super.getRAMcapacity(),"HDD Capacity",super.RAMcapacity,"Box Color",this.getBoxColor());
	}
}
