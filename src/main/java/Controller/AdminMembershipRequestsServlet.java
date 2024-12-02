package Controller;

import dao.MembershipDao;
import model.Membership;
import model.Status;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/adminMembershipRequests")
public class AdminMembershipRequestsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MembershipDao dao = new MembershipDao();
        List<Membership> pendingRequests = dao.getPendingRequests();
        request.setAttribute("pendingRequests", pendingRequests);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adminPendingRequests.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID membershipId =UUID.fromString(request.getParameter("membershipId")) ;
        String action = request.getParameter("action");

        Status status = "approve".equalsIgnoreCase(action) ? Status.APPROVED : Status.REJECTED;

        MembershipDao dao = new MembershipDao();
        dao.updateMembershipStatus(membershipId, status);
        response.sendRedirect("adminMembershipRequests");
    }
}

