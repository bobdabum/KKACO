/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import JavaBeans.User;
import Interfaces.UserInterface;
import DataAccessLayer.*;
import Enums.Params;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author My Pc
 */
@WebServlet(name = "UserProfileController", urlPatterns = {"/user_profile"})
public class UserProfileController extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String action = request.getParameter(Params.ACTION);
            UserInterface userInt = new UserInfo();
            User user = null;
            
            if(action.equals("login")){
                user = userInt.findUserByPW(request.getParameter(Params.EMAIL),
                        request.getParameter(Params.PASSWORD));
            }
            else if(action.equals("register")){
                user = userInt.createUser(request.getParameter("email"),
                        request.getParameter("pw"),
                        request.getParameter("fName"),
                        request.getParameter("lName"));
            }
            if(user!=null){
                HttpSession session = request.getSession(true); //Creates an object http session
                session.setAttribute("userid", user.getUserid());
                request.setAttribute("user", user);
                this.getServletContext().getRequestDispatcher("/WEB-INF/userProfile.jsp")
                        .forward(request, response);
            }
            else
                throw new Exception("Can't find user");
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('" + e.getMessage() + "');");
            out.println("location='index.jsp';");
            out.println("</script>");
        }
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            UserInterface userInt = new UserInfo();
            int userID = (Integer) request.getSession(false).getAttribute("userid");
            User user = userInt.findUserByID(userID);
            request.setAttribute("user", user);
           // this.getServletContext().getRequestDispatcher("/WEB-INF/lettersRequested.jsp")
                //    .forward(request, response);
        }
        catch(Exception e){
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('" + e.getMessage() + "');");
            out.println("location='index.jsp';");
            out.println("</script>");            
        }
    }
}
