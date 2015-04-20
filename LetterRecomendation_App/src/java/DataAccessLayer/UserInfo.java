/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import Interfaces.UserInterface;
import JavaBeans.User;
import java.sql.*;

/**
 *
 * @author My Pc
 */
public class UserInfo implements UserInterface{
    @Override
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
    @Override
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
    @Override
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
                user.setUserid((int)rs.getLong(1));
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
    public void updateUserPassword(String pw, int userID) throws Exception {
        Connection conn = DataBaseConn.getConnection();
        String query = "UPDATE USER"+
                " SET password = ?"+
                " WHERE user_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        try{
            ps.setString(1, PasswordHash.createHash(pw));
            ps.setInt(2, userID);
            ps.executeUpdate();
        }
        catch(Exception e){
            throw e;
        }
    }

    @Override
    public void updateProfileInfo(int userID, String fName, String lName, String email) throws Exception {
        Connection conn = DataBaseConn.getConnection();
        String query = "UPDATE USER"+
                " SET fname = ?,"+
                " lname = ?,"+
                " email = ?"+
                " WHERE user_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        try{
            ps.setString(1, fName);
            ps.setString(2, lName);
            ps.setString(3, email);
            ps.setInt(4, userID);
            ps.executeUpdate();
        }
        catch(Exception e){
            throw e;
        }
    }
}
