

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


public class view extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet view</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            request.getRequestDispatcher("index.html").include(request, response);
        out.print("<br><br>");
     
        try{  
   
    Class.forName("org.apache.derby.jdbc.ClientDriver");  
      Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/nitin","root","root");  
   //Statement st=con.createStatement();
    PreparedStatement pst=con.prepareStatement("select * from registration1");
    ResultSet rs=pst.executeQuery();
     out.println("<table border=2>");
      out.println("<tr>");
      out.println("<th>Enrollment Number</th>");
     out.println("<th>Name</th>");
     out.println("<th>Password</th>");
     out.println("<th>Email</th>");
     out.println("<th>City</th>");
     out.println("<th>EDIT</th>");
     out.println("<th>DELETE</th>");
     
     out.println("</tr>");
    while(rs.next())
    {
        
    out.println("<tr>");
     out.println("<td>"+rs.getInt(1)+"</td>");
     out.println("<td>"+rs.getString(2)+"</td>");
     out.println("<td>"+rs.getString(3)+"</td>");
     out.println("<td>"+rs.getString(4)+"</td>");
     out.println("<td>"+rs.getString(5)+"</td>");
     out.println("<td><a href='editServlet?enno="+rs.getInt(1)+"'>EDIT</a></td>");
     out.println("<td><a href='deleteServlet?enno="+rs.getInt(1)+"'>DELETE</a></td>");
     
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
     
finally{out.close();}
        }
    }

    
   