

package democonnection;

import java.sql.*;
public class DemoConnection {

     public static void main(String[] args) {
         
         try{
         
         Class.forName("com.mysql.jdbc.Driver");
         Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
         Statement st=conn.createStatement();
         int rs=st.executeUpdate("insert into registration values('nitin','knk@aiet.edu.in','123','14/10/1988')");
         if(rs!=0)
         {
             System.out.println("The record has been inserted");
         }
         }
         catch(Exception e)
         {
             System.out.println("Error is "+e.toString());         
         }
         
     
     
     }
    
}
