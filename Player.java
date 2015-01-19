//package random;
import java.util.*;
public class Player {
	
	String name = "?"; //Player's name
	int health = 100; //Player's health
	int roomNum = 5; //Current point
	int energy = 30; //BEAST
	
	
	List<Item> inventory = new ArrayList<Item>(); //items in the room
	
	
	
	Player(String name){
		this.name = name;
	}
	/*
	void talkTo(String creature){
		//System.out.println(creature.dialogue()); //Not sure where dialogue needs to go
		//Prompts a question from a character, could have to answer yes or no, or
		//show an object to get them to talk
	}
	*/

	/*
	void putDown(Map map, Item item){
		if(inventory.contains(item)){
			inventory.remove(item);
			map.getRoomByIndex(roomNum).items.add(item);
			System.out.print("You have dropped "+item.name+"!");
			return;
		}
		System.out.print("Hmm something is not right here..");
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
	*/
	//this will be in the item class
/*	String lookAt(String object){
		return object;//.description(); //Returns description of object
		//Must be in the room or inventory
	}
*/	
	//IMPORTANT

	
		
	/*
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
	}*/

	boolean walk(char direction, Room room, Map map){ //return true if moved
		boolean isMoved=false;
		switch(direction){
			case 'n': if(room.N!=0) {roomNum=room.N; isMoved=true; System.out.println(map.getRoomByIndex(roomNum).ld);energy--;} break;
			case 's': if(room.S!=0) {roomNum=room.S; isMoved=true; System.out.println(map.getRoomByIndex(roomNum).ld);energy--;} break;
			case 'w': if(room.W!=0) {roomNum=room.W; isMoved=true; System.out.println(map.getRoomByIndex(roomNum).ld);energy--;} break;
			case 'e': if(room.E!=0) {roomNum=room.E; isMoved=true; System.out.println(map.getRoomByIndex(roomNum).ld);energy--;} break;
			case 'u': if(room.U!=0) {roomNum=room.U; isMoved=true; System.out.println(map.getRoomByIndex(roomNum).ld);energy--;} break;
			case 'd': if(room.D!=0) {roomNum=room.D; isMoved=true; System.out.println(map.getRoomByIndex(roomNum).ld);energy--;} break;
			default: break;
		}
		if(!isMoved){
			System.out.println("You are still at where you are man!");
		}
		return isMoved;
	}

	/*
	void wear(double healthBonus){
		//healthBonus must be a double between 1 and 2
		if(health > 100){
			health = (int) (100 * healthBonus);
		} else {
			health = (int) (health * healthBonus);
		}
	}*/
	
	public String toString(){
		String s = String.format("Your name is " + name + ".");
		return s;
	}

	void teleport(Map map){
		int maxRoom;
		//int z = (int)(Math.random()*(100))+1;
		
		maxRoom=map.mapSize();
		
		
		roomNum=(int)(Math.random()*(maxRoom-1))+1;
		System.out.println(map.getRoomByIndex(roomNum).ld);
		energy-=20; //energy cost
	}
	
	boolean pushButton(Room room){
		if(!room.hasButton) return false;
		System.out.println("You pressed the button! You gain " + room.buttonValue + " energy points!");
		energy += room.buttonValue;
		room.buttonValue=0;
		return true;
	}
	
	 void suicide(UI youDed){ 		
		youDed.isPlaying = false; 	
		System.out.println("YOU ARE DEAD SON!"); 
	}
	
	void pickUp(Map map, String item){
		for(Item itemInRoom: map.getRoomByIndex(roomNum).items){
			if(itemInRoom.name.equals(item)){
				inventory.add(itemInRoom);
				map.getRoomByIndex(roomNum).items.remove(itemInRoom);
				System.out.println("You have picked up "+item+"!"+"\n");
				return;
			}
		}
		System.out.println("You did not pick up any more "+item+"s.\n");
	}
	
	void consume(UI ui, String item){
		for(Item itemInInventory: inventory){
			if(itemInInventory.name.equals(item.toLowerCase())){
				inventory.remove(itemInInventory);
				System.out.println(itemInInventory.td+"\n");
				if(item.toLowerCase().equals("telewatch")){
					System.out.println("Over time, you slowly starve to death...");
					suicide(ui);
				}
				return;
			}
		}
		System.out.println("That item doesn't exist in your inventory.");
	}
}








