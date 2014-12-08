public class Player {
	
	String name = "?"; //Player's name
	int health = 100; //Player's health
	int roomNum = 1; //Starting point
	
	Player(String name){
		this.name = name;
	}
	
	void talkTo(String creature){
		//System.out.println(creature.dialogue()); //Not sure where dialogue needs to go
		//Prompts a question from a character, could have to answer yes or no, or
		//show an object to get them to talk
	}
	
	void attack(String creature, int creatureHealth, int damageValue, int weaponVal){
		int rand = (int) Math.random() * 5 + 1;
		damageValue = rand * weaponVal;
		//Enemy's health goes down by rand (between 1 and 5), multiplied by weapon
		creatureHealth = creatureHealth - damageValue;
		//Fists is 1, Knife is 1.1, Sword is 1.25, etc. 
	}
	
	void getDamaged(String creature){
		int rand = (int) Math.random() * 50 + 1; 
		//Damages between 1 and 50, could change for specific creatures 
		health = health - rand;
	}
	
	//this will be in the item class
/*	String lookAt(String object){
		return object;//.description(); //Returns description of object
		//Must be in the room or inventory
	}
*/	
	//IMPORTANT
	void take(String object){
		
		//Adds object to inventory
		//Must be in same room as character
	}
	
	void open(String object){
		//object.open();
		//Opens door, window, etc. 
		//Must be in same room as character
	}
	
	void use(String object, String withObject){
		//if(inInventory){
		//	object.function();
		//} else {
		//	System.out.println("The object is not in your inventory.");
		//}
		//Takes object stored in inventory
		//Must be in character's inventory, or same room in some cases
	}
	
	//
	void walk(String direction, int roomNum){
		boolean isPossible = true;
		direction.toLowerCase();
		if(direction == "north" && isPossible == true){
			//roomNum++;
		} else if(direction == "south" && isPossible == true) {
			//roomNum--;
		} else if(direction == "east" && isPossible == true) {
			//map[x]++; //Somehow set for east and west
		} else if(direction == "west" && isPossible == true) {
			//map[x]--; //Same as above
		} else {
			System.out.println("That is not a valid direction.");
		}
		//Moves on the x or y axis of the map
	}
	
	void wear(double healthBonus){
		//healthBonus must be a double between 1 and 2
		if(health > 100){
			health = (int) (100 * healthBonus);
		} else {
			health = (int) (health * healthBonus);
		}
	}
	
	public String toString(){
		String s = String.format("Your name is " + name + ".");
		return s;
	}
}
