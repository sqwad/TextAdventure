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
				
		r = new Room(3,"Office3","You are in a smelly office. There is an exit to the W, and there's an elevator to the E",
				0,0,11,5,0,0,false,0);
		r.items.add(new Item("pen","this is the most powerful weapon in the world", 100, "Mmmm... Inky!"));
		roomMap.add(r);
				
		r = new Room(4,"Office4","You are in a lolly office. There is an exit to the E.",
				0,0,5,0,0,0,false,0);
		r.items.add(new Item("keyboard","this can be used as a keyboard or a kayboard", 7, "Yum! Crunchy KEY Lime flavour!"));
		roomMap.add(r);
				
		r = new Room(5,"Broad Room/Way","You are in a rotfy boardroom. There are exits in all directions!",
				1,2,3,4,0,6,false,0);
		r.items.add(new Item("keyboard","this can be used as a keyboard or a keyboard", 7, "Mmmm... Alphapet Soup flavour!"));
		r.items.add(new Item("notebook","this is a compliment product of pens", 2, "Wow! Once I eat it, I can understand what the notebook trying to say here! Okay, so: \"Welcome to the Wacky World Company. This is a note that is left by the developers, Joey McCauley, Parker Sweet-Boulay, and Blarry Wang, which is not suppose to be in here. But anyways, type \"help\" to see all the commands you can do. And you need to find a way back to Hollywood.. Good luck..\""));
		roomMap.add(r);
		
		r = new Room(6, "Break Room", "You are in a pally break room. There is a button stuck to the table!",
				0,0,0,0,0,7,true,10);
		r.items.add(new Item("sword","this is a powerful nine sword", 9, "That felt interesting."));
		//r.items.add(new Item("Sword","this is a powerful elven sword", 10));
		roomMap.add(r);
		
		r = new Room(7, "IT Room", "A dark basement room. There is a red door to the west which you shouldn't open. The room saids FORGE is to the E",
				0,0,10,8,6,0,false,0);
		r.items.add(new Item("sword","this is a powerful nine sword", 9, "That felt interesting."));
		roomMap.add(r);
		
		r = new Room(8, "Server Room", "A room with a box with lots of lights and buttons. All the data is storaged in the server. There is " +
		"a man who looks like a vampire, his name is Richmond.", 0,9,7,0,0,0, true, 5);
		r.items.add(new Item("richmond", "this is a man who looks like a vampire", 1, "You disgust me, you cannibal."));
		r.items.add(new Item("server", "Produced by IBM, god-like quanlity", 1, "Oh the formula! It's w=a*(c+k^y)!!"));
		roomMap.add(r);
		
		r = new Room(9, "Invention Room", "A glass case saying 'Newest Prototype: Time Watch' is on the table.",8,0,0,0,0,0, false, 0);
		r.items.add(new Item("time watch", "I think I can use this to teleport in a new dimension",10, "Great. Now you're never going to get home."));
		roomMap.add(r);
		
		r = new Room(10, "Forge Room", "It's so hot here!",0,0,7,0,0,0, false,0);
		roomMap.add(r);

		//Elevators

		r = new Room(11, "Elevator", "Alright, seems I can only go up.",0,0,0,3,12,0, false,0);
		roomMap.add(r);
		
		r = new Room(12, "Elevator", "Level 3: Up or down. The door is to the W.",0,0,0,16,13,11, false,0);
		roomMap.add(r);

		r = new Room(13, "Elevator", "Level 4: Up or down. The door is to the W.",0,0,0,20,14,12, false,0);
		roomMap.add(r);

		r = new Room(14, "Elevator", "Level 5: Up or down. The door is to the W.",0,0,0,21,15,13, false,0);
		roomMap.add(r);

		r = new Room(15, "Elevator", "Level 6: Up or down. The door is to the W.",0,0,0,22,16,14, false,0);
		roomMap.add(r);

		r = new Room(16, "Elevator", "Level 7: Up or down. The door is to the W.",0,0,0,23,0,15, false,0);
		roomMap.add(r);


		//level 3
		r = new Room(17, "Bathroom", "You can wash your hand here. Oh, there's a female sign on the door to N, male sign to the W. Elevator to the E.",18,0,12,19,0,0, false,0); //level 3
		r.items.add(new Item("tap","Awesome tap. Rate: 10/10!", 1, "The tap very hard to chew."));
		r.items.add(new Item("soap","A very slippery object.", 1, "The words on the soap says Dove."));
		roomMap.add(r);

		r = new Room(18, "Female Bathroom", "Oh smelly. The only door is to the S.",0,17,0,0,0,0, false,0); //level 3
		r.items.add(new Item("jennifer","A lady trying to open the door.", 3, "Oh I heard someone screaming. Oh damn, it's Jennifer!"));
		roomMap.add(r);

		r = new Room(19, "Male Bathroom", "Do people ever clean up the bathrooms here? The only door is to the E.",0,0,17,0,0,0, false,0); //level 4
		r.items.add(new Item("ben","A gentleman trying to open the door.", 1, "He was thinking about someone called Richmond at the basement."));
		roomMap.add(r);

		//level 4
		r = new Room(20, "Caf", "Food, lots of food. No exits other than the elevator to the E.",0,0,13,0,0,0, false,0); //level 5
		r.items.add(new Item("cupcake","A very good cupcake with coffee beans on it.", 40, "I think it tastes like...nostalgia. :("));
		r.items.add(new Item("magic cookie bar","Cookies with lots of chocolate chips.", 60, "Sweet and amazing!"));
		r.items.add(new Item("champagne","Gentlemen's must-haves.", 10, "Oh no, I'm so tipsy."));
		r.items.add(new Item("lu rou fan","The best rice exists on this planet! ...I meant Earth.", 80, "It's awesome!. Learn more about Lou Rou Fan, please visit: http://www.seriouseats.com/2013/07/taiwanese-meat-sauce-with-rice-recipe.html"));
		roomMap.add(r);

		//level 5
		r = new Room(21, "File Room", "Files, lots of files. No exits other than the elevator to the E.",0,0,14,0,0,0, false,0); //level 6
		r.items.add(new Item("investion documents","An old document book with dust on it.", 0, "It saids the following:\n\t \"The Vortex Watch\" concept invented by Dr Dundas is only feasiable when you can teleport in space and time at the same time. Therefore, a \"Time Watch\" was invented by him to travel through time. But he can never get to invent a device that can teleport through space."));
		r.items.add(new Item("storage list","Seems like a list of all the stoarge info on it.", 1, "\nStorage list: \n\tPencils\t--- Level 2 Offices \n\tNotebooks\t--- Level 2 Offices \n\tKeyboard\t--- Level 2 Offices \n\tSwords\t--- Level 1 Breakrooms \n\t\t--- Basement IT Rooms \n\tInventions\t--- Check with the boss, Clipy, plz."));
		r.items.add(new Item("employee list","Holy, what a heavy book!", 10, "Okay, the highlighted part says: Richmond Felicity Avenal\t--- Server Keeper \n\tJennifer Glee\t--- Door Opener \n\tBen Glee\t--- Door Opener \n\tDr Dundas\t--- Inventor"));
		r.items.add(new Item("hollywood","Wait, they have Hollywood too?.", 0, "\"You have to rush upstairs now!\""));
		roomMap.add(r);

		//level 6
		r = new Room(22, "Balcony", "It's very windy here. No exits other than the elevator to the E.",0,0,15,0,0,0, false,0); //level 7
		r.items.add(new Item("dr dundas","A gentleman smoking cigar at the balcony.", 1, "He is thinking a formula: hmmm, w=a*(...^y)? Whaaaa? Apparently it's related to the vortex thing hmmm..."));
		roomMap.add(r);

		//level 7
		r = new Room(23, "Boss Room", "There's a painting of the boss on the wall. No exits other than the elevator to the E.",0,0,16,0,0,0, false,0); //level 3
		r.items.add(new Item("denholm reynholm","A cool man sitting on his chair talking to his computer.", 1, "The time watch is at...invention room! Wait, forge? Forge space and time...connection lost!"));
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

