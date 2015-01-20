//package random;

import java.util.Scanner;
import java.util.HashMap; 
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

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

		System.out.println("So here is what happened: I was in Hollywood filming a moive called the \"The Independence Day 2\". I was asked to put on this teleport device as a prop. The last thing I remember is that a flash of light came through and I'm here in this weird not-Earth place. I think I'm in a building right now.");
		keyb.nextLine();
		System.out.println("Let me see.. There's a notebook on the table. Oh damn it! It's in some weird language!");
		keyb.nextLine();
		System.out.println("But the notebook likes tasty! Maybe I should eat it!");
		keyb.nextLine();
		System.out.println("Type in \"pick up\" return, and then type in \"notebook\" to pick the notebook up! Once you pick it up, use \"consume\" return \"notebook\" to eat it!");
		




		//commands kicks in
		System.out.println(map.getRoomByIndex(smith.roomNum).ld); //get the current room's long describtion

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
					"to a random room in the map \n inventory: view inventory contents \n look: look around a room \n forge: you can only forge at certain locations.");
					
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
					if(smith.roomNum==10){ // you can only forge in the forge room!
						if(smith.hasItem("time watch")){ //plot
							smith.consume(this, "forge consume");
							smith.addItem("vortex watch", "Very dashing Hollywood watch", 0, "It taste like the melancholy of never be able to go home.");
						}else{
							System.out.println("You have nothing to forge, sir!"); 
						}
					}else{
						System.out.println("What are you talking about?"); 
					}
					break;

				case "pick up": //picking up objects, not classes or girls 
					System.out.print("Pick what up: ");
					smith.pickUp(map,keyb.nextLine().toLowerCase());
					break;
				case "consume": //that's the proper way to drop a item
					System.out.print("Consume what: ");
					smith.consume(this, keyb.nextLine().toLowerCase());
					break;
				case "i": // alright, Mr Harwood
				case "inventory":
					smith.displayInventory();
					break;
				case "look":
					map.getRoomByIndex(smith.roomNum).look();
					break;
				case "suicide": //a good way to end a boring game
					smith.suicide(this);
					
					//isPlaying=false;
					break;
				case "ayy lmao": //#random
					smith.energy=10000;
					System.out.println("Welcome to God/Alien Mode");
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
					smith.energy=10000;
					smith.addItem("time watch", "Very dashing Hollywood watch", 0, "It taste like the melancholy of never be able to go home.");
					smith.roomNum=11;
					break;


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

