package com.swiderski.app;

import com.swiderski.app.utils.SubstringUtil;

import java.util.Scanner;

public class ConsoleGui {

    private SubstringUtil substringUtil;

    public ConsoleGui(SubstringUtil substringUtil) {
        this.substringUtil = substringUtil;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("This program checks if string 2 is a substring of string 1");
        while (running) {
            System.out.println("\nEnter the first string: ");
            String string1 = scanner.next();
            System.out.println("Enter the second string (potential substring) : ");
            String string2 = scanner.next();
            boolean isSubstring = substringUtil.isSubstring(string1, string2);
            System.out.println("Is string '" + string2 + "' a substring of string '" + string1 + "' ? --> " + isSubstring);
            System.out.println("\nDo you want to try again? ( enter t ))");
            running = scanner.next().equals("t");
        }
    }

}
