<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styles.css">
    <title>Create Shelf - AUCA Library Management</title>
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
            background-color: #004080; /* AUCA Blue */
            color: white;
            padding: 20px;
            text-align: center;
        }

        header h1 {
            margin: 0;
            font-size: 28px;
        }

        .container {
            max-width: 800px;
            margin: 40px auto;
            padding: 20px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
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

        input:focus, select:focus {
            outline: none;
            border-color: #0074cc;
            box-shadow: 0 0 5px rgba(0, 116, 204, 0.5);
        }

        button {
            background-color: #0074cc;
            color: white;
            font-size: 16px;
            font-weight: bold;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }

        button:hover {
            background-color: #005bb5;
            transform: translateY(-2px);
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

        /* Mobile Responsiveness */
        @media (max-width: 768px) {
            header h1 {
                font-size: 22px;
            }

            .container {
                padding: 15px;
            }

            form {
                gap: 10px;
            }
        }
    </style>
</head>
<body>

    <header>
        <h1>AUCA Library Management System</h1>
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
        <h2>Create New Shelf</h2>
        <form action="addShelf" method="post">
            <label for="roomId">Room:</label>
            <select name="roomId" required>
                <c:forEach var="room" items="${rooms}">
                    <option value="${room.room_id}">${room.room_code}</option>
                </c:forEach>
            </select>

            <label for="category">Category:</label>
            <input type="text" id="category" name="category" required>

            <label for="initialStock">Initial Stock:</label>
            <input type="number" id="initialStock" name="initialStock" required>

            <label for="availableStock">Available Stock:</label>
            <input type="number" id="availableStock" name="availableStock" required>

            <button type="submit">Create Shelf</button>
        </form>

        <p class="info">Please fill out the details above to create a new shelf.</p>
    </div>

    <footer>
        <p>&copy; 2024 Adventist University of Central Africa. All rights reserved.</p>
    </footer>

</body>
</html>
