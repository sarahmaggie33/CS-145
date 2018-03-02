package hw1;

import java.util.Scanner;

public class UshSure {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Ticket number? ");
		int ticketnumber = in.nextInt();
		System.out.print("Seats in a row? ");
		int seatsinrow = in.nextInt();
		
		int rownumber = ticketnumber / seatsinrow;
		int columnnumber = ticketnumber % seatsinrow;
		char rowletter = (char)('A' + rownumber);
		
		System.out.print("Seat: ");
		System.out.printf("%s%d%n", rowletter, columnnumber);
		
	}
}
