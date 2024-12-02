<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Book - AUCA Library</title>
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
            max-width: 800px;
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

        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        label {
            font-weight: bold;
            color: #333;
        }

        input[type="text"],
        input[type="number"],
        select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 14px;
        }

        input[type="text"]:focus,
        input[type="number"]:focus,
        select:focus {
            border-color: #004080;
            outline: none;
        }

        input[type="submit"] {
            background-color: #0074cc;
            color: white;
            font-weight: bold;
            border: none;
            border-radius: 5px;
            padding: 10px 15px;
            cursor: pointer;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }

        input[type="submit"]:hover {
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
        <h1>AUCA Library System</h1>
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
        <h2>Create New Book</h2>
        <form action="addBook" method="post">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" placeholder="Enter book title" required>
            
            <label for="publisher">Publisher Name:</label>
            <input type="text" id="publisher" name="publisher" placeholder="Enter publisher name" required>
            
            <label for="isbn">ISBN Code:</label>
            <input type="text" id="isbn" name="isbn" placeholder="Enter ISBN code" required>
            
            <label for="edition">Edition:</label>
            <input type="number" id="edition" name="edition" placeholder="Enter edition number" required>
            
            <label for="shelfId">Shelf:</label>
            <select name="shelfId" required>
                <option value="" disabled selected>Select a shelf</option>
                <c:forEach var="shelf" items="${shelves}">
                    <option value="${shelf.id}">${shelf.book_category}</option>
                </c:forEach>
            </select>
            
            <input type="submit" value="Create Book">
        </form>
    </div>

    <footer>
        <p>&copy; 2024 Adventist University of Central Africa. All rights reserved.</p>
    </footer>
</body>
</html>
