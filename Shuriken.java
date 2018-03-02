package hw1;

import java.util.Scanner;

public class Shuriken {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Spin? ");
		double spindegrees = in.nextDouble();
		double spinradians = Math.toRadians(spindegrees);
		
//		double t = 0.0;
//		while (t <= 6.28319) {
//			double x0 = (1.1 + Math.sin(4 * t)) * Math.cos(t + spinradians);
//			double y0 = (1.1 + Math.sin(4 * t)) * Math.sin(t + spinradians);
//			System.out.printf("%.2f %.2f%n", x0, y0);
//			t =+ 0.523599;
//		}
//		System.out.println("Done!");
		
		double t = 0.0;
		double x0 = (1.1 + Math.sin(4 * t)) * Math.cos(t + spinradians);
		double y0 = (1.1 + Math.sin(4 * t)) * Math.sin(t + spinradians);
		System.out.printf("%.2f%s%.2f%n", x0, ",",  y0);
		
		double t1 = Math.toRadians(30);
		double x1 = (1.1 + Math.sin(4 * t1)) * Math.cos(t1 + spinradians);
		double y1 =  (1.1 + Math.sin(4 * t1)) * Math.sin(t1 + spinradians);
		System.out.printf("%.2f%s%.2f%n", x1,",", y1);
		
		double t2 = Math.toRadians(60);
		double x2 = (1.1 + Math.sin(4 * t2)) * Math.cos(t2 + spinradians);
		double y2 =  (1.1 + Math.sin(4 * t2)) * Math.sin(t2 + spinradians);
		System.out.printf("%.2f%s%.2f%n", x2, ",", y2);
		
		double t3 = Math.toRadians(90);
		double x3 = (1.1 + Math.sin(4 * t3)) * Math.cos(t3 + spinradians);
		double y3 =  (1.1 + Math.sin(4 * t3)) * Math.sin(t3 + spinradians);
		System.out.printf("%.2f%s%.2f%n", x3, ",", y3);
		
		double t4 = Math.toRadians(120);
		double x4 = (1.1 + Math.sin(4 * t4)) * Math.cos(t4 + spinradians);
		double y4 =  (1.1 + Math.sin(4 * t4)) * Math.sin(t4 + spinradians);
		System.out.printf("%.2f%s%.2f%n", x4, ",", y4);
		
		double t5 = Math.toRadians(150);
		double x5 = (1.1 + Math.sin(4 * t5)) * Math.cos(t5 + spinradians);
		double y5 =  (1.1 + Math.sin(4 * t5)) * Math.sin(t5 + spinradians);
		System.out.printf("%.2f%s%.2f%n", x5, ",", y5);
		
		double t6 = Math.toRadians(180);
		double x6 = (1.1 + Math.sin(4 * t6)) * Math.cos(t6 + spinradians);
		double y6 =  (1.1 + Math.sin(4 * t6)) * Math.sin(t6 + spinradians);
		System.out.printf("%.2f%s%.2f%n", x6, ",", y6);
		
		double t7 = Math.toRadians(210);
		double x7 = (1.1 + Math.sin(4 * t7)) * Math.cos(t7 + spinradians);
		double y7 =  (1.1 + Math.sin(4 * t7)) * Math.sin(t7 + spinradians);
		System.out.printf("%.2f%s%.2f%n", x7, ",", y7);
		
		double t8 = Math.toRadians(240);
		double x8 = (1.1 + Math.sin(4 * t8)) * Math.cos(t8 + spinradians);
		double y8 =  (1.1 + Math.sin(4 * t8)) * Math.sin(t8 + spinradians);
		System.out.printf("%.2f%s%.2f%n", x8, ",", y8);
		
		double t9 = Math.toRadians(270);
		double x9 = (1.1 + Math.sin(4 * t9)) * Math.cos(t9 + spinradians);
		double y9 =  (1.1 + Math.sin(4 * t9)) * Math.sin(t9 + spinradians);
		System.out.printf("%.2f%s%.2f%n", x9, ",", y9);
		
		double t10 = Math.toRadians(300);
		double x10 = (1.1 + Math.sin(4 * t10)) * Math.cos(t10 + spinradians);
		double y10 =  (1.1 + Math.sin(4 * t10)) * Math.sin(t10 + spinradians);
		System.out.printf("%.2f%s%.2f%n", x10, ",", y10);
		
		double t11 = Math.toRadians(330);
		double x11 = (1.1 + Math.sin(4 * t11)) * Math.cos(t11 + spinradians);
		double y11 =  (1.1 + Math.sin(4 * t11)) * Math.sin(t11 + spinradians);
		System.out.printf("%.2f%s%.2f%n", x11, ",", y11);
		
		double t12 = Math.toRadians(360);
		double x12 = (1.1 + Math.sin(4 * t12)) * Math.cos(t12 + spinradians);
		double y12 =  (1.1 + Math.sin(4 * t12)) * Math.sin(t12 + spinradians);
		System.out.printf("%.2f%s%.2f%n", x12, ",", y12);
		
	}
}
