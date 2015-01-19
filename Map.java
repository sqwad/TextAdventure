//package random;
import java.util.*;
public class Map {
	
	private List<Room> roomMap = new ArrayList<Room>();
	
	private void initroomMap(){
		Room r;
		
		r = new Room(1,"Office1","You are in a dirty office. There is an exit to the S.",
				0,5,0,0,0,0,false,0); 
		r.items.add(new Item("sword","this is a powerful elven sword", 10, "Ow, that's going to be a bad one in the bathroom later."));
		roomMap.add(r);
				
		r = new Room(2,"Office2","You are in an awesome office. There is an exit to the N.",
				5,0,0,0,0,0,false,0);
		r.items.add(new Item("knife","this is a very sharp knife", 2, "Ouch! Gotta love the taste of internal bleeding."));
		roomMap.add(r);
				
		r = new Room(3,"Office3","You are in a smelly office. There is an exit to the W.",
				0,0,0,5,0,0,false,0);
		r.items.add(new Item("pen","this is the most powerful weapon in the world", 100, "Mmmm... Inky!"));
		roomMap.add(r);
				
		r = new Room(4,"Office4","You are in a lolly office. There is an exit to the E.",
				0,0,5,0,0,0,false,0);
		r.items.add(new Item("keyboard","this can be used as a keyboard or a kayboard", 7, "Yum! Crunchy KEY Lime flavour!"));
		roomMap.add(r);
				
		r = new Room(5,"Boardroom","You are in a rotfy boardroom. There are exits in all directions!",
				1,2,3,4,0,6,false,0);
		r.items.add(new Item("keyboard","this can be used as a keyboard or a keyboard", 7, "Mmmm... Alphapet Soup flavour!"));
		r.items.add(new Item("notebook","this is a compliment product of pens", 2, "The ink-slewn paper is mouth-watering."));
		roomMap.add(r);
		
		r = new Room(6, "Break Room", "You are in a pally break room. There is a button stuck to the table!",
				0,0,0,0,0,7,true,10);
		r.items.add(new Item("sword","this is a powerful nine sword", 9, "That felt interesting."));
		//r.items.add(new Item("Sword","this is a powerful elven sword", 10));
		roomMap.add(r);
		
		r = new Room(7, "IT Room", "A dark basement room. There is a red door to the west which you shouldn't open.",
				0,0,0,8,0,0,false,0);
		r.items.add(new Item("sword","this is a powerful nine sword", 9, "That felt interesting."));
		roomMap.add(r);
		
		r = new Room(8, "Server Room", "A room with a box with lots of lights and buttons. There is " +
		"a man who looks like a vampire, his name is Richmond.", 0,9,7,0,0,0, true, 5);
		r.items.add(new Item("richmond", "this is a man who looks like a vampire", 1, "You disgust me, you cannibal."));
		roomMap.add(r);
		
		r = new Room(9, "Invention Room", "A glass case saying 'Newest Prototype: TeleWatch' is on the table.",8,0,0,0,0,0, false, 0);
		r.items.add(new Item("timewatch", "I think I can use this to teleport in a new dimension",10, "Great. Now you're never going to get home."));
		roomMap.add(r);
		
		r = new Room(10, "Hollywood", "You are back home, a beautiful place on earth where Wacky Worlds don't exsist. People are staring" + 
		"at you because you just appered in the middle of the street with no clothes. You grab someone's Statue of Liberty Towel and run to your house.",0,0,0,0,0,0, false,0);
		roomMap.add(r);
		
		r = new Room(11, "Forge Room", "It's so hot here!",0,0,0,0,0,0, false,0);
		roomMap.add(r);
		
		
	}
	
	/*take sword: 
	- copy all of the item info, and make a new identical item that is added to the inventory
	- delete item from room	
	Drop sword:
	- make a copy, put the copy into the current room
	- delete the sword item from the inventory
	*/
	
	Map(){
		initroomMap();
	}


	int mapSize() {
		return roomMap.size();
	}
	
	Room getRoomByIndex(int index){
		for(Room room: roomMap){
			if(room.number==index) return room;
		}
		return null; // null means nothing's there
	}
}

