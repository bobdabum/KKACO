/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;

/**
 *
 * @author Linye Ouyang
 */
public class DataBaseConn {
    public static final String URL = "jdbc:mysql://localhost:3306/kkoca";
    public static final String NAME = "root";
    public static final String PW = "";
    public static Connection getConnection() throws SQLException, NamingException{
        Context initContext = new InitialContext();
        Context envContext  = (Context)initContext.lookup("java:/comp/env");
        DataSource datasource = (DataSource)envContext.lookup("jdbc/kkoca");
        return datasource.getConnection();
    }
}
