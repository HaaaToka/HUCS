
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class OfficeSupplies extends Item {

	protected String coverTitle;
	protected int releaseDate;
	static protected List<OfficeSupplies> officeproducts = new ArrayList<OfficeSupplies>();
	
	/**
	 * empty constructor
	 */
	public OfficeSupplies() {}

	/**
	 * @param price OfficeSupply's cost
	 * @param type OfficeSupply's type
	 * @param releaseDate OfficeSupply's release date
	 * @param coverTitle OfficeSupply's cover title
	 */
	public OfficeSupplies(double price,String type,int releaseDate,String coverTitle) {
		super(price,type);
		this.releaseDate=releaseDate;
		this.coverTitle=coverTitle;
		OfficeSupplies.officeproducts.add(this);
	}

	/**
	 * @return OfficeSupply's cover title
	 */
	public String getCoverTitle(){return this.coverTitle;}
	/**
	 * @return OfficeSupply's release date
	 */
	public int getReleaseDate(){return this.releaseDate;}
}
