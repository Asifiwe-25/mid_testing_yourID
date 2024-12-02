package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dao.ProvinceDao;
import java.util.List;
import model.Province;
import model.Role;
import model.User;
import util.PasswordUtil;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        RequestDispatcher dis = request.getRequestDispatcher("/login.jsp");
        dis.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        UserDao dao = new UserDao();

        User theUser= dao.getUserByUserName(username);


        if(theUser!=null && PasswordUtil.verify(password, theUser.getPassword())) {

            HttpSession session = request.getSession();
            session.setAttribute("user", theUser);

            String url = new String();

            Role role = theUser.getRole();
            if(Role.DEAN.equals(role)) {
                url="dean.jsp";
            }
            else if(Role.HOD.equals(role)) {
                url = "hod.jsp";
            }
            else if(Role.LIBRARIAN.equals(role)) {
                url = "admin-dashboard.jsp";
            }
            else if(Role.STUDENT.equals(role)) {
                url = "user-dashboard.jsp";
            }
            else if(Role.TEACHER.equals(role)) {
                url = "user-dashboard.jsp";
            }
            else {
                request.setAttribute("feedback", "Invalid credentials");
                url = "/login.jsp";
            }
            dispatcher=request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }
    }
}
	