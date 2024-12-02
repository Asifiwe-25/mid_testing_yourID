<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - AUCA Library Management System</title>
    
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
            max-width: 700px;
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

     <div class="container">
        <h2>Create Your Account</h2>
        <form action="user" method="post">
            <!-- Personal Details -->
            <label for="firstname">Enter your First Name:</label>
            <input type="text" id="firstname" name="firstname" required>

            <label for="lastname">Enter your Last Name:</label>
            <input type="text" id="lastname" name="lastname" required>

            <label for="phoneNumber">Enter your Phone Number:</label>
            <input type="text" id="phoneNumber" name="phoneNumber" required>

            <label for="gender">Select Gender:</label>
            <select id="gender" name="gender" required>
                <option value="MALE">Male</option>
                <option value="FEMALE">Female</option>
            </select>

            <!-- Account Details -->
            <label for="username">Enter your Username:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Enter your Password:</label>
            <input type="password" id="password" name="password" required>

            <label for="role">Select Role:</label>
            <select id="role" name="role" required>
                <option value="LIBRARIAN">Librarian</option>
                <option value="STUDENT">Student</option>
                <option value="TEACHER">Teacher</option>
                <option value="HOD">HOD</option>
                <option value="DEAN">Dean</option>
            </select>
            <h3>Memberships Details</h3>
            <label for="memb">Request Preferred Membership:</label>
            <select id="memb" name="memb" required>
                <option value="GOLD">GOLD 5 Books (Frw 500)</option>
                <option value="SILVER">SILVER 3 Books (Frw 300)</option>
                <option value="STRIKE">STRIKE 1 Book (Frw 100)</option>
            </select>

            <!-- Location Details -->
            <h3>Location Details</h3>
            <label for="province">Province:</label>
            <input type="text" id="province" name="province" required>

            <label for="district">District:</label>
            <input type="text" id="district" name="district" required>

            <label for="sector">Sector:</label>
            <input type="text" id="sector" name="sector" required>

            <label for="cell">Cell:</label>
            <input type="text" id="cell" name="cell" required>

            <label for="village">Village:</label>
            <input type="text" id="village" name="village" required>

            <button type="submit">Register</button>
        </form>
        <p class="info">Please fill out all the fields above to create your account.</p>
    </div>

    <footer>
        <p>&copy; 2024 Adventist University of Central Africa. All rights reserved.</p>
    </footer>

</body>
</html>
