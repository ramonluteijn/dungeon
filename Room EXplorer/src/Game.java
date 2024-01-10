import java.util.Scanner;

public class Game {
	
	private Scanner scanner;
	private Player player;
	
	public Game() {
		scanner = new Scanner(System.in);
		player = new Player();
	}
	
	public void play() {
		boolean keepPlaying = true;
		
		while(keepPlaying) {
			setUpRooms();
			
			// play again 
			System.out.println("want to play again? (y/n)");
			if(player.getInput().equals("n")) {
				keepPlaying = false;
				break;
			}
			else if (player.getInput().equals("y")) {
				keepPlaying = true;
			}
			else {
				System.out.println("geen juiste input");
			}
		}
	}
	private void setCommand(String userInput) {
		String result = "?";
		userInput = userInput.toLowerCase();
		switch(userInput) {
			case "go": result = "go";
				break;
			case "item": result = "item";	
				
			default: result = "?";
				break;
		}
	}
	
	private void handleCommand(String userInput, String command) {
		switch(command) {
			case "go":
					switch(userInput) {
						case "east": 
							break;
					}
			case "use":
					switch(userInput) {
						case "east": 
							break;
					}
				break;
			case "look":
				// teel whats in the room
				break;
			case "help":
				// print commands
				break;
		}
	}
	
	//create rooms
	private void setUpRooms() {
		// 2 deuren naar 4 2
		Room firstRoom = new Room("first room");
		System.out.println(firstRoom.getName());
//		firstRoom.addNearbyRooms("east",2);
//		firstRoom.addNearbyRooms("south",4);
//
//		//3 deuren naar 1 5 3
//		Room secondRoom = new Room("second room");
//		secondRoom.addNearbyRooms("west",1);
//		secondRoom.addNearbyRooms("east",3);
//		secondRoom.addNearbyRooms("south",5);
//		
//		// 2 deuren naar 2 6	
//		Room thirdRoom = new Room("third room");
//		thirdRoom.addNearbyRooms("west",2);
//		thirdRoom.addNearbyRooms("south",6);
//		
//		// 3 deuren naar 1 5 7
//		Room fourthRoom = new Room("fourth room");
//		fourthRoom.addNearbyRooms("north",1);
//		fourthRoom.addNearbyRooms("east",5);
//		fourthRoom.addNearbyRooms("south",7);
//		
//		// 4 deuren naar 2 4 6 8
//		Room fifthRoom = new Room("fifth room");
//		fifthRoom.addNearbyRooms("north",2);
//		fifthRoom.addNearbyRooms("west",6);
//		fifthRoom.addNearbyRooms("east",4);
//		fifthRoom.addNearbyRooms("south",8);
//		
//		// 4 deuren naar 3 5 9 10
//		Room sixthRoom = new Room("sixth room");
//		sixthRoom.addNearbyRooms("north",3);
//		sixthRoom.addNearbyRooms("west",5);
//		sixthRoom.addNearbyRooms("east",10);
//		sixthRoom.addNearbyRooms("south",9);
//		
//		// 2 deuren naar 4 8
//		Room seventhRoom = new Room("seventh room");
//		seventhRoom.addNearbyRooms("north",4);
//		seventhRoom.addNearbyRooms("east",8);
//		
//		// 3 deuren naar 5 7 9
//		Room eightRoom = new Room("eight room");
//		eightRoom.addNearbyRooms("north",5);
//		eightRoom.addNearbyRooms("east",9);
//		eightRoom.addNearbyRooms("west",7);
//		
//		// 2 deuren naar 6 8
//		Room ninethRoom = new Room("nineth room");
//		ninethRoom.addNearbyRooms("north",6);
//		ninethRoom.addNearbyRooms("west",8);
//		
//		//2 deuren naar 6 en eind
//		Room tenthRoom = new Room("tenth room");
//		tenthRoom.addNearbyRooms("east",6);
//		tenthRoom.addNearbyRooms("west",1);


	}
	
	private void handleUseCommand(String itemName) {
		
	}
	
	private void handleGetCommand(String itemName) {
		
	}
	
	private boolean checkRoomTravel(String command) {
		boolean result = false;
		return result;
	}
}
