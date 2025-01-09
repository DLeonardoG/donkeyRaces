/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.donkeysrace.view;

import java.util.Scanner;

/**
 *
 * @author camper
 */
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
