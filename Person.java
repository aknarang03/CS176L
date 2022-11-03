
public class Person {
// A person is represented by the name and a birth year.

	private String name;
	private int birthYear;
	
	public Person(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
	}

	   public String toString() {
	      return "Person[name=" + name + ",birthYear=" + birthYear + "]";
	   }

}
