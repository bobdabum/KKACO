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
    public Letter acceptLetter(boolean accepted, int letterID, int userID) throws Exception;
    public Letter requestLetter(int writer_id, int recomendee_id, GregorianCalendar deadline, GregorianCalendar validto, boolean isPrivate) throws Exception;
    public Letter submitLetterText(int letterID, String text) throws Exception;
    public Letter submitLetterFile(int letterID, String url) throws Exception;
    public String[] getLetter(int letterID) throws Exception;
}
