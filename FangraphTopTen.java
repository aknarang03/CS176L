
import org.jsoup.Jsoup;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FangraphTopTen {

	public static void main(String[] args) throws IOException {
		
		String[] ranks2020 = new String[142];
		String[] ranks2021 = new String[132];
		String[] ranks2022 = new String[130];
		ArrayList<Player> players = new ArrayList<Player>();
		
		/*
		direction notes: 
		averaging each player's position year to year and then taking top 10 of all the averages
		they have to be in all 3 for you to average them (otherwise ignore)
		 */
		
		final String link2020 = "https://www.fangraphs.com/leaders.aspx?pos=all&stats=bat&lg=all&qual=y&type=8&season=2020&month=0&season1=2020&ind=0&page=1_142";
		final String link2021 = "https://www.fangraphs.com/leaders.aspx?pos=all&stats=bat&lg=all&qual=y&type=8&season=2021&month=0&season1=2021&ind=0&page=1_132";
		final String link2022 = "https://www.fangraphs.com/leaders.aspx?pos=all&stats=bat&lg=all&qual=y&type=8&season=2022&month=0&season1=2022&ind=0&page=1_130";
		
		makeRankList(link2020, ranks2020);
		makeRankList(link2021, ranks2021);
		makeRankList(link2022, ranks2022);
		
		// tests
		/*
		System.out.println("2020: ");
		for (String name : ranks2020) {
			System.out.println(name);
		}
		System.out.println("2021: ");
		for (String name : ranks2021) {
			System.out.println(name);
		}
		System.out.println("2022: ");
		for (String name : ranks2022) {
			System.out.println(name);
		}
		*/
		
		// create Player object for each player on 2020 list
		// create with 1 time found and their 2020 rank
		for (int i = 0; i < ranks2020.length; i++) {
			Player currentPlayer = new Player(ranks2020[i],i+1);
			players.add(currentPlayer);
		}
		
		// of players in 2020 list, find which are also in 2021 list 
		// increment their times found and add 2021 rank to their total rank
		for (Player currentPlayer : players) {
			for (int i = 0; i < ranks2021.length; i++) {
				if (currentPlayer.getName().equals(ranks2021[i])) {
					currentPlayer.incrementTimesFound();
					currentPlayer.addTotalRank(i+1);
				}
			}
		}
	
		// of players in 2020 list, find which are also in 2022 list 
		// increment their times found and add 2022 rank to their total rank
		for (Player currentPlayer : players) {
			for (int i = 0; i < ranks2022.length; i++) {
				if (currentPlayer.getName().equals(ranks2022[i])) {
					currentPlayer.incrementTimesFound();
					currentPlayer.addTotalRank(i+1);
				}
			}
		}
		
		// remove players that were not found in all three lists, then sort remaining by rank
		players.removeIf(player-> (player.getTimesFound() < 3));
		Collections.sort(players,Comparator.comparing(player->(player.getRank())));
		
		// note: I did not average the rank for ordering because they are all in 3 times so they would remain in the same order regardless
		// still printed average just to show potential ties 
		for (int i = 0; i < 10; i++) {
			Player currentPlayer = players.get(i);
			System.out.println((i+1) + ": " + currentPlayer.getName() + " | average: " + currentPlayer.getAverage());
		}
		
	}
	
	public static void makeRankList(String link, String[] ranksArray) throws IOException {
		
		Document doc = Jsoup.connect(link)
				.timeout(6000).get();
		
		Elements body = doc.select("tbody");
		int counter = 0;
		
		for (Element e : body.select("td.grid_line_regular")) {
			final String name = e.select("a").text();
			if (name != "" && name.length() > 3) {
				ranksArray[counter] = name;
				counter++;
			}
			if (counter == ranksArray.length) {
				break;
			}
		}
		
	}
	
	public static class Player {
		
		private String name;
		private int totalRank;
		private int timesFound;
		
		public Player (String name, int rank){
			this.name = name;
			this.timesFound = 1;
			this.totalRank = rank;
		}
		
		public void incrementTimesFound() {
			timesFound++;
		}
		
		public void addTotalRank(int newRank) {
			totalRank+=newRank;
		}
		
		public String getName() {
			return name;
		}
		
		public int getRank() {
			return totalRank;
		}
		
		public int getTimesFound() {
			return timesFound;
		}
		
		public int getAverage() {
			return totalRank/3;
		}
		
	}

}
