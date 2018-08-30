
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class view1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       
         out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet view</title>");            
            out.println("</head>");
            out.println("<body bgcolor=pink>");
         
        try{  
   
    Class.forName("org.apache.derby.jdbc.ClientDriver");
                  Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/apollo", "apollo", "root");
   //Statement st=con.createStatement();
    PreparedStatement pst=con.prepareStatement("select * from REGISTRATION");
    ResultSet rs=pst.executeQuery();
    
     out.println("<table border=2>");
     
      out.println("<tr>");
      out.println("<th>username</th>");
     out.println("<th>password</th>");
     out.println("<th>ENROLLMENT</th>");
     out.println("<th>FIRSTNAME</th>");
     out.println("<th>LASTNAME</th>");
     out.println("<th>SEMESTER</th>");
     
     out.println("</tr>");
    while(rs.next())
    {
        
    out.println("<tr>");
    
     out.println("<td>"+rs.getString(1)+"</td>");
     out.println("<td>"+rs.getString(2)+"</td>");
     out.println("<td>"+rs.getString(3)+"</td>");
     out.println("<td>"+rs.getString(4)+"</td>");
     out.println("<td>"+rs.getString(5)+"</td>");
     out.println("<td>"+rs.getString(6)+"</td>");
     out.println("<td><a href=edit.html>EDIT</a></td>");
     out.print("<td><a href='delete?sem="+rs.getString(6)+"'>DELETE</a></td>");
    
     
     out.println("</tr>");  
        
      }
    out.println("</table>");     
     out.println("</body>");
      out.println("</html>");
    
    
    
}
        catch(Exception e1)
        {
            System.out.println("Error is "+e1.toString());
        }
     
 
           
        
    }

   

}
