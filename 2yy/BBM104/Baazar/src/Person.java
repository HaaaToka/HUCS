
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Person {
	protected String name,mail;//mail is string because i didnt see anyone's age 
	protected Date birthDay;
	static List<Person> people = new ArrayList<Person>();
	
	/**
	 * empty constructor
	 */
	public Person(){}
	
	/**
	 * @param name Person's name
	 * @param mail Person's mail
	 * @param birthDay Person's birthday
	 */
	public Person(String name,String mail,Date birthDay){
		this.name=name;
		this.mail=mail;
		this.birthDay=birthDay;
		Person.people.add(this);
	}
	
	/**
	 * @return Person's name
	 */
	public String getName(){return this.name;}
	/**
	 * @return Person's mail
	 */
	public String getMail(){return this.mail;}
	/**
	 * @return Person's birth day
	 */
	public Date getBirth(){return this.birthDay;}
	
	
	@Override
	public String toString(){
		return String.format("%s: %s\t%s: %d\t%s: %s",
				"Customer Name",getName(),"e-mail",getMail(),
				"Date of Birth",getBirth());
	}
}
