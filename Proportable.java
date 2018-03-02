package hw4;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Proportable {
	public static BufferedImage blankImage(int width, double ratio, Color color) {
		int height = (int) (width / ratio);
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		int rgb = color.getRGB();
		for (int r = 0; r < height; ++r) {
			for (int c = 0; c < width; ++c) {
				// (c,r)
				img.setRGB(c, r, rgb);
			}
		}
		return img;
	}

	public static int toHorizontal(BufferedImage image, double prop) {
		int width = image.getWidth();
		double xcoor = (width - 1) * prop;
		int xcoor1 = (int) (Math.round(xcoor));
		return xcoor1;

	}

	public static int toVertical(BufferedImage image, double ycoor) {
		int height = image.getHeight();
		double prop = (height - 1) * (1 - ycoor);
		int prop1 = (int) (Math.round(prop));
		return prop1;
	}

	public static int clamp(int number, int lowerBound, int upperBound) {
		return Math.max(lowerBound, Math.min(upperBound, number));
	}

	public static void plotRectangle(BufferedImage imageToPlot, double xPropBottomLeft, double yPropBottomLeft,
			double xPropTopRight, double yPropTopRight, Color color) {
		// convert proportions to indices
		int xPropBottomLeftIndices = toHorizontal(imageToPlot, xPropBottomLeft);
		int xPropTopRightIndices = toHorizontal(imageToPlot, xPropTopRight);
		int yPropBottomLeftIndices = toVertical(imageToPlot, yPropBottomLeft);
		int yPropTopRightIndices = toVertical(imageToPlot, yPropTopRight);
		// clamp indices to the image's dimensions
		int clampXPropBottomLeft = clamp(xPropBottomLeftIndices, 0, imageToPlot.getWidth() - 1);
		int clampXPropTopRight = clamp(xPropTopRightIndices, 0, imageToPlot.getWidth() - 1);
		int clampYPropBottomLeft = clamp(yPropBottomLeftIndices, 0, imageToPlot.getHeight() - 1);
		int clampYPropTopRight = clamp(yPropTopRightIndices, 0, imageToPlot.getHeight() - 1);

		// visit all pixels in these inclusive integer bounds, setting each to the given
		// color
		int rgb = color.getRGB();
		for (int x = clampXPropBottomLeft; x <= clampXPropTopRight; x++) {
			for (int y = clampYPropTopRight; y <= clampYPropBottomLeft; y++) {
				imageToPlot.setRGB(x, y, rgb);
			}
		}
	}

	public static void plotCircle(BufferedImage imageToPlot, double xPropOrigin, double yPropOrigin, double propRadius,
			Color color) {
		// convert the props to indices
		int xOriginIndices = toHorizontal(imageToPlot, xPropOrigin);
		int xClamped = clamp(xOriginIndices, 0, imageToPlot.getWidth() - 1);

		int yOriginIndices = toVertical(imageToPlot, yPropOrigin);
		int yClamped = clamp(yOriginIndices, 0, imageToPlot.getHeight() - 1);

		// apply prop radius to images's width, not its height
		int radiusIndices = toHorizontal(imageToPlot, propRadius);

		// int radius = radiusPropIndices - xPropOriginIndices;
		// visit all pixels within the rectangle circumscribing the circle
		int rgb = color.getRGB();

		// if(imageToPlot.getHeight() == 0 || imageToPlot.getWidth() == 0) {
		for (int x = 0; x <= imageToPlot.getWidth() - 1; x++) {
			for (int y = 0; y <= imageToPlot.getHeight() - 1; y++) {
				int diffX = x - xClamped;
				int diffY = y - yClamped;
				double hyp = Math.hypot(diffX, diffY);

				// only set the color of the pixels whose distance to the center pixel is less
				// than or equal to the integer radius

				if (hyp <= radiusIndices) {

					imageToPlot.setRGB(x, y, rgb);
				}
			}
		}
	}

	public static int chessboardDistance(int aXcoor, int aYcoor, int bXcoor, int bYcoor) {
		int distanceBetweenX = bXcoor - aXcoor;
		int distanceBetweenY = bYcoor - aYcoor;
		int efficient = Math.max(Math.abs(distanceBetweenX), Math.abs(distanceBetweenY));
		return efficient;
	}

	public static double lerp(double a, double b, double propZeroToOne) {
		return (1 - propZeroToOne) * a + (propZeroToOne * b);
	}

	public static void plotLine(BufferedImage imageToPlotOn, double aXprop, double aYprop, double bXprop, double bYprop,
			Color color) {
		int aXcoor = Proportable.toHorizontal(imageToPlotOn, aXprop);
		int bXcoor = Proportable.toHorizontal(imageToPlotOn, bXprop);
		int aYcoor = Proportable.toVertical(imageToPlotOn, aYprop);
		int bYcoor = Proportable.toVertical(imageToPlotOn, bYprop);
		int chessDist = Proportable.chessboardDistance(aXcoor, aYcoor, bXcoor, bYcoor);
		int rgb = color.getRGB();

		for (int i = 0; i <= chessDist; i++) {
			double p = i / (double) chessDist;
			double x = Proportable.lerp(aXcoor, bXcoor, p);
			int xRound = (int) Math.round(x);
			double y = Proportable.lerp(aYcoor, bYcoor, p);
			int yRound = (int) Math.round(y);
			try {
				imageToPlotOn.setRGB(xRound, yRound, rgb);
			} catch (IndexOutOfBoundsException e) {
			}
		}
	}

	public static BufferedImage plot(File fileDrawingCommands, int widthOfImageDrawingOnto)
			throws FileNotFoundException {
		Scanner in = new Scanner(fileDrawingCommands);

		String str = "#";
		double aspectRatio = 0;
		while (str.equals("#")) {
			str = in.next();
			if (str.equals("#")) {
				in.nextLine();
			}
		}
		aspectRatio = Double.parseDouble(str);

		String str1 = "#";
		float backgroundColor1 = 0;

		while (str1.equals("#")) {
			str1 = in.next();
			if (str1.equals("#")) {
				in.nextLine();
			}
		}
		backgroundColor1 = Float.parseFloat(str1);

		String str2 = "#";
		float backgroundColor2 = 0;

		while (str2.equals("#")) {
			str2 = in.next();
			if (str2.equals("#")) {
				in.nextLine();
			}
		}
		backgroundColor2 = Float.parseFloat(str2);

		String str3 = "#";
		float backgroundColor3 = 0;

		while (str3.equals("#")) {
			str3 = in.next();
			if (str3.equals("#")) {
				in.nextLine();
			}
		}
		backgroundColor3 = Float.parseFloat(str3);

		Color color = new Color(backgroundColor1, backgroundColor2, backgroundColor3);
		BufferedImage img = blankImage(widthOfImageDrawingOnto, aspectRatio, color);

		Color newColor = null;

		while (in.hasNext()) {

			String command = in.next();

			if (command.equals("color")) {
				// plot next shapes in red
				float colorR = in.nextFloat();
				float colorG = in.nextFloat();
				float colorB = in.nextFloat();
				newColor = new Color(colorR, colorG, colorB);
			}

			else if (command.equals("rectangle")) {
				// plot rectangle in bottom-left quadrant
				double x1 = in.nextDouble();
				double y1 = in.nextDouble();
				double x2 = in.nextDouble();
				double y2 = in.nextDouble();
				plotRectangle(img, x1, y1, x2, y2, newColor);

			} else if (command.equals("circle")) {
				// plot circle at center of image filling tenth of width
				double xOrigin = in.nextDouble();
				double yOrigin = in.nextDouble();
				double Radius = in.nextDouble();
				plotCircle(img, xOrigin, yOrigin, Radius, newColor);

			} else if (command.equals("line")) {
				// plot line from (0, 0) to (1, 1)
				double aX = in.nextDouble();
				double aY = in.nextDouble();
				double bX = in.nextDouble();
				double bY = in.nextDouble();
				plotLine(img, aX, aY, bX, bY, newColor);

			} else if (command.equals("#")) {
				in.next();
			}
		}

		return img;

	}
}
