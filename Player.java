//package random;
import java.util.*;
import java.text.SimpleDateFormat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Player {
	
	String name = "?"; //Player's name
	//int health = 100; //Player's health, not used in the game
	int roomNum = 5; //Current point
	int energy = 30; //BEAST
	Scanner keyb = new Scanner(System.in);
	
	private List<Item> inventory = new ArrayList<Item>(); //items carried by the player 
	
	Player(String name){
		this.name = name;
	}

	void walk(char direction, Room room, Map map){  // move 
		boolean isMoved=false;

		switch(direction){
			case 'n': if(room.N!=0) {roomNum=room.N; isMoved=true; System.out.println(map.getRoomByIndex(roomNum).ld);energy--;} break;  //cost a energy point tp move
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
	}
	

	void teleport(Map map){ //teleport ya into a random room
		int maxRoom;
		String command;
		char getCommand;
		
		if(hasItem("time watch")){


			System.out.println("Would you like to jump in time or space?"); //since you have a time watch, you can jump in time

			command=keyb.next();
			getCommand=command.toLowerCase().charAt(0);
			if(getCommand=='t'){
				Calendar cal = Calendar.getInstance(); //get calendar, the current time. Thanks StackOverflow
		    	cal.getTime();
		    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		    	System.out.println("It's "+sdf.format(cal.getTime())+", yesterday. Strange.");
		    	energy-=20; //energy cost


			}else if(getCommand=='s'){
				maxRoom=map.mapSize();
				roomNum=(int)(Math.random()*(maxRoom))+1;
				System.out.println(map.getRoomByIndex(roomNum).ld);
				energy-=20; //energy cost


			}else{
				System.out.println("Have you been attending Mr Harwood's physics class to understand what time and space are?"); 
			}


		} else if(hasItem("vortex watch")){
			if(getItemByName("vortex watch").powerEnergy==0){
				System.out.println("There's no fomula pluged in.");
				System.out.print("Vortex Teleport Formula: ");
				String formula=keyb.nextLine();
				if(md5(formula).equals("840abcec300e38b42a0bb6ac36e1656f")){
					getItemByName("vortex watch").powerEnergy=100;
					System.out.println("Wait, the Vortex is generated!");

				}else{
					System.out.print("OMG it's the wrong formula! I think the watch is not happy!");
				}

			}else{

				if((int)(Math.random()*4)+1==1){
					System.out.print("BACK ON EARTH!!!");

				}else{
					maxRoom=map.mapSize();
					roomNum=(int)(Math.random()*(maxRoom))+1;
					System.out.println(map.getRoomByIndex(roomNum).ld);
					energy-=20; //energy cost
					System.out.print("****Science is all about failures sometimes.");
				}

			}

		}else{
			maxRoom=map.mapSize();
			roomNum=(int)(Math.random()*(maxRoom))+1;
			System.out.println(map.getRoomByIndex(roomNum).ld);
			energy-=20; //energy cost
		}


		// debug
	}
	
	boolean pushButton(Room room){ //push a button in a room to gain some energy
		if(!room.hasButton) return false;
		System.out.println("You pressed the button! You gain " + room.buttonValue + " energy points!");
		energy += room.buttonValue;
		room.buttonValue=0;
		return true;
	}
	
	 void suicide(UI youDed){	// ehhh, pretty self-explainitory, you know what I meant
		youDed.isPlaying = false; 	//no more playing mate
		System.out.println("YOU ARE DEAD SON!"); 
	}
	
	void pickUp(Map map, String item){ // get a item add to inventory
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
	
	void consume(UI ui, String item){ //destory an item from inventory and display the string in item
		if(item.toLowerCase().equals("forge consume")){  //consume while forging
				inventory.remove(getItemByName("time watch"));
				return;
		}
		for(Item itemInInventory: inventory){
			if(itemInInventory.name.equals(item.toLowerCase())){
				inventory.remove(itemInInventory);
				System.out.println(itemInInventory.td+"\n");
				if(item.toLowerCase().equals("time watch")||item.toLowerCase().equals("vortex watch")){
					System.out.println("Over time, you slowly starve to death...");
					suicide(ui);
				}
				energy+=itemInInventory.powerEnergy;
				return;
			}
		}
		System.out.println("That item doesn't exist in your inventory.");
	}

	Item getItemByName(String itemName){
		for(Item item: inventory){
			if(item.name.equals(itemName)){
				return item;
			}
		}
		return null;
	}


	boolean hasItem(String itemName){
		for(Item item: inventory){
			if(item.name.equals(itemName)){
				return true;
			}
		}
		return false;
	}

	void addItem(String name, String ld, int powerEnergy, String td){
		inventory.add(new Item(name, ld, powerEnergy, td));
	}

	public String toString(){ //no usage
		String s = String.format("Your name is " + name + ".");

		return s;
	}


	void displayInventory(){
		if(inventory.isEmpty()) System.out.println("Your inventory isEmpty().");
			for(Item item: inventory){
				System.out.println(item.name);
		}
	}


	String md5(String password){  //thx internet
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			 md.update(password.getBytes());
 
        	byte byteData[] = md.digest();
 
        	//convert the byte to hex format
        	StringBuffer sb = new StringBuffer();
        	for (int i = 0; i < byteData.length; i++) {
        	 sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        	}
        	return sb.toString();
        }catch(NoSuchAlgorithmException e){

		}
		return "HUH?";
	}
}








