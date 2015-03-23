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

	


}
