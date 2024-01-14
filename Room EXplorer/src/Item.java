public class Item {
	private String name;
	private String useText;
	
	public Item(String n_name, String n_useText) {
		this.name = n_name;
		this.useText = n_useText;
	}
	
	public String getName() {
		return name;
	}
	
	public String getUseText() {
		return useText;
	}
	
	//return magic wand art
	public String art() {
		String result = "Oh no Fluffy spawned \n\n";
		result +="	     |\\_/|                  \n";
		result +="	     | O O   Woof! \n";
		result +="	     |   <>              _  \n";
		result +="	     |  _/\\------____ ((| |)) \n";
		result +="	     |               `--' |   \n";
		result +="	 ____|_       ___|   |___.' \n";
		result +="	/_/_____/____/_______| \n" ;
		return result;
	}
}
