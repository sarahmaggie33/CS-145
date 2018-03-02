package hw7;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class PlacesCache {
	private ArrayList<Place> places;
	private Set pl;

	public PlacesCache() {
		places = new ArrayList<Place>();
		pl = new Set();
	}
	
	public boolean isCached(String name) {
		return pl.has(name);
	}
	
	public Place getPlace(String name) throws NoSuchPlaceException {
		for (Place place : places) {
			if(place.getName().equals(name)) {
				return place;
			}
		}

		Place placer = new Place(name);
		places.add(placer);
		pl.add(name);
		return placer;
		}
	
	public int size() {
		return places.size();
	}
	
	public Place get(int i) {
		return places.get(i);
	}
	
	
}
