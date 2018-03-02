package hw7;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Place {
	private String name;
	private double latitude;
	private double longitude;
	private String lat;
	private String longer;
	private Set people;
	

	public Place(String name, double latitude, double longitude) {
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		people = new Set();
	}
	
	public Place(String name) throws NoSuchPlaceException {
		this.name = name;
		people = new Set();
		try {URL url = toGeocodeURL();
			String latlong = WebUtilities.slurpURL(url);
			String[] parts = latlong.split(" ");
			lat = parts[0];
			this.latitude = Double.parseDouble(lat);
			longer = parts[1];
			this.longitude = Double.parseDouble(longer);
			}
		catch (Exception e){
			throw new NoSuchPlaceException(name);
		}
		
	}
	
	public void addPerson(String person) {
			people.add(person);
	}
	
	public String toKML() {
		String kml = "";
		kml += String.format("%s%n", "<Placemark>");
		kml += String.format("%s%s%s%n", "<name>", getName(), "</name>");
		kml += String.format("%s%s%s%n", "<description>", people.toString(), "</description>");
		kml += String.format("%s%.2f%s%.2f%s%n", "<Point><coordinates>", getLongitude(), ",", getLatitude(), "</coordinates></Point>");
		kml += String.format("%s", "</Placemark>");
		return kml;
	}
	
	public String getName() {
		return this.name;
		
	}
	public double getLatitude() {
		return this.latitude;
	}
	public double getLongitude() {
		return this.longitude;
	}
	
	public URL toGeocodeURL() throws MalformedURLException, URISyntaxException {
		String scheme = "http";
		String authority = "www.twodee.org";
		String path = "/teaching/cs1/2017c/homework/hw7/geocode.php";
		String placename = this.name;
		String query = "place=" + placename;
		String fragment = null;
		URI uri = new URI(scheme, authority, path, query, fragment);
		URL url = new URL(uri.toString());
		return url;
		
	}
	
	
}
