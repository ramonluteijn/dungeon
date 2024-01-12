import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	
//	instance variables 
	private String name;
	private Scanner scanner;
	private	ArrayList<Item> item = new ArrayList<Item>();
	
//	create basic player in constructor
	public Player () {
		scanner = new Scanner(System.in);
		name = "?";
	}
	
////	inputs van wat de speler wilt doen
//	public String getPlayAgain() {
//		String result = "?";
//		result = scanner.nextLine();
//		result = result.toLowerCase();
//		if(result.equals("n")) {
//			return result;
//		}
//		else if(result.equals("y")) {
//			return result;
//		}
//		else {
//			return result;
//		}
//	}
	
	//insert player name
	public void setName() {
		name = scanner.nextLine();	
	}

	//get player name
	public String getName() {
		return name;
	}
	
	//add item to backpack
	public void addItem(Item n_item) {
		item.add(n_item);
	}
	
	//get item from backpack
	public Item getItem(String n_item) {
		for(Item i : item) {
			if(i.getName().equals(n_item)) {
				return i;
			}
		}
		return null;
	}
	
	//show items in backpack
	public String backPack() {
		String result = "Items in backpack: \n";
		if(item != null) {
			for(Item i : item) {
				result += i.getName() + "\n";
			}
		}
		return result;
	}
	
	// delete item from backpack
	public void removeItem(String n_item) {
		for(Item i : item) {
			if(i.getName().equals(n_item)) {
				item.remove(i);	
				break;
			}
		}
	}
		
}
