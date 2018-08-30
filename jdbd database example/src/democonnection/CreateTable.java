
package democonnection;
import java.sql.*;
public class CreateTable {

    public static void main(String[] args) {
        
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/college?zeroDateTimeBehavior=convertToNull", "root", "root");
        Statement st=conn.createStatement();
        //int rs=st.executeUpdate("create table DEMO(name varchar(10), email varchar(30), pass varchar(30),bod varchar(20))");
        int rs=st.executeUpdate("insert into login values('Harit',123)");
            //System.out.println("Table Create...");
            System.out.println("Record Inserted...");
        
       
        }
        catch(Exception e)
        {
            System.out.println("Error is "+e.toString());
        }
        
        
        
    }
    
    
}
