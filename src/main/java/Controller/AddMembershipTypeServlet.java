package Controller;

import dao.MembershipTypeDao;
import model.Membership_type;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/addMembershipType")
public class AddMembershipTypeServlet extends HttpServlet {

    // Display the membership type creation form
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to the addMembershipType.jsp to display the form
        RequestDispatcher dispatcher = request.getRequestDispatcher("membershipTypeList.jsp");
        dispatcher.forward(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String membershipName = request.getParameter("membership_name");
        int maxBooks = Integer.parseInt(request.getParameter("max_books"));
        int price = Integer.parseInt(request.getParameter("price"));

        Membership_type newMembershipType = new Membership_type();
        newMembershipType.setMembership_name(membershipName);
        newMembershipType.setMax_books(maxBooks);
        newMembershipType.setPrice(price);

        MembershipTypeDao membershipTypeDao = new MembershipTypeDao();
        membershipTypeDao.save(newMembershipType);

      
        response.sendRedirect("/addMembershipType");  
    }
}
