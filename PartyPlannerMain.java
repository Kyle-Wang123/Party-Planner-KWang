/*
 * 
 * 
 * 
 * 
 * 
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class PartyPlannerMain
 {
	
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		String companies[] = {"Wal-Mart","Kroger","Amazon","Lowes","Best Western","KMart","Fusian","Heinz","Gucci",
		 "Prada","Nike","Dodge","Maserati","Razor","AMD","Razer"};
		 Company[] listOfComps = new Company[17];
		 
		System.out.print("How big would you like your party to be?(Enter an integer) ");
		int size = scan.nextInt();
		System.out.print("How many people would you like to be seated at each table?(Enter an integer) ");
		int sizeTable = scan.nextInt();
		System.out.print("How many tables would you like to be at each table?(Enter an integer) ");
		int numTables = scan.nextInt();
		scan.nextLine();
		System.out.print("What would you like to name your party? ");
		String nameStr = scan.nextLine();
		Party party = new Party(numTables, sizeTable, size, nameStr);
		ArrayList<Table> partyTabs = party.getTables();
		System.out.println(party.getTables());
		for (int j = 0; j < 16; j++)
		{
			int companySize = 10;
			listOfComps[j] = new Company(companySize, companies[j], j+1);
		}//for 
		//System.out.println(party.getNumTables()+"\n"+party.getTableSize()+"\n"+party.getSize()+"\n"+party.getName());
		
		int i= 0;
		try 
		{
			File myObj = new File("attendees.csv");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) 
			{
				int canAdd2Tab = 0;
				
				String[] data = myReader.nextLine().split(",");
				
				String idStr = data[3];
				int idHold = Integer.parseInt(idStr) - 1;
				String nameHold = data[1]+" "+data[2];
				if (party.canAdd() == true)
			    {
					for (Table table1 : partyTabs)
					{
						if (table1.canAdd() == true)
						{
							canAdd2Tab++;
						}
					} 
					if (listOfComps[idHold].canAdd() == true && canAdd2Tab > 0)
					{
						System.out.println(data[1] +" "+data[3]);
						Person holdDude = new Person(nameHold, idHold);
						for (int l = 0; l < numTables; l++)
						{
							if(partyTabs.get(l).canAdd(holdDude))
							{	
								partyTabs.get(l).addPerson(holdDude);
								party.addPerson(holdDude);
								listOfComps[idHold].addPerson(holdDude);
								holdDude.changeTab(l);
								holdDude.changeSeat(partyTabs.get(l).getSize());
								System.out.println(holdDude.getTable() +" "+holdDude.getSeat());
								l = numTables;
							}//if
						}//for
					}//if
				}//if
			}//while
			myReader.close();
		}//try
		catch (FileNotFoundException e)
		{
			System.out.println("An error has occured");
			e.printStackTrace();
		}//catch
		
		boolean cont2Add = true;
		
		
			
		
		/*Person pope = new Person("kyle",2);
		Person pope2 = new Person("kyle",3);
		Table table = new Table(2, 2, "table1");
		table.addPerson(pope2);
		table.addPerson(pope);*/
	}//main
}//PartyPlannerMain

