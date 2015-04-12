package ListPkg;

//list house class is used to implement the listable interface,
//Here the implementation of abstract methords are done . and this act
//as the concrete class of the Listable Interface
public class ListHouse implements Listable{
  
//These variables are defined to store the data retrieved
//To access them we created some public methods
	
	// private variables
		private String lastName;
		private String firstName;
		private int lotNumber;
		private int price;
		private int squareFeet;
		private int bedRooms;
		
//The listhouse contain a parametrized constructor to assign the values
//The values which are passed to this constructor will be stored in the private variables.
//we return a single object containing lots of details.	
		public ListHouse(String lastName, String firstName, int lotNumber,
		int price, int squareFeet, int bedRooms )
		{
		this.lastName = lastName;
		this.firstName = firstName;
		this.lotNumber = lotNumber;
		this.price = price;
		this.squareFeet = squareFeet;
		this.bedRooms = bedRooms;
		}
		
		public Listable copy()
		// Returns a copy of this ListHouse object
		{
		ListHouse result = new ListHouse(lastName, firstName, lotNumber, price,
		squareFeet, bedRooms);
		return result;
		}
		
		public String compareTo(Listable comp)//we used listable because thats how we made it in the interface
		// Houses are compared based on their lot numbers and helps to find the position
		{
			int result;
		ListHouse other = (ListHouse)comp;
		 result = this.lotNumber - other.lotNumber;
		
		if (result >0) {
			//if the result is Greater than zero our current lot number is Larger than comparing lot number
			return "Greater";
			
		} else if (result <0) {
			//if the result is less than zero our current lot number is smaller than comparing lot number
			return "Less";
	
		} else {
			//if the result is zero that means the lot numbers are equal
			return "Equal";
			
		} 		 
		
		}
		
		// these methods are used to access the values of private variables
		public String lastName()
		{
		return lastName;
		}
		public String firstName()
		{
		return firstName;
		}
		public int lotNumber()
		{
		return lotNumber;
		}
		public int price()
		{
		return price;
		}
		public int squareFeet()
		{
		return squareFeet;
		}
		public int bedRooms()
		{
		return bedRooms;
		}
		
  
}
