import java.util.*;
import static java.util.stream.Collectors.*;

class Person {
	
	String fullName;
	String gender;
	Integer age;

	public Person(String fullName, String gender, Integer age) {
		this.fullName = fullName;
		this.gender = gender;
		this.age = age;
	}
	
	public String getFullName() { return this.fullName; }
	
	public Integer getAge() { return this.age; }
}

public class Stream {
	
	public static List<Person> createPeople() {
		return Arrays.asList(
			new Person("Sara", "FEMALE", 20),
			new Person("Alice", "MALE", 22),
			new Person("Adward", "FEMALE", 35),
			new Person("Adward", "FEMALE", 19),
			new Person("Banana", "FEMALE", 26),
			new Person("Sara", "MALE", 19),
			new Person("Adward", "MALE", 24),
			new Person("Waiwai", "FEMALE", 29),
			new Person("Yumyum", "FEMALE", 26)
		);
	}
	
	public static void main(String[] args) {
		System.out.println("Start");
		
		List<Person> people = createPeople();
		
		// getPeopleAgeMore18AndReturnNameWithUpperCase(people);
	
		// totalAge(people);
		
		getMaxAge(people);
	}
	
	public static void getPeopleAgeMore18AndReturnNameWithUpperCase(List<Person> people) {
		List<String> result = people.stream()
			.filter(person -> person.age > 18)
			.map(Person::getFullName)
			.map(String::toUpperCase)
			.collect(toList());
		
		System.out.println(result);
	}
	
	public static void totalAge(List<Person> people) {
		int result1 = people.stream()
			.map(Person::getAge)
			.reduce(0, Integer::sum);
		
		int result2 = people.stream()
			.mapToInt(Person::getAge)
			.sum();

		System.out.println(result2);
	}
	
	public static void getMaxAge(List<Person> people) {
		System.out.println(
			people.stream()
				.max((p1, p2) -> p1.getAge() > p2.getAge() ? 1 : -1)
				.map(Person::getAge));
		
	}
}