import java.util.ArrayList;
import java.util.HashMap;

public class Room {
	private HashMap<String, Room> nearbyRooms;
	private String name;
	private	ArrayList<Item> item = new ArrayList<Item>();
	
	public Room(String n_name) {
		this.name = n_name;
		this.nearbyRooms = new HashMap<String, Room>();
	}
	
	// add rooms
	public void addNearbyRooms(String direction, Room room) {
		nearbyRooms.put(direction, room);
	}
	
	//look for other possible rooms to go to
	public String getMap() {
		String result = "";
		for(String i : nearbyRooms.keySet()) {
			result += i + "\n"; 
		} 
		if(item != null) {
			result += "items in room: \n";
			for(Item i : item) {
				result += i.getName() + "\n";
			}
		}
		return result;
	}
	
	// get name of the current room
	public String getName() {
		return name;
	}

	//change position to another room
	public Room goRoom(String direction) {
		if(nearbyRooms.containsKey(direction)) {
			return nearbyRooms.get(direction);
		}
		else {
			return null;
		}
	}
	
	public void getItem(String n_item) {
		if(item.contains(n_item)) {
			for(Item i : item) {
				if(i.equals(n_item)) {
					item.get(i);
				}
			}
		}
		
	}

	// add item to room
	public void addItem(Item n_item) {
		item.add(n_item);
	}
	
	// delete item from room
	public void removeItem(String n_item) {
		for(Item i : item) {
			if(i.getName().equals(n_item)) {
				item.remove(i);
			}
		}
	}
	
	public void art() {
		System.out.println("	     |\\_/|                  ");
		System.out.println("	     | O O   Woof! ");
		System.out.println("	     |   <>              _  ");
		System.out.println("	     |  _/\\------____ ((| |))");
		System.out.println("	     |               `--' |   ");
		System.out.println("	 ____|_       ___|   |___.' ");
		System.out.println("	/_/_____/____/_______|");


	    }
}