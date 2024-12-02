/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import dao.BookDao;
import dao.MembershipDao;
import dao.RoomDao;
import dao.ShelfDao;
import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;
import model.Membership;
import model.Room;
import model.Shelf;
import model.User;

/**
 *
 * @author the-ceo
 */
@WebServlet(name = "LibrarianServlet", urlPatterns = {"/LibrarianServlet"})
public class LibrarianServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        UserDao userDao = new UserDao();
        BookDao bookDao = new BookDao();
        ShelfDao shelDao = new ShelfDao();
        RoomDao roomDao = new RoomDao();
        MembershipDao membDao = new MembershipDao();
        
        List<User> users = userDao.showAll();
        List<Book> books = bookDao.showAll();
        List<Shelf> shelves = shelDao.getAllShelves();
        List<Room> rooms = roomDao.getAllRooms();
        List<Membership> membs = membDao.getPendingRequests();
        
        request.setAttribute("users", users);
        request.setAttribute("books", books);
        request.setAttribute("shelves", shelves);
        request.setAttribute("rooms", rooms);
        request.setAttribute("membs", membs);
        
        String phoneNumber = request.getParameter("phoneNumber");

        // Fetch location by phone number (mock or DB query)
        User user = userDao.findByPhoneNumber(phoneNumber);
        if (user != null && user.getLocation() != null) {
            response.getWriter().print("User location: " + user.getLocation().getName());
            request.setAttribute("userLocation", user.getLocation());
        } else if (user != null) {
            response.getWriter().print("User found, but location is not set.");
            request.setAttribute("userLocation", "No location available");
        } else {
            request.setAttribute("userLocation", "Not Found");
        }

        
//        RequestDispatcher dis = request.getRequestDispatcher("admin-dashboard.jsp");
//        dis.forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
