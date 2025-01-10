
package com.mycompany.donkeysrace.view;

import java.util.Scanner;

public abstract class Utility {
    public static int getIntFromUser(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("invalid number:");
            }
        }
    }
}
