package hw6;

import java.io.File;

import hw6.speccheck.GifSequenceWriter;

public class SpotUtilities {
	private static double rowDelta;
	private static double columnDelta;
	private static double outerDistance;
	private static double innerDistance;

	public static int[] countNeighbors(boolean[][] bitmap, int horzRadOuter, int vertRadOuter, int horzRadInner,
			int vertRadInner, int column, int row) {
		int[] endArray = new int[2];
		int activators = 0;
		int inhibitors = 0;
		for (int i = row - vertRadOuter; i <= row + vertRadOuter; i++) {
			for (int j = column - horzRadOuter; j <= column + horzRadOuter; j++) {
				double rowDelta = Math.pow(i - row, 2);
				double columnDelta = Math.pow(j - column, 2);
				double outerDistance = (columnDelta / Math.pow(horzRadOuter, 2)) + (rowDelta / Math.pow(vertRadOuter, 2));
				double innerDistance = (columnDelta / Math.pow(horzRadInner, 2)) + (rowDelta / Math.pow(vertRadInner, 2));
				if (BitmapUtilities.isOn(bitmap, j, i) && innerDistance <= 1 && outerDistance <= 1) {
					activators++;
					// ++endArray[0];
				} else if (BitmapUtilities.isOn(bitmap, j, i) && outerDistance <= 1) {
					inhibitors++;
					// ++endArray[1];
				}
			}
		}
		endArray[0] = activators;
		endArray[1] = inhibitors;
		return endArray;
	}

	public static boolean[][] step(boolean[][] bitmap, int horzRadOuter, int vertRadOuter, int horzRadInner, int vertRadInner, double prop) {
		
		boolean[][] bitmapNew = new boolean[bitmap.length][bitmap[0].length];
		for (int r = 0; r < bitmapNew.length; r++) {
			for (int c = 0; c < bitmapNew[r].length; c++) {
				int[] activeInhibitor = countNeighbors(bitmap, horzRadOuter, vertRadOuter, horzRadInner,
						vertRadInner, c, r);
//				int nActive = activeInhibitor[0];
//				int nInhibitor = activeInhibitor[1];

				double diff = activeInhibitor[0] - prop * activeInhibitor[1];

				if (Math.abs(diff) < 0.001) {
					// bitmapNew[r][c] = BitmapUtilities.equals(bitmap, bitmapNew);
					bitmapNew[r][c] = bitmap[r][c];
				} else if (diff > 0) {
					bitmapNew[r][c] = true;
				} else {
					bitmapNew[r][c] = false;
				}
			}
		}
		return bitmapNew;
	}

	public static int converge(boolean[][] pre, int horzRadOuter, int vertRadOuter, int horzRadInner, int vertRadInner,
			double prop, File gif, int maxNSteps) {

		GifSequenceWriter out = new GifSequenceWriter(gif, 200, true);
		out.appendFrame(BitmapUtilities.toBufferedImage(pre));
		int i = 0;
		boolean[][] post = BitmapUtilities.create(pre.length, pre[0].length);
		boolean notSame = true;

		while (notSame && i < maxNSteps) {
			post = step(pre, horzRadOuter, vertRadOuter, horzRadInner, vertRadInner, prop);
			out.appendFrame(BitmapUtilities.toBufferedImage(post));
			notSame = !BitmapUtilities.equals(pre, post);
			i++;
			pre = post;
		}

		out.close();
		return i + 1;
	}

}