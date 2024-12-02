<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to AUCA Library</title>
    <style>
        /* General Styles */
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
            color: #333;
        }

        header {
            background-color: #004080; /* AUCA Blue Theme */
            color: white;
            padding: 20px;
            text-align: center;
        }

        header h1 {
            margin: 0;
            font-size: 28px;
        }

        .container {
            max-width: 900px;
            margin: 50px auto;
            padding: 20px;
            text-align: center;
            background-color: white;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }

        .container h2 {
            color: #004080;
            margin-bottom: 20px;
        }

        .nav-links {
            margin-top: 20px;
        }

        .nav-links a {
            text-decoration: none;
            font-weight: bold;
            color: #0074cc;
            margin: 0 15px;
            padding: 10px 20px;
            border: 2px solid #0074cc;
            border-radius: 5px;
            transition: all 0.3s ease;
        }

        .nav-links a:hover {
            background-color: #0074cc;
            color: white;
            transform: translateY(-2px);
        }

        footer {
            background-color: #003366;
            color: white;
            text-align: center;
            padding: 10px 0;
            margin-top: 50px;
        }

        footer p {
            margin: 0;
            font-size: 12px;
        }
    </style>
</head>
<body>
    <header>
        <h1>Welcome to AUCA Library Management System</h1>
    </header>

    <div class="container">
        <h2>Your Gateway to Knowledge</h2>
        <p>Explore thousands of books, journals, and digital resources. Manage your memberships, request books, and enhance your learning experience with ease.</p>
        <div class="nav-links">
            <a href="login">Login</a>
            <a href="register.jsp">Register</a>
        </div>
    </div>

    <footer>
        <p>&copy; 2024 Adventist University of Central Africa. All rights reserved.</p>
    </footer>
</body>
</html>

