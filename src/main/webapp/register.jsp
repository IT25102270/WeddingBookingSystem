<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Couple Registration | Wedding Booking System</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <div class="card shadow">
        <div class="card-header bg-primary text-white text-center">
          <h4>Register Your Wedding</h4>
        </div>
        <div class="card-body">
          <form action="RegisterServlet" method="POST">
            <div class="mb-3">
              <label for="partner1" class="form-label">Partner 1 Name</label>
              <input type="text" class="form-control" id="partner1" name="partner1" required>
            </div>
            <div class="mb-3">
              <label for="partner2" class="form-label">Partner 2 Name</label>
              <input type="text" class="form-control" id="partner2" name="partner2" required>
            </div>
            <div class="mb-3">
              <label for="email" class="form-label">Email Address</label>
              <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="mb-3">
              <label for="password" class="form-label">Password</label>
              <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <div class="mb-3">
              <label for="weddingDate" class="form-label">Planned Wedding Date</label>
              <input type="date" class="form-control" id="weddingDate" name="weddingDate" required>
            </div>
            <button type="submit" class="btn btn-primary w-100">Create Account</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>