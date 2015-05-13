/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import DataAccessLayer.LetterInfo;
import Enums.Params;
import Interfaces.LetterInterface;
import JavaBeans.Letter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "RequestsReceivedController", urlPatterns = {"/letters_received"})
public class RequestsReceivedController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
       public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            LetterInterface letterInt = new LetterInfo();
            int letterID = (Integer) request.getSession(false).getAttribute("letterid");
            ArrayList<Letter> letter = letterInt.findUserLetterRequested(letterID);
            request.setAttribute("letter", letter);
          //  this.getServletContext().getRequestDispatcher("/WEB-INF/userProfile.jsp")
          //          .forward(request, response);
        }
        catch(Exception e){
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('" + e.getMessage() + "');");
            out.println("location='index.jsp';");
            out.println("</script>");            
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String action = request.getParameter(Params.ACTION);
            LetterInterface letterInt = new LetterInfo();// UserInterface userInt = new UserInfo();
            Letter letter = null;
            
            if(action.equals("acceptReject")){
                //need to add 0 and 1 condition  
                letter = letterInt.acceptLetter(Boolean.valueOf(request.getParameter("accepted")),
                        Integer.parseInt(request.getParameter("letterID")),
                        Integer.parseInt(request.getParameter("userID")));
            }
            else if(action.equals("submitText")){
                letter = letterInt.submitLetterText(Integer.parseInt(request.getParameter("letterID")),
                        request.getParameter("text"));
            }
            else if(action.equals("submitFile")){
                 letter = letterInt.submitLetterFile(Integer.parseInt(request.getParameter("letterID")),
                          request.getParameter("URL"));
            }
            //Below this is not edited
            if(letter != null){
                HttpSession session = request.getSession(true); //Creates an object http session
                session.setAttribute("letterid", letter.getLetter_id());
                request.setAttribute("letter", letter);
                this.getServletContext().getRequestDispatcher("/WEB-INF/userProfile.jsp")
                        .forward(request, response);
            }
            else
                throw new Exception("Can't find letter");
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('" + e.getMessage() + "');");
            out.println("location='index.jsp';");
            out.println("</script>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
