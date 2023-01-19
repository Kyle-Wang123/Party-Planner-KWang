/** This is the group super class
 * 
 * 
 * 
 * 
 **/
 import java.util.ArrayList;
 import java.util.Scanner;
 
 
 public class Group
 {
	 private int size;
	 private ArrayList<Person> listPeople;
	 private String name;
	 Scanner scan = new Scanner(System.in);
	 String companies[] = {"Wal-Mart","Kroger","Amazon","Lowes","Best Western","KMart","Fusian","Heinz","Gucci",
		 "Prada","Nike","Dodge","Maserati","Razor","AMD","Razer"};
	 
	 public Group(int size, String name)
	 {
		 this.size = size;
		 this.name = name;
		 listPeople = new ArrayList<Person>();
	 }//Group
	 
	 public String getName()
	 {return name;}
	 
	 public int getSize()
	 {return listPeople.size();}
	 
	 public int getMaxSize()
	 {return size;}
	 
	 public boolean canAdd()
	 {
		 if (size > listPeople.size())
		 {
			return true; 
		}//if
		return false;
	}//canAdd
	
	
	public ArrayList<Person> getList()
	{ return listPeople;}
	
	public boolean addPerson(Person attendee)
	{ listPeople.add(attendee); return true;}
	
	
 }//Group
