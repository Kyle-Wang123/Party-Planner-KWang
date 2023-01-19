import java.util.ArrayList;

public class Company extends Group
{
	 private int companyID;
	 public Company(int size, String name, int id)
	 {
		 super(size, name);
		 companyID = id;
	 }//company
	 
	 public int getID()
	 {return companyID;}
 }//Company
