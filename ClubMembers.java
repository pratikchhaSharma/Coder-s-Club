/*
 * @author Pratikchha Dhungana
 * This program adds club member object to a linked list and print report for the user.
 */
import javax.swing.JOptionPane;
public class ClubMembers 
{
	public static void main (String[]args)
	{
		Member person; //object of Member class
		MembersLinkedList memberList = new MembersLinkedList(); //creating a linked list
		JOptionPane.showMessageDialog(null, "Welcome! Click 'OK' to proceed to next step.");
		do
		{
			try
			{
				person = getMember();
			    addMember(person, memberList);
			}
			catch (IllegalArgumentException e)
			{
				JOptionPane.showMessageDialog(null, "Error. Try again!");
			}
		}
		while(JOptionPane.showConfirmDialog(null, "Press 'YES' to add another club member.")==JOptionPane.YES_OPTION);
		printMember(memberList);
		JOptionPane.showMessageDialog(null, "Thank you. Have a great day!");
	//end main
	}
	/*
	 * @param person is a object of Member class, memberList is a linkedlist of MembersLinkedList class
	 * addMember adds person to the linked list nodes
	 */
	public static void addMember(Member person, MembersLinkedList memberList)
	{
			memberList.addSorted(new Node(person, null)); //adding person to the linkedlist
	//end addMember
	}
	
	public static void printMember(MembersLinkedList aMember)
	{
		String report = "Total Members: " + Member.getNumMembers() + "\nAll club members are listed below: \n" + "First Name            Last Name               Email               Major            Joined Date \n" ;
		while(aMember.getSize()>0)
		{
			report+= aMember.remove();
		}
		JOptionPane.showMessageDialog(null, report);
	//end printMember
	}
	
	/*
	 * @param none 
	 * returns Member object
	 * getMember creates object of Member class, prompts user for member information,
	 * validates the information entered and returns a object of Member class
	 */
	public static Member getMember()
	{
		Member aMember = new Member();
		boolean added = false;
		do 
		{
			try
			{
				aMember = new Member(JOptionPane.showInputDialog(null,"Enter first name: "),JOptionPane.showInputDialog(null,"Enter last name: "),JOptionPane.showInputDialog(null,"Enter your email: "),JOptionPane.showInputDialog(null,"Enter your major: \n Note: Major should be either IT or CS."),JOptionPane.showInputDialog(null,"Enter today's date: "));
				added = true;
			}
			catch (IllegalArgumentException e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}while(!added);
		return aMember;
	//end getMember
	}
//end class
}
