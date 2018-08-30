import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

public class change1 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
             String uname=request.getParameter("uname");
             String oldpass=request.getParameter("oldpass");
             String newpass=request.getParameter("newpass");
             String confirmpass=request.getParameter("confirmpass");
             
            
             
              try
            {
             Class.forName("org.apache.derby.jdbc.ClientDriver");
                  Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/apollo", "apollo", "root");
            PreparedStatement statement = con.prepareStatement("select uname, pass from registration where uname =? and pass=?");
            statement.setString(1, uname);
            statement.setString(2, oldpass);
            ResultSet result = statement.executeQuery();
            if(result.next()){
               
                String newuname=result.getString(1);
                String newoldpass=result.getString(2);
                //out.println(newuname);
                //out.println(newoldpass);
               
               if(oldpass.equals(newoldpass) && newpass.equals(confirmpass))
                {
                    try{  
   
                         Class.forName("org.apache.derby.jdbc.ClientDriver");
                  Connection con1=DriverManager.getConnection("jdbc:derby://localhost:1527/apollo", "apollo", "root"); 
   
                                 PreparedStatement pst=con1.prepareStatement("update REGISTRATION set PASS=? where UNAME=?");
                                 pst.setString(1, newpass);
                                 pst.setString(2, uname);
            
           int rs= pst.executeUpdate();
           out.println("your password change successfully");
           out.println("<br>");
           request.getRequestDispatcher("index.html").include(request, response);
      //  out.print("<br><br>");
       //out.println("racord updated");
        
        
}
        catch(Exception e1)
        {
            System.out.println("Error is "+e1.toString());
        }
     }
               else
               {
                   out.println("your pass and new pass dont match");
                    out.println("<br><br>");
                   request.getRequestDispatcher("change.html").include(request, response);
               }
                
                
                
            }
            else 
            {
                out.println("<br><br>");
                out.println("username and password are incorrect");
                 out.println("<br><br>");
                request.getRequestDispatcher("change.html").include(request, response);
            }
            
        }
            catch(Exception e)
            {
                System.out.println("DB related Error");
                e.printStackTrace();
            }   
              
               if(oldpass.equals(null)||oldpass==""||newpass.equals(null)||newpass=="")
                  {
                      out.println("<br><br>");
                      out.println("please enter old password and new password");
                       request.getRequestDispatcher("change.html").include(request, response);
                  }
              
              }
    }

