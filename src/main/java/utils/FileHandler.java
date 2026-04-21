package utils;

import models.User;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileHandler {

    // Defines the file name.
    private static final String USER_FILE = "C:\\Users\\ar186\\Documents\\OOP Project\\WeddingBookingSystem\\users.txt";

    /**
     * Saves any User object to the text file.
     */
    public static boolean saveUser(User user) {
        try (FileWriter fw = new FileWriter(USER_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println(user.toFileString());
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    } // <--- This was the missing bracket!

    /**
     * The "Read" Operation: Scans the text file to validate login credentials.
     */
    public static boolean validateUser(String email, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                // Our file format is: id, name, email, password, role, etc.
                if (data.length >= 4 && data[2].equals(email) && data[3].equals(password)) {
                    return true; // Match found!
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file or file doesn't exist yet.");
        }
        return false; // No match found
    }
}