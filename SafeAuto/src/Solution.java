import java.util.*; 



public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DriverManager dm = DriverManager.getInstance(); //singleton DriverManager
		FileReader.readTxtFile("driver.txt"); 
		
		dm.sort(new DriverComparator());		//sorting by mileage
		//dm.printAll();                          //output            
		
 
		Iterator<Driver> itr = dm.iterator(); //get iterator
		while (itr.hasNext()) {
			System.out.println(itr.next().toString()); //output
		}
	}
}

