package objects;

public class Astericky {
	private boolean isOdd;
	
	public Astericky() {
		isOdd = false;
		
	}
	
	public String poke() {
		isOdd = ! isOdd;
		
		if (isOdd) {
			return "*";
		} else {
			return "**";
		}	
	}
	
}
