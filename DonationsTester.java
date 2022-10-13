import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DonationsTester {

	public static void main(String[] args) throws FileNotFoundException {

		//setup
		
		File donationsFile = new File("Donations.txt");
		Scanner fileReader = new Scanner(donationsFile);
		Scanner userInput = new Scanner(System.in);
		
		Donations giveToMe = new Donations();
		double currentAmt;
		String currentString;
		
		System.out.print("Would you like to process donations now? (enter 'Yes' to continue): ");
		String answer = userInput.nextLine();
		userInput.close();
		
		// donations processing
		
		if (answer.equals("Yes")) {
			
			currentString = fileReader.nextLine();
			
			while (fileReader.hasNextLine()) {
				
				if (currentString.equals("<EOF>")) {
					break;
				}
				
				else if (currentString.startsWith("<individual donation>")) {
					currentString = currentString.replaceAll("<individual donation>","");
					currentAmt = Double.parseDouble(currentString);
					giveToMe.processDonation("individual",currentAmt);
				}
				
				else if (currentString.startsWith("<business donation>")) {
					currentString = currentString.replaceAll("<business donation>","");
					currentAmt = Double.parseDouble(currentString);
					giveToMe.processDonation("business",currentAmt);
				}
				
				else if (currentString.startsWith("<other donation>")) {
					currentString = currentString.replaceAll("<other donation>","");
					currentAmt = Double.parseDouble(currentString);
					giveToMe.processDonation("other",currentAmt);
				}
				
				currentString = fileReader.nextLine();
			}
			
			giveToMe.getStatistics();
			fileReader.close();
			
		}
		
		else {
			System.out.println("Ending now without processing donations");
			System.exit(0);
		}
		
	}

}
