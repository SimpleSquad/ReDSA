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
  
}
