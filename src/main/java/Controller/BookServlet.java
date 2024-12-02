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
import dao.ShelfDao;
import model.Book;
import model.Book_status;
import model.Shelf;

@WebServlet("/addBook")
public class BookServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShelfDao shelfDao = new ShelfDao();
        List<Shelf> shelves = shelfDao.getAllShelves();
        
        request.setAttribute("shelves", shelves);
        
        request.getRequestDispatcher("manage-books.jsp").forward(request, response);
    }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String publisher = request.getParameter("publisher");
        String isbn = request.getParameter("isbn");
        int edition = Integer.parseInt(request.getParameter("edition"));
        UUID shelfId = UUID.fromString(request.getParameter("shelfId"));
        
        Book book = new Book();
        book.setTitle(title);
        book.setPublisher_name(publisher);
        book.setISBNCode(isbn);
        book.setEdtition(edition);
        book.setStatus(Book_status.AVAILABLE);
        
        BookDao bookDao = new BookDao();
        bookDao.saveBookAndAssociateWithShelf(book, shelfId);
        
        response.sendRedirect("manage-books.jsp"); 
    }

}
