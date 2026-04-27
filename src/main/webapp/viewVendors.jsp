<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Vendor" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Vendors | DreamWedding Admin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            min-height: 100vh;
            background: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.85)),
            url('https://images.unsplash.com/photo-1511285560929-80b456fea0bc?auto=format&fit=crop&w=1500&q=80') center/cover no-repeat fixed;
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

        /* Customizing the table to look like glass with Cyan/Teal accents */
        .glass-table {
            color: white;
            margin-bottom: 0;
        }

        .glass-table thead th {
            background: rgba(13, 202, 240, 0.15); /* Subtle cyan tint */
            color: #fff;
            border-bottom: 2px solid rgba(13, 202, 240, 0.5);
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
        .glass-badge-info {
            background: rgba(13, 202, 240, 0.2);
            border: 1px solid rgba(13, 202, 240, 0.5);
            color: #6edff6;
        }

        .btn-info-custom {
            background-color: #0dcaf0;
            color: black;
            border: none;
            border-radius: 10px;
            font-weight: bold;
            transition: 0.3s;
        }

        .btn-info-custom:hover {
            background-color: #31d2f2;
            transform: translateY(-2px);
            box-shadow: 0 10px 20px rgba(13, 202, 240, 0.3);
        }

        .btn-outline-light-custom {
            border-radius: 10px;
            font-weight: bold;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="glass-container">

        <div class="d-flex justify-content-between align-items-center mb-4">
            <div>
                <h2 class="fw-bold mb-0 text-info">Registered Vendors</h2>
                <p class="text-light opacity-50 small mb-0">Manage photographers, caterers, decorators, and more.</p>
            </div>
            <a href="addVendor.jsp" class="btn btn-info-custom px-4 py-2 shadow">+ Add New Vendor</a>
        </div>

        <div class="table-responsive" style="border-radius: 10px; overflow: hidden;">
            <table class="table glass-table table-borderless">
                <thead>
                <tr>
                    <th>Vendor / Business Name</th>
                    <th>Service Category</th>
                    <th>Contact Number</th>
                    <th>Base Rate (LKR)</th>
                </tr>
                </thead>
                <tbody>
                <%
                    // Note: Ensure these getter names match your Vendor.java model!
                    List<Vendor> vendors = (List<Vendor>) request.getAttribute("vendorList");

                    if (vendors != null && !vendors.isEmpty()) {
                        for (Vendor v : vendors) {
                %>
                <tr>
                    <td class="fw-bold text-white"><%= v.getName() %></td>
                    <td><span class="badge glass-badge-info rounded-pill px-3 py-2"><%= v.getServiceType() %></span></td>
                    <td class="opacity-75"><%= v.getPhone() %></td>
                    <td class="fw-bold">Rs. <%= String.format("%,.2f", v.getBasePrice()) %></td>
                </tr>
                <%
                    }
                } else {
                %>
                <tr>
                    <td colspan="4" class="text-center text-light opacity-50 py-5">
                        <div class="fs-1 mb-2">📷</div>
                        No vendors registered yet. Start building your service network!
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>

        <div class="mt-4 pt-3 border-top border-secondary border-opacity-25">
            <a href="dashboard.jsp" class="btn btn-outline-light btn-outline-light-custom px-4">← Back to Dashboard</a>
        </div>
    </div>
</div>

</body>
</html>