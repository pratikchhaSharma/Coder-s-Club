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


	public void addSorted(Node node)
   {
		if (isEmpty()) //when the list is empty
      { 
			add(node);
			return;
		}
				
		Node current = head; 
		Node previous = current;
		
		if(getSize()==1) { //when the list has only one node
			if(node.getData().getLastName().compareTo(current.getData().getLastName()) > 0 ){
				node.setNext(current);
				head = node;
				size++; 
			}
			else {
				current.setNext(node);
				size++; 
			}
			return;
		}
    
      previous = current; 
		current = current.getNext(); 
		
		while(current!=null){
			if(node.getData().getLastName().compareTo(current.getData().getLastName()) > 0 ){
					previous.setNext(node);
					node.setNext(current);
					size++;
					return;
			}
			
			previous = current; 
			current = current.getNext();
			
		}
		previous.setNext(node);
		size++;
				
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


