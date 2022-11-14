
public class Quiz implements Measurable{
	
	private int score;
	
	public Quiz (int score) {
		if (score >= 0 && score <= 100) {
			this.score = score;
		}
		else {
			this.score = 0;
		}
	}

	public double getMeasure() {
		return score;
	}
	
	
	
	

}
