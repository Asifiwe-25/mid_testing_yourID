package Controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dao.BorrowerDao;
import dao.UserDao;
import model.Book;
import model.Book_status;
import model.Borrower;
import model.User;

@WebServlet("/borrowBook")
public class BorrowBookServlet extends HttpServlet {
    
    // This method will handle the GET request to show the book borrowing form
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch list of available books for borrowing
        BookDao bookDao = new BookDao();
        List<Book> availableBooks = bookDao.getAvailableBooks();  
        
        request.setAttribute("availableBooks", availableBooks);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/borrow_book.jsp");
        dispatcher.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        UUID bookId = UUID.fromString(request.getParameter("bookId"));
        
        UserDao userDao = new UserDao();
        User user = userDao.getUserById(userId);
        
        BookDao bookDao = new BookDao();
        Book book = bookDao.getBookById(bookId);
        
        if (book != null) {
            book.setStatus(Book_status.BORROWED);;
            bookDao.updateBook(book);
       
            Borrower borrower = new Borrower();
            borrower.setUser(user);  
            borrower.setBook(book);
            borrower.setPickup_date(new Date());  
            borrower.setDue_date(calculateDueDate()); 
            borrower.setFine(0);  
            borrower.setLate_charge_fees(0); 
            
            BorrowerDao borrowerDao = new BorrowerDao();
            borrowerDao.save(borrower);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/borrow_book.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/borrow_book.jsp");
            dispatcher.forward(request, response);
        }
    }
    
    private Date calculateDueDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 30);  
        return cal.getTime();
    }
}

