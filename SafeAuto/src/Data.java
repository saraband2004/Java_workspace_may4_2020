


public class Data {  // both trip and driver shares the same core data types                          
	private String name;
	protected double mileage;
	protected int time; //in minute
	public Data(String name, int time, double mileage) { 
		this.name = name;
		this.mileage= mileage;
		this.time = time;
	}
	public String getName() {
		return this.name;
	}
	
	public int getTime() {
		return this.time;
	}
	
	public double getMileage() {
		return this.mileage;
	}
	
	public double getAverage() {
		return (double)(this.mileage * 60.0 / ((double) time));
	}
}
