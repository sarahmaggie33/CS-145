package hw7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DondeUtilities {

	public static PlacesCache readCSV(File file) throws FileNotFoundException {		
		PlacesCache places = new PlacesCache();

		try {
			Scanner in = new Scanner(file);
			while (in.hasNextLine()) {
				String word = in.nextLine();
				System.out.println(word);
				String[] parts = word.split(Pattern.quote("|"), -1);
				String person = parts[0];
				Place place = places.getPlace(parts[1]);
				place.addPerson(person);
				
			}
			in.close();

		} catch (NoSuchPlaceException e) {
			System.out.println("This place does not exist.");
		}

		return places;
	}

	public static void writeKML(PlacesCache cache, File file) throws IOException, FileNotFoundException {
		String kml = "";
		kml += String.format("%s%n", "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		kml += String.format("%s%n", "<kml xmlns=\"http://www.opengis.net/kml/2.2\">");
		kml += String.format("%s%n", "<Document>");
		kml += String.format("%s%n", "<name>Donde</name>");

		for (int i = 0; i < cache.size(); i++) {
			Place place = cache.get(i);
			kml += String.format("%s%n", place.toKML());
		}
		kml += String.format("%s%n", "</Document>");
		kml += String.format("%s%n", "</kml>");
		BufferedWriter out = new BufferedWriter(new FileWriter(file));
		out.write(kml);
		out.close();

	}

}
