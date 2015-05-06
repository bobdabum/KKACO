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
    public ArrayList<Letter> findUserLetterReceived(int userID) throws Exception;
    public ArrayList<Letter> findUserLetterRequested(int userID) throws Exception;
    public void acceptLetter(boolean accepted, int letterID, int userID) throws Exception;
    public void requestLetter(int writer_id, int recomendee_id, GregorianCalendar deadline, GregorianCalendar validto, boolean isPrivate) throws Exception;
    public void submitLetterText(int letterID, String text) throws Exception;
    public void submitLetterFile(int letterID, String url) throws Exception;
    public String[] getLetter(int letterID) throws Exception;
}
