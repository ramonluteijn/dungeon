import java.util.Scanner;

public class Game {
	
	private Scanner scanner;
	private Player player;
	private Room currentRoom;
	
	public Game() {
		scanner = new Scanner(System.in);
		player = new Player();
	}
	
	public void play() {
		boolean keepPlaying = true;
//		System.out.println("insert name");
//		player.setName();
		setUpRooms();
		String command = "?";
//		currentRoom.art();
	
		while(keepPlaying) {
			System.out.println("insert command");
			handleCommand(scanner.nextLine());	
			// play again 
//			System.out.println("want to play again? (y/n)");
//			if(player.getPlayAgain().equals("n")) {
//				keepPlaying = false;
//				break;
//			}
//			else if (player.getPlayAgain().equals("y")) {
//				keepPlaying = true;
//			}
//			else {
//				System.out.println("geen juiste input");
//			}
//			keepPlaying = false;
		}
	}
	
	// user commands
	private void handleCommand(String userInput) {
	    String str = userInput;
	    String[] arrOfStr = str.split(" ");
	    String input = "?";
	    String command = "?";
	    if(arrOfStr.length >1) {
	    	input = arrOfStr[1];
	    }
	    command = arrOfStr[0];
		switch(command) {
			case "map":
						System.out.println(currentRoom.getMini());
				break;
			case "go":  
					if(currentRoom.goRoom(input) == null) {
						System.out.println("cannot go this way \n");
					}
					else {
						currentRoom = currentRoom.goRoom(input);
						System.out.println("travel to the "+currentRoom.getName()+" succesful \n");
					}
				break;
			case "use": 
					player.removeItem(input);
					System.out.println("item is used");
				break;
			case "get":
					if(currentRoom.getItem(input) != null) {
						player.addItem(currentRoom.getItem(input));
						currentRoom.removeItem(input);
						System.out.println("added to backpack \n");
					}
					else {
						System.out.println("doesnt excist \n");
					}
				break;
			case "drop":
					if(player.getItem(input) != null) {
						currentRoom.addItem(player.getItem(input));
						player.removeItem(input);
						System.out.println("removed from backpack \n");
					}
					else {
						System.out.println("Not in backpack");
						System.out.println("Use the following command: backpack");
					}
					break;
			case "look":
					 System.out.println(currentRoom.getName()+" possibilities: ");
					 System.out.println(currentRoom.getMap());	
				break;
			case "help":
				// print commands
					System.out.println("go [direction]: north, east, south, west");
					System.out.println("use [item]: the item you want to use");
					System.out.println("get [item]: pick the item up from the room");
					System.out.println("drop [item]: drop item in the current room");
					System.out.println("look: look around in the room");
					System.out.println("pack: shows everything in your backpack \n");
				break;
			case "pack":
				System.out.println(player.backPack());
				break;
		}
	}
	
	//create rooms
	private void setUpRooms() {
		Room firstRoom = new Room("first room");
		currentRoom = firstRoom;
		Room secondRoom = new Room("second room");
		Room thirdRoom = new Room("third room");
		Room fourthRoom = new Room("fourth room");
		Room fifthRoom = new Room("fifth room");
		Room sixthRoom = new Room("sixth room");
		Room seventhRoom = new Room("seventh room");
		Room eightRoom = new Room("eight room");
		Room ninethRoom = new Room("nineth room");
		Room tenthRoom = new Room("tenth room");
		Item torch = new Item("torch", "you can see");
		Item key = new Item("key", "unlock a door");
		Item sword = new Item("sword", "shank");
		Item magicWand = new Item("magic wand", "use the weapon of a god"); // item of a god to add fluffy
		Item stick = new Item("stick", "just a stick");
			
		firstRoom.addNearbyRooms("east",secondRoom);
		firstRoom.addNearbyRooms("south",fourthRoom);
		firstRoom.addItem(torch);
		
		secondRoom.addNearbyRooms("west",firstRoom);
		secondRoom.addNearbyRooms("east",thirdRoom);
		secondRoom.addNearbyRooms("south",fifthRoom);
		secondRoom.addItem(sword);
		
		thirdRoom.addNearbyRooms("west",secondRoom);
		thirdRoom.addNearbyRooms("south",sixthRoom);
		thirdRoom.addItem(stick);
	
		fourthRoom.addNearbyRooms("north",firstRoom);
		fourthRoom.addNearbyRooms("east",fifthRoom);
		fourthRoom.addNearbyRooms("south",seventhRoom);

		fifthRoom.addNearbyRooms("north",secondRoom);
		fifthRoom.addNearbyRooms("west",sixthRoom);
		fifthRoom.addNearbyRooms("east",fourthRoom);
		fifthRoom.addNearbyRooms("south",eightRoom);
		
		sixthRoom.addNearbyRooms("north",thirdRoom);
		sixthRoom.addNearbyRooms("west",fifthRoom);
		sixthRoom.addNearbyRooms("east",tenthRoom);
		sixthRoom.addNearbyRooms("south",ninethRoom);
		
		seventhRoom.addNearbyRooms("north",fourthRoom);
		seventhRoom.addNearbyRooms("east",eightRoom);
		seventhRoom.addItem(key);
		
		eightRoom.addNearbyRooms("north",fifthRoom);
		eightRoom.addNearbyRooms("east",ninethRoom);
		eightRoom.addNearbyRooms("west",seventhRoom);
		
		ninethRoom.addNearbyRooms("north",sixthRoom);
		ninethRoom.addNearbyRooms("west",eightRoom);
		
		tenthRoom.addNearbyRooms("east",sixthRoom);
		tenthRoom.addNearbyRooms("west",firstRoom);
		tenthRoom.addItem(magicWand);
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
