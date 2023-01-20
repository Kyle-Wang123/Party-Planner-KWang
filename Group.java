/** Kyle Wang
 * This is the group superclass. The purpose of this class is to generalize all types of groups(companies, parties, and tables).
 *  The group class is contains many key methods such as canAdd() which determines if a group object can have more ateendees
 *  added to it. It also contains addPerson(Person attendee) which adds a Person object to the ArrayList of Person objects that
 * every instance of the group object has.
 **/
 import java.util.ArrayList;
 import java.util.Scanner;
 
 
 public class Group
 {
	 //declaring local instance variables
	 private int size;
	 private ArrayList<Person> listPeople;
	 private String name;
	 Scanner scan = new Scanner(System.in);
	 String companies[] = {"Wal-Mart","Kroger","Amazon","Lowes","Best Western","KMart","Fusian","Heinz","Gucci",
		 "Prada","Nike","Dodge","Maserati","Razor","AMD","Razer"};
	 private int numCompanies = companies.length;
	 
	 public Group(int size, String name)//constructor
	 {
		 this.size = size;
		 this.name = name;
		 listPeople = new ArrayList<Person>();
		 
	 }//Group
	 
	 //getter functions
	 public String getName()
	 {return name;}
	 
	 public int getSize()
	 {return listPeople.size();}
	 
	 public int getMaxSize()
	 {return size;}
	 
	 public int getComp()
	 {return numCompanies;}
	
	public ArrayList<Person> getList()
	{ return listPeople;}
	
	public void addPerson(Person attendee)//adds a Person object to the Group object's ArrayList of Persons
	{ listPeople.add(attendee);}
	
	public boolean canAdd()//sees if you can add another Person object to a Group object
	 {
		if (getMaxSize() >= getSize()+1)
		{
			return true; 
		}//if
		return false;
	} //canAdd
	
	public String toString()
	{return "\nParty Name: "+getName()+"\nMaximum People: "+getMaxSize()+"\nCurrent Amount of People: "+getSize()+"\n\n";}
	
 }//Group
