package utils;

import models.User;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileHandler {
    // Defines the file name. This will create users.txt in your Tomcat server directory.
    private static final String USER_FILE = "users.txt";

    /**
     * Saves any User object to the text file.
     * Polymorphism is at play here: calling user.toFileString() will execute
     * the specific format defined in Couple, Vendor, or Admin.
     */
    public static boolean saveUser(User user) {
        // The 'true' parameter in FileWriter enables append mode,
        // so it adds new lines instead of overwriting the whole file.
        try (FileWriter fw = new FileWriter(USER_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println(user.toFileString());
            return true; // Successfully saved

        } catch (IOException e) {
            e.printStackTrace();
            return false; // Failed to save
        }
    }
}