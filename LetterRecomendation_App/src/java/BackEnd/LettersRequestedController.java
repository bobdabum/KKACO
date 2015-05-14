/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import Enums.Params;
import DataAccessLayer.*;
import Interfaces.*;
import JavaBeans.Letter;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hien
 */
@WebServlet(name = "LettersRequestedController", urlPatterns = {Params.URLPATTERN_LETTERSREQUESTED})
public class LettersRequestedController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try{
            LetterInterface letterInt = new LetterInfo();
            int userID = (Integer) request.getSession().getAttribute(Params.USER_ID);
           ArrayList<Letter> letters = letterInt.findLettersRequested(userID);
            request.setAttribute(Params.LETTERS, letters);
            this.getServletContext().getRequestDispatcher(Params.URL_LETTERSREQUESTED)
                    .forward(request, response);
        }
        catch(Exception e){
            
        }
    }
    
     @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {             
            LetterInterface letterInt = new LetterInfo();

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date date = df.parse(request.getParameter(Params.DEADLINE));
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(date);
            
            GregorianCalendar validTo = new GregorianCalendar();
            validTo.setTime(df.parse(request.getParameter(Params.VALIDTO)));

            letterInt.requestLetter(Integer.parseInt(request.getParameter(Params.WRITERID)), 
                    Integer.parseInt(request.getParameter(Params.RECOMENDEEID)),
                    cal, 
                    validTo,
                    Boolean.valueOf(request.getParameter(Params.ISPRIVATE)));
            
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println("Error! " + e.getMessage());
        }
    }
}