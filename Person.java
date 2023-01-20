/** Kyle Wang
 * This is the person class and it contains information about an attendee including their name,
 * the company they work at, the table they're sitting at, and the seat they are sitting at.
 * It also contains mutator functions that change the seat they are sitting at.
 **/


public class  Person
{
	private int company;
	private String name;
	private int table;
	private int seat;
	String companies[] = {"Wal-Mart","Kroger","Amazon","Lowes","Best Western","KMart","Fusian","Heinz","Gucci",
		 "Prada","Nike","Dodge","Maserati","Razor","AMD","Razer"};
		 
	public Person(String name, int company)//constructor
	{
		this.name = name;
		this.company = company;
	}//Person
	
	//getter methods
	public String getName()
	{return name;}
	
	public int getCompany()
	{return company;}
	
	public int getSeat()
	{return seat;}
	
	public int getTable()
	{return table;}
	
	//mutator methods
	public void changeTab(int table)
	{this.table = table;}
	
	public void changeSeat(int seat)
	{this.seat = seat;}
	
	public String toString()//toString method
	{return name +"\tCompany: "+companies[getCompany()]+"\tTable Number: "+getTable()+"\tSeat Number: "+getSeat()+"\n";}
}//Person
