class Trip {
	Data data; //composition
	
	public Trip(String name, int time, double mileage) { //standard constructor (not in use)
		data = new Data(name, time, mileage);
	}
			
	public Trip(String s) throws BadInputLine{ //alternative constructor (in use)
		try {
			String[] arr= s.split(" ");
			if (arr.length != 5 || arr[0].compareTo("Trip")!=0) {
				throw new BadInputLine();
			}
			double mile = Double.valueOf(arr[4]);
			int start = stringToMinute(arr[2]);
			int end = stringToMinute(arr[3]);
			if (end <= start || mile < 0) {
				throw new BadInputLine();
			}
			data = new Data(arr[1], end - start, mile);
		}
		catch(Exception E) {
			throw new BadInputLine();
		}
	}
	
	private int stringToMinute(String s) throws BadInputLine{ //this method is not static because of the exception thrown
		String[] arr = s.split(":");
		if (arr.length!=2) {
			throw new BadInputLine();
		}
		if (Integer.valueOf(arr[0]) >= 24 || Integer.valueOf(arr[0]) < 0) { //determines whether the time is in correct hour:minute format
			throw new BadInputLine();
		}
		if (Integer.valueOf(arr[1]) >= 60 || Integer.valueOf(arr[1]) < 0) {
			throw new BadInputLine();
		}
		return Integer.valueOf(arr[0])*60+ Integer.valueOf(arr[1]);
	}
}	