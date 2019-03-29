public class MembersLinkedList 
{
	private Node head; 
	private int size; 
	
	public MembersLinkedList(){size = 0;}

	public boolean isEmpty() 
	{
		if (head==null) 
			return true;
		else 
			return false; 
	}
	public int getSize(){ return size; }

	public void add(Node node){
		size++;
		if(head==null) 
			head = node; //if the linkedlist is empty
		else
		{
			Node curr = head; 
			if(!curr.hasNext())  //if there is only one element in linked list
			{
				curr.setNext(node);
			}
			else //more than one node in a linked list
			{
				while(curr.hasNext())
				{
					curr = curr.getNext(); 
				}
				curr.setNext(node);
			}
		}
	//end add	
	}
	
	/*
	 * @param none
	 * remove method returns and removes from the linkedlist
	 */
	public Member remove()
	{ 
		if(isEmpty()) 
			return null;
		Node curr = head;
		Node previous = head;
		if(!curr.hasNext()) //linked list has only one element
		{
			Member data = curr.getData();
			head= null;
			size--;
			return data;
		}
		else //linked list has multiple elements
		{ 
			while(curr.hasNext())
			{
				previous = curr;
				curr = curr.getNext();
			}
			Member data = curr.getData();
			previous.setNext(null);
			curr = null;
			size--;
			return data;
	   }
	//end remove
   }

//end class
}


