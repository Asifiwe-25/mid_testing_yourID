/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import dao.BorrowerDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Borrower;
import model.User;

/**
 *
 * @author the-ceo
 */
@WebServlet(name = "UserDashboardServlet", urlPatterns = {"/UserDashboardServlet"})
public class UserDashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession s = request.getSession();
        User user = (User) s.getAttribute("user");
        BorrowerDao bDao = new BorrowerDao();
        List<Borrower> borrowedBooks = bDao.viewBorrowedBooks(user.getPerson_id());
        // Set data to the request
        request.setAttribute("borrowedBooks", borrowedBooks);

        // Forward to JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-dashboard.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle book return
        String bookId = request.getParameter("bookId");
        if (bookId != null) {
            // Simulate removing the returned book (replace with DB logic)
            System.out.println("Book with ID " + bookId + " returned successfully.");
        }

        // Redirect back to the dashboard
        response.sendRedirect("UserDashboardServlet");
    }
}
