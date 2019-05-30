/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gznag
 */
public class DbConnection {
    private static DbConnection singleton;
    
    private DbConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){        
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE,null,e);        
        }
    }
    
    public static DbConnection getInstance(){
        if(singleton == null){
           singleton = new DbConnection();
        }
        return singleton;    
    }
    
    public Connection getConnection(){
        Connection conn = null;
        
        String str_conn = "jdbc:mysql://localhost:3306/fpw19_dbserramirco";
                
        try{
            conn = (Connection) DriverManager.getConnection(str_conn, "fpw19_DbSerraMirco", "freePeerReview");
        }catch(SQLException e){
        
            e.printStackTrace();
        }
        return conn;
    }
}
