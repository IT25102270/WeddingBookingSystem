package controllers;

import utils.FileHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Get the data from the login form
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // 2. Use our FileHandler to Read/Search the text file
        boolean isValid = FileHandler.validateUser(email, password);

        // 3. Redirect based on the result
        if (isValid) {
            // Success! Send them to the main dashboard (we will build this next)
            response.sendRedirect("dashboard.jsp");
        } else {
            // Failure! Send them back to the login page with an error message
            response.sendRedirect("login.jsp?error=true");
        }
    }
}