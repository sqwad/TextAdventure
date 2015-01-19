//package random;

import java.util.Scanner;

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
		boolean status=true; //check if moved, plz refer to line 47
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
			command=keyb.next();
			command = command.toLowerCase();
			switch(command){ // main game is here
				case "help": 
					System.out.println("\nYou can try to type:\n N : walk north \n " +
					"S : walk south \n E : walk east \n W : walk west \n U : climb up \n D : slide down \n " +
					"talkto: talk to a character \n pushbutton: push a button \n checkenergy: check energy points \n " +
					"pickup: pick up an object \n consume: consume an object in your inventory \n teleport: teleport " +
					"to a random room in the map \n inventory: view inventory contents \n look: look around a room\n");
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
				case "pushbutton": smith.pushButton(map.getRoomByIndex(smith.roomNum)); break;
				case "checkenergy": System.out.print(smith.energy+". "); break;
				case "teleport": 
					smith.teleport(map);
					break;
				case "forge":
					if(smith.roomNum==11){
						
					}else{
						System.out.println("NOPE!"); 
					}
					break;
				case "pickup": 
					smith.pickUp(map,keyb.next().toLowerCase());
					break;
				case "consume":
					smith.consume(this, keyb.next().toLowerCase());
					break;
				case "inventory":
					if(smith.inventory.isEmpty()) System.out.println("Your inventory isEmpty().");
					for(Item item: smith.inventory){
						System.out.println(item.name);
					}
					break;
				case "look":
					map.getRoomByIndex(smith.roomNum).look();
					break;
				case "suicide": 
					smith.suicide(this);
					
					//isPlaying=false;
					break;
				case "ayy":
					if(keyb.next().toLowerCase().equals("lmao")){
						smith.energy++;
						System.out.println("Your energy points went up by 1!");
					}else{
						System.out.println("You mean \"ayy lmao\"? 2 late!");
						smith.energy--;	
					}
					break;
				case "talkto":
					System.out.println("You mumble incomprehensible gibberish. They don't understand you.");
					break;
				case "?":
					System.out.println("What?");
					break;
				case "spencersbirthday":
					System.out.println("Happy birthday Spencer!");
					break;
				default:				
					System.out.println("NOPE!"); 
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

