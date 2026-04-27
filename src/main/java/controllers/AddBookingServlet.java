package controllers;

import models.Booking;
import utils.FileHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddBookingServlet")
public class AddBookingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Generate a unique Booking ID
        String bookingId = "BKG" + System.currentTimeMillis();

        // 2. Gather data from the form
        String userEmail = request.getParameter("userEmail"); // The couple making the booking
        String venueId = request.getParameter("venueId");     // The selected hotel/hall
        String vendorId = request.getParameter("vendorId");   // The selected service provider
        String eventDate = request.getParameter("eventDate");
        String status = "Pending"; // All new bookings start as Pending

        // 3. Create the Booking object (OOP: Instantiation)
        Booking newBooking = new Booking(bookingId, userEmail, venueId, vendorId, eventDate, status);

        // 4. Save it to the text file
        if (FileHandler.saveBooking(newBooking)) {
            response.sendRedirect("dashboard.jsp?bookingAdded=true");
        } else {
            response.sendRedirect("addBooking.jsp?error=true");
        }
    }
}