
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import java.sql.*;

public class registration1 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
          
          String uname=request.getParameter("uname");
          String pass=request.getParameter("pass");
          String enroll=request.getParameter("enroll");
          String fname=request.getParameter("fname");
          String lname=request.getParameter("lname");
          String sem=request.getParameter("sem");
          
          
          try{  
             
                 
                    
                  Class.forName("org.apache.derby.jdbc.ClientDriver");
                  Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/apollo", "apollo", "root");
                    PreparedStatement pst=con.prepareStatement("insert into REGISTRATION values(?,?,?,?,?,?)");
                    pst.setString(1, uname);
                    pst.setString(2, pass);
                    pst.setString(3, enroll);
                    pst.setString(4, fname);
                    pst.setString(5, lname);
                    pst.setString(6, sem);
                    int o=pst.executeUpdate();
                    
                   
            
       request.getRequestDispatcher("index.html").include(request, response);
       out.print("<br><br>");
       out.print("Record inserted..."+o);
    }
        catch(Exception e1)
        {
            System.out.println("Error is "+e1.toString());
        }
        }  
     }

