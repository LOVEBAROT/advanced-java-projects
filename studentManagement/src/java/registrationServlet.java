

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;


public class registrationServlet extends HttpServlet {

   
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
    PreparedStatement pst=con.prepareStatement("insert into registration1 values(?,?,?,?,?)");
            pst.setInt(1, enno);
            pst.setString(2, n);
            pst.setString(3, p);
            pst.setString(4, e);
            pst.setString(5, c);
            pst.executeUpdate();
       
        request.getRequestDispatcher("index.html").include(request, response);
        out.print("<br><br>");
        out.print("Recor inserted...");
}
        catch(Exception e1)
        {
            System.out.println("Error is "+e1.toString());
        }
     
finally{out.close();}  
  
}  
        
    }


    

    