
public class Student extends Person {
// A student is represented by the name, birth year, and major.
	
	private String major;
	
	public Student (String name, int birthYear, String major) {
		super(name, birthYear);
		this.major = major;
	}

	   public String toString() {
	      return "Student[super=" + super.toString() + ",major=" + major + "]";
	   }

}
