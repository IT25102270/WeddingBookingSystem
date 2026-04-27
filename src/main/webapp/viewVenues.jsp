<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Venue" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Venues | DreamWedding Admin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            min-height: 100vh;
            background: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.9)),
            url('https://images.unsplash.com/photo-1464366400600-7168b8af9bc3?auto=format&fit=crop&w=1500&q=80') center/cover no-repeat fixed;
            color: white;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            padding: 40px 0;
        }

        .glass-container {
            background: rgba(255, 255, 255, 0.03);
            backdrop-filter: blur(15px);
            border: 1px solid rgba(255, 255, 255, 0.1);
            border-radius: 20px;
            padding: 30px;
            box-shadow: 0 25px 50px rgba(0,0,0,0.5);
        }

        /* Customizing the table to look like glass with Blue accents */
        .glass-table {
            color: white;
            margin-bottom: 0;
        }

        .glass-table thead th {
            background: rgba(13, 110, 253, 0.15); /* Subtle primary blue tint */
            color: #fff;
            border-bottom: 2px solid rgba(13, 110, 253, 0.5);
            font-weight: 600;
            letter-spacing: 0.5px;
            padding: 15px;
        }

        .glass-table tbody td {
            background: rgba(255, 255, 255, 0.02);
            border-bottom: 1px solid rgba(255, 255, 255, 0.05);
            color: #e0e0e0;
            vertical-align: middle;
            padding: 15px;
        }

        /* Hover effect */
        .glass-table tbody tr:hover td {
            background: rgba(255, 255, 255, 0.08);
            color: white;
            cursor: pointer;
        }

        /* Glass-style badges */
        .glass-badge-primary {
            background: rgba(13, 110, 253, 0.2);
            border: 1px solid rgba(13, 110, 253, 0.5);
            color: #9ec5fe;
        }

        .btn-custom { border-radius: 10px; font-weight: bold; transition: 0.3s; }
        .btn-custom:hover { transform: translateY(-2px); }
    </style>
</head>
<body>

<div class="container">
    <div class="glass-container">

        <div class="d-flex justify-content-between align-items-center mb-4">
            <div>
                <h2 class="fw-bold mb-0 text-primary">Registered Venues</h2>
                <p class="text-light opacity-50 small mb-0">Explore our luxury hotels, halls, and destinations.</p>
            </div>

            <%-- ONLY SHOW THIS BUTTON TO ADMINS --%>
            <% if ("Admin".equalsIgnoreCase((String) session.getAttribute("userRole"))) { %>
            <a href="addVenue.jsp" class="btn btn-primary shadow btn-custom">+ Add New Venue</a>
            <% } %>

        </div>
        <div class="table-responsive" style="border-radius: 10px; overflow: hidden;">
            <table class="table glass-table table-borderless">
                <thead>
                <tr>
                    <th>Venue Name</th>
                    <th>Location</th>
                    <th>Max Capacity</th>
                    <th>Price Per Day (LKR)</th>
                </tr>
                </thead>
                <tbody>
                <%
                    // Your exact Java logic, safely preserved!
                    List<Venue> venues = (List<Venue>) request.getAttribute("venueList");

                    if (venues != null && !venues.isEmpty()) {
                        for (Venue v : venues) {
                %>
                <tr>
                    <td class="fw-bold text-white"><%= v.getName() %></td>
                    <td class="opacity-75"><%= v.getLocation() %></td>
                    <td><span class="badge glass-badge-primary rounded-pill px-3 py-2"><%= v.getMaxCapacity() %> Guests</span></td>
                    <td class="fw-bold">Rs. <%= String.format("%,.2f", v.getPricePerDay()) %></td>
                </tr>
                <%
                    }
                } else {
                %>
                <tr>
                    <td colspan="4" class="text-center text-light opacity-50 py-5">
                        <div class="fs-1 mb-2">🏨</div>
                        No venues registered yet. Start adding your locations!
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>

        <div class="mt-4 pt-3 border-top border-secondary border-opacity-25">
            <%
                // Check who is currently looking at the page
                String currentRole = (String) session.getAttribute("userRole");
                String returnPage = (currentRole != null && currentRole.equalsIgnoreCase("Admin")) ? "dashboard.jsp" : "userDashboard.jsp";
            %>
            <a href="<%= returnPage %>" class="btn btn-outline-light btn-custom px-4">← Back to Dashboard</a>
        </div>
    </div>
</div>

</body>
</html>