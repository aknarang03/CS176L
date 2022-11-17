import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener{
	
	private Measurable[] toMeasure; // balance, area, score
	private String selectedMetric; // average, max, min
	private String printInfo; // info for sysout upon button press
	
	public ButtonListener(Measurable[] toMeasure, String selectedMetric, String printInfo) {
		this.toMeasure = toMeasure;
		this.selectedMetric = selectedMetric;
		this.printInfo = printInfo;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		if (selectedMetric == "Average") {
			System.out.println(selectedMetric + " " + printInfo + " is " + Data.average(toMeasure));
		} else if (selectedMetric == "Maximum") {
			System.out.println(selectedMetric + " " + printInfo + " is " + Data.max(toMeasure));
		} else if (selectedMetric == "Minimum") {
			System.out.println(selectedMetric + " " + printInfo + " is " + Data.min(toMeasure));
		}
		
	}
}
