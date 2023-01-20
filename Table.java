/**Kyle Wang
 * This is the table subclass of the Group superclass. It's purpose is to help with better organization. The table subclass
 * also contains tableNum which further helps with differentiating tables from each other.
 **/

import java.util.ArrayList;

public class Table extends Group
{
	//local instance variables
	private int tableNum;
	private ArrayList<Person> peopleList;
	
	public Table(int size, int tableNum, String name)//constructor
	{
		super(size, name);
		this.tableNum = tableNum;
		peopleList = super.getList();
	}//Table

	//getter methods
	public int tableNum()
	{return tableNum;}
	
	public String toString()//toString method
	{
		String str = super.toString();
		for (int i = 0; i < getSize(); i++)
		{
			str += peopleList.get(i)+"\n";
		}//for
		return str;
	}//toString
}//Table

