package Controller;


import dao.MembershipDao;
import dao.MembershipTypeDao;
import dao.ProvinceDao;
import dao.UserDao;
import dao.VillageDao;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cell;
import model.District;
import model.GENDER;
import model.Location;
import model.Location_type;
import model.Membership;
import model.Membership_type;
import model.Province;
import model.Role;
import model.Sector;
import model.Status;
import model.User;
import model.Village;
import util.PasswordUtil;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Extract personal details
            String firstname = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");
            String phoneNumber = request.getParameter("phoneNumber");
            String gender = request.getParameter("gender");
            String role = request.getParameter("role");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String hashedPass = PasswordUtil.hash(password);
            String memb = request.getParameter("memb");
            Membership_type mt = new Membership_type();
            MembershipTypeDao mtdao = new MembershipTypeDao();
            List<Membership_type> membs = mtdao.getAllMembershipTypes();
            if (membs == null || membs.isEmpty()){
                Membership_type pMt1 = mt;
                Membership_type pMt2 = mt;
                Membership_type pMt3 = mt;
                
                pMt1.setMax_books(5);
                pMt1.setMembership_name("GOLD");
                pMt1.setPrice(500);
                
                pMt2.setMax_books(3);
                pMt2.setMembership_name("SILVER");
                pMt2.setPrice(300);
                
                pMt3.setMax_books(1);
                pMt3.setMembership_name("STRIKE");
                pMt3.setPrice(100);
                
                mtdao.save(pMt3);
                mtdao.save(pMt2);
                mtdao.save(pMt1);
                
            }
            switch (memb) {
                case "GOLD":
                    mt = mtdao.getMembershipTypeByName(memb);
                    break;
                case "STRIKE":
                    mt = mtdao.getMembershipTypeByName(memb);
                    break;
                case "SILVER":
                    mt = mtdao.getMembershipTypeByName(memb);
                    break;
            }

            // Extract location details
            String provinceName = request.getParameter("province");
            String districtName = request.getParameter("district");
            String sectorName = request.getParameter("sector");
            String cellName = request.getParameter("cell");
            String villageName = request.getParameter("village");

            // Create location hierarchy
            Province province = new Province(provinceName);
            District district = new District(districtName, province);
            Sector sector = new Sector(sectorName, district);
            Cell cell = new Cell(cellName, sector);
            Village village = new Village(villageName, cell);

            // Add hierarchical relationships
            province.addDistrict(district);
            district.addSector(sector);
            sector.addCell(cell);
            cell.addVillage(village);

            // Save entities using DAOs
            ProvinceDao provinceDao = new ProvinceDao();
            provinceDao.save(province); // Cascading saves district, sector, cell, and village
 
            UserDao userDao = new UserDao();
            VillageDao vdao = new VillageDao();
            
            // Fetch saved village
            Village persistedVillage = vdao.findById(village.getId());

            // Create user
            User user = new User();
            user.setPerson_id(UUID.randomUUID());
            user.setFirst_name(firstname);
            user.setLast_name(lastName);
            user.setPhone_number(phoneNumber);
            user.setGender(GENDER.valueOf(gender));
            user.setRole(Role.valueOf(role));
            user.setUser_name(username);
            user.setPassword(hashedPass);
            user.setLocation(persistedVillage);
            
            // Save User
            userDao.insert(user);

            // Create membership
            Membership membership = new Membership();
            membership.setMembership_code(UUID.randomUUID().toString());
            membership.setRegistration_date(new Date());
            membership.setExpiring_time(Date.from(LocalDate.now().plusYears(1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
            membership.setStatus(Status.PENDING);
            membership.setReader(user);
            membership.setMembership_type(mt);
            MembershipDao membershipDao = new MembershipDao();
            membershipDao.insert(membership);

            request.setAttribute("feedback", "Registration complete! You can now log in.");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("feedback", "Error occurred during registration. Please try again.");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }

}
