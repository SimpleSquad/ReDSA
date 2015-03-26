package ListPkg; 


        public class SortedList {

// Declaring variables

        private ListHouse house;           // The info in a list node. a node contains an object which has house details
	private SortedList next;          // A link to the next node on the list
	private SortedList starter;       // Reference to the first node on the list
	private int numItems;            // Number of elements in the list.
	private SortedList currentPos;   // Current position of the selection
	            
		
      // constructor

       public SortedList()		
	          { 

     // at the start of the program we set all values
		  numItems = 0;
		  starter = null;
		  currentPos = null;
	          }


//////////////////// ADT Methords ////////////////////////////////////////////



    // this is the methord we use to insert items in to the linklist

	 public void insert (ListHouse item) 

		 {

		   SortedList newNode = new SortedList();        // Reference to node being inserted
		   SortedList backer = new SortedList();        //  reference to the back one
		   SortedList pos = new SortedList();          //  reference to a position
		     
		   pos = starter;
		   backer = null;
	           boolean moreToSearch = (pos != null);       //this is used to find whether all the nodes are examined

		          while (moreToSearch) 

		             {

		    	switch (item.compareTo(pos.house))

                                    {

				case "Less": moreToSearch = false;
                                             break;

     //	if compare result is less than zero that means we have found the correct place 
     //	for this node. otherwords our lotnumber is smaller than current comparing nodes lot number
     //	 we are inserting in a sorted order, ascending order


					 
					

				default: backer = pos;
					pos = pos.next;

    // then check whether we are at the end of the list

					moreToSearch = (pos != null);
					break;

    // If the node number is larger we should move the location to a higher node
    //and the location should be the previous location

					
				   }		    	

		           }


/////////////////////////////////// Inserting begins////////////////////////////////////////////////////


			  newNode.house = (ListHouse)item.copy();

   //if the previous node is null the current position is the first node

			  if (backer == null)

  // so we enter the first element to the next position 
  // and the new node to the starter position	
			  
			  {

			  newNode.next = starter;
			  starter = newNode;

			  }

			  else

 //or we make the current position next and newnode the next of the previous

			  {

			  newNode.next = pos;
	  		  backer.next = newNode;

			  }

 //increase no of items

			  numItems++;

//close method public void insert

		  }



	        public Listable getNextItem ()

// Returns copy of the next element on this list

		{ 
                        if(numItems ==1 && flag=="o")        // this is for setting the list when all elements are deleted

			{                                   //or else the current position will be the deleted one

			if (currentPos.next == null)        // if no next go back to beginning
			currentPos = starter;

			}

		      Listable nextItem = currentPos.house.copy();

			if (currentPos.next == null)      // if no next go back to beginning

				currentPos = starter;			
			else

			       currentPos = currentPos.next;

			return nextItem;
		}


// this is the deletion methord	  


		 public void delete (ListHouse item)	
 
	     {	    
                        SortedList pos = starter;
			                                   // Locate node to be deleted
		        switch (item.compareTo(pos.house))

                          {

			case "Equal":
				starter = starter.next;    // Delete first node
				break;

			default:
			        while (!item.compareTo(pos.next.house).equalsIgnoreCase("Equal"))
				pos = pos.next;
					                  // Delete node at pos.next

				pos.next = pos.next.next;
				break;
			 }

			numItems--;

	    }


// check availability of houses in the list

	public boolean availability(ListHouse item) {
		 
		  boolean moreToSearch;
		  SortedList pos = starter;
		  boolean found = false;
		  moreToSearch = (pos != null);
		  while (moreToSearch && !found)

		     {

		         switch (item.compareTo(pos.house)) 

                                   {

			     case "Equal":
		 		          found = true;
				          break;
				
			    case "Less":
				         moreToSearch = false;
				         break;

			    default:
				        pos = pos.next;
				        moreToSearch = (pos != null);
				        break;
		                    }			
		    }

		       return found;                // Returns found or not

	                                                }


// this is used to get the needed element


		  public Listable Fetcher(ListHouse item)                                //Listable because copy is listable

		           {

			  SortedList pos = starter;
			  boolean found = false;

			       while (!found)

			         {

			  if (item.compareTo(pos.house).equalsIgnoreCase("Equal"))       // If they match
			  found = true;

			  else
			  pos = pos.next;

			          }
			  return pos.house.copy();

		            }  

      public void reset()
            {

// reset to 1 element
	
		  currentPos = starter;
	}

	
      public int lengthIs()

 // Returns the number of elements on this list

	{
	return numItems;
	}


	
	  public SortedList getCurrent()
	  {
		  return currentPos; 
	  }
	  


}

