package objects;

import java.util.ArrayList;
import java.util.Random;

public class Raffle {

	private ArrayList<String> names;
	private Random generator;
	
	public Raffle() {
		names = new ArrayList<String>();
		generator = new Random();
	}
		
	public void add(String name) {
		if (name.equals("Jill")) {
		names.add(name);
		}
	}
	
	public String draw() {
		return null;
		
	}
	
	
	
	
}
