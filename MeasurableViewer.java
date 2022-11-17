import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Scanner;

public class MeasurableViewer {
	
	private static final int FRAME_WIDTH = 250;
	private static final int FRAME_HEIGHT = 150;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
	   
	   //Create Measurable arrays
	   
		Measurable[] accounts = new Measurable[3];
		accounts[0] = new BankAccount(176220);
		accounts[1] = new BankAccount(513120);
		accounts[2] = new BankAccount(30510);
		   
		Measurable[] countries = new Measurable[3];
		countries[0] = new Country("Uruguay", 176220);
		countries[1] = new Country("Thailand", 513120);
		countries[2] = new Country("Belgium", 30510);	   
	      
		Measurable[] quizzes = new Measurable[5];
		quizzes[0] = new Quiz(95);
		quizzes[1] = new Quiz(80);
		quizzes[2] = new Quiz(90);
		quizzes[3] = new Quiz(50);
		quizzes[4] = new Quiz(75);
	   
		//Get metric from user
		System.out.print("Enter metric to use, 1 for maximum, 2 for minimum, 3 for average: ");
		int userInput = in.nextInt();
		String selectedMetric="Average";
	   
		if (userInput == 1) {
		   selectedMetric = "Maximum";
		}
		if (userInput == 2) {
		   selectedMetric = "Minimum";
		}
		if (userInput == 3) {
		   selectedMetric = "Average";
		}

		//Create frame and panel    
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.add(panel);

		//Bank Account button and listener
		JButton balanceButton = new JButton("Get " + selectedMetric + " Balance");
		panel.add(balanceButton);
		ActionListener balanceListener = new ButtonListener(accounts, selectedMetric, "Account Balance");
		balanceButton.addActionListener(balanceListener);

		//Country button and listener
		JButton areaButton = new JButton("Get " + selectedMetric + " Area");
		panel.add(areaButton);
		ActionListener areaListener = new ButtonListener(countries, selectedMetric, "Country Area");
		areaButton.addActionListener(areaListener);
      
		//Quiz button and listener
		JButton scoreButton = new JButton("Get " + selectedMetric + " Score");
		panel.add(scoreButton);
		ActionListener scoreListener = new ButtonListener(quizzes, selectedMetric, "Quiz Score");
		scoreButton.addActionListener(scoreListener);

		//Display buttons
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
      
		//Close scanner
		in.close();
		
	}
}
