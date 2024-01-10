import java.util.Scanner;

public class Player {
	
//	instance variables 
	private String name;
	private Scanner scanner;
	
//	create basic player in constructor
	public Player () {
		scanner = new Scanner(System.in);
		name = "?";
	}
	
//	inputs van wat de speler wilt doen
	public String getInput() {
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
	
	public void setName() {
		name = scanner.nextLine();	
	}
	
	public String getName() {
		return name;
	}
}
