package Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MembershipDao;
import dao.MembershipTypeDao;
import dao.UserDao;
import model.Membership;
import model.Membership_type;
import model.Status;
import model.User;

@WebServlet("/membershipRequest")
public class MembershipApplication extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MembershipTypeDao membershipDao = new MembershipTypeDao();
        List<Membership_type> membershipTypes = membershipDao.getAllMembershipTypes(); 

        request.setAttribute("membershipTypes", membershipTypes); 

        RequestDispatcher dispatcher = request.getRequestDispatcher("/membership_applicationForm.jsp");
        dispatcher.forward(request, response);
    }
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        UUID membershipTypeId = UUID.fromString(request.getParameter("membershipType"));
        String memberShipCode= request.getParameter("code");
        
        
        UserDao userDao = new UserDao();
        User user = userDao.getUserByUserName(userName);
        if (user == null) {
        	
            request.setAttribute("error", "User not found.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/membership_applicationForm.jsp");
            dispatcher.forward(request, response);
            return;
        }

        MembershipTypeDao membershipDao = new MembershipTypeDao();
        Membership_type selectedMembershipType = membershipDao.getMembershipTypeById(membershipTypeId);
        if (selectedMembershipType == null) {
            request.setAttribute("error", "Invalid membership type selected.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/membership_applicationForm.jsp");
            dispatcher.forward(request, response);
            return;
        }

        Membership membership = new Membership();
        membership.setMembership_type(selectedMembershipType);
        membership.setReader(user);
        membership.setMembership_code(memberShipCode);
        membership.setStatus(Status.PENDING);
        membership.setRegistration_date(new Date());
        MembershipDao dao = new MembershipDao();
        dao.insert(membership);
        user.setMembership(membership); 
        userDao.updateUser(user);
      
        response.sendRedirect("membershipSuccess.jsp"); 
    }

}
