

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class updateServlet extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         String en = request.getParameter("enno");
        int enno = Integer.parseInt(en);
        String n = request.getParameter("userName");
        String p = request.getParameter("userPass");
        String e = request.getParameter("userEmail");
        String c = request.getParameter("city");

        try{  
   
    Class.forName("org.apache.derby.jdbc.ClientDriver");  
      Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/nitin","root","root");  
   //Statement st=con.createStatement();
    PreparedStatement pst=con.prepareStatement("update registration1 set username=?,pass=?,email=?,city=? where enno=?");
            pst.setString(1, n);
            pst.setString(2, p);
            pst.setString(3, e);
            pst.setString(4, c);
            pst.setInt(5, enno);
            pst.executeUpdate();
     
        request.getRequestDispatcher("index.html").include(request, response);
        out.print("<br><br>");
        request.getRequestDispatcher("view").forward(request, response);
        
        
}
        catch(Exception e1)
        {
            System.out.println("Error is "+e1.toString());
        }
     
finally{out.close();}  
        
        
        
        
        
        
            
        }
    }

   