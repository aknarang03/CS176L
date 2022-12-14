
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class InputOutputFiles {
   
	public static void main(String[] args) throws FileNotFoundException {
	   
	  boolean haveFile = false;
	  
	  Scanner userInput = new Scanner(System.in); 
	  Scanner in = null;
	  
	  while (!haveFile) {
		  
		  System.out.println("Please enter the path to open the input file for example C:\\Downloads\\lines.txt: ");
		  // what I used during my testing: C:\Users\Anjali\Downloads\lines.txt
	  
		  try {
			  String fileString = userInput.nextLine();
			  File inputFile = new File(fileString);
			  in = new Scanner(inputFile);
			  haveFile = true;
		  } catch (FileNotFoundException ex){
			  System.out.println("File is not found, please try again");
		  }
	  
	  }
      
	  // what I used during my testing: 
      // PrintWriter outputFile = new PrintWriter("C:\\Users\\Anjali\\Downloads\\outlines.txt");
	  // I put the original back for you.
      PrintWriter outputFile = new PrintWriter("C:\\Users\\geckert\\Downloads\\e02\\student\\outlines.txt");
     
      while (in.hasNext()) {
      String what = in.next();
      outputFile.println(what);
      }
      
      in.close();
      userInput.close();
      outputFile.close();
   }
}
