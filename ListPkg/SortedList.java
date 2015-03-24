package ListPkg; 


public class SortedList {

// variables

        private ListHouse house; // The info in a list node. a node contains an object which has house details
	private SortedList next; // A link to the next node on the list
	private SortedList starter; // Reference to the first node on the list
	private int numItems; // Number of elements in the list.
	private SortedList currentPos; // Current position of the selection
	
		
      // constructor
		public SortedList()		
	  { 
     // at the start of the program we set all values
		  numItems = 0;
		  starter = null;
		  currentPos = null;
	  }
//////////////////// ADT Methords ////////////////////////////////////////////

//	  this is the methord we use to insert items in to the linklist

	  public void insert (ListHouse item) 
		 {
		    SortedList newNode = new SortedList(); // Reference to node being inserted
		    SortedList backer = new SortedList(); //  reference to the back one
		    SortedList pos = new SortedList(); //  reference to a position
		     
		      pos = starter;
			  backer = null;
			  boolean moreToSearch = (pos != null);//this is used to find whether all the nodes are examined

		    while (moreToSearch) 
		    {
		    	switch (item.compareTo(pos.house)) {
				case "Less":
//					 if compare result is less than zero that means we have found the perfect place 
//					 for this node. otherwords our lotnumber is smaller than current comparing nodes lot number
//					 we are inserting in a sorted order, ascending order .
					 moreToSearch = false;
					break;

				default:
//					If the node number is larger we should move the location to a higher node
//					and the location should be the previous location
					backer = pos;
					pos = pos.next;
//					then check whether we are at the end of the list
					moreToSearch = (pos != null);
					break;
				}		    	

		    }
//             Inserting begins
			  newNode.house = (ListHouse)item.copy();
//			if the previous node is null the current position is the first node
			  if (backer == null)
//		    so we enter the first element to the next position 
//			and the new node to the starter position				  
			  {
			  newNode.next = starter;
			  starter = newNode;
			  }
			  else
//				  or we make the current position next and newnode the next of the previous
			  {
			  newNode.next = pos;
	  		  backer.next = newNode;
			  }
//			  increase no of items
			  numItems++;

		  }

}
