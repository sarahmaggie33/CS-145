package hw2;

public class NumberUtilities {
	public static int round10(double number) {
		double dividedByTen = number/10;
		double round = Math.round(dividedByTen);
		double backUp = round * 10.0;
		return (int) backUp;
	}
	
	
	public static int getGameCount(int rounds) {	
		double gamesWinner = Math.pow(2, rounds) - 1;
		return (int) gamesWinner;
	}
	
	
	public static double getFraction(double number) {
		double positive = Math.abs(number);
		double decimal = positive - Math.floor(positive);
		return decimal;
			
		
		
	}
}
