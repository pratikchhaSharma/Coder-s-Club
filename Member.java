/*
 * @author Pratikchha
 * Member class stores information related to a member of Coder's Club
 */
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Member implements Comparable<Member> {
	//declaring variables
private String firstName;
private String lastName;
private String email;
private String major;
private String date;

/*
*comapres and returns integer value based on the last name of the member
*/
public int compareTo(Member o)
{
		if(this.lastName.compareToIgnoreCase(o.getLastName())<0) return -1; 
		else if (this.lastName.compareToIgnoreCase(o.getLastName())> 0) return 1; 
		else return 0;
}

public Member(){};
public Member(String firstName, String lastName, String email, String major, String date)
{
   this();
	if(firstName==null || firstName.contentEquals(""))
		throw new IllegalArgumentException("First name must be provided");
	if(lastName==null || lastName.equals(""))
		throw new IllegalArgumentException("Last name must be provided");
	if(major==null || major.equals(""))
		throw new IllegalArgumentException("Major must be provided");
	if(email==null || email.equals("") || !(emailValidation(email)))
	      throw new IllegalArgumentException("You must enter valid email");
	if(date==null || date.equals("") || !(validateDate(date)))
	      throw new IllegalArgumentException("Please enter valid date.");
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.major = major;
	this.date = date;
//end constructor
}

public void setFirstName(String firstName)
{
	if(firstName==null || firstName.equals(""))
		throw new IllegalArgumentException("First name must be provided");
	this.firstName = firstName;
//end setFirstName
}

public void setLastName(String lastName)
{
	if(lastName==null || lastName.equals(""))
		throw new IllegalArgumentException("Last name must be provided");
	this.lastName = lastName;
//end setLastName
}

public void setMajor(String major)
{
	if(major==null || major.equals(""))
		throw new IllegalArgumentException("Major must be provided");
	if(!major.equalsIgnoreCase("IT") || !major.equalsIgnoreCase("CS"))
	this.major = major;
//end setMajor
}

public void setEmail(String email)
{
if(email==null || email.equals("") || !(emailValidation(email)))
      throw new IllegalArgumentException("You must enter valid email");
this.email = email;
//end setEmail
}

public void setDate(String date)
{
	if(date==null || date.equals("") || !(validateDate(date)))
	      throw new IllegalArgumentException("Please enter valid date.");
	this.date = date;
}

public boolean emailValidation(String email)
{
	   boolean isValid = false;
	   if((email.indexOf("@")==-1) || (email.indexOf(".")==-1))
	   {
	       throw new IllegalArgumentException("There should be at least one '@' and '.'");
	   }
	   if(email.indexOf("@")>email.lastIndexOf("."))
	   {
	      throw new IllegalArgumentException(". should follow @");
	   }
	   if(email.indexOf("@")<1)
	   {
	      throw new IllegalArgumentException("There should be at least one character or digit before '@'");
	   }
	   isValid = true;
	   return isValid;
//end emailValidation
}

public boolean validateDate(String date){
	
	if(date== null || date.contentEquals(""))
	{
		return false;
	}
	else
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setLenient(false);
		
		try 
		{
			Date enteredDate = sdf.parse(date);	
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}	
		return true;
	}
}

public String getFirstName(){return this.firstName;}
public String getLastName(){return this.lastName;}
public String getEmail(){return this.email;}
public String getMajor(){return this.major;}
public String getDate(){return this.date;}

public String toString()
{
	return  this.firstName + "                " +  this.lastName + "                   "
			+  this.email + "                   " + this.major + "                " +
			this.date + "\n";
}
//end class
}
