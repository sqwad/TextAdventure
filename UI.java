import java.util.Scanner;



public class UI {

	Player smith;
	Map map;
	Scanner keyb;



	void initUI(){ //init varibles here
		smith = new Player("Will Smith");
		map = new Map();
		keyb=new Scanner(System.in);
	}

	void display(){
		initUI();
		String command;
		boolean status=true; //check if moved, plz refer to line 47
		System.out.println(""); // add a new line

		System.out.println("Welcome, "+smith.name+"!");
		System.out.println(map.getRoomByIndex(smith.roomNum).ld); //get the current room's long describtion

		//commands kicks in
		System.out.println("Try to type in commands to walk around!");

		while(true){
			System.out.println(""); // add a new line
			System.out.print(smith.name+": "); // cool input line
			command=keyb.next();

			switch(command.toLowerCase()){ // main game is here
				case "help": System.out.println("\nYou can try to type:\n N : walk north \n S : walk south \n E : walk east \n W : walk west \n U : climb up \n D : slide down \n ");break;
				case "n": status=smith.walk('n', map.getRoomByIndex(smith.roomNum)); break;
				case "s": status=smith.walk('s', map.getRoomByIndex(smith.roomNum)); break;
				case "w": status=smith.walk('w', map.getRoomByIndex(smith.roomNum)); break;
				case "e": status=smith.walk('e', map.getRoomByIndex(smith.roomNum)); break;
				case "u": status=smith.walk('u', map.getRoomByIndex(smith.roomNum)); break;
				case "d": status=smith.walk('d', map.getRoomByIndex(smith.roomNum)); break;
				default: status=false; System.out.println("NOPE!"); break;
			}

			if(status){ //check if moved
				System.out.println(map.getRoomByIndex(smith.roomNum).ld);
			}else{
				System.out.println("You are still at where you are man!");
			}
			status=true;
		}
	}




	public static void main(String[] args){
		new UI().display(); // deal with static
	}
}
