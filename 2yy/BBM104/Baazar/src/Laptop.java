
import java.util.ArrayList;
import java.util.List;

public class Laptop extends Computer  {

	static protected List<Laptop> laptops = new ArrayList<Laptop>();
	protected int hasHDMI=0;
	protected String manufacturer,brand;
	static int laptopStock=0;
	
	/**
	 * empty constructor
	 */
	public Laptop(){}
	
	/**
	 * @param price Laptop's cost
	 * @param type Laptop's type
	 * @param manufacturer Laptop'smanufacturer 
	 * @param brand Laptop's brand
	 * @param maxVolt Laptop's maximum volt
	 * @param maxPower Laptop's power
	 * @param operatingSystem Laptop's operating system
	 * @param cpu Laptop's cpu
	 * @param RAMcapacity Laptop's ram capacity
	 * @param HDDcapacity Laptop's hdd capacity
	 * @param HDMI Laptop's has HDMI support?
	 */
	public Laptop(double price,String type,String manufacturer,String brand,int maxVolt,int maxPower,String operatingSystem,String cpu,String RAMcapacity,String HDDcapacity,int HDMI){
		super(price,type,maxVolt,maxPower,operatingSystem,cpu,RAMcapacity,HDDcapacity);
		this.hasHDMI=HDMI;
		this.manufacturer=manufacturer;
		this.brand=brand;
		Laptop.laptopStock++;
		Laptop.laptops.add(this);
	}	
	/**
	 * @return Laptop's manufacturer
	 */
	public String getManufacturer(){return this.manufacturer;}
	/**
	 * @return Laptop's brand
	 */
	public String getBrand(){return this.brand;}
	/**
	 * @return Laptop's has hdmi?
	 */
	public int gethasHDMI(){return this.hasHDMI;}
	public String yesnoHDMI(){if(this.gethasHDMI()==1) return "Yes"; return "No";} 
	
	@Override
	public String toString(){
		return String.format("%s: %s\n%s: %d\n%s: %.01f $\n%s: %s\n%s: %s\n%s: %d V.\n%s: %d W.\n%s: %s\n%s: %s \n%s: %s GB.\n%s: %s GB.\n%s: %s",
				"Item Type",super.getItemType(),"Item ID",super.getId(),"Price",super.getPrice(),"Manufacturer",this.getManufacturer(),
				"Brand",this.getBrand(),"Max Volt",super.getMaxVolt(),"Max Watt",super.getMaxPower(),"Operating System",super.getOperatingSystem(),
				"CPU Type",super.getCPU(),"RAM Capacity",super.getRAMcapacity(),"HDD Capacity",super.getHDDcapacity(),
				"HDMI support",this.yesnoHDMI());
	}
}
