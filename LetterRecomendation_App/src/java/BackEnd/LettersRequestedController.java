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
        try {
            LetterInterface letterInt = new LetterInfo();
            int userID = (Integer) request.getSession().getAttribute(Params.USER_ID);
            //ArrayList<Letter> letters = letterInt.findLettersRequested(userID);
            
            Letter let1 = new Letter(); 
            let1.setWriter_fName("Kim");
            let1.setWriter_lName("Araracap");
            let1.setStatus(0);
            
            Letter let2 = new Letter();
            let2.setWriter_fName("Ralph");
            let2.setWriter_lName("Lauren");
            let2.setStatus(2);
            
            Letter let3 = new Letter();
            let3.setWriter_fName("Lauren");
            let3.setStatus(3);
            GregorianCalendar now = new GregorianCalendar();
            let3.setDeadline(now);
            
            ArrayList<Letter> letters = new ArrayList<Letter>();
            letters.add(let1);
            letters.add(let2);
            letters.add(let3);
            
            request.setAttribute(Params.LETTERS, letters);
            this.getServletContext().getRequestDispatcher(Params.URL_LETTERSREQUESTED)
                    .forward(request, response);
        } catch (Exception e) {

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

            letterInt.requestLetter(request.getParameter(Params.EMAIL),
                    (Integer) request.getSession().getAttribute(Params.USER_ID),
                    cal,
                    validTo,
                    Boolean.valueOf(request.getParameter(Params.ISPRIVATE)));

            doGet(request, response);
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println("Error! " + e.getMessage());
        }
    }
}
