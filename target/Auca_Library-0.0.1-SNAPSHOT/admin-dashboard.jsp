<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard - AUCA</title>
    <link rel="stylesheet" href="css/styles.css">
    <style>
        /* Include your existing styles here */
        body, header, nav, .dashboard-container, footer {
            /* Existing styles from your example */
        }

        /* Table Styles */
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }

        table th, table td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }

        table th {
            background-color: #004080;
            color: white;
            font-weight: bold;
        }

        table tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        table tr:hover {
            background-color: #ddd;
        }

        .table-section {
            margin-bottom: 40px;
        }

        .table-section h3 {
            color: #004080;
            margin-bottom: 10px;
        }

        .table-section a {
            color: #0074cc;
            text-decoration: none;
            font-weight: bold;
        }

        .table-section a:hover {
            text-decoration: underline;
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

    <div class="dashboard-container">
        <h2>Welcome to the Admin Dashboard</h2>

        <!-- Users Table -->
        <h3>Users</h3>
        <!--<a href="add-user.jsp">Add User</a>-->
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Phone</th>
                    <th>Role</th>
                    <th>Gender</th>
                    <th>Membership Status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.person_id}</td>
                        <td>${user.first_name} ${user.last_name}</td>
                        <td>${user.phone_number}</td>
                        <td>${user.role}</td>
                        <td>${user.gender}</td>
                        <td>${user.membership.status}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <h3>Search User Location</h3>
        <form action="LibrarianServlet" method="GET">
            <label for="phoneNumber">Enter Phone Number:</label>
            <input type="text" id="phoneNumber" name="phoneNumber" required>
            <button type="submit">Get Location</button>
        </form>

        <c:if test="${not empty userLocation}">
            <p><strong>Province :</strong> ${userLocation.cell.sector.district.province.name}</p>
            <p><strong>District :</strong> ${userLocation.cell.sector.district.name}</p>
            <p><strong>Sector :</strong> ${userLocation.cell.sector.name}</p>
            <p><strong>Cell :</strong> ${userLocation.cell.name}</p>
            <p><strong>Village :</strong> ${userLocation.name}</p>
        </c:if>


        <!-- Books Table -->
        <h3>Books</h3>
        <a href="addBook">Add Book</a>
        <table border="1">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Edition</th>
                    <th>ISBN</th>
                    <th>Publisher</th>
                    <th>Status</th>
                    <th>Category</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td>${book.title}</td>
                        <td>${book.edition}</td>
                        <td>${book.isbnCode}</td>
                        <td>${book.publisherName}</td>
                        <td>${book.status}</td>
                        <td>${book.shelf.book_category}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- Shelves Table -->
        <h3>Shelves</h3>
        <a href="addShelf">Add Shelf</a>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Initial Stock</th>
                    <th>Available Stock</th>
                    <th>Category</th>
                    <th>Borrowed Number</th>
                    <th>Location</th>
                    
                </tr>
            </thead>
            <tbody>
                <c:forEach var="shelf" items="${shelves}">
                    <tr>
                        <td>${shelf.id}</td>
                        <td>${initial_stock}</td>
                        <td>${available_stock}</td>
                        <td>${shelf.book_category}</td>
                        <td>${shelf.borrowed_number}</td>
                        <td>${shelf.location}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- Rooms Table -->
        <h3>Rooms</h3>
        <a href="RoomServlet">Add Room</a>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="room" items="${rooms}">
                    <tr>
                        <td>${room.room_id}</td>
                        <td>${room.room_code}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- Pending Membership Approvals -->
        <h3>Pending Memberships</h3>
        <!--<a href="approve-memberships.jsp">Approve Memberships</a>-->
        
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
                <c:forEach var="m" items="${membs}">
                    <tr>
                        <td>${m.reader.first_name} ${m.reader.last_name}</td>
                        <td>${m.membership_type.membership_name}</td>
                        <td>${m.membership_code}</td>
                        <td>
                            <form action="adminMembershipRequests" method="post">
                                <input type="hidden" name="membershipId" value="${m.membership_id}">
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
