
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


public class insertData extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter(); 
        response.setContentType("text/html;charset=UTF-8");
        String id=request.getParameter("id");      
        String pass=request.getParameter("pass");    
         try{  
   
    Class.forName("org.apache.derby.jdbc.ClientDriver");  
      Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/college","root","root");  
   //Statement st=con.createStatement();
    PreparedStatement pst=con.prepareCall("insert into login values(?,?)");
    pst.setString(1, id);
    pst.setString(2, pass);
    pst.executeUpdate();
//int rs=st.executeUpdate("insert into login values('ssss','ssss')");
        out.print("Recor inserted...");
        
        out.print("<a href='demoservlet'> GET ServletContext Name</a>");
}
catch(Exception e)
{
   out.println("Error is "+e.toString());
}
     
finally{out.close();}  
  
}  
    }

  

