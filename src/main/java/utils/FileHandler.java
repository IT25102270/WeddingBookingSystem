package utils;

import models.User;
import models.Vendor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    // Universal paths so it works on any laptop
    // Force the system to save directly to the new C: drive folder
    private static final String BASE_PATH = "C:\\WeddingData\\";
    private static final String USER_FILE = BASE_PATH + "users.txt";
    private static final String VENDOR_FILE = BASE_PATH + "vendors.txt";
    private static final String VENUE_FILE = BASE_PATH + "venues.txt";
    private static final String BOOKING_FILE = BASE_PATH + "bookings.txt";
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
    /**
     * Member 3 "Create" Operation: Saves a Venue to the text file.
     */
    public static boolean saveVenue(models.Venue venue) {
        try (FileWriter fw = new FileWriter(VENUE_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println(venue.toFileString());
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Member 3 "Read" Operation: Gets all venues from the text file.
     */
    public static List<models.Venue> getAllVenues() {
        List<models.Venue> venueList = new ArrayList<>();
        File file = new File(VENUE_FILE);

        if (!file.exists()) return venueList;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 5) {
                    models.Venue v = new models.Venue(data[0], data[1], data[2], Integer.parseInt(data[3]), Double.parseDouble(data[4]));
                    venueList.add(v);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return venueList;
    }
    /**
     * Member 4 "Create" Operation: Saves a Booking to the text file.
     */
    public static boolean saveBooking(models.Booking booking) {
        try (FileWriter fw = new FileWriter(BOOKING_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println(booking.toFileString());
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Member 4 "Read" Operation: Gets all bookings from the text file.
     */
    public static List<models.Booking> getAllBookings() {
        List<models.Booking> bookingList = new ArrayList<>();
        File file = new File(BOOKING_FILE);

        if (!file.exists()) return bookingList;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 6) {
                    models.Booking b = new models.Booking(data[0], data[1], data[2], data[3], data[4], data[5]);
                    bookingList.add(b);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookingList;
    }
    public static String getUserRole(String email) {
        // Now it uses your perfectly set up USER_FILE variable!
        try (BufferedReader br = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(email)) {
                    if (line.toLowerCase().contains("admin")) {
                        return "Admin";
                    } else {
                        return "Couple";
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error finding role: " + e.getMessage());
        }
        return "Couple";
    }

}