package FileHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import ListPkg.*;

public class HouseFile {

	private static BufferedReader reader;
	private static PrintWriter writer;
	private static boolean inStreamStatus = false;
	private static boolean outStreamStatus = false;
	private static String nextup =""; // Holds "next" line from file
	// Equals null if at end of file

	public static void checkAvailability()
	{
		try {
			File sourcer = new File("house.txt"); 
			if(!sourcer.exists())
			sourcer.createNewFile();
			
	        } catch (Exception e) {
	        	System.out.println("Issue in "+e);
	                              }			
	}
	

	public static void startRead() 
	// Reset file for reading
	{
		try {
			
			if (inStreamStatus) reader.close();
			if (outStreamStatus) writer.close();
			reader = new BufferedReader(new FileReader("house.txt"));
			inStreamStatus = true;
			nextup = reader.readLine();
			
		} 
		
		catch (IOException e) {
			System.out.println("Issue in "+e); 
		}
	
	}

	public static void startWriter() 
	// Reset file for writing
	{
		try {
			
			if (inStreamStatus) reader.close();
			if (outStreamStatus) writer.close();
			writer = new PrintWriter(new FileWriter("house.txt"));
			outStreamStatus = true;
			
		} 
		
		catch (Exception e) {
			System.out.println("Issue in "+e); 
		}

	}

	public static boolean isMore() {
	// Returns true if file open for reading and there is still more house
	// information available in it
	
	if (!inStreamStatus || (nextup == null))
	return false;
	else return true;
	}

	public static ListHouse getNextHouse() 
	// Gets and returns house information from the house info file
	// Precondition: reader is open and holds more house information
	{
		String lastName = "lname";
		String firstName = "fname";
		int lotNumber = 0;
		int price = 0;
		int squareFeet = 0;
		int bedRooms =0;
		
		try {		
			
			lastName = nextup;
			firstName = reader.readLine();
			lotNumber = Integer.parseInt(reader.readLine());
			price = Integer.parseInt(reader.readLine());
			squareFeet = Integer.parseInt(reader.readLine());
			bedRooms = Integer.parseInt(reader.readLine());
			nextup = reader.readLine();			
		} 

		catch (IOException e) {
			System.out.println("Issue in "+e); 
		}
		
		ListHouse house = new ListHouse(lastName, firstName, lotNumber, price,
		squareFeet, bedRooms);
		return house;


}
	
	public static void writerToFile(ListHouse house) 
	// Puts parameter house information into the house info file
	// Precondition: writer is open
	{
		try {
			
			writer.println(house.lastName());
			writer.println(house.firstName());
			writer.println(house.lotNumber());
			writer.println(house.price());
			writer.println(house.squareFeet());
			writer.println(house.bedRooms());
		} 

		catch (Exception e) {
			System.out.println("Issue in "+e); 
		}

	}

	public static void streamCloser() 
	// Closes house info file
	{
		
		try {
			
			if (inStreamStatus) reader.close();
			if (outStreamStatus) writer.close();
			inStreamStatus = false;
			outStreamStatus = false;
			
		} 

		catch (IOException e) {
			System.out.println("Issue in "+e); 
		}

	}
}
