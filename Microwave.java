
public class Microwave {
	
	private int power = 1;
	private int time;
	
	public void power() {
		if (power == 1){
			power = 2;
		}
		else {
			power = 1;
		}
		System.out.println("Power Button was pressed. Power level is " + power + ".");
	}
	
	public void time() {
		time += 30;
		System.out.println("Time Button was pressed. Time is " + time + " seconds.");
	}
	
	public void reset() {
		power = 1;
		time = 0;
		System.out.println("Reset Button was pressed. Power level is " + power + ". Time is " + time + " seconds.");
	}
	
	public void start() {
		System.out.println("Cooking for " + time + " seconds at level " + power + ".");
	}

}
