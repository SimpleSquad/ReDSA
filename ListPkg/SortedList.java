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


}
