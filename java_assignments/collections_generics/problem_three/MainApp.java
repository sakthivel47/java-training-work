package problemthree;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
	public static void main(String[] args) {
		
		List<FriendshipCriteria<String, String>> friendsWithLocations = new ArrayList<FriendshipCriteria<String, String>>();
		
		
		friendsWithLocations.add(new FriendshipCriteria<>("Mukesh Ambani", "Mumbai"));
		friendsWithLocations.add(new FriendshipCriteria<>("Elon Musk", "California"));
		friendsWithLocations.add(new FriendshipCriteria<>("Ambani", "California"));
		
		String requestLocation = "California"; // find friends in this location
		
		// printing friends that matches critera of location California
		System.out.println("Showing list of friends in " + requestLocation);
		for(FriendshipCriteria<String, String> friend : friendsWithLocations) {
			if(friend.getAttribute().equals(requestLocation)) {
				System.out.println(friend.getName());
			}
		}
		
		List<FriendshipCriteria<String, Integer>> friendsWithAge = new ArrayList<FriendshipCriteria<String, Integer>>();
		

		friendsWithAge.add(new FriendshipCriteria<>("Mukesh Ambani", 55));
		friendsWithAge.add(new FriendshipCriteria<>("Elon Musk", 43));
		friendsWithAge.add(new FriendshipCriteria<>("Ambani", 39));
		
		int age = 50; // find friends less than this age
		
		// printing friends that matches critera of less than age 50
		System.out.println("Showing list of friends less than : " + age);
		for(FriendshipCriteria<String, Integer> friend : friendsWithAge) {
			if(friend.getAttribute() <= age) {
				System.out.println(friend.getName());
			}
		}
		
	}
}
