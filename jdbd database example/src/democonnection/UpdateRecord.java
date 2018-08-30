

package democonnection;
import java.sql.*;

public class UpdateRecord {

    public static void main(String[] args) {

        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/college?zeroDateTimeBehavior=convertToNull", "root", "root");
        Statement st=conn.createStatement();
        int rs=st.executeUpdate("UPDATE LOGIN SET name='JIGAR' where Password=123");
        if(rs !=0)
        {
            System.out.println("Recorded Updated...");
        }
        else
        {
            System.out.println("Recored not Updated..");
        }
            
        }
        catch(Exception e)
        {
            System.out.println("Error is "+e.toString());
        
        }
        
    }
    
    
}
