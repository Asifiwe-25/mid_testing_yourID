package Controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dao.RoomDao;
import dao.ShelfDao;
import model.Book;
import model.Room;
import model.Shelf;

@WebServlet("/addShelf")
public class AddshelfServlet extends HttpServlet {

	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        RoomDao roomDao = new RoomDao();
	        List<Room> rooms = roomDao.getAllRooms();  
	        
	        request.setAttribute("rooms", rooms);  
	        request.getRequestDispatcher("/shelf.jsp").forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	        String category = request.getParameter("category");
	        int initialStock = Integer.parseInt(request.getParameter("initialStock"));
	        int availableStock = Integer.parseInt(request.getParameter("availableStock"));
	        UUID roomId = UUID.fromString(request.getParameter("roomId"));

	        Shelf shelf = new Shelf();
	        shelf.setId(UUID.randomUUID());
	        shelf.setBook_category(category);
	        shelf.setInitial_stock(initialStock);
	        shelf.setAvailable_stock(availableStock);

	        ShelfDao shelfDao = new ShelfDao();
	        shelfDao.saveShelf(shelf, roomId);  

	        response.sendRedirect("shelf.jsp");  
	    }
}
