package hw7;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class WebUtilities {
	public static String slurpURL(URL url) throws IOException {
		URLConnection conn = url.openConnection();
		InputStream is = conn.getInputStream();
		Scanner in = new Scanner(is);
		String words = "";
		while (in.hasNext()) {
			words += String.format("%s%n", in.nextLine());
		}
		in.close();
		return words;
	}
}
