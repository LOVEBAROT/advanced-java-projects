
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
import javax.servlet.*;


public class delete extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         String sem=request.getParameter("sem");
        
        try{  
   
             Class.forName("org.apache.derby.jdbc.ClientDriver");
                  Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/apollo", "apollo", "root"); 
            PreparedStatement pst;
            pst = con.prepareStatement("delete from REGISTRATION where sem=?");
            pst.setString(1, sem);
            int rs=pst.executeUpdate();
            RequestDispatcher rd=request.getRequestDispatcher("view1");
            rd.forward(request, response);
            out.println("racord deleted");
            }
        catch(Exception e1)
        {
            System.out.println("Error is "+e1.toString());
        }
     
finally{out.close();}
        }
        
        
           
        
    }

    
