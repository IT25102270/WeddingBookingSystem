package models;

public class Venue {
    private String venueId;
    private String name;
    private String location;
    private int maxCapacity;
    private double pricePerDay;

    public Venue(String venueId, String name, String location, int maxCapacity, double pricePerDay) {
        this.venueId = venueId;
        this.name = name;
        this.location = location;
        this.maxCapacity = maxCapacity;
        this.pricePerDay = pricePerDay;
    }

    // Getters and Setters (Encapsulation)
    public String getVenueId() { return venueId; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public int getMaxCapacity() { return maxCapacity; }
    public double getPricePerDay() { return pricePerDay; }

    // Custom method to format the data for our text file
    public String toFileString() {
        return venueId + "," + name + "," + location + "," + maxCapacity + "," + pricePerDay;
    }
}