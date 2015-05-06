/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

<<<<<<< HEAD
=======
import Interfaces.UserInterface;
>>>>>>> master
import DataAccessLayer.*;
import JavaBeans.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author My Pc
 */
<<<<<<< HEAD
@WebServlet(name="LoginController1", urlPatterns={"/login"})
public class LoginController extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        try{
            UserInterface userInt = new UserInfo();
            User user = userInt.findUserByPW(request.getParameter("email"),
                    request.getParameter("pw"));
            request.setAttribute("user", user);
            this.getServletContext().getRequestDispatcher("/userProfile.jsp")
                    .forward(request, response);
        }
        catch(Exception e){
            PrintWriter out = response.getWriter();
            out.println("Error! "+e.getMessage());
        }
    }
}
=======
@WebServlet(name = "LoginController1", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            UserInterface userInt = new UserInfo();
            User user = userInt.findUserByPW(request.getParameter("email"),
                    request.getParameter("pw"));
            HttpSession session = request.getSession();
            session.setAttribute("user_id", user.getUserid());
            request.setAttribute("user", user);
            this.getServletContext().getRequestDispatcher("/userProfile.jsp")
                    .forward(request, response);
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('" + e.getMessage() + "');"); // out.println("alert('Login failed. Please try again.');");
            out.println("location='index.jsp';");
            out.println("</script>");
        }
    }
}
>>>>>>> master
