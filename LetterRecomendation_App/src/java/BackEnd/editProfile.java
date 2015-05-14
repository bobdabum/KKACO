/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import DataAccessLayer.UserInfo;
import Enums.Params;
import Interfaces.UserInterface;
import JavaBeans.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hien
 */
@WebServlet(name = "editProfile", urlPatterns = {Params.URLPATTERN_EDITPROFILE})
public class editProfile extends HttpServlet {

   @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String action = request.getParameter(Params.ACTION);
            UserInterface userInt = new UserInfo();
            User user = null;
            
            if(action.equals(Params.LOGIN)){
                user = userInt.findUserByPW(request.getParameter(Params.EMAIL),
                        request.getParameter(Params.PASSWORD));
            }
            else if(action.equals(Params.REGISTER)){
                user = userInt.createUser(request.getParameter(Params.EMAIL),
                        request.getParameter(Params.PASSWORD),
                        request.getParameter(Params.FNAME),
                        request.getParameter(Params.LNAME));
            }
            if(user!=null){
                HttpSession session = request.getSession(true); //Creates an object http session
                session.setAttribute(Params.USER_ID, user.getUserid());
                request.setAttribute(Params.USER, user);
                this.getServletContext().getRequestDispatcher(Params.URL_EDITPROFILE)
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
            int userID = (Integer) request.getSession(false).getAttribute(Params.USER_ID);
            User user = userInt.findUserByID(userID);
            request.setAttribute(Params.USER, user);
            this.getServletContext().getRequestDispatcher(Params.URL_EDITPROFILE)
                    .forward(request, response);
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
