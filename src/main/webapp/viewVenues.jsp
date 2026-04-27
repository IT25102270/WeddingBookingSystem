<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Venue" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Venues | Wedding System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2>Registered Venues</h2>
        <a href="addVenue.jsp" class="btn btn-primary">+ Add New Venue</a>
    </div>

    <div class="card shadow border-0">
        <div class="card-body p-0">
            <table class="table table-hover table-striped m-0">
                <thead class="table-dark">
                <tr>
                    <th>Venue Name</th>
                    <th>Location</th>
                    <th>Max Capacity</th>
                    <th>Price Per Day (LKR)</th>
                </tr>
                </thead>
                <tbody>
                <%
                    // Grab the list we attached in the Servlet
                    List<Venue> venues = (List<Venue>) request.getAttribute("venueList");

                    if (venues != null && !venues.isEmpty()) {
                        for (Venue v : venues) {
                %>
                <tr>
                    <td class="fw-bold"><%= v.getName() %></td>
                    <td><%= v.getLocation() %></td>
                    <td><span class="badge bg-info text-dark"><%= v.getMaxCapacity() %> Guests</span></td>
                    <td>Rs. <%= String.format("%,.2f", v.getPricePerDay()) %></td>
                </tr>
                <%
                    }
                } else {
                %>
                <tr>
                    <td colspan="4" class="text-center text-muted py-4">No venues registered yet.</td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>

    <div class="mt-3">
        <a href="dashboard.jsp" class="btn btn-outline-secondary">Back to Dashboard</a>
    </div>
</div>

</body>
</html>