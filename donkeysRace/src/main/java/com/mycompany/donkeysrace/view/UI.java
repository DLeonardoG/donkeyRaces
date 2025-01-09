/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.donkeysrace.view;

import java.awt.BorderLayout;
import java.util.Scanner;

/**
 *
 * @author camper
 */
public class UI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println("\n=== DonkeyRaces ===");
            System.out.println("1. Owner");
            System.out.println("2. Gambler");
            System.out.println("3. Admin");
            System.out.println("4. Exit...");
            System.out.print("Select an option: ");

            option = Utility.getIntFromUser(scanner);

            switch (option) {
                case 1 -> UserOwner(scanner);
                case 2 -> UserGambler(scanner);
                case 3 -> LoginAdmin(scanner);
                case 4 -> System.out.println("Exiting the system....");
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);
    }

      private static void UserOwner(Scanner scanner) {
        int option;
        do {
            System.out.println("\n--- Owner ---");
            System.out.println("1. Sign in");
            System.out.println("2. Update information");
            System.out.println("3. Register donkey");
            System.out.println("4. Delete donkey");
            System.out.println("5. List donkeys");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
            option = Utility.getIntFromUser(scanner);

            switch (option) {
                case 1 -> System.out.println("Sign in");
                case 2 -> System.out.println("Update");
                case 3 -> System.out.println("Register");
                case 4 -> System.out.println("Delete");
                case 5 -> System.out.println("List");
                case 6 -> System.out.println("Returning with menu...");
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (option != 6);
    }
      private static void UserGambler(Scanner scanner) {
        int option;
        do {
            System.out.println("\n--- Gambler ---");
            System.out.println("1. Sign in");
            System.out.println("2. Add amount");
            System.out.println("3. Bet");
            System.out.println("4. View history");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            option = Utility.getIntFromUser(scanner);

            switch (option) {
                case 1 -> System.out.println("Sign in");
                case 2 -> System.out.println("add amount");
                case 3 -> System.out.println("bet");
                case 4 -> System.out.println("view");
                case 5 -> System.out.println("Returning with menu...");
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (option != 5);
    }
      private static void UserAdmin(Scanner scanner) {
        int option;
        do {
            System.out.println("\n--- Admin ---");
            System.out.println("1. View Owners");
            System.out.println("2. View donkeys");
            System.out.println("3. Create Race");
            System.out.println("4. History");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            option = Utility.getIntFromUser(scanner);

            switch (option) {
                case 1 -> System.out.println("Sign in");
                case 2 -> System.out.println("add amount");
                case 3 -> System.out.println("bet");
                case 4 -> System.out.println("view");
                case 5 -> System.out.println("Returning with menu...");
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (option != 5);
    }
      private static void LoginAdmin(Scanner scanner) {
        int option;
        do {
            System.out.println("\n--- Admin ---");
            System.out.println("1. Log in");
            System.out.println("2. Exit...");
            System.out.print("Select an option: ");
            option = Utility.getIntFromUser(scanner);

            switch (option) {
                case 1 -> System.out.println("Sign in");
                case 2 -> System.out.println("Returning with menu...");
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (option != 2);
    }
      
}
    

