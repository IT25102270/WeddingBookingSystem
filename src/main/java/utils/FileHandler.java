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
    private static final String REVIEW_FILE = BASE_PATH + "reviews.txt";
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
    /**
     * Saves a Review object to the reviews text file.
     */
    public static boolean saveReview(models.Review review) {
        try (java.io.FileWriter fw = new java.io.FileWriter(REVIEW_FILE, true);
             java.io.PrintWriter pw = new java.io.PrintWriter(fw)) {

            pw.println(review.toFileString());
            return true;

        } catch (java.io.IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Reads the reviews text file and returns a list of all Review objects.
     */
    public static java.util.List<models.Review> getAllReviews() {
        java.util.List<models.Review> reviews = new java.util.ArrayList<>();
        System.out.println("Trying to read from: " + REVIEW_FILE);
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(REVIEW_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                // Ensure we have exactly 5 pieces of data (ID, Email, Target, Rating, Comment)
                if (data.length == 5) {
                    models.Review review = new models.Review(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4]);
                    reviews.add(review);
                }
            }
        } catch (java.io.IOException e) {
            // It's perfectly fine if the file doesn't exist yet!
            System.out.println("No reviews file found yet. Returning empty list.");
        }
        return reviews;
    }
    /**
     * Deletes a review from the text file by its ID.
     */
    public static boolean deleteReview(String reviewId) {
        java.util.List<models.Review> reviews = getAllReviews();
        boolean isDeleted = false;

        // Notice the 'false' here — it tells Java to overwrite the file instead of appending!
        try (java.io.FileWriter fw = new java.io.FileWriter(REVIEW_FILE, false);
             java.io.PrintWriter pw = new java.io.PrintWriter(fw)) {

            for (models.Review r : reviews) {
                if (r.getReviewId().equals(reviewId)) {
                    isDeleted = true; // We found the spam! Skip writing this one.
                } else {
                    pw.println(r.toFileString()); // Keep the good ones
                }
            }
            return isDeleted;
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    // ==========================================
    // VENDOR UPDATE & DELETE LOGIC
    // ==========================================

    public static boolean deleteVendor(String vendorId) {
        java.util.List<models.Vendor> vendors = getAllVendors(); // Assuming you have this!
        boolean isDeleted = false;
        try (java.io.PrintWriter pw = new java.io.PrintWriter(new java.io.FileWriter(VENDOR_FILE, false))) {
            for (models.Vendor v : vendors) {
                if (v.getId().equals(vendorId)) isDeleted = true;
                else pw.println(v.toFileString());
            }
            return isDeleted;
        } catch (java.io.IOException e) { return false; }
    }

    public static boolean updateVendor(models.Vendor updatedVendor) {
        java.util.List<models.Vendor> vendors = getAllVendors();
        boolean isUpdated = false;
        try (java.io.PrintWriter pw = new java.io.PrintWriter(new java.io.FileWriter(VENDOR_FILE, false))) {
            for (models.Vendor v : vendors) {
                if (v.getId().equals(updatedVendor.getId())) {
                    pw.println(updatedVendor.toFileString());
                    isUpdated = true;
                } else {
                    pw.println(v.toFileString());
                }
            }
            return isUpdated;
        } catch (java.io.IOException e) { return false; }
    }

    // ==========================================
    // VENUE UPDATE & DELETE LOGIC
    // ==========================================

    public static boolean deleteVenue(String venueId) {
        java.util.List<models.Venue> venues = getAllVenues(); // Assuming you have this!
        boolean isDeleted = false;
        try (java.io.PrintWriter pw = new java.io.PrintWriter(new java.io.FileWriter(VENUE_FILE, false))) {
            for (models.Venue v : venues) {
                if (v.getVenueId().equals(venueId)) isDeleted = true;
                else pw.println(v.toFileString());
            }
            return isDeleted;
        } catch (java.io.IOException e) { return false; }
    }

    public static boolean updateVenue(models.Venue updatedVenue) {
        java.util.List<models.Venue> venues = getAllVenues();
        boolean isUpdated = false;
        try (java.io.PrintWriter pw = new java.io.PrintWriter(new java.io.FileWriter(VENUE_FILE, false))) {
            for (models.Venue v : venues) {
                if (v.getVenueId().equals(updatedVenue.getVenueId())) {
                    pw.println(updatedVenue.toFileString());
                    isUpdated = true;
                } else {
                    pw.println(v.toFileString());
                }
            }
            return isUpdated;
        } catch (java.io.IOException e) { return false; }
    }

}