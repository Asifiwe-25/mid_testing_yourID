<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Request Membership - AUCA Library</title>
    <style>
        /* General Styles */
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
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
            max-width: 700px;
            margin: 40px auto;
            padding: 20px;
            background-color: white;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }

        h2 {
            text-align: center;
            color: #004080;
            margin-bottom: 20px;
        }

        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        label {
            font-weight: bold;
            margin-bottom: 5px;
            color: #555;
        }

        input, select {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input:disabled {
            background-color: #e9ecef;
            color: #6c757d;
        }

        input[type="submit"] {
            background-color: #0074cc;
            color: white;
            font-size: 16px;
            font-weight: bold;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #005bb5;
        }

        .info {
            font-size: 14px;
            color: #888;
            text-align: center;
        }

        footer {
            background-color: #003366;
            color: white;
            text-align: center;
            padding: 10px 0;
            margin-top: 30px;
        }

        footer p {
            margin: 0;
            font-size: 12px;
        }
    </style>
</head>
<body>
    <header>
        <h1>AUCA Library Management System</h1>
    </header>

    <div class="container">
        <h2>Request Membership</h2>
        <form action="membershipRequest" method="post">
            <label for="userName">User Name:</label>
            <input type="text" id="userName" name="userName" required>

            <label for="code">Membership Code:</label>
            <input type="text" id="code" name="code" required>

            <label for="membershipType">Membership Type:</label>
            <select name="membershipType" id="membershipType" required>
                <option value="">Select Membership Type</option>
                <c:forEach var="membershipType" items="${membershipTypes}">
                    <option value="${membershipType.membership_type_id}">
                        ${membershipType.membership_name}
                    </option>
                </c:forEach>
            </select>

            <label for="maxBooks">Max Books:</label>
            <input type="text" id="maxBooks" name="maxBooks" value="${membershipType.max_books}" disabled>

            <label for="price">Price:</label>
            <input type="text" id="price" name="price" value="${membershipType.price}" disabled>

            <input type="submit" value="Request Membership">
        </form>
        <p class="info">Fields marked with * are required.</p>
    </div>

    <footer>
        <p>&copy; 2024 Adventist University of Central Africa. All rights reserved.</p>
    </footer>
</body>
</html>
