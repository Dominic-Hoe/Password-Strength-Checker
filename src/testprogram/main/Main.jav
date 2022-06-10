package testprogram.main;

import java.util.Scanner;

public class Main {

    private static final String specialCharacters = "!%&*+=";

    /*
    Loops through each character in the string, and ensures
    that all of the characters are uppercase.
     */
    private static boolean isAllUpper(String s) {
        for (char c : s.toCharArray()) {
            // Checks if the character is numeric, if so,
            // then the string cannot be all uppercase.
            if (Character.isDigit(c)) return false;
            if (Character.isLetter(c) && Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }

    /*
    Loops through each character in the string, and ensures
    that all of the characters are lowercase.
     */
    private static boolean isAllLower(String s) {
        for (char c : s.toCharArray()) {
            // Checks if the character is numeric, if so,
            // then the string cannot be all lowercase.
            if (Character.isDigit(c)) return false;
            if (Character.isLetter(c) && Character.isUpperCase(c)) {
                return false;
            }
        }
        return true;
    }

    /*
    Loops through each character in the string, and ensures
    that all of the characters are numbers.
     */
    private static boolean isAllNumeric(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    // Checks if the password has bad characters that are not allowed
    // in the password.
    private static boolean validatePassword(String s) {
        for (char c : s.toCharArray()) {
            String alphabeticCharacters = "abcdefghijklmnopqrstuvwxyz";
            String numericCharacters = "0123456789";
            if (!alphabeticCharacters.contains(String.valueOf(c).toLowerCase())
                    && !numericCharacters.contains(String.valueOf(c).toLowerCase())
                    && !specialCharacters.contains(String.valueOf(c).toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int points = 0;

        while (true) {
            // Takes in the user's password via console input
            Scanner passwordScanner = new Scanner(System.in);
            System.out.print("Enter password: ");

            // Stores the user's password in the password variable
            String password = passwordScanner.nextLine();
            // Ensures the password length is at least 8 characters
            if (password.length() < 8) {
                System.out.println("Please ensure password is 8 characters minimum.");
                continue;
            }
            // Ensures the password length does not exceed 15 characters
            if (password.length() > 15) {
                System.out.println("Please ensure password is 15 characters maximum.");
                continue;
            }
            // Checks if the password has bad characters that are not allowed
            // in the password.
            if (!validatePassword(password)) {
                System.out.println("Please ensure you are only using alphanumeric characters, alongside these special characters: !, %, *, &, +, =");
                continue;
            }
            // If the password length is more than or equal to 10,
            // add 20 points
            if (password.length() >= 10)
                points += 20;
            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                // Checks if the password contains special characters
                // and adds 10 points.
                if (specialCharacters.contains(String.valueOf(c)))
                    points += 10;
                else
                    // If the password does not contain special characters
                    // it only adds 5 points.
                    points += 5;
            }
            // Checks if the password contains all uppercase characters.
            boolean upperCaseOnly = isAllUpper(password);
            // Checks if the password contains all lowercase characters.
            boolean lowerCaseOnly = isAllLower(password);
            // Checks if the password contains all numeric characters, such as the digits 0-9.
            boolean numericCharsOnly = isAllNumeric(password);
            // If the password contains only uppercase letters or lowercase
            // letters, deduct 3 points per character.
            if (upperCaseOnly || lowerCaseOnly)
                for (int i = 0; i < password.length(); i++)
                    points -= 3;
            // If the password contains only numbers, deduct 5 points
            // per character.
            else if (numericCharsOnly)
                for (int i = 0; i < password.length(); i++)
                    points -= 5;

            /*
            This code does the following:
            - Defines a score variable
            - Sets its value dependent on the points variable:
            Points less than or equal to 20 = very low
            Points less than or equal to 40 = low
            Points less than or equal to 70 = medium
            Points less than or equal to 80 = high
            Otherwise, very high
             */
            String score = (points <= 20 ? "very low" : (points <= 40 ? "low" : (points <= 70 ? "medium" : (points <= 80 ? "high" : "very high"))));
            System.out.println("Your password score is: " + score + ", with " + points + " points.");
            break;
        }
    }

}
