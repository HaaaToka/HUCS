
import java.util.ArrayList;
import java.util.List;

public class Cddvd extends OfficeSupplies {

	/**
	 * keep every cddvd at this arrayList
	 */
	static protected List<Cddvd> cddvds=new ArrayList<Cddvd>();
	protected String composer,songs;
	static int cddvdStock=0;
	
	/**
	 * empty constructor
	 */
	public Cddvd() {}

	/**
	 * @param price cddvd's cost
	 * @param type cddvd's type
	 * @param releaseDate cddvd's release date
	 * @param coverTitle cddvd's cover title
	 * @param composer cddvd's composer
	 * @param song  in cddvd's songs
	 */
	public Cddvd(double price,String type, int releaseDate, String coverTitle,String composer,String song) {
		super(price,type, releaseDate, coverTitle);
		this.composer=composer;
		this.songs=song;
		Cddvd.cddvdStock++;
		Cddvd.cddvds.add(this);
	}
	/**
	 * @return learn cddvd's composer
	 */
	public String getComposer(){return this.composer;}
	/**
	 * @return learn in cddvd's songs
	 */
	public String getSongs(){return this.songs;}

	@Override
	public String toString(){
		return String.format("%s: %s\n%s: %d\n%s: %.01f $\n%s: %d\n%s: %s\n%s: %s\n%s: %s",
				"Item Type",super.getItemType(),"Item ID",super.getId(),"Price",super.getPrice(),"Release Date",super.getReleaseDate(),
				"Title",super.getCoverTitle(),"Songs",this.getSongs(),"Composer",this.getComposer());
		}
}
