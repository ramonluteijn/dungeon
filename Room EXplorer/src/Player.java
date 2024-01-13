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
	
	//gets the name of the item when used
	public String getItemName(String n_item) {
		for(Item i : item) {
			if(i.getName().equals(n_item)) {
				return i.getName();
			}
		}
		return null;
	}
	
	public String useItem(String n_item) {
		for(Item i : item) {
			if(i.getName().equals(n_item)) {
				if(n_item.equals("magic-wand")) {
					return i.getUseText()+"\n"+i.art();
				}
				return i.getUseText();
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
