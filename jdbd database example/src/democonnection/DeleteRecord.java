
package democonnection;
import java.sql.*;
public class DeleteRecord {

    public static void main(String[] args) {
        
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/college?zeroDateTimeBehavior=convertToNull", "root", "root");
        Statement st=conn.createStatement();
        int rs=st.executeUpdate("Delete from login where Name='SSAAA'");
        if(rs!=0)
        {
            System.out.println("Record Deleted...");
        }
        else
        {
            System.out.println("Not Deleted...");
        }
        }
        catch(Exception e)
        {
            System.out.println("Error is "+e.toString());
        }
        
        
        
    }
    
    
}
