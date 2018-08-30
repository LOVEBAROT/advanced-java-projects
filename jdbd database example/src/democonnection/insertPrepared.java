

package democonnection;
import java.sql.*;

public class insertPrepared {

    public static void main(String[] args) {
        
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection  conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/college?zeroDateTimeBehavior=convertToNull", "root", "root");
        PreparedStatement pst=conn.prepareStatement("insert into login values(?,?)");
        pst.setString(1, "SSAAA");
        pst.setInt(2,11221);
        int rs=pst.executeUpdate();
        
            System.out.println("Recored Inserted.."+rs);
            
            conn.close();
        }
        catch(Exception e)
        {
            System.out.println("Error is "+e.toString());
        }
        
    }
    
    
}
