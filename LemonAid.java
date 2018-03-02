package hw1;
import java.util.Scanner;

public class LemonAid {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("How many parts lemon juice? ");	
		double lemonjuice = in.nextDouble();
		
		System.out.print("How many parts sugar? ");	
		double sugar = in.nextDouble();
		
		System.out.print("How many parts water? ");	
		double water = in.nextDouble();
		
		double totalparts = lemonjuice + sugar + water;
		
		System.out.print("How many cups of lemonade? ");	
		int cups = in.nextInt();
		
//		double proplemon = (lemonjuice / totalparts) * cups;
//		double propsugar = (sugar / totalparts) * cups;
//		double propwater = (water / totalparts) * cups;
		
		System.out.println("Amounts (in cups):");	
		System.out.print("  Lemon juice: ");
		System.out.println((lemonjuice / totalparts) * cups);
		System.out.print("  Sugar: ");
		System.out.println((sugar / totalparts) * cups);
		System.out.print("  Water: ");
		System.out.println((water / totalparts) * cups);

		
	}

}
