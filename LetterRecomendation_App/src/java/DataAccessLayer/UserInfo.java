/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import Interface.UserInterface;
import JavaBeans.Letter;
import JavaBeans.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author My Pc
 */
public class UserInfo implements UserInterface{
    public User findUserByID(int studentID) throws Exception {
        Connection conn = DataBaseConn.getConnection();
        String query = "SELECT fname, lname, email"+
                " FROM user"+
                " WHERE user_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        try{
            ps.setInt(1, studentID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                User user = new User();
                user.setUserid(studentID);
                user.setfName(rs.getString("fname"));
                user.setlName(rs.getString("lname"));
                user.setEmail(rs.getString("email"));
                return user;
            }
            else{
                throw new Exception("No student with id "+studentID+" found.");
            }
        }
        catch(SQLException e){
            throw e;
        }
    }
    public User findUserByPW(String email, String pw) throws Exception {
        Connection conn = DataBaseConn.getConnection();
        String query = "SELECT fname, lname, email, password, user_id"+
                " FROM user"+
                " WHERE email = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        try{
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                if(PasswordHash.validatePassword(pw, rs.getString("password"))){
                    User user = new User();
                    user.setfName(rs.getString("fname"));
                    user.setlName(rs.getString("lname"));
                    user.setEmail(rs.getString("email"));
                    user.setUserid(Integer.parseInt(rs.getString("user_id")));
                    return user;
                }
                else{
                    throw new Exception("Login failed.");
                }
            }
            else{
                throw new Exception("Login failed.");
            }
        }
        catch(Exception e){
            throw e;
        }
    }
    public User createUser(String email, String pw, String fName, String lName) throws Exception{
        Connection conn = DataBaseConn.getConnection();
        String query = "INSERT INTO USER(fname, lname, email, password)"+
                " VALUES(?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        try{
            ps.setString(1, fName);
            ps.setString(2, lName);
            ps.setString(3, email);
            ps.setString(4, PasswordHash.createHash(pw));
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                User user = new User();
                user.setEmail(email);
                user.setfName(fName);
                user.setlName(lName);
                return user;
            }
            else{
                throw new Exception("Email already exists in system!");
            }
        }
        catch(Exception e){
            throw e;
        }
    }

    @Override
    public User updateUserPassword(String pw, int userID) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User updateProfileInfo(String userID, String fName, String lName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Letter> findUserLetterReceived(int userID) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Letter> findUserLetterRequested(int userID) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void acceptLetter(boolean accepted, int letterID, int userID) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void requestLetter(int writer_id, int recomendee_id, GregorianCalendar deadline, GregorianCalendar validto, boolean isPrivate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void submitLetterText(int letterID, String text) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void submitLetterFile(int letterID, String url) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getLetter(int letterID) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
