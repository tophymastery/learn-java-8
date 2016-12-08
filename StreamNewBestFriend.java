import java.util.*;
import static java.util.stream.Collectors.*;

// Reference tutorial: https://www.youtube.com/watch?v=2OvxOgayedU

class Person {
	enum Gender { MALE, FEMALE}
	
	private String name;
	private Date birthday;
	private Gender gender;
	private String hometown;
	private int age;
	
	public String getHometown() { return hometown; }
	public Set<Friend> getFriends() { return friends; }
	
	private Set<Friend> friends = new HashSet<Friend>();
}

class Friend {
	private Person friend;
	private Date becomeFriends;
	
	public Person getPerson() { return friend; }
}

class SocialNetwork {
	private Set<Person> people;
}

public class StreamNewBestFriend {
	
	public static Set<Friend> createFriend() {
		return new HashSet<Friend>();
	}
	
	public static Set<Person> createPeople() {
		return new HashSet<Person>(Arrays.asList(
			new Person()
		));
	}
	
	public static void main(String[] args) {
		System.out.println("Start");
		
		hometownOfFriends(createFriend());
		
		lonelyPeople(createPeople());
		
		averageNumberOfFriends(createPeople());
	}
	
	// #################################### 
	// #.           Imperative            #
	// ####################################
	// Problems with this style of programming
	// 1. Losts of boilerplate - basic operations require 5+ LOC
	// 2. Imperative (how to do it) NOT declarative (what to do)
	// 3. Mutable variables are potentially error prone
	// 4. Difficult to parallelize
	public static Set<String> hometownOfFriends(Set<Friend> friends) {
		Set<String> result = new HashSet<>();				// declare result variable
		for (Friend friend : friends) {						// interate
			result.add(friend.getPerson().getHometown()); 	// modify result
		}
		
		return result;										// return result
	}
	
	public static Set<Person> lonelyPeople(Set<Person> people) {
		Set<Person> result = new HashSet<>();				// declare result variable
		for (Person p : people) {							// interate
			if (p.getFriends().isEmpty()) {
				result.add(p);								// modify result
			}
		}
		return result;										// return result
	}
	
	public static int averageNumberOfFriends(Set<Person> people) {
		int sum = 0;										// declare result variable
		for (Person p : people) {							// interate
			sum += p.getFriends().size();					// modify result
		}
		return sum / people.size();							// return result
	}
	
	// #################################### 
	// #         Java 8 streams           #
	// ####################################
	// 1. wrapper around collection
	// 2. streams are lazy, i.e. can be infinite
	// public static Set<String> hometownOfFriendsS(Set<Friend> friends) {
// 		return friends.stream()
// 					.map(f -> f.getPerson().getHometown())
// 					.collect(Collectors.toSet());
// 	}
//
// 	public static Set<Person> lonelyPeopleS(Set<Person> people) {
// 		return people.stream()
// 			.filter(p -> p.getFriends.isEmpty())
// 			.collect(Collectors.toSet());
// 	}
//
// 	public static int averageNumberOfFriendsS(Set<Person> people) {
// 		return people.stream()
// 			.map(p -> p.getFriends().size())
// 			.reduce(0, (x, y) -> x + y)
// 			/ people.size();
// 	}
//
// 	public static Set<Person> friendOfFriends(Set<Friend> friends) {
// 		Set<Set<Friend> fof = friends.stream()
// 			.flatMap(friend -> friend.getPerson().getFriends().stream())
// 			.map(Friend::getPerson)
// 			.filter(person -> person != this)
// 			.collect(Collectors.toSet());
// 	}
	
	// ######################################################## 
	// #           Eliminate null poiter exception            #
	// ########################################################
	// OPtional<T>
	// 1. empty - throw an exception if you try to get the reference
	// 2. non-empty - contain a non-null reference
	// public static Friend longestFriendship(Set<Friend> friends) {
// 		Friend result = null;
// 		for (Friend friend : friends) {
// 			if (result == null)
// 				result =
// 		}
//
// 		return result;
// 	}

	// ################################################################## 
	// #     Simplifying concurrency with Futures and Rx Obserables     #
	// ##################################################################
	

}