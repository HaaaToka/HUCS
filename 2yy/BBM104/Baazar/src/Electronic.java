

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Electronic extends Item {
	
	protected int maxVolt,maxPower;
	static protected List<Electronic> electronics = new ArrayList<Electronic>();	
	
	/**
	 * empty constructor
	 */
	public Electronic(){}
	/**
	 * @param price electronic item's cost
	 * @param type electronic item's type
	 * @param maxVolt electronic item's maximum volt
	 * @param maxPower electronic item's maximum power
	 */
	public Electronic(double price,String type,int maxVolt,int maxPower){
		super(price,type);
		this.maxVolt=maxVolt;
		this.maxPower=maxPower;
		Electronic.electronics.add(this);
	}
	/**
	 * @return learn electronic item's maximum volt
	 */
	public int getMaxVolt(){return this.maxVolt;}
	/**
	 * @return learn electronic item's maximum power
	 */
	public int getMaxPower(){return this.maxPower;}
}
