import java.util.*; 



class DriverComparator implements Comparator<Driver>{ //user defined comparator
	public int compare (Driver a, Driver b) {
		if (a.data.getMileage() < b.data.getMileage()) {return 1;}
		if (a.data.getMileage() > b.data.getMileage()) {return -1;}
		return a.data.getName().compareTo(b.data.getName());
	}
}



class DriverManager implements Iterable<Driver>{
	private static DriverManager driverManager = null;
	private ArrayList<Driver> driverList;
	private HashMap<String, Driver> map;  //hashmap sends driver's name to driver class
	
	public Driver getDriver(String name) {
		return map.get(name);
	}
	
	public boolean addDriver(Driver driver) {
		if (map.containsKey(driver.data.getName())) { //if the same driver was already constructed, return false
			return false;	//the current code does not do anything for a duplicate driver. this could be modified in future.		
		}
		driverList.add(driver);
		map.put(driver.data.getName(), driver);
		return true;
	}
	
	public void sort(Comparator<Driver> comparator) {        //sorting by external compatrator 
		Collections.sort(driverList, comparator);
	}
	
	private DriverManager() { 	//singleton constructor
		driverList = new ArrayList<>();
		map = new HashMap<>();
	}
	
	public static DriverManager getInstance() { 	//singleton get_instance
		if (driverManager == null) {
			driverManager = new DriverManager();
		}
		return driverManager;
	}
		
	public Iterator<Driver> iterator() {    //pass out iterator of arraylist
		return driverList.iterator();
	}
	
}