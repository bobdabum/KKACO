/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import DataAccessLayer.UserInfo;
import Interfaces.UserInterface;
import JavaBeans.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hien
 */
@WebServlet(name = "EditUserPWController", urlPatterns = {"/EditUserPWController"})
public class EditUserPWController extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            UserInterface userInt = new UserInfo();
            User user = userInt.updateUserPassword(request.getParameter("pw"), Integer.parseInt(request.getParameter("userID")));

            this.getServletContext().getRequestDispatcher("/userProfile.jsp")
                    .forward(request, response);
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Password edit failed. Please try again.');"); // out.println("alert('Login failed. Please try again.');");
            out.println("location='index.jsp';");
            out.println("</script>");
        }
    }
}
