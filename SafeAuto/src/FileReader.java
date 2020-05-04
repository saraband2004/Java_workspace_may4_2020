import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class FileReader{
	public static void readTxtFile(String filename) { //scan each line from the input file           
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(filename));
		}
		catch(FileNotFoundException E) { 
			System.out.println("\""+filename+"\" file not found");
	    	return ;
		}
		int k = 1;
		while (scanner.hasNext()) {
			String s = scanner.nextLine(); //reads txt file line by line, convert each line to a String
			try{
				stringPasing(s);  // this is the only line related to Driver/Trip in this method
			}
			catch(BadInputLine E) {
				System.out.println("Bad Input Line "+k);
			}
			k++;
		}
		scanner.close();		
	}
	
	/*
	 * parse the input string and sort it to driver or trip 
	 * */
	private static void stringPasing(String s) throws BadInputLine {
		String[] arr = s.split(" ");
		DriverManager dm = DriverManager.getInstance();

		if (arr[0].compareTo("Driver") == 0 && arr.length == 2 && arr[1].length() >= 1) {   //if current string stands for a driver
			dm.addDriver(new Driver(arr[1]));				//the current code does not do anything for a duplicate driver. this could be modified in future.
		}
		else if (arr[0].compareTo("Trip") == 0) {			//if current string stands for a trip
			Trip trip = new Trip(s);
			try {
				if (dm.getDriver(arr[1])!=null) {
					dm.getDriver(arr[1]).takeTrip(trip);
				}
				else throw new NoSuchDriverFound();
			}                                                   
			catch(NoSuchDriverFound E) {
				System.out.println("No driver found with name = "+trip.data.getName());
			}
		} 
		else {
			throw new BadInputLine();
		}
    } 
}