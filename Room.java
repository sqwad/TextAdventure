import java.util.*;
//Room class
public class Room {
	int number;
	int N, E, S, W, U, D;
	int buttonValue;
	
	// List<Item> items = new ArrayList<Item>();
	List<Item> items = new ArrayList<Item>(); //items in the room
	
	
	String sd, ld;
	boolean hasButton;
	
	
	
	Room(int n, String sd, String ld, int N, int S,int E,int W,int U,int D, boolean hasButton, int buttonValue){
		number = n;
		this.N= N; 
		this.E= E; 
		this.S= S; 
		this.W= W; 
		this.U= U; 
		this.D= D; 
		this.ld= ld; 
		this.sd= sd; 
		this.hasButton=hasButton;
		this.buttonValue=buttonValue;
		//this.isLit=isLit;
		//init items here
	}
	
	void look(){
		System.out.println(ld + "\nHere is a list of all items in the room: ");
		for(Item x: items){
			System.out.println(x.name);
		}
	}
	
	
	// private void initItem(){
		// Items.add(new Item("Sword", 10));
		// Items.add(new Item("Stapler", 2));
		// Items.add(new Item("Newly Sharpened Pencil", 5));
		// Items.add(new Item("Dull Pencil", 4));
		// Items.add(new Item("Holy Grill", 5));
		// Items.add(new Item("Ring", 100));
	// }

	

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
