/** Kyle Wang
 * 1/13/23
 * PartyPlannerMain.java
 * This is the driver/tester class. It starts by asking the user how large the party is, how many tables are there,
 * how many people are at each table, and the name of the party. It then looks through attendees.csv and sorts them into companies.
 * If a company is full, it won't add it to the company roster. It then calls the addMore() function in the party class. The program
 * then prints the attendees by table and companies. Finally, the program prompts the 
 * user if they would like to search for an attendee. If the answer is yes, then the user must provide the name of the attendee they
 * wish to search for.
 **/
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class PartyPlannerMain
 {
	
	public static void main (String[] args) {
		//initializing vars and objects
		Scanner scan = new Scanner(System.in);
		String companies[] = {"Wal-Mart","Kroger","Amazon","Lowes","Best Western","KMart","Fusian","Heinz","Gucci",
		 "Prada","Nike","Dodge","Maserati","Razor","AMD","Razer"};
		 Company[] listOfComps = new Company[16];
		 int numCompanies = listOfComps.length;
		 
		 //prompting the user about party information
		System.out.print("How many people would you like your party to have?(Enter an integer) ");
		int size = scan.nextInt();
		System.out.print("How many seats would you like at each table?(Enter an integer) ");
		int sizeTable = scan.nextInt();
		System.out.print("How many tables would you like there to be?(Enter an integer) ");
		int numTables = scan.nextInt();
		scan.nextLine();//buffer I think?
		System.out.print("What would you like to name your party? ");
		String nameStr = scan.nextLine();
		Party party = new Party(numTables, sizeTable, size, nameStr);//creating the instance of a party
		ArrayList<Table> partyTabs = party.getTables();
		for (int j = 0; j < numCompanies; j++)//creating an arraylist of tables
		{
			int companySize = 10;
			listOfComps[j] = new Company(companySize, companies[j], j);
		}//for 
		
		//scans the csv file	
		try 
		{
			int i= 0;
			File myObj = new File("attendees.csv");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) 
			{	
				String[] data = myReader.nextLine().split(",");//delimiting the data by commas and storing them into an array
				String idStr = data[3];//the company id in string form
				int idHold = Integer.parseInt(idStr) - 1;//turning it into an int
				String nameHold = data[1]+" "+data[2];//getting the name
				if (party.canAdd() == true)//if the party can add more people
			    {
					if (listOfComps[idHold].canAdd() == true)//if the specified company can hold more people
					{
						Person holdDude = new Person(nameHold, idHold);//creating a Person object
						party.addPerson(holdDude);//adding the Person object to a Party object
						listOfComps[idHold].addPerson(holdDude);//adding the Person to their company
					}//if
				}//if
			}//while
			myReader.close();
		}//try
		catch (FileNotFoundException e)//exception
		{
			System.out.println("An error has occured");
			e.printStackTrace();
		}//catch
		
		party.addMore(listOfComps);//asking the user if they want to add more people
		
		int countTabs = 0;//initialzing counter variables
		int countSeat = 1;
		for (int m = 0; m < numCompanies; m++)
		{
			ArrayList<Person> holdList = listOfComps[m].getList();//getting the list of people from each company
			int holdSize = listOfComps[m].getSize();//getting the size of the company roster
			for (int n = 0; n < holdSize; n++)
			{
				if (countTabs == 10)//if each table has a person sitting at seat# countSeat
				{
					countTabs = 0;//goes back to the first table
					countSeat++;//goes to the next seat in each table
				}//if
				Person holdAttend = holdList.get(n);//initializing a Person object
				partyTabs.get(countTabs).addPerson(holdAttend);//adding the Person to table# countTabs
				holdAttend.changeTab(countTabs + 1);//assigns the person their table number
				holdAttend.changeSeat(countSeat);//assigns the Person to their seat number
				countTabs++;//incrementer
			}//for
		}//for
		
		System.out.println(party);//printing by table
		for(int k = 0; k < numCompanies; k++)//goes through listOfComps
		{
			System.out.println(listOfComps[k]);//prints each company's roster
		}//for
		
		System.out.print("Would you like to search for an attendee? ");//asking if they would like to search for a  person
		String searchYN = scan.nextLine();
		if (searchYN.equalsIgnoreCase("yes")==true)//if yes
		{
			System.out.print("What is the name of the attendee you are searching for? ");//asking for the name
			String searchName = scan.nextLine();
			party.search(searchName, partyTabs);//calls the search function in the Party Class
		}//if
	}//main
}//PartyPlannerMain

