/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import JavaBeans.User;

/**
 *
 * @author My Pc
 */
public interface UserInterface {
    public User findUserByID(int studentID) throws Exception;
    public User findUserByPW(String email, String pw) throws Exception;
    public User createUser(String email, String pw, String fName, String lName) throws Exception;
}
