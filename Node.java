public class Node
{
	private Member data; 
	private Node next; //link
	
	public Node(Member data, Node next)
	{
		this.data = data; 
		this.next = next; 
	}
	
	public void setData(Member data) { this.data = data; }
	public void setNext(Node next){ this.next = next; }
	public Member getData(){return data; }
	public Node getNext() { return next; }
	public boolean hasNext()
	{ 
		if (next!=null) 
			return true; 
		else 
			return false; 
	}
}
