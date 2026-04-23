<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Vendor | Wedding System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="card shadow col-md-6 mx-auto">
        <div class="card-header bg-dark text-white"><h4>Add Service Provider</h4></div>
        <div class="card-body">
            <form action="AddVendorServlet" method="POST">
                <div class="mb-3">
                    <label class="form-label">Company Name</label>
                    <input type="text" name="vName" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Service Type</label>
                    <select name="vType" class="form-select">
                        <option value="Photography">Photography</option>
                        <option value="Catering">Catering</option>
                        <option value="Decoration">Decoration</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label">Price (LKR)</label>
                    <input type="number" name="vPrice" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="email" name="vEmail" class="form-control" required>
                </div>
                <button type="submit" class="btn btn-success w-100">Register Vendor</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>