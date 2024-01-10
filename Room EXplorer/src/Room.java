import java.util.HashMap;

public class Room {
	private HashMap<String, Integer> nearbyRooms;
	private String name;
	public Room(String n_name) {
		this.name = n_name;
//		this.nearbyRooms = new HashMap<String, Integer>();
	
	}
	
	public void addNearbyRooms(String direction, Integer number) {
		nearbyRooms.put(direction, number);
	}
	public void getMap() {
		String result = "?";
		for(String i : nearbyRooms.keySet()) {
			System.out.println(i);
					
		}
		
	}
	
	public String getName() {
		return name;
	}
}
