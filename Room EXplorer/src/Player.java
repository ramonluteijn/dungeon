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
	
//	inputs van wat de speler wilt doen
	public String getPlayAgain() {
		String result = "?";
		result = scanner.nextLine();
		result = result.toLowerCase();
		if(result.equals("n")) {
			return result;
		}
		else if(result.equals("y")) {
			return result;
		}
		else {
			return result;
		}
	}
	
	//insert player name
	public void setName() {
		name = scanner.nextLine();	
	}

	public String getName() {
		return name;
	}
	
	public void getItem(Item n_item) {
		item.add(n_item);
	}
}
