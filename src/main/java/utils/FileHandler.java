package utils;

import models.User;
import models.Vendor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    // Universal paths so it works on any laptop
    private static final String BASE_PATH = System.getProperty("user.home") + File.separator;
    private static final String USER_FILE = BASE_PATH + "users.txt";
    private static final String VENDOR_FILE = BASE_PATH + "vendors.txt";

    /**
     * Saves any User object (Couple/Admin) to the text file.
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
    }

    /**
     * Saves a Vendor object to the vendor text file.
     */
    public static boolean saveVendor(Vendor vendor) {
        try (FileWriter fw = new FileWriter(VENDOR_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println(vendor.toFileString());
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Validates login credentials from the text file.
     */
    public static boolean validateUser(String email, String password) {
        File file = new File(USER_FILE);
        if (!file.exists()) return false;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 4 && data[2].equalsIgnoreCase(email) && data[3].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Member 2 "Read" Operation: Gets all vendors from the text file.
     */
    public static List<Vendor> getAllVendors() {
        List<Vendor> vendorList = new ArrayList<>();
        File file = new File(VENDOR_FILE);

        if (!file.exists()) return vendorList;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 7) {
                    Vendor v = new Vendor(data[0], data[1], data[2], data[3], data[5], Double.parseDouble(data[6]));
                    vendorList.add(v);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vendorList;
    }
}