<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create Room</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <header>
        <h1>Create Room</h1>
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

    <div class="form-container">
        <form action="RoomServlet" method="post">
            <label for="code">Room Code:</label>
            <input type="text" id="code" name="code" required placeholder="Enter Room Code">
            <button type="submit">Create Room</button>
        </form>
    </div>

    <div class="back-link">
        <a href="LibrarianServlet">Back to Dashboard</a>
    </div>
</body>
</html>
