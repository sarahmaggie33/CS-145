package hw3;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Trutilities {
	
	public static boolean isOrdered(int a, int b, int c, int d, int e) {
		return (a <= b && b <= c && c <= d && d <= e) || (a >= b && b >= c && c >= d && d >= e);
	}
	
	public static boolean isGreenish(String hex) {
		String red = hex.substring(1, 3);
		String green = hex.substring(3, 5);
		String blue = hex.substring(5, 7);
		int r = Integer.parseInt(red, 16);
		int g = Integer.parseInt(green, 16);
		int b = Integer.parseInt(blue, 16);
		return r < g && b < g;
	}
	
	public static boolean isMilitary(String time) {
		String hours = time.substring(0, 2);		
		String minutes = time.substring(2);
		int hh = Integer.parseInt(hours);
		int mm = Integer.parseInt(minutes);
		
		return hh <= 23 && mm <= 59;
	}
	
	public static boolean isImage(File file) {
		String fileString = file.toString();
		int period = fileString.lastIndexOf('.');
		String extension = fileString.substring(period +1);
		String extensionToLowercase = extension.toLowerCase();
		return extensionToLowercase.equalsIgnoreCase("png") || extensionToLowercase.equals("gif") || extensionToLowercase.equals("jpg") || extensionToLowercase.equals("jpeg");
	}
	
	public static boolean hasMultipleDots(String text) {
		int firstDot = text.indexOf('.') + 1;
		String partOne = text.substring(0, firstDot);
		String partTwo = text.substring(firstDot);
		return partOne.contains(".") & partTwo.contains(".");
	}
	
	public static boolean fitsAspect(int width, int height, double ratio) {
		double target = width / (double) height;
		double diffTtoR = Math.abs(target - ratio);
		return diffTtoR < 0.001;
	}
	
	public static boolean fitsWithin(int widthA, int heightA, int widthB, int heightB) {
		return (widthA <= widthB && heightA <= heightB) || (heightA <= widthB && widthA <= heightB);
	}
	
	public static boolean isFaster(String timeA, String timeB) {
		int indexColonA = timeA.indexOf(':');
		String timeAhours = timeA.substring(0, indexColonA);
		String timeAmins = timeA.substring(indexColonA + 1);

		int indexColonB = timeB.indexOf(':');
		String timeBhours = timeB.substring(0, indexColonB);
		String timeBmins = timeB.substring(indexColonB + 1);

		int Ahours = Integer.parseInt(timeAhours);
		int hoursToMinutesA = 60 * Ahours;
		int Amins = Integer.parseInt(timeAmins);
		int aTimeTotalMinutes = hoursToMinutesA + Amins;

		int Bhours = Integer.parseInt(timeBhours);
		int hoursToMinutesB = 60 * Bhours;
		int Bmins = Integer.parseInt(timeBmins);
		int bTimeTotalMinutes = hoursToMinutesB + Bmins;

		return aTimeTotalMinutes < bTimeTotalMinutes;
	}
	
	public static boolean isIllegal(String direction) {
		return !direction.equalsIgnoreCase("north") && !direction.equalsIgnoreCase("south") && !direction.equalsIgnoreCase("east") && !direction.equalsIgnoreCase("west");
	}
	
	public static boolean isOld(File file, int year, int month, int day) {
		long timeModified = file.lastModified();
		Calendar cal = new GregorianCalendar(year, month - 1 , day);
		long todayDate = cal.getTimeInMillis();
		return todayDate >= timeModified;

	}
		
}
