package Controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RoomDao;
import javax.servlet.RequestDispatcher;
import model.Room;

/**
 * Servlet implementation class RoomServlet
 */
@WebServlet(name = "RoomServlet", urlPatterns = {"/RoomServlet"})
public class RoomServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("create_room.jsp").forward(request, response);
    }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomCode = request.getParameter("code");

        try {
            Room room = new Room();

            room.setRoom_id(UUID.randomUUID());
            room.setRoom_code(roomCode);
            RoomDao theroom = new RoomDao();
            theroom.saveRoom(room);

            RequestDispatcher dis = request.getRequestDispatcher("shelf.jsp");
            dis.forward(request, response);
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}
