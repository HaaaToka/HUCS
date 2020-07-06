

import java.util.ArrayList;
import java.util.List;

public class Computer extends Electronic {

	protected String operatingSystem,CPU,RAMcapacity,HDDcapacity;
	static List<Computer> computers = new ArrayList<Computer>();
	
	/**
	 * empty constructor
	 */
	public Computer(){}
	
	/**
	 * @param price computer's cost
	 * @param type computer's type
	 * @param maxVolt computer's has maximum volt
	 * @param maxPower computer's has maximum power
	 * @param operatingSystem computer's has which operating system 
	 * @param cpu computer's cpu type
	 * @param RAMcapacity computer's has ram capacity
	 * @param HDDcapacity computer's has hdd capacity
	 */
	public Computer(double price,String type,int maxVolt,int maxPower,String operatingSystem,String cpu,String RAMcapacity,String HDDcapacity){
		super(price,type,maxVolt,maxPower);
		this.operatingSystem=operatingSystem;
		this.CPU=cpu;
		this.RAMcapacity=RAMcapacity;
		this.HDDcapacity=HDDcapacity;
		Computer.computers.add(this);
	}
	/**
	 * @return learn computer's operating system
	 */
	public String getOperatingSystem(){return this.operatingSystem;}
	/**
	 * @return computer's cpu
	 */
	public String getCPU(){return this.CPU;}
	/**
	 * @return computer's ram capacity
	 */
	public String getRAMcapacity(){return this.RAMcapacity;}
	/**
	 * @return computer's hdd capacity
	 */
	public String getHDDcapacity(){return this.HDDcapacity;}
}
