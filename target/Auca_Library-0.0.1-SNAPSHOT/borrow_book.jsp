<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Borrow Book - AUCA Library</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
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
<body class="bg-gray-50 min-h-screen">
    <header>
        <h1>Welcome to AUCA Library Dashboard</h1>
    </header>
     <nav>
        <ul>
            <li><a href="UserDashboardServlet">Borrowed books - Dashboard</a></li>
            <li><a href="#">Account setting</a></li>
            <li><a href="LogoutServlet">logout</a></li>
        </ul>
    </nav>
    <!-- Main Content -->
    <div class="max-w-6xl mx-auto py-8 px-4">
        <h1 class="text-3xl font-bold text-center mb-6">Available Books for Borrowing</h1>

        <!-- Check if user is logged in -->
        <c:if test="${not empty user}">
            <c:choose>
                <c:when test="${user.membership != null && user.membership.status == 'APPROVED'}">
                    <c:if test="${not empty availableBooks}">
                        <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
                            <c:forEach var="book" items="${availableBooks}">
                                <div class="bg-white shadow-lg rounded-lg overflow-hidden">
                                    <!-- Book Details -->
                                    <div class="p-6">
                                        <h3 class="text-xl font-semibold text-gray-800">${book.title}</h3>
                                        <p class="mt-2 text-gray-600"><strong>Edition:</strong> ${book.edition}</p>
                                        <p class="mt-2 text-gray-600"><strong>ISBN:</strong> ${book.isbnCode}</p>
                                        <p class="mt-2 text-gray-600"><strong>Publication Year:</strong> ${book.publicationYear}</p>
                                        <p class="mt-2 text-gray-600"><strong>Publisher:</strong> ${book.publisherName}</p>
                                        <p class="mt-2 text-gray-600"><strong>Status:</strong> ${book.status}</p>

                                        <!-- Borrow Button -->
                                        <c:choose>
                                            <c:when test="${book.status == 'AVAILABLE'}">
                                                <form action="BorrowServlet" method="POST" class="mt-4">
                                                    <input type="hidden" name="bookId" value="${book.bookId}">
                                                    <input type="hidden" name="action" value="borrowBook">
                                                    <button type="submit" class="bg-blue-600 text-white px-4 py-2 rounded">
                                                        Borrow Now
                                                    </button>
                                                </form>
                                            </c:when>
                                            <c:otherwise>
                                                <div class="mt-4 bg-red-100 border border-red-400 text-red-700 px-4 py-2 rounded">
                                                    Not available for borrowing.
                                                </div>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </c:if>
                    <c:if test="${empty availableBooks}">
                        <p class="text-center text-gray-600">No books available for borrowing at the moment.</p>
                    </c:if>
                </c:when>

                <c:otherwise>
                    <div class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded text-center">
                        Your membership is not approved. Please wait for approval to borrow books.
                    </div>
                </c:otherwise>
            </c:choose>
        </c:if>

        <!-- User not logged in -->
        <c:if test="${empty user}">
            <div class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded text-center">
                Please <a href="/login.jsp" class="text-blue-600 underline">log in</a> to borrow books.
            </div>
        </c:if>
    </div>
</body>
</html>
