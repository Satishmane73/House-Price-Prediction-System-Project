package org.techhub.clientapp;

import java.util.*;

public class HousePricePredClientApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scr = new Scanner(System.in);
		do {
			System.out.println("1 : Enter State");
			System.out.println("2 : Display All States");
			System.out.println("9 : Exit");
			System.out.println("Enter your choice");
			int ch = scr.nextInt();
			switch (ch) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 9:
				
				System.exit(0);
				break;
			default:
				
				System.out.println("Wrong input");
				break;
			}
		} while (true);
	}

}
