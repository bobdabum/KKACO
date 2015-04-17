/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import JavaBeans.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author My Pc
 */
public interface UserInterface {
    //User Methods
    public User findUserByID(int userID) throws Exception;
    public User findUserByPW(String email, String pw) throws Exception;
    public User createUser(String email, String pw, String fName, String lName) throws Exception;
    public User updateUserPassword(String pw, int userID) throws Exception;
    public User updateProfileInfo(String userID, String fName, String lName) throws Exception;
    
    //Letter Methods
    public ArrayList<Letter> findUserLetterReceived(int userID) throws Exception;
    public ArrayList<Letter> findUserLetterRequested(int userID) throws Exception;
    public void acceptLetter(boolean accepted, int letterID, int userID) throws Exception;
    public void requestLetter(int writer_id, int recomendee_id, GregorianCalendar deadline, GregorianCalendar validto, boolean isPrivate) throws Exception;
    public void submitLetterText(int letterID, String text) throws Exception;
    public void submitLetterFile(int letterID, String url) throws Exception;
    public String[] getLetter(int letterID) throws Exception;
    
    //Institute Methods
} 