/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import JavaBeans.Letter;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author My Pc
 */
public interface LetterInterface {        
    //Letter Methods
    /**
     * Finds LOR requests received by a user.
     * @param userID User ID of the receiver.
     * @return Returns list of letter requests.
     * @throws Exception Throws DB exceptions.
     */
    public ArrayList<Letter> findRequestsReceived(int userID) throws Exception;
    /**
     * Finds LOR requested by a user
     * @param userID User ID of requester
     * @return Returns list of requests user has sent.
     * @throws Exception 
     */
    public ArrayList<Letter> findLettersRequested(int userID) throws Exception;
    /**
     * User accepts or rejects a letter request.
     * @param accepted True = accepted, false = rejected.
     * @param letterID LetterID of the requested letter.
     * @param userID The user ID of the writer.
     * @return
     * @throws Exception 
     */
    public void acceptLetter(boolean accepted, int letterID, int userID) throws Exception;
    public void requestLetter(String email, int recomendee_id, GregorianCalendar deadline, GregorianCalendar validto, boolean isPrivate) throws Exception;
    public void submitLetterText(int letterID, String text) throws Exception;
    public void submitLetterFile(int letterID, String url) throws Exception;
    public String[] getLetter(int letterID) throws Exception;
}
