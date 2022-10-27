import java.util.*;

public class Medals {
	
	public static void main(String[] args) {
		
		// variables
		
		final int COUNTRIES = 8; 
		final int MEDALS = 3;
		int goldCount = 0, silverCount = 0, bronzeCount = 0;
		
		// one array list per country containing amount of each medal type (gold, silver, bronze respectively)
		
		ArrayList<Integer> canada = new ArrayList<Integer>();
		canada.add(0);
		canada.add(3);
		canada.add(0);
		
		ArrayList<Integer> italy = new ArrayList<Integer>();
		italy.add(0);
		italy.add(0);
		italy.add(1);
		
		ArrayList<Integer> germany = new ArrayList<Integer>();
		germany.add(0);
		germany.add(0);
		germany.add(1);
		
		ArrayList<Integer> japan = new ArrayList<Integer>();
		japan.add(1);
		japan.add(0);
		japan.add(0);
		
		ArrayList<Integer> kazakhstan = new ArrayList<Integer>();
		kazakhstan.add(0);
		kazakhstan.add(0);
		kazakhstan.add(1);
		
		ArrayList<Integer> russia = new ArrayList<Integer>();
		russia.add(3);
		russia.add(1);
		russia.add(1);
		
		ArrayList<Integer> southKorea = new ArrayList<Integer>();
		southKorea.add(0);
		southKorea.add(1);
		southKorea.add(0);
		
		ArrayList<Integer> unitedStates = new ArrayList<Integer>();
		unitedStates.add(1);
		unitedStates.add(0);
		unitedStates.add(1);
		
		// 2d array list of medal counts for each country
		
		ArrayList<ArrayList<Integer>> medalCounts = new ArrayList<ArrayList<Integer>>();
		medalCounts.add(canada);
		medalCounts.add(italy);
		medalCounts.add(germany);
		medalCounts.add(japan);
		medalCounts.add(kazakhstan);
		medalCounts.add(russia);
		medalCounts.add(southKorea);
		medalCounts.add(unitedStates);
		
		// array list of country names for outputting in loop
		
		ArrayList<String> countries = new ArrayList<String>();
		countries.add("Canada");
		countries.add("Italy");
		countries.add("Germany");
		countries.add("Japan");
		countries.add("Kazakhstan");
		countries.add("Russia");
		countries.add("South Korea");
		countries.add("United States");
		
		// table output
		
		// output header
		System.out.format("%13s%13s%13s%13s%13s", "Country", "Gold", "Silver", "Bronze", "Total");
		System.out.println();
		
		for (int i = 0; i < COUNTRIES; i++) { // one iteration per country
			
			int countryTotal = 0;
		     
			// output country name 
			System.out.format("%13s",countries.get(i));
			
			// add to medal type counts during each iteration
			goldCount += medalCounts.get(i).get(0);
	 		silverCount += medalCounts.get(i).get(1);
	 		bronzeCount += medalCounts.get(i).get(2);
		     
		    for (int j = 0; j < MEDALS; j++) { // one iteration per medal type
		    	 
		    	// add to medal total for current country during each iteration
		    	countryTotal += medalCounts.get(i).get(j);
		    	 
		    	// output count for current medal type
		    	System.out.format("%13d",medalCounts.get(i).get(j));
		    	
		     }
		     
		    // output total medals per country
		     System.out.format("%13d",countryTotal);
		     System.out.println();
		} 
		
		// output medal type totals and overall amount of medals
		System.out.format("%13s%13s%13s%13s%13s","Totals",goldCount,silverCount,bronzeCount,goldCount+silverCount+bronzeCount);
		
	}
}
		
	