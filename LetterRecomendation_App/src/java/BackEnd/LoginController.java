/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import Interfaces.UserInterface;
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