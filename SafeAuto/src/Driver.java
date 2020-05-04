
class Driver{
	public Data data; //composition
		
	public Driver(String name) { //constructor
		data = new Data(name, 0, 0.0);
	}
	
	public void takeTrip(Trip trip) {
		if (trip.data.getName().compareTo(data.getName()) != 0) { //name check 
			return;  //could throw an exception or output some message
		}
		if (trip.data.getAverage() < 5.0 || trip.data.getAverage() > 100.0) {
			return;  //could throw an exception or output some message
		}		
		data.mileage += trip.data.getMileage();
		data.time += trip.data.getTime();
	}
		
	public String toString() {
		if (data.mileage == 0) {
			return data.getName() + ": 0 miles";
		}
		return data.getName() + ": "+ (int)data.mileage + " miles @ " + (int)Math.round(data.getAverage()) + " mph";
	}
}
