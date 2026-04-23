<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Vendor" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Vendors | Wedding System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2>Registered Service Providers</h2>
        <a href="addVendor.jsp" class="btn btn-success">+ Add New Vendor</a>
    </div>

    <div class="card shadow">
        <div class="card-body">
            <table class="table table-hover table-striped">
                <thead class="table-dark">
                <tr>
                    <th>Company Name</th>
                    <th>Service Type</th>
                    <th>Base Price (LKR)</th>
                    <th>Contact Email</th>
                </tr>
                </thead>
                <tbody>
                <%
                    // Grab the list we attached in the Servlet
                    List<Vendor> vendors = (List<Vendor>) request.getAttribute("vendorList");

                    if (vendors != null && !vendors.isEmpty()) {
                        // Loop through each vendor and create a table row
                        for (Vendor v : vendors) {
                %>
                <tr>
                    <td><%= v.getName() %></td>
                    <td><span class="badge bg-primary"><%= v.getServiceType() %></span></td>
                    <td>Rs. <%= String.format("%,.2f", v.getBasePrice()) %></td>
                    <td><%= v.getEmail() %></td>
                </tr>
                <%
                    }
                } else {
                %>
                <tr>
                    <td colspan="4" class="text-center text-muted">No vendors registered yet.</td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>