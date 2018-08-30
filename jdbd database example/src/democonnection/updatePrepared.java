

package democonnection;
import java.sql.*;
public class updatePrepared {
    public static void main(String[] args) {
        
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/college?zeroDateTimeBehavior=convertToNull", "root", "root");
        PreparedStatement pst=conn.prepareStatement("update login set name=? where password=?");
        pst.setString(1, "love");
        pst.setInt(2, 222);
        
        
        int i=pst.executeUpdate();
        
            System.out.println("Total Number of Updatede Recored is "+i);
        }
        catch(Exception e)
        {
            System.out.println("Error is "+e.toString());
        }
        
    }
    
    
    
}
