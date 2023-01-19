  //person.java


public class  Person
{
	private int company;
	private String name;
	private int table;
	private int seat;
	
	public Person(String name, int company)
	{
		this.name = name;
		this.company = company;
	}//Person
	
	public String getName()
	{return name;}
	
	public int getCompany()
	{return company;}
	
	public String toString()
	{return name + "\n";}
	
	public void changeTab(int table)
	{this.table = table;}
	
	public void changeSeat(int seat)
	{this.seat = seat;}
	
	public int getSeat()
	{return seat;}
	
	public int getTable()
	{return table;}
	
}//Person
