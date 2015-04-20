/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import DataAccessLayer.UserInfo;
import Interface.UserInterface;
import JavaBeans.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hien
 */
@WebServlet(name = "RequestLetterController", urlPatterns = {"/RequestLetterController"})
public class RequestLetterController extends HttpServlet {

     @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
             
            UserInterface userInt = new UserInfo();

            DateFormat df = new SimpleDateFormat("dd MM yyyy");
            Date date = df.parse(request.getParameter("deadline"));
            Calendar cal = new GregorianCalendar();
            cal.setTime(date);

            User user = userInt.requestLetter(Integer.parseInt(request.getParameter("writer_id")), 
                    Integer.parseInt(request.getParameter("recomendee_id")),
                    cal, 
                    request.getParameter("validto"),
                    request.getParameter("isPrivate"));

            this.getServletContext().getRequestDispatcher("/userProfile.jsp")
                    .forward(request, response);
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println("Error! " + e.getMessage());
        }
    }
}