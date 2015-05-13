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
@WebServlet(name = "RequestsReceivedController", urlPatterns = {Params.URLPATTERN_REQUESTSRECEIVED})
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
            int userID = (Integer) request.getSession(false).getAttribute(Params.USER_ID);
            ArrayList<Letter> letter = letterInt.findRequestsReceived(userID);
            request.setAttribute(Params.LETTERS, letter);
            this.getServletContext().getRequestDispatcher(Params.URL_REQUESTSRECEIVED)
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
            LetterInterface letterInt = new LetterInfo();
            Letter letter = null;
            
            if(action.equals("acceptReject")){
                //need to add 0 and 1 condition  
                letterInt.acceptLetter(Boolean.valueOf(request.getParameter(Params.ACCEPTED)),
                        Integer.parseInt(request.getParameter(Params.LETTERID)),
                        (Integer)request.getSession(false).getAttribute(Params.USER_ID));
            }
            else if(action.equals(Params.SUBMITTEXT)){
                letterInt.submitLetterText(Integer.parseInt(request.getParameter(Params.LETTERID)),
                        request.getParameter(Params.TEXT));
            }
            else if(action.equals(Params.SUBMITFILE)){
                 letterInt.submitLetterFile(Integer.parseInt(request.getParameter(Params.LETTERID)),
                          request.getParameter(Params.URL));
            }
            //Below this is not edited
            if(letter != null){
                HttpSession session = request.getSession(true); //Creates an object http session
                session.setAttribute(Params.LETTERID, letter.getLetter_id());
                request.setAttribute(Params.LETTERS, letter);
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
