package hw6;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;


public class BitmapUtilities {
	public static boolean[][] create(int width, int height) {
		boolean[][] bitmap = new boolean[height][width];
		return bitmap;
	}

	public static void randomize(boolean[][] bitmap, long seed) {
		Random gen = new Random(seed);
		for (int i = 0; i < bitmap.length; i++) {
			for (int j = 0; j < bitmap[i].length; j++) {
				bitmap[i][j] = gen.nextBoolean();
			}
		}
	}

	public static void write(boolean[][] bitmap, File file) throws FileNotFoundException {
		PrintWriter out = new PrintWriter(file);

		out.println("P1");
		out.print(bitmap[0].length);
		out.print(" ");
		out.println(bitmap.length);
		for (int i = 0; i < bitmap.length; i++) {
			for (int j = 0; j < bitmap[i].length; j++) {
				if (bitmap[i][j]) {
					out.println("0");
				} else {
					out.println("1");
				}
			}
		}
		
	out.close();
		
	}

	public static BufferedImage toBufferedImage(boolean[][] bitmap) {
//		boolean[row][column]
		BufferedImage img = new BufferedImage(
				bitmap[0].length, bitmap.length, BufferedImage.TYPE_BYTE_BINARY);
		for (int i = 0; i < bitmap.length; i++) {
			for (int j = 0; j < bitmap[i].length; j++) {
				if (bitmap[i][j]) {
				img.setRGB(j, i, Color.BLACK.getRGB());
			} else {
				img.setRGB(j, i, Color.WHITE.getRGB());
			}
		}
	}
		return img;

	}

	public static boolean equals(boolean[][] bitmap1, boolean[][] bitmap2) {
		boolean check = Arrays.deepEquals(bitmap1, bitmap2);
		return check;
	}

	public static boolean[][] clone(boolean[][] bitmap) {
		boolean[][] copy = new boolean[bitmap.length][];
		for (int i = 0; i < bitmap.length; i++) {
			copy[i] = Arrays.copyOf(bitmap[i], bitmap[i].length);
		}
		
		return copy;

	}

	public static int wrapIndex(int upperBound, int index) {
		if (index < 0) {
			return (index % upperBound + upperBound) % upperBound;
		}
		else if (index >= upperBound) {
			return index % upperBound;
		} else {
		return index;
		}
	}

	public static boolean isOn(boolean[][] bitmap, int columnIndex, int rowIndex) {
//		boolean[row][column]
		int wrappedRowIndex = wrapIndex(bitmap.length, rowIndex);
		int wrappedColumnIndex = wrapIndex(bitmap[0].length, columnIndex);
		return bitmap[wrappedRowIndex][wrappedColumnIndex];

	}

}
