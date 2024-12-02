<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Pending Membership Requests</title>
    <link rel="stylesheet" href="css/styles.css">
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
            font-size: 24px;
        }

        .container {
            max-width: 1200px;
            margin: 30px auto;
            padding: 20px;
            background-color: white;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }

        .container h2 {
            text-align: center;
            color: #004080;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }

        table thead {
            background-color: #004080;
            color: white;
        }

        table thead th {
            padding: 10px;
            text-align: left;
            font-size: 14px;
        }

        table tbody tr {
            background-color: #f9f9f9;
            border-bottom: 1px solid #ddd;
        }

        table tbody tr:nth-child(even) {
            background-color: #f1f1f1;
        }

        table tbody td {
            padding: 10px;
            text-align: left;
            font-size: 14px;
        }

        table tbody td form {
            display: flex;
            gap: 10px;
        }

        input[type="submit"] {
            padding: 5px 15px;
            border: none;
            border-radius: 5px;
            color: white;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"][value="approve"] {
            background-color: #28a745;
        }

        input[type="submit"][value="approve"]:hover {
            background-color: #218838;
        }

        input[type="submit"][value="reject"] {
            background-color: #dc3545;
        }

        input[type="submit"][value="reject"]:hover {
            background-color: #c82333;
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
        <h1>Admin Dashboard</h1>
    </header>
    <nav>
        <ul>
            <li><a href="LibrarianServlet">Dashboard</a></li>
            <li><a href="addBook">Manage Books</a></li>
            <li><a href="addShelf">Assign Shelf</a></li>
            <li><a href="RoomServlet">Create Room</a></li>
            <li><a href="LogoutServlet">logout</a></li>
        </ul>
    </nav>
    

    <div class="container">
        <h2>Pending Membership Requests</h2>
        <table>
            <thead>
                <tr>
                    <th>User Name</th>
                    <th>Membership Type</th>
                    <th>Membership Code</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="request" items="${pendingRequests}">
                    <tr>
                        <td>${request.reader.user_name}</td>
                        <td>${request.membership_type.membership_name}</td>
                        <td>${request.membership_code}</td>
                        <td>
                            <form action="adminMembershipRequests" method="post">
                                <input type="hidden" name="membershipId" value="${request.membership_id}">
                                <input type="submit" name="action" value="approve">
                                <input type="submit" name="action" value="reject">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <footer>
        <p>&copy; 2024 Adventist University of Central Africa. All rights reserved.</p>
    </footer>
</body>
</html>
