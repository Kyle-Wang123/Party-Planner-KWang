/**Kyle Wang
 * This is the party subclass which is an extension of the Group superclass. The Party class will automatically create an ArrayList of Table
 * objects which makes it easier to find a specified table. The party subclass has many important functions such as the the addMore() 
 * and the search(String findPer, ArrayList<Table> findArr) functions. The addMore() function allows the user to manually add in attendees.
 * The search(String findPer, ArrayList<Table> findArr) function sees if there is a person with the specified name at the party.
 **/
import java.util.ArrayList;
import java.util.Scanner;

public class Party extends Group
{
	//declaring local instance variables
	private ArrayList<Table> tables;
	private int sizeTable;
	private int tablesNum;
	
	public Party(int numTables, int tableSize, int size, String name)//constructor
	{
		super(size, name);
		tables = new ArrayList<Table>();
		for (int i = 0; i < numTables; i++)//creating the ArrayList of Table objects
		{
			int temp = i+1;
			tables.add(new Table(tableSize, temp, "Table "+temp));
		}//for
		tablesNum = numTables;
		sizeTable = tableSize;
	}//Party
	
	//getter functions
	public int getNumTables()
	{return tablesNum;}
	
	public int getTableSize()
	{return sizeTable;}
	
	public ArrayList<Table> getTables()
	{return tables;}
	
	public void addMore(Company comps[])//allows user to manually add in attendees
	{
		Company listComps[] = comps;//declaring variables
		boolean keepAdd = true;
		while (getSize() < getMaxSize() && keepAdd == true)//keeps looping until the maximum amount of people is reached
																							//or the user wishes to stop(keepAdd == false) adding more people
		{
			Scanner scan = new Scanner(System.in);
			System.out.print("Would you like add more people? There are currently "+getSize()+" people out of "+getMaxSize()+" at the party. ");//prompting the user if they wish to add more people
			String addMore = scan.nextLine();
			if (addMore.equalsIgnoreCase("yes"))//if the answer is yes
			{
				//initializing instance variables
				int compID = -1;
				boolean compFound = false;
				//prompting the user
				System.out.print("What is the name of the person that is registering? ");
				String nameIN = scan.nextLine();
				System.out.print("What company does the person registering work for? ");
				String compIN = scan.nextLine();
				
				for (int l = 0; l < getComp(); l++)//looking if the company given is invited to the party
				{
					if(compIN.equalsIgnoreCase(companies[l]) == true)//if inputted company is the same as a company in the companies arr
					{
						compFound = true;//company is found
						compID = l;//marks which company they belong to
						l = getComp();//breaks out of for loop
					}//if
				}//for
				if (compFound == false)//if company was not found
				{
					System.out.println("Employees of that company will not be attending this party.");
				}//if
				else
				{
					if (listComps[compID].canAdd() == true)//seeing if there is already 10 people from the company or not
					{//if there is less than 10 people from that company
						Person per = new Person(nameIN, compID);//creating new Person object
						listComps[compID].addPerson(per);//adds person to the specified company
						addPerson(per);//adds person to the party
						System.out.println("Person sucessfully registered!");
					}//if
					else
					{//if there is 10 people from that company
						System.out.println("There can be no more people allowed from this company!");
					}//else
				}//else
			}//if
			else if (addMore.equalsIgnoreCase("no")==true)
			{keepAdd = false;}//if answer is no
			if (getSize()==getMaxSize())//if maximum size is reached
			{System.out.println("Maximum amount of people reached!"); keepAdd = false;}
		}//while
	}//addMore
	
	public boolean search(String findPer, ArrayList<Table> findArr)//searchs for specified person in the party
	{
		for (Table findTab : findArr)//for each loop that looks through each Table
		{
			for (Person person : findTab.getList())//for each loop that looks through each person at a specific table
			{
				if (person.getName().equalsIgnoreCase(findPer))//if the specified name is found
				{
					System.out.println("Attendee found! Here is their information:\n"+person);
					return true;
				}//if
			}//for
		}//for
		System.out.println("There is no attendee by that name!");//if the name was not found
		return false;
	}//search
	
	public String toString()//toString function
	{
		String str = super.toString();
		for(int i = 0; i < tablesNum; i++)
		{
			str+=tables.get(i)+"\n";
		}//for
		return str;
	}//toString
}//Party
