import java.util.ArrayList;

public class Table extends Group
{
	private int tableNum;
	private ArrayList<Person> peopleList;
	
	public Table(int size, int tableNum, String name)
	{
		super(size, name);
		this.tableNum = tableNum;
		peopleList = super.getList();
	}//Table

	public boolean canAdd(Person attendee)
	{
			for (Person attend : peopleList)
			{
				if (attendee.getCompany() == attend.getCompany())
				{
					return false;
				}//if
			}//for
		return true;
	}//canAdd
			
			
	public boolean addPerson(Person attendee)
	{
		ArrayList<Person> peopleList = getList();
		if (super.canAdd() == true)
		{
			for (Person attend : peopleList)
			{
				if (attendee.getCompany() == attend.getCompany())
				{
					return false;
				}//if
			}//for
			super.addPerson(attendee);
			return true;
		}//if
		return false;
	}//assignTable
	
	public String toString()
	{return getName();}
}//Table
