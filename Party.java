import java.util.ArrayList;

public class Party extends Group
{
	private ArrayList<Table> tables;
	private int sizeTable;
	private int tablesNum;
	
	public Party(int numTables, int tableSize, int size, String name)
	{
		super(size, name);
		tables = new ArrayList<Table>();
		for (int i = 0; i < numTables; i++)
		{
			int temp = i+1;
			tables.add(new Table(tableSize, temp, "Table "+temp));
		}//for
		tablesNum = numTables;
		sizeTable = tableSize;
	}//Party
	
	public int getNumTables()
	{return tablesNum;}
	
	public int getTableSize()
	{return sizeTable;}
	
	public ArrayList<Table> getTables()
	{return tables;}
	
}//Party
