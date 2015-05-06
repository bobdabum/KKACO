/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import DataAccessLayer.LetterInfo;
import DataAccessLayer.UserInfo;
import Interfaces.*;
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
             
            LetterInterface letterInt = new LetterInfo();

            DateFormat df = new SimpleDateFormat("dd MM yyyy");
            Date date = df.parse(request.getParameter("deadline"));
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(date);
            
            GregorianCalendar validTo = new GregorianCalendar();
            validTo.setTime(df.parse(request.getParameter("validto")));

            letterInt.requestLetter(Integer.parseInt(request.getParameter("writer_id")), 
                    Integer.parseInt(request.getParameter("recomendee_id")),
                    cal, 
                    validTo,
                    Boolean.valueOf(request.getParameter("isPrivate")));

            this.getServletContext().getRequestDispatcher("/userProfile.jsp")
                    .forward(request, response);
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println("Error! " + e.getMessage());
        }
    }
}