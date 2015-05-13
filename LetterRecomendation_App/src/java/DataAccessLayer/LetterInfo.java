/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import Interfaces.LetterInterface;
import JavaBeans.Letter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author My Pc
 */
public class LetterInfo implements LetterInterface{
    @Override
    public ArrayList<Letter> findRequestsReceived(int userID) throws Exception {
        Connection conn = DataBaseConn.getConnection();
        String query = "SELECT writer.fname, writer.lname, recomendee_id, letter_id,"+
                " rec.fname, rec.lname, deadline, validto, requestdate, status, type"+
                " FROM userletter a"+
                " JOIN user writer ON writer.user_id = a.writer_id"+
                " JOIN user rec ON rec.user_id = a.recomendee_id"+
                " WHERE a.writer_id = ?"+
                " AND (a.status = 0 OR a.status = 1)";
        PreparedStatement ps = conn.prepareStatement(query);
        try{
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            ArrayList<Letter> list = new ArrayList<Letter>();
            while(rs.next()){
                Letter letter = new Letter();
                letter.setWriter_fName(rs.getString(1));
                letter.setWriter_lName(rs.getString(2));
                letter.setRecomendee_id(rs.getInt(3));
                letter.setWriter_id(userID);
                letter.setLetter_id(rs.getInt(4));
                letter.setRec_fName(rs.getString(5));
                letter.setRec_lName(rs.getString(6));
                
                GregorianCalendar deadline = new GregorianCalendar();
                deadline.setTime(rs.getDate(7));
                GregorianCalendar validto = new GregorianCalendar();
                validto.setTime(rs.getDate(8));
                GregorianCalendar requestDate = new GregorianCalendar();
                requestDate.setTime(rs.getTimestamp(9));
                letter.setDeadline(deadline);
                letter.setValidto(validto);
                letter.setRequestdate(requestDate);
                letter.setStatus(rs.getInt(10));
                letter.setType(rs.getInt(11));
                list.add(letter);
            }
            return list;
        }
        catch(Exception e){
            throw e;
        }
    }
    
    @Override
    public ArrayList<Letter> findLettersRequested(int userID) throws Exception {
        Connection conn = DataBaseConn.getConnection();
        String query = "SELECT writer.fname, writer.lname, recomendee_id, letter_id,"+
                " rec.fname, rec.lname, deadline, validto, requestdate, status, type"+
                " FROM userletter a"+
                " JOIN user writer ON writer.user_id = a.writer_id"+
                " JOIN user rec ON rec.user_id = a.recomendee_id"+
                " WHERE a.recomendee_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        try{
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            ArrayList<Letter> list = new ArrayList<Letter>();
            while(rs.next()){
                Letter letter = new Letter();
                letter.setWriter_fName(rs.getString(1));
                letter.setWriter_lName(rs.getString(2));
                letter.setRecomendee_id(rs.getInt(3));
                letter.setWriter_id(userID);
                letter.setLetter_id(rs.getInt(4));
                letter.setRec_fName(rs.getString(5));
                letter.setRec_lName(rs.getString(6));
                
                GregorianCalendar deadline = new GregorianCalendar();
                deadline.setTime(rs.getDate(7));
                GregorianCalendar validto = new GregorianCalendar();
                validto.setTime(rs.getDate(8));
                GregorianCalendar requestDate = new GregorianCalendar();
                requestDate.setTime(rs.getTimestamp(9));
                letter.setDeadline(deadline);
                letter.setValidto(validto);
                letter.setRequestdate(requestDate);
                letter.setStatus(rs.getInt(10));
                letter.setType(rs.getInt(11));
                list.add(letter);
            }
            return list;
        }
        catch(Exception e){
            throw e;
        }
    }
    
    @Override
    public void acceptLetter(boolean accepted, int letterID, int userID) throws Exception {
        Connection conn = DataBaseConn.getConnection();
        String query = "UPDATE userletter "
                + " SET status = ?"
                + " WHERE writer_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        try{
            ps.setInt(2, userID);
            ps.setInt(1, (accepted)? 1:2);
            ps.execute();
        }
        catch(Exception e){
            throw e;
        }
    }
    
    @Override
    public void requestLetter(int writer_id, int recomendee_id, GregorianCalendar deadline, GregorianCalendar validto, boolean isPrivate) throws Exception {
        Connection conn = DataBaseConn.getConnection();
        String query = "INSERT INTO userletter(writer_id, recomendee_id, deadline, validto, type)"+
                " VALUES(?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        try{
            ps.setInt(1, writer_id);
            ps.setInt(2, recomendee_id);
            ps.setDate(3, new java.sql.Date(deadline.getTimeInMillis()));
            ps.setDate(4, new java.sql.Date(validto.getTimeInMillis()));
            ps.setInt(5, (isPrivate)? 1:0);
        }
        catch(Exception e){
            throw e;
        }
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
