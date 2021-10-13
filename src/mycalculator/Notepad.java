
package mycalculator;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class Notepad {  
    public static void main(String[] args) { 
        Notepad pro=new Notepad();
        pro.createConnection();
       
    } 
    void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nstu?zeroDateTimeBehavior=convertToNull","root","");
          Statement stmt=con.createStatement();
          ResultSet rs=stmt.executeQuery("select * from userdata");
          while(rs.next())
                System.out.println(+rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getString(3));
           
      con.close();
        } 
        catch(Exception e){
            System.out.println("e");
        }
    }
    
}
