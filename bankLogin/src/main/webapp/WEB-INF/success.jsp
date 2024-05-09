<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Successful Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            text-align: center;
        }

        .message {
            color: #007bff;
            font-size: 24px;
            margin-bottom: 20px;
        }

        .logout-button {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .logout-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <p class="message">Successfully Logged In</p>
        <button class="logout-button" onclick="logout()">Logout</button>
    </div>
</body>
<script>
function logout() {
    window.location.href = '/';
}

document.addEventListener('DOMContentLoaded', function() {
    const value = localStorage.getItem('key');
    if (value !== null) {
        localStorage.removeItem("key");
    }
});
</script>
</html>
