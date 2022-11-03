
public class PersonTester {
		
	public static void main(String[] args) {
		
		Person p1 = new Person("John", 1965); // John, born 1965
		Person p2 = new Person("Mary Ann", 1970); // Mary Ann, born 1970
		Student s1 = new Student("Ann", 1982, "Computer Science"); // Ann, born 1982, Computer Science major
		Student s2 = new Student("Thomas",1986,"Biology"); // Thomas, born 1986, Biology major
		Instructor i1 = new Instructor("Joseph", 1954, 65000); // Joseph, born 1954, 65000 salary
		     
		
		    // results and expected results
		     
			System.out.println(p1.toString());
			System.out.println("Expected: Person[name=John,birthYear=1965]");
			System.out.println("");
		      
			System.out.println(p2.toString());
		    System.out.println("Expected: Person[name=Mary Ann,birthYear=1970]");
		    System.out.println("");
		      
		    System.out.println(s1.toString());
		    System.out.println("Expected: Student[super=Person[name=Ann,birthYear=1982],major=Computer Science]");
		    System.out.println("");
		      
		    System.out.println(s2.toString());
		    System.out.println("Expected: Student[super=Person[name=Thomas,birthYear=1986],major=Biology]");
		    System.out.println("");
		      
		    System.out.println(i1.toString());
		    System.out.println("Expected: Instructor[super=Person[name=Joseph,birthYear=1954],salary=65000.0]");
		    
	}
	
}