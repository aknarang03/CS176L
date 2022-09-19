import java.util.Scanner;

public class HousePainting {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//Get inputs
		
		System.out.print("Please enter the cost per square foot: ");
		double costSqFt = sc.nextDouble();
		
		System.out.print("Please enter the length of the house: ");
		double houseLength = sc.nextDouble();
		
		System.out.print("Please enter the width of the house: ");
		double houseWidth = sc.nextDouble();
		
		System.out.print("Please enter the height of the house: ");
		double houseHeight = sc.nextDouble();
		
		System.out.print("Please enter the number of windows: ");
		double numWindows = sc.nextDouble();
		
		System.out.print("Please enter the length of a window: ");
		double windowLength = sc.nextDouble();
		
		System.out.print("Please enter the width of a window: ");
		double windowWidth = sc.nextDouble();
		
		System.out.print("Please enter the number of doors: ");
		double numDoors = sc.nextDouble();
		
		System.out.print("Please enter the length of a door: ");
		double doorLength = sc.nextDouble();
		
		System.out.print("Please enter the width of a door: ");
		double doorWidth = sc.nextDouble();
		
		//Do calculations
		
		double peakSideFootage = 2*(houseLength*houseWidth+0.5*(houseLength*(houseHeight-houseWidth)));
		double normalSideFootage = 2*(houseLength*houseWidth);
		double windowFootage = numWindows*(windowLength*windowWidth);
		double doorFootage = numDoors*(doorLength*doorWidth);
		double totalSquareFootage = (peakSideFootage+normalSideFootage)-(windowFootage+doorFootage);
		double totalCost = totalSquareFootage*costSqFt;
		
		//Output results
		
		System.out.format("\nYour total paintable surface area is %.0f",totalSquareFootage);	
		System.out.format(" square feet.\nYour estimate is %.0f",totalCost);
		System.out.print(" dollars.");
		
	}

}
