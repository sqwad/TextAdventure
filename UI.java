//package random;

import java.util.Scanner;
import java.util.HashMap; 

public class UI {

	
	Player smith;
	Map map;
	Scanner keyb; 
	boolean isPlaying;
	
	void initUI(){ //init varibles here
		smith = new Player("Will Smith");
		map = new Map();
		keyb=new Scanner(System.in);
		isPlaying = true;
		
	}

	void display(){
		initUI();
		//debug
			//System.out.print(smith.teleport(map));
			
		//end debug
		
		String command;
		HashMap<String, String> dictionary = new HashMap<String, String>();





		System.out.println(""); // add a new line
		System.out.println("Welcome to Will Smith's Wacky World!");
		System.out.println("HINT: You are "+smith.name+"!");
		System.out.println(map.getRoomByIndex(smith.roomNum).ld); //get the current room's long describtion

		//commands kicks in
		System.out.println("Try to type in commands to walk around!");

		while(isPlaying == true){
			if(smith.energy<=0) {
				smith.suicide(this);
				break;
			}
			System.out.println(""); // add a new line
			System.out.print(smith.name+": "); // cool input line
			command=keyb.nextLine();
			command = command.toLowerCase();
			switch(command){ // main game is here
				case "help": 
					System.out.println("\nYou can try to type:\n N : walk north \n " +
					"S : walk south \n E : walk east \n W : walk west \n U : climb up \n D : slide down \n " +
					"talk to: talk to a character \n push button: push a button \n check energy: check energy points \n " +
					"pick up: pick up an object \n consume: consume an object in your inventory \n teleport: teleport " +
					"to a random room in the map \n inventory: view inventory contents \n look: look around a room");
					
					for(String key: dictionary.keySet()){  // takes all the dictionary words to the help
						System.out.print(" "+key+": Say \""+dictionary.get(key)+"\" back \n");
					}

					break;

				case "n":
				case "north":
				case "south":
				case "east":
				case "west":
				case "up":
				case "down":
				case "s": 
				case "w": 
				case "e": 
				case "u": 
				case "d": 					
					smith.walk(command.charAt(0), map.getRoomByIndex(smith.roomNum), map);
					break;
				case "push button": smith.pushButton(map.getRoomByIndex(smith.roomNum)); break;
				case "check energy": System.out.print(smith.energy+". "); break;
				case "teleport": 
					smith.teleport(map);
					break;
				case "forge":
					if(smith.roomNum==11){
						
					}else{
						System.out.println("What are you talking about?"); 
					}
					break;
				case "pick up": //picking up objects, not classes or girls 
					smith.pickUp(map,keyb.next().toLowerCase());
					break;
				case "consume": //that's the proper way to drop a item
					smith.consume(this, keyb.next().toLowerCase());
					break;
				case "i": // alright, Mr Harwood
				case "inventory":
					if(smith.inventory.isEmpty()) System.out.println("Your inventory isEmpty().");
					for(Item item: smith.inventory){
						System.out.println(item.name);
					}
					break;
				case "look":
					map.getRoomByIndex(smith.roomNum).look();
					break;
				case "suicide": //a good way to end a boring game
					smith.suicide(this);
					
					//isPlaying=false;
					break;
				case "ayy lmao": //#random
					smith.energy++;
					System.out.println("Your energy points went up by 1!");
					break;
				case "talk to":
					System.out.println("You mumble incomprehensible gibberish. They don't understand you.");
					break;
				case "?":
					System.out.println("What?");
					break;
				case "spencer's birthday":
					System.out.println("Happy birthday Spencer!");
					break;
				case "debug":
					System.out.println("Debug mode is on");
					while(true){
						System.out.println("Input: ");
						command=keyb.nextLine();
						System.out.println(command);
					}
				default:
					if(dictionary.get(command)!=null){
						System.out.println(dictionary.get(command));
					}else{
						System.out.print("Alright, teach me what should I say: "); 
						dictionary.put(command, keyb.nextLine());
					}
					break;
			}
			
			if(isPlaying==false){
				break;
			} 
			
			
		}
	}
	
	public static void main(String[] args){
		new UI().display(); // deal with static
	}
}

