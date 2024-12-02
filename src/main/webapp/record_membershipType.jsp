<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Membership Type - AUCA Library</title>
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

        input {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input:focus {
            outline: none;
            border-color: #0074cc;
            box-shadow: 0 0 5px rgba(0, 116, 204, 0.5);
        }

        input[type="submit"] {
            background-color: #0074cc;
            color: white;
            font-size: 16px;
            font-weight: bold;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }

        input[type="submit"]:hover {
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
    </style>
</head>
<body>
    <header>
        <h1>AUCA Library Management System</h1>
    </header>

    <div class="container">
        <h2>Create New Membership Type</h2>
        <form action="addMembershipType" method="post">
            <label for="membership_name">Membership Name:</label>
            <input type="text" id="membership_name" name="membership_name" required>

            <label for="max_books">Max Books Allowed:</label>
            <input type="number" id="max_books" name="max_books" required>

            <label for="price">Price:</label>
            <input type="number" id="price" name="price" required>

            <input type="submit" value="Create Membership Type">
        </form>
        <p class="info">Ensure all fields are filled correctly before submitting.</p>
    </div>

    <footer>
        <p>&copy; 2024 Adventist University of Central Africa. All rights reserved.</p>
    </footer>
</body>
</html>
