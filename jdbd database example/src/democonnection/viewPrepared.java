
package democonnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class viewPrepared {

    public static void main(String[] args) {
        
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/college?zeroDateTimeBehavior=convertToNull", "root", "root");
            PreparedStatement pst=conn.prepareStatement("select * from login");
            ResultSet rs=pst.executeQuery();
            System.out.println("Name "+" "+"Password");
            while(rs.next())
            {
                System.out.println(rs.getString(1)+" "+rs.getInt(2));
            }
        }
        catch(Exception e)
        {
            System.out.println("Error is "+e.toString());
        }
        
        
        
    }
    
    
    
}
