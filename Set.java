package hw7;

import java.util.ArrayList;

public class Set {
	private int n;
//	private String[] list;
	private ArrayList<String> array;

	public Set() {
//		list = new String[2];
		array = new ArrayList<String>();
	}

	public boolean has(String element) {
		return array.contains(element);
	}

	public void add(String element) {
		if (!array.contains(element))
			array.add(element);
		
//		if (!has(element) || n == 0) {
//			String[] list2 = new String[list.length * 2];
//			for (int i = 0; i < list.length; i++) {
//				list2[i] = list[i];
//			} 
//			 list = list2;
//			 n++;
//
//		}
//		list[n - 1] = element;
	}

	public String toString() {
		String words = "";
		for (int i = 1; i <= array.size(); i++) {
			if (i == array.size()) {
				words += String.format("%s", array.get(i - 1));
			} else if (i < array.size()) {
				words += String.format("%s%n", array.get(i -1));
			}
		}
		return words;
	}
}
