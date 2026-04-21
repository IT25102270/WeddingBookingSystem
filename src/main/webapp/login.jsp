<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Login | Wedding Booking System</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-md-5">

      <% if ("success".equals(request.getParameter("status"))) { %>
      <div class="alert alert-success text-center">Registration successful! Please login.</div>
      <% } else if ("error".equals(request.getParameter("error"))) { %>
      <div class="alert alert-danger text-center">Invalid email or password.</div>
      <% } %>

      <div class="card shadow">
        <div class="card-header bg-success text-white text-center">
          <h4>Account Login</h4>
        </div>
        <div class="card-body">
          <form action="LoginServlet" method="POST">
            <div class="mb-3">
              <label for="email" class="form-label">Email Address</label>
              <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="mb-3">
              <label for="password" class="form-label">Password</label>
              <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <button type="submit" class="btn btn-success w-100">Login</button>
          </form>
          <div class="text-center mt-3">
            <a href="register.jsp">Don't have an account? Register here.</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>