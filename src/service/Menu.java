package service;

import java.util.Scanner;

public class Menu {

	public static void showMenu() {
		System.out.println();
		System.out.println("### SELLERS ###");
		System.out.println("1 List All Sellers");
		System.out.println("2 Find a Seller");
		System.out.println("3 List Seller by Department");
		System.out.println("4 Create a Seller");
		System.out.println("5 Update a Seller");
		System.out.println("6 Delete a Seller");
		System.out.println();
		System.out.println("### DEPARTMENTS ###");
		System.out.println("7 List All Departments");
		System.out.println("8 Find a Department");
		System.out.println("9 Create a Department");
		System.out.println("10 Update a Department");
		System.out.println("11 Delete a Department");
		System.out.println("12 Exit the program");
		System.out.print("Choose an option: ");
	}

	public static int getUserChoice(Scanner sc) {
		int choice = -1;
		while (true) {
			try {
				choice = sc.nextInt();
				sc.nextLine();
				if (choice >= 1 && choice <= 12) {
					break;
				} else {
					System.out.println("Invalid choice!");
					System.out.println();
					showMenu();
				}
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("Invalid input! Please enter a number between 1 and 12.");
				System.out.println();
				showMenu();
			}
		}
		return choice;
	}

	public static void exitProgram(Scanner sc) {
		System.out.println("Exiting program...");
		sc.close();
	}
}
