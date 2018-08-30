package democonnection;
import java.sql.*;
public class deletePrepared {
    public static void main(String[] args) {
        
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/college?zeroDateTimeBehavior=convertToNull", "root", "root");
        PreparedStatement pst=conn.prepareStatement("delete from login where password=? or name=?");
        pst.setString(2,"AAA");
        pst.setInt(1, 111);
        
        int i=pst.executeUpdate();
            System.out.println("Recored Deleted ..."+i);
        
        }
        catch(Exception e)
        {
            System.out.println("Error is "+e.toString());
        }
        
    }
    



}
