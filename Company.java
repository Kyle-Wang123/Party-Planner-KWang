/**Kyle Wang 
 * This is the company class. The company class is a subclass of the Group superclass. The main purpose of this class is to better
 * organize people by company so it is easier to print by company and store people into companies.
 **/

import java.util.ArrayList;

public class Company extends Group
{
	 private int companyID;
	 public Company(int size, String name, int id)//constructor
	 {
		 super(size, name);
		 companyID = id;
	 }//company
	 
	 public int getID()//getter function
	 {return companyID;}
	 
	 public String toString()//toString function
	 {
		String str = super.toString();//adding statistics
		for (int i = 0; i < getSize(); i++)
		{
			str += getList().get(i)+"\n";//adding all the people to the string
		}//for
		return str;
	}//toString
 }//Company
