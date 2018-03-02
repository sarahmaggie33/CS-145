package objects;

public class Hugs {
	private final int nEnd;
	private int nMatches;
	
	public Hugs(int nMatches) {
		this.nEnd = nMatches;
		this.nMatches = 0;
		
	}
	
	public boolean tick() {
		nMatches++;
		return nMatches >= nEnd;
	}
	
	public void reset() {
		nMatches = 0;
	}
	
	
	
}
