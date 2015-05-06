/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import JavaBeans.User;

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
    public User updateProfileInfo(int userID, String fName, String lName) throws Exception;
} 