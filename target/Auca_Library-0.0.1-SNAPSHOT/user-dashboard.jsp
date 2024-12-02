<%@page import="model.User"%>
<%@page import="model.Borrower"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard - AUCA Library</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            color: #333;
        }

        header {
            background-color: #004080;
            color: white;
            padding: 20px;
            text-align: center;
        }

        header h1 {
            font-size: 32px;
            margin: 0;
        }

        .container {
            width: 80%;
            max-width: 1200px;
            margin: 40px auto;
            padding: 20px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: #004080;
            text-align: center;
            margin-bottom: 20px;
        }

        .dashboard-options {
            display: flex;
            justify-content: space-around;
            margin-bottom: 30px;
        }

        .dashboard-options a {
            text-decoration: none;
            font-size: 18px;
            color: white;
            padding: 15px 25px;
            background-color: #004080;
            border-radius: 5px;
            transition: background-color 0.3s ease, transform 0.3s ease;
        }

        .dashboard-options a:hover {
            background-color: #0066cc;
            transform: translateY(-2px);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table th, table td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }

        table th {
            background-color: #004080;
            color: white;
        }

        table tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        table tr:hover {
            background-color: #f1f1f1;
        }

        .return-button {
            background-color: #ff4d4d;
            color: white;
            padding: 8px 12px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .return-button:hover {
            background-color: #e63939;
        }

        footer {
            background-color: #003366;
            color: white;
            text-align: center;
            padding: 15px;
            margin-top: 40px;
        }

        footer p {
            margin: 0;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <header>
        <h1>Welcome to AUCA Library Dashboard</h1>
    </header>
    <nav>
        <ul>
            <li><a href="UserDashboardServlet">Borrowed books - Dashboard</a></li>
            <li><a href="LogoutServlet">logout</a></li>
        </ul>
    </nav>

    <div class="container">
        <% User user = (User) session.getAttribute("user"); %>
        <h2>Hello, <%= user!= null ? user.getFirst_name() +" "+ user.getLast_name() : "" %></h2>
        <div class="dashboard-options">
            <a href="borrowBook">Borrow a Book</a>
            <a href="#">Account Settings</a>
        </div>

        <h3>Your Borrowed Books</h3>
        <table>
            <thead>
                <tr>
                    <th>#</th>
                    <th>Title</th>
                    <th>Borrow Date</th>
                    <th>Return Date</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Borrower> borrowedBooks =
                        (List<Borrower>) request.getAttribute("borrowedBooks");

                    if (borrowedBooks != null) {
                        for (Borrower b : borrowedBooks) {
                %>
                <tr>
                    <td><%= b.getBook().getBook_id()%></td>
                    <td><%= b.getBook().getTitle() %></td>
                    <td><%= b.getPickup_date()%></td>
                    <td><%= b.getReturn_date()%></td>
                    <td>
                        <form action="UserDashboardServlet" method="post" style="margin: 0;">
                            <input type="hidden" name="bookId" value="<%= b.getBook().getBook_id()%>">
                            <button type="submit" class="return-button">Return</button>
                        </form>
                    </td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="6">No borrowed books found.</td>
                </tr>
                <%
                    }
                %>
            </tbody>

        </table>
    </div>

    <footer>
        <p>&copy; 2024 Adventist University of Central Africa. All rights reserved.</p>
    </footer>
</body>
</html>
