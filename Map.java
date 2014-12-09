//package random;
import java.util.*;
public class Map {
	
	List<Room> Map = new ArrayList<Room>();
	
	void initMap(){
		Map.add(new Room(1,"Office1","You are in a dirty office. There is an exits to N.",
				0,5,0,0,0,0));
		Map.add(new Room(2,"Office2","You are in an awesome office. There is an exits to S.",
				5,0,0,0,0,0));
		Map.add(new Room(3,"Office3","You are in a smelly office. There is an exits to E.",
				0,0,0,5,0,0));
		Map.add(new Room(4,"Office4","You are in a lolly office. There is an exits to W.",
				0,0,5,0,0,0));
		Map.add(new Room(5,"Boardroom","You are in a rotfy boardroom. There are exits to all directions!",
				1,2,3,4,0,0));
	}
	Map(){
		initMap();
	}



	Room getRoomByIndex(int index){
		for(Room room: Map){
			if(room.number==index) return room;
		}
		return null; // null means nothing's there
	}
}

//Room class
class Room {
	int number;
	int N, E, S, W, U, D;
	//List<Item> Map = new ArrayList<Item>(); //2 B Finished
	//Employee owner;
	String sd, ld;
	boolean isLit;
	
	
	Room(int n, String sd, String ld, int N, int S,int E,int W,int U,int D){
		number = n;
		this.N= N; 
		this.E= E; 
		this.S= S; 
		this.W= W; 
		this.U= U; 
		this.D= D; 
		this.ld= ld; 
		this.sd= sd; 
		//this.isLit=isLit;
		//init items here
	}
}
/*
class Corridor {
	 Corridor (int n, String sd, String ld, int e1, int e2){
		number = n; 
		this.ld= ld; 
		this.sd= sd; 
		this.e1=e1;
		this.e2=e2;
		//init items here
	}
	 
	int number;
	int e1, e2;
	int[] room= new int[20]; //connected to 20 rooms
	
	String sd, ld;
	
	//List<Item> Map = new ArrayList<Item>(); //2 B Finished
	
	
	
	
	
}
*/
