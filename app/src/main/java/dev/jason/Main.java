package dev.jason;

import dev.jason.calculator.Calculator;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);

		System.out.println("1. Cricket");
		System.out.println("2. Calculator");

		System.out.print("Enter your choice: ");
		int choice;

		try {
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					try {
						dev.jason.cricket.Main.mainGame();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 2: new Calculator().calculator(); break;
			}
		} catch (Exception e) {
			System.out.println("Error occurred: " + e.getMessage());
		}
	}
}