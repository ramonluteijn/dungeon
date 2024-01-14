import java.util.Scanner;

public class Game {
	
	private Scanner scanner;
	private Player player;
	private Room currentRoom;
	private Room tenthRoomnr;
	private Room firstRoomnr;
	private boolean keepPlaying;
	private boolean torchUsed = false;
	private boolean pickaxeUsed = false;
	private boolean keyUsed = false;
	private boolean stickUsed = false;
	
	public Game() {
		scanner = new Scanner(System.in);
		player = new Player();
	}
	
	//play game
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
					if(currentRoom.getName().equals("tenth room")) {
						if(input.equals("east")) {
							System.out.println(player.getName()+"\n, you finished the game");
							keepPlaying = false;
						}		
					}
					else {
						currentRoom = currentRoom.goRoom(input);
						System.out.println("travel to the "+currentRoom.getName()+" succesful \n");
					}				
				}
				break;
			case "use": 
					if(player.getItem(input) != null) {
						System.out.println(player.useItem(input));
						if(player.getItemName(input).equals("torch")) {
							torchUsed = true;
						}
						//break wall to last room open
						else if(player.getItemName(input).equals("pickaxe")) {
							
							if(currentRoom.getName().equals("sixth room")) {
								pickaxeUsed = true;
								 if(pickaxeUsed) {
									 currentRoom.addNearbyRooms("east",tenthRoomnr);
									 System.out.println("You opent up a wall to the end, type look to see which way");
								 }
							}
							else {
								System.out.println("these walls are not weak enough to be broken down, \nlook for a weaker wall\n");
							}
						}
						
						// end gane
						else if(player.getItemName(input).equals("key")) {
							if(currentRoom.getName().equals("tenth room")) {
								keyUsed = true;
								if(keyUsed) {
									currentRoom.addNearbyRooms("east",firstRoomnr);
								}
							}
							else {
								System.out.println("look for a door\n");
							}
						}
						else if(player.getItemName(input).equals("stick")) {
							stickUsed = true;
							if(stickUsed) {
								System.out.println(player.useItem("stick"));
								player.addItem(player.getItem("stick"));
								
							}
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
						System.out.println("Use the following command the look in your backpack: pack");
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
					 else if(currentRoom.getName().equals("sixth room")) {
						 if(!pickaxeUsed) {
							  System.out.println(currentRoom.getMap(false));
							  System.out.println("the east wall looks different, \nmaybe i can break it with a PICKAXE");
						 }
						 else {
							  System.out.println(currentRoom.getMap(false));	
						 } 
					 }
					 else if(currentRoom.getName().equals("tenth room")) {
						 if(!keyUsed) {
							 System.out.println(currentRoom.getMap(false));
							 System.out.println("there is a door, \nmaybe i can open it with a KEY");
						 }
						 else {
							  System.out.println(currentRoom.getMap(false));	
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
		firstRoomnr = firstRoom; 
		Room secondRoom = new Room("second room");
		Room thirdRoom = new Room("third room");
		Room fourthRoom = new Room("fourth room");
		Room fifthRoom = new Room("fifth room");
		Room sixthRoom = new Room("sixth room");
		Room seventhRoom = new Room("seventh room");
		Room eightRoom = new Room("eight room");
		Room ninethRoom = new Room("nineth room");
		Room tenthRoom = new Room("tenth room");
		tenthRoomnr = tenthRoom;
		Item torch = new Item("torch", "you can see");
		Item key = new Item("key", "unlocked a door");
		Item pickaxe = new Item("pickaxe", "you broke the wall");
		Item magicWand = new Item("magic-wand", "you used the weapon of a god");
		Item stick = new Item("stick", "you used a stick to break a wall...\nyour stick broke... \nyou now have 2 smaller sticks\n");
			
		firstRoom.addNearbyRooms("east",secondRoom);
		firstRoom.addNearbyRooms("south",fourthRoom);
		
		firstRoom.addItem(torch);
		firstRoom.addItem(magicWand);
		firstRoom.addItem(pickaxe);
		firstRoom.addItem(stick);
		firstRoom.addItem(key);
		
		secondRoom.addNearbyRooms("west",firstRoom);
		secondRoom.addNearbyRooms("east",thirdRoom);
		secondRoom.addNearbyRooms("south",fifthRoom);
		
		
		thirdRoom.addNearbyRooms("west",secondRoom);
		thirdRoom.addNearbyRooms("south",sixthRoom);
		
	
		fourthRoom.addNearbyRooms("north",firstRoom);
		fourthRoom.addNearbyRooms("east",fifthRoom);
		fourthRoom.addNearbyRooms("south",seventhRoom);

		fifthRoom.addNearbyRooms("north",secondRoom);
		fifthRoom.addNearbyRooms("east",sixthRoom);
		fifthRoom.addNearbyRooms("west",fourthRoom);
		fifthRoom.addNearbyRooms("south",eightRoom);
		
		sixthRoom.addNearbyRooms("north",thirdRoom);
		sixthRoom.addNearbyRooms("west",fifthRoom);
		sixthRoom.addNearbyRooms("south",ninethRoom);
		
		seventhRoom.addNearbyRooms("north",fourthRoom);
		seventhRoom.addNearbyRooms("east",eightRoom);
		
		eightRoom.addNearbyRooms("north",fifthRoom);
		eightRoom.addNearbyRooms("east",ninethRoom);
		eightRoom.addNearbyRooms("west",seventhRoom);
		
		ninethRoom.addNearbyRooms("north",sixthRoom);
		ninethRoom.addNearbyRooms("west",eightRoom);
		
		tenthRoom.addNearbyRooms("west",sixthRoom);
	}
}
