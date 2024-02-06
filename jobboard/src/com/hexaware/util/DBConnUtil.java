package com.hexaware.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnUtil {
	
    public static Connection getConnection() throws SQLException, FileNotFoundException, IOException, ClassNotFoundException 
    {
    	
    	Connection con=null;

                try 
                {
                   Class.forName("com.mysql.cj.jdbc.Driver");
            
                   con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jobboard","root","Root");
                    
            return con;
            
                
        } catch (Exception e) {
          
              System.out.println(e);
        }
                return con;
    }
}
