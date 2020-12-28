/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author PY
 */
public class DatabaseAccess {
    protected Connection co;
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    String user = "sys as sysdba";
    String pass = "Oracle123";
    String driver = "oracle.jdbc.OracleDriver";
    
    public void getConnection(){
        try {
            Class.forName(driver);
            co = DriverManager.getConnection(url, user, pass);
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getconnection2(){
        try {
            // Set the connection properties.
            // required: SYSDBA
            Properties prop = new Properties();
            prop.setProperty("user","sys");
            prop.setProperty("password","Oracle123");
            prop.setProperty("internal_logon","sysdba");

            OracleDataSource ods = new OracleDataSource();
            ods.setConnectionProperties(prop);
            ods.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
            OracleConnection ocon = (OracleConnection)ods.getConnection();
            System.out.println("Connected");     

          } catch(SQLException e) {
            System.out.println(e.getMessage());
          }
    }
    public void getClose(){
        try {
            co.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
