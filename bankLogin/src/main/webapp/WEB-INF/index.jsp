<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration and Login System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }

        h2, h3 {
            margin-top: 30px;
            margin-bottom: 10px;
            color: #333;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            color: #666;
        }

        input[type="email"],
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        button[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h2>User Registration and Login System</h2>
    
    <!-- Login Form -->
    <h3>Login</h3>
    <form action="/login" method="post">
        <label>Email:</label><br>
        <input type="email" name="email" required>
        <button type="submit">Send OTP</button>
    </form>
    
    <!-- Signup Form -->
    <h3>Sign Up</h3>
    <form action="/register" method="post">
        <label>Email:</label><br>
        <input type="email" name="email" required><br>
        <label>Mobile Number:</label><br>
        <input type="text" name="mobileNo" required><br>
        <label>User Name:</label><br>
        <input type="text" name="userName" required><br>
        <button type="submit">Sign Up</button>
    </form>
</body>
<script>
document.addEventListener('DOMContentLoaded', function() {
    const value = localStorage.getItem('key');
    if (value !== null) {
        localStorage.removeItem("key");
    }
});
</script>
</html>
