
import java.util.ArrayList;
import java.util.List;

public class Book extends OfficeSupplies {

	static protected List<Book> books=new ArrayList<Book>();
	protected String publisher,authors;
	protected int pages;
	static int bookStock=0;
	
	/**
	 * create empty constructor
	 */
	public Book() {}
	
	/**
	 * @param price book's cost
	 * @param type item'type
	 * @param releaseDate book's release date
	 * @param coverTitle book's cover title
	 * @param publisher book's publisher
	 * @param author book's author
	 * @param pages book's pages count
	 */
	public Book(double price,String type, int releaseDate, String coverTitle,String publisher,String author,int pages) {
		super(price,type, releaseDate, coverTitle);
		this.publisher=publisher;
		this.authors=author;
		this.pages=pages;
		Book.bookStock++;
		Book.books.add(this);
	}
	/**
	 * @return book's publisher
	 */
	public String getPublisher(){return this.publisher;}
	
	/**
	 * @return book's authors
	 */
	public String getAuthor(){return this.authors;}
	
	/**
	 * @return book's pages count
	 */
	public int getPages(){return this.pages;}

	@Override
	public String toString(){
		return String.format("%s: %s\n%s: %d\n%s: %.01f $\n%s: %d\n%s: %s\n%s: %s\n%s: %s\n%s: %d %s",
				"Item Type",super.getItemType(),"Item ID",super.getId(),"Price",super.getPrice(),"Release Date",super.getReleaseDate(),
				"Title",super.getCoverTitle(),"Publisher",this.getPublisher(),"Author",this.getAuthor(),"Page",this.getPages(),"pages");
		}
}
