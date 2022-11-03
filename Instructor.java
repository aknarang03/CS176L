
public class Instructor extends Person {
// An instructor is represented by a name, a birth year, and a salary.
	
	private double salary; 
	
	public Instructor(String name, int birthYear, double salary) {
		super(name, birthYear);
		this.salary = salary;
	}

	   public String toString() {
	      return "Instructor[super=" + super.toString() + ",salary=" + salary + "]";
	   }

}
