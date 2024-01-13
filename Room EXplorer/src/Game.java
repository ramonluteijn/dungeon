import java.util.Scanner;

public class Game {
	
	private Scanner scanner;
	private Player player;
	private Room currentRoom;
	private boolean keepPlaying;
	private boolean torchUsed = false;
	
	public Game() {
		scanner = new Scanner(System.in);
		player = new Player();
	}
	
	public void play() {
		keepPlaying = true;
		System.out.println("insert name");
		player.setName();
		setUpRooms();
		System.out.println("type 'help' for commands");
		System.out.println("you are in room number 1 \n");	
		handleCommand("look");
		currentRoom.getName();
		while(keepPlaying) {
			System.out.println("insert command");
			handleCommand(scanner.nextLine());
		}
	}
	
	// user commands
	private void handleCommand(String userInput) {
		String str = userInput;
	    str = str.toLowerCase();
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
					if(player.getItem(input) != null) {
						System.out.println(player.useItem(input));
						if(player.getItemName(input).equals("torch")) {
							torchUsed = true;
						}
						else if(player.getItemName(input).equals("torch")) {
							torchUsed = true;
						}
						
					}	
					else {
						System.out.println("doesnt excist \n");
					}
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
					 if(currentRoom.getName().equals("second room")){
						 // check if player uses torch
						 if(torchUsed) {
							 System.out.println(currentRoom.getMap(false));
						 }
						 else {
							 System.out.println(currentRoom.getMap(true));
							 System.out.println("you can go back");
						 }
					 }
					 else {
						  System.out.println(currentRoom.getMap(false));	
					 }
				break;
			case "help":
				// print commands
					System.out.println("go [direction]: north, east, south, west");
					System.out.println("use [item]: the item you want to use");
					System.out.println("get [item]: pick the item up from the room");
					System.out.println("drop [item]: drop item in the current room");
					System.out.println("look: look around in the room");
					System.out.println("pack: shows everything in your backpack");
					System.out.println("quit: leaves the game");
					System.out.println("map: shows the layout of the game \n");
				break;
			case "pack":
				System.out.println(player.backPack());
				break;
			case "quit":
					keepPlaying = false;
					System.out.println("You quit the game.");
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
		Item key = new Item("key", "unlocked a door");
		Item posion = new Item("posion", "get drunk");
		Item magicWand = new Item("magic-wand", "you used the weapon of a god"); // item of a god to add fluffy
		Item stick = new Item("stick", "just a stick");
			
		firstRoom.addNearbyRooms("east",secondRoom);
		firstRoom.addNearbyRooms("south",fourthRoom);
		firstRoom.addItem(torch);
		firstRoom.addItem(magicWand);

		secondRoom.addNearbyRooms("west",firstRoom);
		secondRoom.addNearbyRooms("east",thirdRoom);
		secondRoom.addNearbyRooms("south",fifthRoom);
		secondRoom.addItem(posion);
		
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
	}
}
