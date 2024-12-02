html<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Membership Types - AUCA Library</title>
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
            background-color: white;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }

        h2 {
            text-align: center;
            color: #004080;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        table th, table td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: center;
        }

        table th {
            background-color: #004080;
            color: white;
        }

        table tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        table tr:hover {
            background-color: #e6f7ff;
        }

        a {
            display: inline-block;
            text-decoration: none;
            font-weight: bold;
            color: white;
            background-color: #0074cc;
            padding: 10px 20px;
            border-radius: 5px;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }

        a:hover {
            background-color: #005bb5;
            transform: translateY(-2px);
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
        <h2>List of Membership Types</h2>
        <table>
            <thead>
                <tr>
                    <th>Membership Name</th>
                    <th>Max Books</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="membership" items="${membershipTypes}">
                    <tr>
                        <td>${membership.membership_name}</td>
                        <td>${membership.max_books}</td>
                        <td>${membership.price}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div style="text-align: center;">
            <a href="addMembershipType.jsp">Create New Membership Type</a>
        </div>
    </div>

    <footer>
        <p>&copy; 2024 Adventist University of Central Africa. All rights reserved.</p>
    </footer>
</body>
</html>
