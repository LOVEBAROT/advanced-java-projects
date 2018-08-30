
package democonnection;
import java.sql.*;

public class ViewRecord {
    
    public static void main(String[] args) {
        
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/college?zeroDateTimeBehavior=convertToNull", "root", "root");
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from login");
        while(rs.next())
        {
            System.out.println(rs.getString(1)+"  "+rs.getString(2));
            
        }
        
        }
        catch(Exception e)
        {
            System.out.println("Error is "+e.toString());
        }
        
        
    }
    
    
}
